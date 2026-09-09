package com.applyflow.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ApplicationStatusConverter
        implements AttributeConverter<ApplicationStatus, String> {

    @Override
    public String convertToDatabaseColumn(ApplicationStatus status) {
        if (status == null) {
            return null;
        }

        return status.getValue();
    }

    @Override
    public ApplicationStatus convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }

        for (ApplicationStatus status : ApplicationStatus.values()) {
            if (status.getValue().equalsIgnoreCase(value)) {
                return status;
            }
        }

        throw new IllegalArgumentException("Unknown application status: " + value);
    }
}