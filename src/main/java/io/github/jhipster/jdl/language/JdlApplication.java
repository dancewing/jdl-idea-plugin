package io.github.jhipster.jdl.language;

import java.util.List;

public class JdlApplication extends JdlApplicationConfig{

  private List<JdlEntity> entities;

  private List<JdlOption> options;

  public List<JdlEntity> getEntities() {
    return entities;
  }

  public void setEntities(List<JdlEntity> entities) {
    this.entities = entities;
  }

  public List<JdlOption> getOptions() {
    return options;
  }

  public void setOptions(List<JdlOption> options) {
    this.options = options;
  }
}
