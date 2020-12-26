package io.github.jhipster.jdl.language;

import java.util.ArrayList;
import java.util.List;

public class JdlEntity extends JdlOptionRule {

  private String packageName;
  private String name;
  private List<JdlField> fields = new ArrayList<>();
  private boolean isEnum;
  private List<JdlRelationship> relationships = new ArrayList<>();

  public JdlEntity(String name) {
    this.name = name;
    this.isEnum = false;
  }

  public JdlEntity(String name, boolean isEnum) {
    this.name = name;
    this.isEnum = isEnum;
  }

  public String getPackageName() {
    return packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<JdlField> getFields() {
    return fields;
  }

  public List<JdlRelationship> getRelationships() {
    return relationships;
  }

  @Override
  public String toString() {
    return "JdlEntity{" +
        "name='" + name + '\'' +
        ", fields=" + fields +
        ", isEnum=" + isEnum +
        '}';
  }
}
