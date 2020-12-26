package io.github.jhipster.jdl.psi;

import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiNamedElement;

public interface JdlNamedElement extends JdlPsiCompositeElement, PsiNamedElement, NavigationItem, PsiNameIdentifierOwner {
  JdlId getId();
}
