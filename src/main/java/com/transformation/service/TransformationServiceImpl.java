package com.transformation.service;

import com.transformation.mapper.TransformationMapper;
import com.transformation.model.Transformation;
import com.transformation.model.TransformationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class TransformationServiceImpl implements TransformationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransformationServiceImpl.class);

    private final ValidationService validationService;

    public TransformationServiceImpl(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public TransformationResponse transformItems(Transformation transformation) {
        LOGGER.info("transformItems.start");

        var items = transformation.getItems();
        validationService.validateItems(items);

        var transformedItems = new ArrayList<String>();

        var distinctItems = items.stream()
                .distinct()
                .collect(Collectors.toList());

        distinctItems.forEach(item -> {
            if (item.contains("_")) {
                item = item.substring(0, 1).toUpperCase()
                        + item.substring(1);
                while (item.contains("_")) {
                    item = item
                            .replaceFirst(
                                    "_[a-z]",
                                    String.valueOf(
                                            Character.toUpperCase(
                                                    item.charAt(
                                                            item.indexOf("_") + 1))));
                }
            }
            transformedItems.add(item);
        });
        LOGGER.info("transformItems.end");
        return TransformationMapper.INSTANCE.buildTransformationResponse(transformation.getName(), transformedItems);
    }
}
