package com.transformation.service;

import com.transformation.model.Transformation;
import com.transformation.model.TransformationResponse;

public interface TransformationService {
    TransformationResponse transformItems(Transformation transformation);
}
