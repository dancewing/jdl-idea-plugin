// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package io.github.jhipster.jdl.lexer;

import static io.github.jhipster.jdl.JdlTokenTypes.*;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.MergeFunction;
import com.intellij.lexer.MergingLexerAdapterBase;
import com.intellij.psi.tree.IElementType;
import io.github.jhipster.jdl._JdlLexer;

public class JdlLexer extends MergingLexerAdapterBase {

  public JdlLexer() {
    super(createLexer());
  }

  private static FlexAdapter createLexer() {
    return new FlexAdapter(new _JdlLexer() {
      @Override
      public void reset(final CharSequence buffer, final int start, final int end, final int initialState) {
        super.reset(buffer, start, end, initialState);
        myLeftBraceCount = 0;
        myStateStack.clear();
      }
    });
  }

  /**
   * Merges WHITE_SPACE and REGULAR_STRING_PART tokens,
   * collapses sequence like {@code {MULTI_LINE_(DOC_)COMMENT_START MULTI_LINE_COMMENT_BODY* MULTI_LINE_COMMENT_END}} into a single {@code DartTokenTypesSets.MULTI_LINE_(DOC_)COMMENT}.
   * Doc comment content is lazily parsed separately
   */
  private static final MergeFunction MERGE_FUNCTION = (firstTokenType, originalLexer) -> {
    //if (firstTokenType == REGULAR_STRING_PART || firstTokenType == WHITE_SPACE) {
    if (firstTokenType == WHITE_SPACE) {
      // merge consequent tokens of the same type
      while (true) {
        final IElementType nextTokenType = originalLexer.getTokenType();
        if (nextTokenType != firstTokenType) break;
        originalLexer.advance();
      }
      return firstTokenType;
    }
    else if (firstTokenType == MULTI_LINE_COMMENT_START || firstTokenType == MULTI_LINE_DOC_COMMENT_START) {
      // merge multiline comments that are parsed in parts into single element
      while (true) {
        final IElementType nextTokenType = originalLexer.getTokenType();
        if (nextTokenType == null) break; // EOF reached, multi-line comment is not closed

        originalLexer.advance();
        if (nextTokenType == MULTI_LINE_COMMENT_END) break;

        assert nextTokenType == MULTI_LINE_COMMENT_BODY : nextTokenType;
      }

      return firstTokenType == MULTI_LINE_DOC_COMMENT_START ? MULTI_LINE_DOC_COMMENT
          : MULTI_LINE_COMMENT;
    }

    return firstTokenType;
  };

  @Override
  public MergeFunction getMergeFunction() {
    return MERGE_FUNCTION;
  }
}
