// This is a generated file. Not intended for manual editing.
package io.github.jhipster.jdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface JdlEntityDefinition extends JdlClass {

  @Nullable
  JdlComponentName getComponentName();

  @Nullable
  JdlEntityTypeBody getEntityTypeBody();

  @NotNull
  List<JdlMetadata> getMetadataList();

}
