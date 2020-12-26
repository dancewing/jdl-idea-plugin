package io.github.jhipster.jdl.language.validation;

public abstract class AbstractJdlValueValidation extends AbstractJdlValidation {

  public AbstractJdlValueValidation(String name) {
    super(name);
  }

  protected String value;

  @Override
  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String getValue() {
    return value;
  }
}
