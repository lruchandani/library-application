package com.lalit.library.subscriptionservice.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status,String> {
    @Override
    public String convertToDatabaseColumn(Status status) {
        return status.getStatus();
    }

    @Override
    public Status convertToEntityAttribute(String s) {
        return Status.from(s);
    }
}
