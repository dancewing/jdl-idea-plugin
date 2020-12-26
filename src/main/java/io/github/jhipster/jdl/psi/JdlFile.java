package io.github.jhipster.jdl.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.SyntaxTraverser;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.containers.JBIterable;
import io.github.jhipster.jdl.JdlFileType;
import io.github.jhipster.jdl.JdlLanguage;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class JdlFile extends PsiFileBase {

  public JdlFile(@NotNull FileViewProvider viewProvider) {
    super(viewProvider, JdlLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return JdlFileType.INSTANCE;
  }

  @Override
  public String toString() {
    return "Jdl File";
  }

  public List<JdlApplicationDefinition> getApplicationDefinitions() {
    return PsiTreeUtil.getStubChildrenOfTypeAsList(this, JdlApplicationDefinition.class);
  }

  public List<JdlEntityDefinition> getEntityDefinitions() {
    return PsiTreeUtil.getStubChildrenOfTypeAsList(this, JdlEntityDefinition.class);
  }

  public List<JdlEnumDefinition> getEnumDefinitions() {
    return PsiTreeUtil.getStubChildrenOfTypeAsList(this, JdlEnumDefinition.class);
  }

  public List<JdlOptionDefinition> getOptionDefinitions() {
     return PsiTreeUtil.getStubChildrenOfTypeAsList(this, JdlOptionDefinition.class);
  }

  public List<JdlRelationshipDefinition> getRelationshipDefinitions() {
     return PsiTreeUtil.getStubChildrenOfTypeAsList(this, JdlRelationshipDefinition.class);
  }
}
