package io.github.jhipster.jdl.ide.folding;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;

@State(name = "JdlCodeFoldingSettings", storages = @Storage("editor.xml"))
public class JdlCodeFoldingSettings implements PersistentStateComponent<JdlCodeFoldingSettings> {

  private boolean myCollapseParts = true;
  private boolean myCollapseGenericParams;

  public static JdlCodeFoldingSettings getInstance() {
    return ApplicationManager.getApplication().getService(JdlCodeFoldingSettings.class);
  }

  @Override
  public JdlCodeFoldingSettings getState() {
    return this;
  }

  @Override
  public void loadState(@NotNull final JdlCodeFoldingSettings state) {
    XmlSerializerUtil.copyBean(state, this);
  }

  public boolean isCollapseGenericParameters() {
    return myCollapseGenericParams;
  }

  public void setCollapseGenericParameters(final boolean collapseGenericParams) {
    myCollapseGenericParams = collapseGenericParams;
  }

  public boolean isCollapseParts() {
    return myCollapseParts;
  }

  public void setCollapseParts(final boolean collapseParts) {
    myCollapseParts = collapseParts;
  }
}
