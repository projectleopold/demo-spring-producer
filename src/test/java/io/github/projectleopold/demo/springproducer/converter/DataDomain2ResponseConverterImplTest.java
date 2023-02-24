package io.github.projectleopold.demo.springproducer.converter;

import io.github.projectleopold.demo.springproducer.dto.DataResponse;
import io.github.projectleopold.demo.springproducer.domain.DataDomain;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = DataDomain2ResponseConverterImpl.class)
class DataDomain2ResponseConverterImplTest {

    @Test
    void should_convert(@Autowired DataDomain2ResponseConverter converter) {
        DataResponse dto = converter.convert(DataDomain.builder()
                .id("test-id")
                .value("test-value")
                .build());
        assertEquals(DataResponse.builder()
                .id("test-id")
                .value("test-value")
                .build(), dto);
    }

}