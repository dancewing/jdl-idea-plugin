package io.github.jhipster.jdl;

import static io.github.jhipster.jdl.psi.JdlTypes.ABSTRACT;
import static io.github.jhipster.jdl.psi.JdlTypes.APPLICATION;
import static io.github.jhipster.jdl.psi.JdlTypes.APPLICATIONTYPE;
import static io.github.jhipster.jdl.psi.JdlTypes.AP_CONFIG;
import static io.github.jhipster.jdl.psi.JdlTypes.AP_ENTITIES;
import static io.github.jhipster.jdl.psi.JdlTypes.AS;
import static io.github.jhipster.jdl.psi.JdlTypes.ASYNC;
import static io.github.jhipster.jdl.psi.JdlTypes.AUTHENTICATIONTYPE;
import static io.github.jhipster.jdl.psi.JdlTypes.AWAIT;
import static io.github.jhipster.jdl.psi.JdlTypes.BASENAME;
import static io.github.jhipster.jdl.psi.JdlTypes.BUILDTOOL;
import static io.github.jhipster.jdl.psi.JdlTypes.CACHEPROVIDER;
import static io.github.jhipster.jdl.psi.JdlTypes.CLIENTFRAMEWORK;
import static io.github.jhipster.jdl.psi.JdlTypes.CLIENTPACKAGEMANAGER;
import static io.github.jhipster.jdl.psi.JdlTypes.CLIENTTHEME;
import static io.github.jhipster.jdl.psi.JdlTypes.CLIENTTHEMEVARIANT;
import static io.github.jhipster.jdl.psi.JdlTypes.COVARIANT;
import static io.github.jhipster.jdl.psi.JdlTypes.DATABASETYPE;
import static io.github.jhipster.jdl.psi.JdlTypes.DEFERRED;
import static io.github.jhipster.jdl.psi.JdlTypes.DEVDATABASETYPE;
import static io.github.jhipster.jdl.psi.JdlTypes.DTOSUFFIX;
import static io.github.jhipster.jdl.psi.JdlTypes.ENABLEHIBERNATECACHE;
import static io.github.jhipster.jdl.psi.JdlTypes.ENABLESWAGGERCODEGEN;
import static io.github.jhipster.jdl.psi.JdlTypes.ENABLETRANSLATION;
import static io.github.jhipster.jdl.psi.JdlTypes.ENTITY;
import static io.github.jhipster.jdl.psi.JdlTypes.ENTITYSUFFIX;
import static io.github.jhipster.jdl.psi.JdlTypes.ENUM;
import static io.github.jhipster.jdl.psi.JdlTypes.EXPORT;
import static io.github.jhipster.jdl.psi.JdlTypes.EXTENSION;
import static io.github.jhipster.jdl.psi.JdlTypes.EXTERNAL;
import static io.github.jhipster.jdl.psi.JdlTypes.FACTORY;
import static io.github.jhipster.jdl.psi.JdlTypes.GET;
import static io.github.jhipster.jdl.psi.JdlTypes.GLOBAL;
import static io.github.jhipster.jdl.psi.JdlTypes.HIDE;
import static io.github.jhipster.jdl.psi.JdlTypes.IMPLEMENTS;
import static io.github.jhipster.jdl.psi.JdlTypes.IMPORT;
import static io.github.jhipster.jdl.psi.JdlTypes.JHIPREFIX;
import static io.github.jhipster.jdl.psi.JdlTypes.LANGUAGES;
import static io.github.jhipster.jdl.psi.JdlTypes.LATE;
import static io.github.jhipster.jdl.psi.JdlTypes.LIBRARY;
import static io.github.jhipster.jdl.psi.JdlTypes.MESSAGEBROKER;
import static io.github.jhipster.jdl.psi.JdlTypes.MIXIN;
import static io.github.jhipster.jdl.psi.JdlTypes.NATIVE;
import static io.github.jhipster.jdl.psi.JdlTypes.NATIVELANGUAGE;
import static io.github.jhipster.jdl.psi.JdlTypes.NUM_ANY_BLOB;
import static io.github.jhipster.jdl.psi.JdlTypes.NUM_BIG_DECIMAL;
import static io.github.jhipster.jdl.psi.JdlTypes.NUM_BLOB;
import static io.github.jhipster.jdl.psi.JdlTypes.NUM_BOOELAN;
import static io.github.jhipster.jdl.psi.JdlTypes.NUM_DOUBLE;
import static io.github.jhipster.jdl.psi.JdlTypes.NUM_ENUM;
import static io.github.jhipster.jdl.psi.JdlTypes.NUM_FLOAT;
import static io.github.jhipster.jdl.psi.JdlTypes.NUM_IMAGE_BLOB;
import static io.github.jhipster.jdl.psi.JdlTypes.NUM_INSTANT;
import static io.github.jhipster.jdl.psi.JdlTypes.NUM_INT;
import static io.github.jhipster.jdl.psi.JdlTypes.NUM_LOCAL_DATE;
import static io.github.jhipster.jdl.psi.JdlTypes.NUM_LONG;
import static io.github.jhipster.jdl.psi.JdlTypes.NUM_STRING;
import static io.github.jhipster.jdl.psi.JdlTypes.NUM_TEXT_BLOB;
import static io.github.jhipster.jdl.psi.JdlTypes.NUM_ZONED_DATE_TIME;
import static io.github.jhipster.jdl.psi.JdlTypes.OF;
import static io.github.jhipster.jdl.psi.JdlTypes.ON;
import static io.github.jhipster.jdl.psi.JdlTypes.OPERATOR;
import static io.github.jhipster.jdl.psi.JdlTypes.OPTION_ANGULAR_SUFFIX;
import static io.github.jhipster.jdl.psi.JdlTypes.OPTION_CLIENT_ROOT_FOLDER;
import static io.github.jhipster.jdl.psi.JdlTypes.OPTION_DTO;
import static io.github.jhipster.jdl.psi.JdlTypes.OPTION_FILTER;
import static io.github.jhipster.jdl.psi.JdlTypes.OPTION_MICRO_SERVICE;
import static io.github.jhipster.jdl.psi.JdlTypes.OPTION_NO_FLUENT_METHOD;
import static io.github.jhipster.jdl.psi.JdlTypes.OPTION_PAGINATE;
import static io.github.jhipster.jdl.psi.JdlTypes.OPTION_READONLY;
import static io.github.jhipster.jdl.psi.JdlTypes.OPTION_SEARCH;
import static io.github.jhipster.jdl.psi.JdlTypes.OPTION_SERVICE;
import static io.github.jhipster.jdl.psi.JdlTypes.PACKAGENAME;
import static io.github.jhipster.jdl.psi.JdlTypes.PART;
import static io.github.jhipster.jdl.psi.JdlTypes.PRODDATABASETYPE;
import static io.github.jhipster.jdl.psi.JdlTypes.REACTIVE;
import static io.github.jhipster.jdl.psi.JdlTypes.RELATIONSHIP;
import static io.github.jhipster.jdl.psi.JdlTypes.REQUIRED;
import static io.github.jhipster.jdl.psi.JdlTypes.SEARCHENGINE;
import static io.github.jhipster.jdl.psi.JdlTypes.SERVERPORT;
import static io.github.jhipster.jdl.psi.JdlTypes.SERVICEDISCOVERYTYPE;
import static io.github.jhipster.jdl.psi.JdlTypes.SET;
import static io.github.jhipster.jdl.psi.JdlTypes.SHOW;
import static io.github.jhipster.jdl.psi.JdlTypes.SKIPCLIENT;
import static io.github.jhipster.jdl.psi.JdlTypes.SKIPSERVER;
import static io.github.jhipster.jdl.psi.JdlTypes.SKIPUSERMANAGEMENT;
import static io.github.jhipster.jdl.psi.JdlTypes.STATIC;
import static io.github.jhipster.jdl.psi.JdlTypes.SYNC;
import static io.github.jhipster.jdl.psi.JdlTypes.TESTFRAMEWORKS;
import static io.github.jhipster.jdl.psi.JdlTypes.TYPEDEF;
import static io.github.jhipster.jdl.psi.JdlTypes.USESASS;
import static io.github.jhipster.jdl.psi.JdlTypes.YIELD;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilderFactory;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.ILazyParseableElementType;
import com.intellij.psi.tree.TokenSet;
import io.github.jhipster.jdl.lexer.JdlDocLexer;
import org.jetbrains.annotations.NotNull;

