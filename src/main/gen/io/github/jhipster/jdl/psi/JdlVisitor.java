// This is a generated file. Not intended for manual editing.
package io.github.jhipster.jdl.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class JdlVisitor extends PsiElementVisitor {

  public void visitProperty(@NotNull JdlProperty o) {
    visitNamedElement(o);
  }

  public void visitNamedElement(@NotNull JdlNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
