package io.github.projectleopold.demo.springproducer.converter;

import io.github.projectleopold.demo.springproducer.domain.DataDomain;
import io.github.projectleopold.demo.springproducer.dto.DataResponse;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class DataDomain2ResponseConverterImpl implements DataDomain2ResponseConverter {

    @NonNull
    @Override
    public DataResponse convert(DataDomain source) {
        return DataResponse.builder()
                .id(source.getId())
                .value(source.getValue())
                .build();
    }

}
