package com.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Converter(autoApply = true)
public class HashMapConverter implements AttributeConverter<Map<String, Object>, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, Object> attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            // Handle the exception accordingly
            throw new RuntimeException("Error converting map to JSON: " + e.getMessage());
        }
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return new HashMap<>();
        }

        try {
            return objectMapper.readValue(dbData, HashMap.class);
        } catch (IOException e) {
            // Handle the exception accordingly
            throw new RuntimeException("Error converting JSON to map: " + e.getMessage());
        }
    }
}
