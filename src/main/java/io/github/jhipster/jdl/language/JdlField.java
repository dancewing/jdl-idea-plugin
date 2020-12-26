package io.github.jhipster.jdl.language;

import io.github.jhipster.jdl.language.validation.JdlValidation;
import java.util.ArrayList;
import java.util.List;

public class JdlField {

  public JdlField() {
  }

  public JdlField(String name) {
    this.name = name;
  }

  private String name;
  private JdlFieldType type;
  private String typeName;

  private List<JdlValidation> validations = new ArrayList<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public JdlFieldType getType() {
    return type;
  }

  public void setType(JdlFieldType type) {
    this.type = type;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public boolean isEnum() {
    return type != null && type == JdlFieldType.Enum;
  }

  public List<JdlValidation> getValidations() {
    return validations;
  }

  @Override
  public String toString() {
    return "JdlField{" +
        "name='" + name + '\'' +
        ", type=" + type +
        ", validations=" + validations +
        '}';
  }
}
