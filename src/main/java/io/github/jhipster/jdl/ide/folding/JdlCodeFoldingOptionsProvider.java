package io.github.jhipster.jdl.ide.folding;

import com.intellij.application.options.editor.CodeFoldingOptionsProvider;
import com.intellij.openapi.options.BeanConfigurable;
import io.github.jhipster.jdl.JdlBundle;

public class JdlCodeFoldingOptionsProvider extends BeanConfigurable<JdlCodeFoldingSettings> implements CodeFoldingOptionsProvider {

  public JdlCodeFoldingOptionsProvider() {
    super(JdlCodeFoldingSettings.getInstance(), JdlBundle.message("jdl.title"));
    JdlCodeFoldingSettings settings = getInstance();
    checkBox(JdlBundle.message("checkbox.collapse.parts"), settings::isCollapseParts, settings::setCollapseParts);
    checkBox(JdlBundle.message("checkbox.collapse.generic.parameters"), settings::isCollapseGenericParameters,
        settings::setCollapseGenericParameters);
  }
}
