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

  //TokenSet STRINGS = TokenSet.create(RAW_SINGLE_QUOTED_STRING, RAW_TRIPLE_QUOTED_STRING, OPEN_QUOTE, CLOSING_QUOTE, REGULAR_STRING_PART);

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

  TokenSet COMMENTS = TokenSet.create(SINGLE_LINE_COMMENT, SINGLE_LINE_DOC_COMMENT, MULTI_LINE_COMMENT, MULTI_LINE_DOC_COMMENT);

  TokenSet RESERVED_WORDS = TokenSet.create(
      APPLICATION,
      ENTITY,
      ENUM,
      RELATIONSHIP,
      AP_ENTITIES,
      AP_CONFIG
      );

  TokenSet OPTIONS = TokenSet.create(
      OPTION_SERVICE,
      OPTION_PAGINATE,
      OPTION_MICRO_SERVICE,
      OPTION_SKIP_CLIENT,
      OPTION_SKIP_SERVER,
      OPTION_NO_FLUENT_METHOD,
      OPTION_FILTER,
      OPTION_READONLY,
      OPTION_DTO,
      OPTION_SEARCH,
      OPTION_ANGULAR_SUFFIX,
      OPTION_CLIENT_ROOT_FOLDER
  );

  TokenSet FIELD_TYPES = TokenSet.create(
      NUM_STRING,
      NUM_INT,
      NUM_LONG,
      NUM_BIG_DECIMAL,
      NUM_FLOAT,
      NUM_DOUBLE,
      NUM_ENUM,
      NUM_BOOELAN,
      NUM_LOCAL_DATE,
      NUM_INSTANT,
      NUM_ZONED_DATE_TIME,
      NUM_BLOB,
      NUM_ANY_BLOB,
      NUM_IMAGE_BLOB,
      NUM_TEXT_BLOB
  );

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
