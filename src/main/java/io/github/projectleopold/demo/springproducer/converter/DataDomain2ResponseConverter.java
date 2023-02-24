package io.github.projectleopold.demo.springproducer.converter;

import io.github.projectleopold.demo.springproducer.domain.DataDomain;
import io.github.projectleopold.demo.springproducer.dto.DataResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

public interface DataDomain2ResponseConverter extends Converter<DataDomain, DataResponse> {

    @NonNull
    @Override
    DataResponse convert(DataDomain source);

}
