package io.github.projectleopold.demo.springproducer.converter;

import io.github.projectleopold.demo.springproducer.dto.DataRequest;
import io.github.projectleopold.demo.springproducer.domain.DataDomain;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = DataRequest2DomainConverterImpl.class)
class DataRequest2DomainConverterImplTest {

    @Test
    void should_convert(@Autowired DataRequest2DomainConverter converter) {
        DataDomain dto = converter.convert(DataRequest.builder()
                .id("test-id")
                .data("test-value")
                .build());
        assertEquals(DataDomain.builder()
                .id("test-id")
                .value("test-value")
                .build(), dto);
    }

}