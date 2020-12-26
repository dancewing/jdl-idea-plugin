package io.github.jhipster.jdl.psi;

import com.intellij.psi.tree.IElementType;
import io.github.jhipster.jdl.JdlLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class JdlTokenType extends IElementType {

  public JdlTokenType(@NotNull @NonNls String debugName) {
    super(debugName, JdlLanguage.INSTANCE);
  }

  @Override
  public String toString() {
    return "JdlTokenType." + super.toString();
  }

}
