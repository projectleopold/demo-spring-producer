package io.github.projectleopold.demo.springproducer.service;

import io.github.projectleopold.demo.springproducer.dto.DataRequest;
import io.github.projectleopold.demo.springproducer.dto.DataResponse;

import java.util.List;
import java.util.Optional;

public interface DataService {

    DataResponse insert(DataRequest data);

    Optional<DataResponse> find(String dataId);

    List<DataResponse> findAll();

    void remove(String dataId);

    void removeAll();

}
