package com.example.emnudemo;

import org.apache.commons.logging.LogFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.logging.Logger;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class SeasonConverter implements AttributeConverter<Season, String> {

    @Override
    public String convertToDatabaseColumn(Season attribute) {

        System.out.println("convertToDatabaseColumn");

        if (attribute == null) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public Season convertToEntityAttribute(String dbData) {

        System.out.println("convertToDatabaseColumn");

        if (dbData == null) {
            return null;
        }

        return Stream.of(Season.values())
                .filter(s -> s.getCode().equalsIgnoreCase(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
