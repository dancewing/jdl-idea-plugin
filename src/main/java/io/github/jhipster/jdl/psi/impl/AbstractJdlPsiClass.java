package io.github.jhipster.jdl.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import io.github.jhipster.jdl.psi.JdlClass;
import io.github.jhipster.jdl.psi.JdlComponentName;
import io.github.jhipster.jdl.psi.JdlEnumConstantDeclaration;
import io.github.jhipster.jdl.psi.JdlEnumDefinition;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractJdlPsiClass extends AbstractJdlComponentImpl implements JdlClass {

  public AbstractJdlPsiClass(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public boolean isEnum() {
    return this instanceof JdlEnumDefinition;
  }

  @NotNull
  @Override
  public List<JdlEnumConstantDeclaration> getEnumConstantDeclarationList() {
     return Collections.emptyList();
  }

  @Override
  public String getName() {
    final JdlComponentName name = getComponentName();
    if (name != null) {
      return name.getText();
    }
    return super.getName();
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
    final JdlComponentName componentName = getComponentName();
    if (componentName != null) {
      componentName.setName(name);
    }
    return this;
  }
}
