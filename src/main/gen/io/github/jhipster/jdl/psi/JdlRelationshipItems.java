// This is a generated file. Not intended for manual editing.
package io.github.jhipster.jdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface JdlRelationshipItems extends JdlPsiCompositeElement {

  @NotNull
  List<JdlMetadata> getMetadataList();

  @NotNull
  JdlRelationshipSourceType getRelationshipSourceType();

  @Nullable
  JdlRelationshipSourceTypeOptions getRelationshipSourceTypeOptions();

  @NotNull
  JdlRelationshipTargetType getRelationshipTargetType();

  @Nullable
  JdlRelationshipTargetTypeOptions getRelationshipTargetTypeOptions();

}
