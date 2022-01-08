package com.transformation.controller;

import com.transformation.model.Transformation;
import com.transformation.model.TransformationResponse;
import com.transformation.service.TransformationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class TransformationController {
    private final TransformationService service;

    public TransformationController(TransformationService service) {
        this.service = service;
    }

    @PostMapping("/transformation")
    public ResponseEntity<TransformationResponse> transformItems(@RequestBody Transformation transformation){
        var response = service.transformItems(transformation);
        return ResponseEntity.ok(response);
    }
}
