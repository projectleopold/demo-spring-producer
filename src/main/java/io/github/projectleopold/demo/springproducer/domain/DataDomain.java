package io.github.projectleopold.demo.springproducer.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataDomain {

    private String id;
    private String value;

}
