package io.github.jhipster.jdl;

import static io.github.jhipster.jdl.psi.JdlTypes.*;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilderFactory;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.ILazyParseableElementType;
import com.intellij.psi.tree.TokenSet;
import io.github.jhipster.jdl.lexer.JdlDocLexer;
import org.jetbrains.annotations.NotNull;

public interface JdlTokenTypes {

  IElementType WHITE_SPACE = TokenType.WHITE_SPACE;
  IElementType BAD_CHARACTER = TokenType.BAD_CHARACTER;

  // DartLexer returns multiline comments as a single MULTI_LINE_COMMENT or MULTI_LINE_DOC_COMMENT
  // DartDocLexer splits MULTI_LINE_DOC_COMMENT in tokens

  // can't appear in PSI because merged into MULTI_LINE_COMMENT
  IElementType MULTI_LINE_COMMENT_START = new JdlElementType("MULTI_LINE_COMMENT_START");

  IElementType MULTI_LINE_DOC_COMMENT_START = new JdlElementType("MULTI_LINE_DOC_COMMENT_START");
  IElementType MULTI_LINE_COMMENT_BODY = new JdlElementType("MULTI_LINE_COMMENT_BODY");
  IElementType DOC_COMMENT_LEADING_ASTERISK = new JdlElementType("DOC_COMMENT_LEADING_ASTERISK");
  IElementType MULTI_LINE_COMMENT_END = new JdlElementType("MULTI_LINE_COMMENT_END");

  IElementType SINGLE_LINE_COMMENT = new JdlElementType("SINGLE_LINE_COMMENT");
  IElementType SINGLE_LINE_DOC_COMMENT = new JdlElementType("SINGLE_LINE_DOC_COMMENT");
  IElementType MULTI_LINE_COMMENT = new JdlElementType("MULTI_LINE_COMMENT");

  IElementType MULTI_LINE_DOC_COMMENT = new DartDocCommentElementType();

  class DartDocCommentElementType extends ILazyParseableElementType {
    public DartDocCommentElementType() {
      super("MULTI_LINE_DOC_COMMENT", JdlLanguage.INSTANCE);
    }

    @Override
    public ASTNode parseContents(@NotNull final ASTNode chameleon) {
      final PsiBuilder builder = PsiBuilderFactory.getInstance().createBuilder(chameleon.getTreeParent().getPsi().getProject(),
          chameleon,
          new JdlDocLexer(),
          getLanguage(),
          chameleon.getChars());
      doParse(builder);
      return builder.getTreeBuilt().getFirstChildNode();
    }

    private void doParse(final PsiBuilder builder) {
      final PsiBuilder.Marker root = builder.mark();

      while (!builder.eof()) {
        builder.advanceLexer();
      }

      root.done(this);
    }
  }

  //TokenSet RESERVED_WORDS = TokenSet.create(ASSERT)
  TokenSet COMMENTS = TokenSet.create(SINGLE_LINE_COMMENT, SINGLE_LINE_DOC_COMMENT, MULTI_LINE_COMMENT, MULTI_LINE_DOC_COMMENT);

  TokenSet BUILT_IN_IDENTIFIERS = TokenSet.create(ABSTRACT,
      AS,
      COVARIANT,
      DEFERRED,
      EXPORT,
      EXTENSION,
      EXTERNAL,
      FACTORY,
      GET,
      IMPLEMENTS,
      IMPORT,
      LIBRARY,
      MIXIN,
      OPERATOR,
      PART,
      SET,
      STATIC,
      TYPEDEF,
      // next are not listed in spec, but they seem to have the same sense as BUILT_IN_IDENTIFIERS: somewhere treated as keywords, but can be used as normal identifiers
      ON,
      OF,
      NATIVE,
      SHOW,
      HIDE,
      SYNC,
      ASYNC,
      AWAIT,
      YIELD,
      LATE,
      REQUIRED);

}
