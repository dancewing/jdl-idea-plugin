package io.github.jhipster.jdl.language.validation;

public abstract class AbstractJdlValidation implements JdlValidation {

  protected String name;

  public AbstractJdlValidation(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getValue() {
    return getName();
  }

  @Override
  public void setValue(String v) {
  }

  @Override
  public String toString() {
    return getValue();
  }
}
