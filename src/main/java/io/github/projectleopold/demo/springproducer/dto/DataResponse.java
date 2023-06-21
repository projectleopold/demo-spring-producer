package io.github.projectleopold.demo.springproducer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataResponse {

    private String id;
    private String data;

}
