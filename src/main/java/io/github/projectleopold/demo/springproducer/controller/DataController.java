package io.github.projectleopold.demo.springproducer.controller;

import io.github.projectleopold.demo.springproducer.dto.DataRequest;
import io.github.projectleopold.demo.springproducer.dto.DataResponse;
import io.github.projectleopold.demo.springproducer.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/datum")
public class DataController {

    private final DataService dataService;

    @PostMapping
    public ResponseEntity<DataResponse> create(@RequestBody DataRequest data) {
        return ResponseEntity.ok(dataService.insert(data));
    }

    @GetMapping("/{dataId}")
    public ResponseEntity<DataResponse> get(@PathVariable String dataId) {
        return dataService.find(dataId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DataResponse>> getAll() {
        return ResponseEntity.ok(dataService.findAll());
    }

    @DeleteMapping("/{dataId}")
    public ResponseEntity<?> delete(@PathVariable String dataId) {
        dataService.remove(dataId);
        return ResponseEntity.ok().build();
    }

}
