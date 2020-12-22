package io.github.jhipster.jdl.psi;

import com.intellij.psi.PsiNameIdentifierOwner;
import org.jetbrains.annotations.Nullable;

public interface JdlComponent extends JdlPsiCompositeElement, PsiNameIdentifierOwner {
  @Nullable
  JdlComponentName getComponentName();
}
