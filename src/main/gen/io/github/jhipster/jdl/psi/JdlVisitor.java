// This is a generated file. Not intended for manual editing.
package io.github.jhipster.jdl.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;

public class JdlVisitor extends PsiElementVisitor {

  public void visitApplicationEntities(@NotNull JdlApplicationEntities o) {
    visitPsiCompositeElement(o);
  }

  public void visitApplicationTypeBody(@NotNull JdlApplicationTypeBody o) {
    visitPsiCompositeElement(o);
  }

  public void visitApplicationTypeBodyInner(@NotNull JdlApplicationTypeBodyInner o) {
    visitPsiCompositeElement(o);
  }

  public void visitApplicationTypeDefinition(@NotNull JdlApplicationTypeDefinition o) {
    visitPsiCompositeElement(o);
  }

  public void visitComponentName(@NotNull JdlComponentName o) {
    visitNamedElement(o);
  }

  public void visitDirectiveTypeBody(@NotNull JdlDirectiveTypeBody o) {
    visitPsiCompositeElement(o);
  }

  public void visitDirectiveTypeDefinition(@NotNull JdlDirectiveTypeDefinition o) {
    visitPsiCompositeElement(o);
  }

  public void visitEntityNames(@NotNull JdlEntityNames o) {
    visitPsiCompositeElement(o);
  }

  public void visitEntityTypeBody(@NotNull JdlEntityTypeBody o) {
    visitPsiCompositeElement(o);
  }

  public void visitEntityTypeBodyInner(@NotNull JdlEntityTypeBodyInner o) {
    visitPsiCompositeElement(o);
  }

  public void visitEntityTypeDefinition(@NotNull JdlEntityTypeDefinition o) {
    visitClass(o);
  }

  public void visitEntry(@NotNull JdlEntry o) {
    visitPsiCompositeElement(o);
  }

  public void visitEnumConstantDeclaration(@NotNull JdlEnumConstantDeclaration o) {
    visitComponent(o);
  }

  public void visitEnumTypeDefinition(@NotNull JdlEnumTypeDefinition o) {
    visitClass(o);
  }

  public void visitFieldMember(@NotNull JdlFieldMember o) {
    visitComponent(o);
  }

  public void visitId(@NotNull JdlId o) {
    visitPsiCompositeElement(o);
  }

  public void visitClass(@NotNull JdlClass o) {
    visitPsiCompositeElement(o);
  }

  public void visitComponent(@NotNull JdlComponent o) {
    visitPsiCompositeElement(o);
  }

  public void visitNamedElement(@NotNull JdlNamedElement o) {
    visitPsiCompositeElement(o);
  }

  public void visitPsiCompositeElement(@NotNull JdlPsiCompositeElement o) {
    visitElement(o);
  }

}
