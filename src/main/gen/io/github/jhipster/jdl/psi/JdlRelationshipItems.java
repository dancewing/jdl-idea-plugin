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

  @NotNull
  JdlRelationshipTargetType getRelationshipTargetType();

  @NotNull
  List<JdlRelationshipTypeOptions> getRelationshipTypeOptionsList();

}
