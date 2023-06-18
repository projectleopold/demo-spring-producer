package io.github.projectleopold.demo.springproducer.springconsumer;

import io.github.projectleopold.demo.springproducer.dto.DataRequest;
import io.github.projectleopold.demo.springproducer.dto.DataResponse;
import io.github.projectleopold.demo.springproducer.service.DataService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;

@DirtiesContext
@AutoConfigureMessageVerifier
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public abstract class SpringConsumerRestContractTest {

    @MockBean
    DataService dataService;

    @BeforeEach
    public void setupWebApplicationContext(@Autowired WebApplicationContext context) {
        RestAssuredMockMvc.webAppContextSetup(context);
    }

    @BeforeEach
    public void mockDataService() {
        when(dataService.insert(argThat(
                request -> request.getId().matches("id-.+")
                        && request.getValue().matches("value-.+"))))
                .then(invocation -> {
                    DataRequest request = invocation.getArgument(0, DataRequest.class);
                    return DataResponse.builder()
                            .id(request.getId())
                            .value(request.getValue())
                            .build();
                });
    }

}
