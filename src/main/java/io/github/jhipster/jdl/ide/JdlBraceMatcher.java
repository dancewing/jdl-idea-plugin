package io.github.jhipster.jdl.ide;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import io.github.jhipster.jdl.JdlTokenTypes;
import io.github.jhipster.jdl.psi.JdlTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JdlBraceMatcher implements PairedBraceMatcher {

  private static final BracePair[] BRACE_PAIRS = {
      new BracePair(JdlTypes.LBRACE, JdlTypes.RBRACE, true),
      new BracePair(JdlTypes.LBRACKET, JdlTypes.RBRACKET, false),
      new BracePair(JdlTypes.LPAREN, JdlTypes.RPAREN, false)
  };

  @Override
  public BracePair @NotNull [] getPairs() {
    return BRACE_PAIRS;
  }

  @Override
  public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
    //return contextType == null || !JdlTokenTypes.STRINGS.contains(contextType);
    return true;
  }

  @Override
  public int getCodeConstructStart(PsiFile psiFile, int openingBraceOffset) {
    return openingBraceOffset;
  }
}
