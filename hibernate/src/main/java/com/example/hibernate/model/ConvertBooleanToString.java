package com.example.hibernate.model;

import jakarta.persistence.AttributeConverter;

public class ConvertBooleanToString implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        if(attribute==null) return null;
        return attribute ? "Yes" : "No";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        if(dbData==null) return null;

        return dbData.equals("Yes");
    }
}
