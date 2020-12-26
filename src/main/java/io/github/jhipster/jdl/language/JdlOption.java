package io.github.jhipster.jdl.language;

import java.util.ArrayList;
import java.util.List;

public class JdlOption {

  private String name;
  private String value;
  private List<JdlEntity> includeEntities = new ArrayList<>();
  private List<JdlEntity> excludeEntities = new ArrayList<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<JdlEntity> getIncludeEntities() {
    return includeEntities;
  }

  public void setIncludeEntities(List<JdlEntity> includeEntities) {
    this.includeEntities = includeEntities;
  }

  public List<JdlEntity> getExcludeEntities() {
    return excludeEntities;
  }

  public void setExcludeEntities(List<JdlEntity> excludeEntities) {
    this.excludeEntities = excludeEntities;
  }

  public List<JdlEntity> getEntities() {
    return null;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
