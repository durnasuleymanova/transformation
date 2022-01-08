package com.transformation.service;

import com.transformation.model.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationService.class);

    public void validateItems(List<String> items) {
        LOGGER.info("validateItems.start");
        items.forEach(item -> {
            if (item.matches(".*\\d.*")) {
                LOGGER.error("validateItems.error");
                throw new ValidationException();
            }
        });
        LOGGER.info("validateItems.end");
    }
}
