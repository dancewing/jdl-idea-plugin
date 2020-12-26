// This is a generated file. Not intended for manual editing.
package io.github.jhipster.jdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface JdlFieldMember extends JdlComponent {

  @NotNull
  JdlComponentName getComponentName();

  @NotNull
  JdlFieldTypeDefinition getFieldTypeDefinition();

  @Nullable
  JdlFieldValidations getFieldValidations();

  @NotNull
  List<JdlMetadata> getMetadataList();

}
