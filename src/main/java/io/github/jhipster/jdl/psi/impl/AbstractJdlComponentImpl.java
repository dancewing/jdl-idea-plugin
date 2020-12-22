package io.github.jhipster.jdl.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import io.github.jhipster.jdl.psi.JdlComponent;
import io.github.jhipster.jdl.psi.JdlComponentName;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractJdlComponentImpl extends JdlPsiCompositeElementImpl implements JdlComponent {

  public AbstractJdlComponentImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public @Nullable JdlComponentName getComponentName() {
    return null;
  }

  @Override
  public @Nullable PsiElement getNameIdentifier() {
    return null;
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
