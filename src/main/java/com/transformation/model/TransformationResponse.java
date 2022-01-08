package com.transformation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransformationResponse extends Transformation {
    private Long timestamp;

    public TransformationResponse(String name, List<String> items, Long timestamp) {
        super(name, items);
        this.timestamp = timestamp;
    }
}
