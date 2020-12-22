package io.github.jhipster.jdl.lexer;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.MergingLexerAdapter;
import com.intellij.psi.tree.TokenSet;
import io.github.jhipster.jdl._JdlDocLexer;
import static io.github.jhipster.jdl.JdlTokenTypes.MULTI_LINE_COMMENT_BODY;

public class JdlDocLexer extends MergingLexerAdapter {

  public JdlDocLexer() {
    super(new FlexAdapter(new _JdlDocLexer()), TokenSet.create(MULTI_LINE_COMMENT_BODY));
  }
}