public interface JdlTokenTypes {

  IFileElementType JDL_FILE = new IFileElementType("JDLFILE", JdlLanguage.INSTANCE);

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

  IElementType CFG_APPLICATION_CONFIG_ITEMS = new JdlElementType("CFG_APPLICATION_CONFIG_ITEMS");

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
      GLOBAL,
      APPLICATION,
      ENTITY,
      ENUM,
      RELATIONSHIP,
      AP_ENTITIES,
      AP_CONFIG
  );

  TokenSet CONFIG_ITEMS = TokenSet.create(
      APPLICATIONTYPE, AUTHENTICATIONTYPE, BASENAME, BUILDTOOL, CACHEPROVIDER, CLIENTFRAMEWORK, CLIENTPACKAGEMANAGER, CLIENTTHEME, CLIENTTHEMEVARIANT,
      DATABASETYPE, DEVDATABASETYPE, DTOSUFFIX, ENABLEHIBERNATECACHE, ENABLESWAGGERCODEGEN, ENABLETRANSLATION, ENTITYSUFFIX, JHIPREFIX, LANGUAGES,
      MESSAGEBROKER, NATIVELANGUAGE, PACKAGENAME, PRODDATABASETYPE, REACTIVE, SEARCHENGINE, SERVERPORT, SERVICEDISCOVERYTYPE, SKIPCLIENT, SKIPSERVER,
      SKIPUSERMANAGEMENT, TESTFRAMEWORKS, USESASS
  );

  TokenSet OPTIONS = TokenSet.create(
      OPTION_SERVICE,
      OPTION_PAGINATE,
      OPTION_MICRO_SERVICE,
      SKIPCLIENT,
      SKIPSERVER,
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
