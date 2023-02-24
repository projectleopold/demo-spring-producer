package io.github.projectleopold.demo.springproducer.converter;

import io.github.projectleopold.demo.springproducer.domain.DataDomain;
import io.github.projectleopold.demo.springproducer.dto.DataRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

public interface DataRequest2DomainConverter extends Converter<DataRequest, DataDomain> {

    @NonNull
    @Override
    DataDomain convert(DataRequest source);

}
