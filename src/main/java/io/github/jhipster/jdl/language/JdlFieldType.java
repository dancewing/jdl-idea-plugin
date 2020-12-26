package io.github.jhipster.jdl.language;

import io.github.jhipster.jdl.language.validation.JdlMaxLengthValidation;
import io.github.jhipster.jdl.language.validation.JdlMaxValidation;
import io.github.jhipster.jdl.language.validation.JdlMinBytesValidation;
import io.github.jhipster.jdl.language.validation.JdlMinLengthValidation;
import io.github.jhipster.jdl.language.validation.JdlMinValidation;
import io.github.jhipster.jdl.language.validation.JdlPatternValidation;
import io.github.jhipster.jdl.language.validation.JdlRequiredValidation;
import io.github.jhipster.jdl.language.validation.JdlUniqueValidation;
import io.github.jhipster.jdl.language.validation.JdlValidation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public enum JdlFieldType {
  String("String", JdlRequiredValidation.class, JdlMinLengthValidation.class, JdlMaxLengthValidation.class, JdlPatternValidation.class,
      JdlUniqueValidation.class),
  Integer("Integer", JdlRequiredValidation.class, JdlMinValidation.class, JdlMaxValidation.class, JdlUniqueValidation.class),
  Long("Long", JdlRequiredValidation.class, JdlMinValidation.class, JdlMaxValidation.class, JdlUniqueValidation.class),
  BigDecimal("BigDecimal", JdlRequiredValidation.class, JdlMinValidation.class, JdlMaxValidation.class, JdlUniqueValidation.class),
  Float("Float", JdlRequiredValidation.class, JdlMinValidation.class, JdlMaxValidation.class, JdlUniqueValidation.class),
  Double("Double", JdlRequiredValidation.class, JdlMinValidation.class, JdlMaxValidation.class, JdlUniqueValidation.class),
  Enum("Enum", JdlRequiredValidation.class, JdlUniqueValidation.class),
  Boolean("Boolean", JdlRequiredValidation.class, JdlUniqueValidation.class),
  LocalDate("LocalDate", JdlRequiredValidation.class, JdlUniqueValidation.class),
  ZonedDateTime("ZonedDateTime", JdlRequiredValidation.class, JdlUniqueValidation.class),
  Instant("Instant", JdlRequiredValidation.class, JdlUniqueValidation.class),
  Duration("Duration", JdlRequiredValidation.class, JdlUniqueValidation.class),
  UUID("UUID", JdlRequiredValidation.class, JdlUniqueValidation.class),
  Blob("Blob", JdlRequiredValidation.class, JdlMinBytesValidation.class, JdlMinBytesValidation.class, JdlUniqueValidation.class),
  AnyBlob("AnyBlob", JdlRequiredValidation.class, JdlMinBytesValidation.class, JdlMinBytesValidation.class, JdlUniqueValidation.class),
  ImageBlob("ImageBlob", JdlRequiredValidation.class, JdlMinBytesValidation.class, JdlMinBytesValidation.class, JdlUniqueValidation.class),
  TextBlob("TextBlob", JdlRequiredValidation.class, JdlMinBytesValidation.class, JdlMinBytesValidation.class, JdlUniqueValidation.class);

  public static final List<JdlFieldType> ALL_WITHOUT_ENUM = Arrays
      .asList(String, Integer, Long, BigDecimal, Float, Double, Boolean, LocalDate, ZonedDateTime, Instant, Duration, UUID, Blob, AnyBlob,
          ImageBlob, TextBlob);

  private final String type;
  private final List<Class<? extends JdlValidation>> validations;

  JdlFieldType(String type, Class<? extends JdlValidation>... validations) {
    this.type = type;
    this.validations = new ArrayList<>();
    if (validations != null) {
      for (Class<? extends JdlValidation> validation : validations) {
        this.validations.add(validation);
      }
    }
  }

  public java.lang.String getType() {
    return type;
  }

  public List<Class<? extends JdlValidation>> getValidations() {
    return validations;
  }

  public static JdlFieldType from(String type) {
    for (JdlFieldType fieldType : ALL_WITHOUT_ENUM) {
      if (StringUtils.equals(type, fieldType.getType())) {
        return fieldType;
      }
    }
    return null;
  }
}
