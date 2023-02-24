package io.github.projectleopold.demo.springproducer.service;

import io.github.projectleopold.demo.springproducer.converter.DataDomain2ResponseConverter;
import io.github.projectleopold.demo.springproducer.converter.DataRequest2DomainConverter;
import io.github.projectleopold.demo.springproducer.domain.DataDomain;
import io.github.projectleopold.demo.springproducer.dto.DataRequest;
import io.github.projectleopold.demo.springproducer.dto.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {

    private final Map<String, DataDomain> dataById = new ConcurrentHashMap<>();

    private final DataRequest2DomainConverter dataRequest2DomainConverter;
    private final DataDomain2ResponseConverter dataDomain2ResponseConverter;

    @Override
    public DataResponse insert(DataRequest data) {
        DataDomain domain = dataRequest2DomainConverter.convert(data);
        dataById.put(domain.getId(), domain);
        return dataDomain2ResponseConverter.convert(domain);
    }

    @Override
    public Optional<DataResponse> find(String dataId) {
        return Optional.ofNullable(dataById.get(dataId))
                .map(dataDomain2ResponseConverter::convert);
    }

    @Override
    public List<DataResponse> findAll() {
        return dataById.values().stream()
                .map(dataDomain2ResponseConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(String dataId) {
        dataById.remove(dataId);
    }

    @Override
    public void removeAll() {
        dataById.clear();
    }

}
