package io.github.projectleopold.demo.springproducer;

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

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@DirtiesContext
@AutoConfigureMessageVerifier
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public abstract class BaseRestContractTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    @MockBean
    DataService dataService;

    @BeforeEach
    public void setupWebApplicationContext() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @BeforeEach
    public void mockDataService() {
        when(dataService.insert(
                eq(DataRequest.builder()
                        .id("new-data-id")
                        .value("new-data-value")
                        .build())))
                .thenReturn(DataResponse.builder()
                        .id("new-data-id")
                        .value("new-data-value")
                        .build());

        when(dataService.find(eq("single-data-id")))
                .thenReturn(Optional.of(DataResponse.builder()
                        .id("single-data-id")
                        .value("single-data-value")
                        .build()));

        when(dataService.findAll())
                .thenReturn(List.of(DataResponse.builder()
                        .id("first-data-id")
                        .value("first-data-value")
                        .build(), DataResponse.builder()
                        .id("second-data-id")
                        .value("second-data-value")
                        .build()));
    }

}

