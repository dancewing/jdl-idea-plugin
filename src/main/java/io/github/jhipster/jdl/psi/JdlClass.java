package io.github.jhipster.jdl.psi;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface JdlClass extends JdlComponent {

  @Nullable
  JdlComponentName getComponentName();

  boolean isEnum();

  @NotNull
  List<JdlEnumConstantDeclaration> getEnumConstantDeclarationList();

}
