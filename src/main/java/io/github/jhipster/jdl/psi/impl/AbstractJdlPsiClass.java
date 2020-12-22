package io.github.jhipster.jdl.psi.impl;

import com.intellij.lang.ASTNode;
import io.github.jhipster.jdl.psi.JdlClass;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractJdlPsiClass extends AbstractJdlComponentImpl implements JdlClass {

  public AbstractJdlPsiClass(@NotNull ASTNode node) {
    super(node);
  }
}
