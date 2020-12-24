// This is a generated file. Not intended for manual editing.
package io.github.jhipster.jdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface JdlApplicationConfig extends JdlPsiCompositeElement {

  @NotNull
  List<JdlConfigArrayItem> getConfigArrayItemList();

  @NotNull
  List<JdlConfigBooleanItem> getConfigBooleanItemList();

  @NotNull
  List<JdlConfigNumberItem> getConfigNumberItemList();

  @NotNull
  List<JdlConfigStringItem> getConfigStringItemList();

  @NotNull
  List<JdlPackageNameConfigItem> getPackageNameConfigItemList();

}
