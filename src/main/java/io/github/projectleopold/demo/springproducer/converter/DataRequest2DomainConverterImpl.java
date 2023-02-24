package io.github.projectleopold.demo.springproducer.converter;

import io.github.projectleopold.demo.springproducer.domain.DataDomain;
import io.github.projectleopold.demo.springproducer.dto.DataRequest;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class DataRequest2DomainConverterImpl implements DataRequest2DomainConverter {

    @NonNull
    @Override
    public DataDomain convert(DataRequest source) {
        return DataDomain.builder()
                .id(source.getId())
                .value(source.getValue())
                .build();
    }

}
