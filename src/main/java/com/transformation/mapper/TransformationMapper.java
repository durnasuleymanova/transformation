package com.transformation.mapper;

import com.transformation.model.TransformationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public abstract class TransformationMapper {
    public static final TransformationMapper INSTANCE = Mappers.getMapper(TransformationMapper.class);

    public TransformationResponse buildTransformationResponse(String name, List<String> items) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return new TransformationResponse(name, items, timestamp.getTime());
    }
}
