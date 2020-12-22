// This is a generated file. Not intended for manual editing.
package io.github.jhipster.jdl.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.github.jhipster.jdl.psi.impl.*;

public interface JdlTypes {

  IElementType APPLICATION_ENTITIES = new JdlElementType("APPLICATION_ENTITIES");
  IElementType APPLICATION_TYPE_BODY = new JdlElementType("APPLICATION_TYPE_BODY");
  IElementType APPLICATION_TYPE_BODY_INNER = new JdlElementType("APPLICATION_TYPE_BODY_INNER");
  IElementType APPLICATION_TYPE_DEFINITION = new JdlElementType("APPLICATION_TYPE_DEFINITION");
  IElementType COMPONENT_NAME = new JdlElementType("COMPONENT_NAME");
  IElementType DIRECTIVE_TYPE_BODY = new JdlElementType("DIRECTIVE_TYPE_BODY");
  IElementType DIRECTIVE_TYPE_DEFINITION = new JdlElementType("DIRECTIVE_TYPE_DEFINITION");
  IElementType ENTITY_NAMES = new JdlElementType("ENTITY_NAMES");
  IElementType ENTITY_TYPE_BODY = new JdlElementType("ENTITY_TYPE_BODY");
  IElementType ENTITY_TYPE_BODY_INNER = new JdlElementType("ENTITY_TYPE_BODY_INNER");
  IElementType ENTITY_TYPE_DEFINITION = new JdlElementType("ENTITY_TYPE_DEFINITION");
  IElementType ENTRY = new JdlElementType("ENTRY");
  IElementType ENUM_CONSTANT_DECLARATION = new JdlElementType("ENUM_CONSTANT_DECLARATION");
  IElementType ENUM_TYPE_BODY_INNER = new JdlElementType("ENUM_TYPE_BODY_INNER");
  IElementType ENUM_TYPE_DEFINITION = new JdlElementType("ENUM_TYPE_DEFINITION");
  IElementType FIELD_MEMBER = new JdlElementType("FIELD_MEMBER");
  IElementType ID = new JdlElementType("ID");

  IElementType ABSTRACT = new JdlTokenType("abstract");
  IElementType AND = new JdlTokenType("&");
  IElementType AND_AND = new JdlTokenType("&&");
  IElementType AND_AND_EQ = new JdlTokenType("&&=");
  IElementType AND_EQ = new JdlTokenType("&=");
  IElementType APPLICATION = new JdlTokenType("application");
  IElementType AP_CONFIG = new JdlTokenType("config");
  IElementType AP_ENTITIES = new JdlTokenType("entities");
  IElementType AS = new JdlTokenType("as");
  IElementType ASSERT = new JdlTokenType("assert");
  IElementType ASYNC = new JdlTokenType("async");
  IElementType AT = new JdlTokenType("@");
  IElementType AWAIT = new JdlTokenType("await");
  IElementType BIN_NOT = new JdlTokenType("~");
  IElementType BLANK = new JdlTokenType("BLANK");
  IElementType BREAK = new JdlTokenType("break");
  IElementType CASE = new JdlTokenType("case");
  IElementType CATCH = new JdlTokenType("catch");
  IElementType CLASS = new JdlTokenType("class");
  IElementType COLON = new JdlTokenType(":");
  IElementType COMMA = new JdlTokenType(",");
  IElementType CONST = new JdlTokenType("const");
  IElementType CONTINUE = new JdlTokenType("continue");
  IElementType COVARIANT = new JdlTokenType("covariant");
  IElementType DEFAULT = new JdlTokenType("default");
  IElementType DEFERRED = new JdlTokenType("deferred");
  IElementType DIRECTIVE_MICROSERVICE = new JdlTokenType("microservice");
  IElementType DIRECTIVE_PAGINATE = new JdlTokenType("paginate");
  IElementType DIRECTIVE_SERVICE = new JdlTokenType("service");
  IElementType DIV = new JdlTokenType("/");
  IElementType DIV_EQ = new JdlTokenType("/=");
  IElementType DO = new JdlTokenType("do");
  IElementType DOT = new JdlTokenType(".");
  IElementType DOT_DOT = new JdlTokenType("..");
  IElementType DOT_DOT_DOT = new JdlTokenType("...");
  IElementType DOT_DOT_DOT_QUEST = new JdlTokenType("...?");
  IElementType ELSE = new JdlTokenType("else");
  IElementType ENTITY = new JdlTokenType("entity");
  IElementType ENUM = new JdlTokenType("enum");
  IElementType EQ = new JdlTokenType("=");
  IElementType EQ_EQ = new JdlTokenType("==");
  IElementType EXPORT = new JdlTokenType("export");
  IElementType EXPRESSION_BODY_DEF = new JdlTokenType("=>");
  IElementType EXTENDS = new JdlTokenType("extends");
  IElementType EXTENSION = new JdlTokenType("extension");
  IElementType EXTERNAL = new JdlTokenType("external");
  IElementType FACTORY = new JdlTokenType("factory");
  IElementType FALSE = new JdlTokenType("false");
  IElementType FINAL = new JdlTokenType("final");
  IElementType FINALLY = new JdlTokenType("finally");
  IElementType FOR = new JdlTokenType("for");
  IElementType GET = new JdlTokenType("get");
  IElementType GT = new JdlTokenType(">");
  IElementType GT_EQ = new JdlTokenType(">=");
  IElementType GT_GT = new JdlTokenType(">>");
  IElementType GT_GT_EQ = new JdlTokenType(">>=");
  IElementType HASH = new JdlTokenType("#");
  IElementType HIDE = new JdlTokenType("hide");
  IElementType IDENTIFIER = new JdlTokenType("IDENTIFIER");
  IElementType IF = new JdlTokenType("if");
  IElementType IMPLEMENTS = new JdlTokenType("implements");
  IElementType IMPORT = new JdlTokenType("import");
  IElementType IN = new JdlTokenType("in");
  IElementType INT_DIV = new JdlTokenType("~/");
  IElementType INT_DIV_EQ = new JdlTokenType("~/=");
  IElementType IS = new JdlTokenType("is");
  IElementType LATE = new JdlTokenType("late");
  IElementType LBRACE = new JdlTokenType("{");
  IElementType LBRACKET = new JdlTokenType("[");
  IElementType LIBRARY = new JdlTokenType("library");
  IElementType LINEFEED = new JdlTokenType("\\n");
  IElementType LOW_ID = new JdlTokenType("LOW_ID");
  IElementType LPAREN = new JdlTokenType("(");
  IElementType LT = new JdlTokenType("<");
  IElementType LT_EQ = new JdlTokenType("<=");
  IElementType LT_LT = new JdlTokenType("<<");
  IElementType LT_LT_EQ = new JdlTokenType("<<=");
  IElementType MINUS = new JdlTokenType("-");
  IElementType MINUS_EQ = new JdlTokenType("-=");
  IElementType MINUS_MINUS = new JdlTokenType("--");
  IElementType MIXIN = new JdlTokenType("mixin");
  IElementType ML_COMMENT = new JdlTokenType("block comment");
  IElementType MUL = new JdlTokenType("*");
  IElementType MUL_EQ = new JdlTokenType("*=");
  IElementType NATIVE = new JdlTokenType("native");
  IElementType NEQ = new JdlTokenType("!=");
  IElementType NEW = new JdlTokenType("new");
  IElementType NL = new JdlTokenType("NL");
  IElementType NOT = new JdlTokenType("!");
  IElementType NULL = new JdlTokenType("null");
  IElementType NUM_ANY_BLOB = new JdlTokenType("AnyBlob");
  IElementType NUM_BIG_DECIMAL = new JdlTokenType("BigDecimal");
  IElementType NUM_BLOB = new JdlTokenType("Blob");
  IElementType NUM_BOOELAN = new JdlTokenType("Boolean");
  IElementType NUM_DOUBLE = new JdlTokenType("Double");
  IElementType NUM_ENUM = new JdlTokenType("Enum");
  IElementType NUM_FLOAT = new JdlTokenType("Float");
  IElementType NUM_IMAGE_BLOB = new JdlTokenType("ImageBlob");
  IElementType NUM_INT = new JdlTokenType("Integer");
  IElementType NUM_LOCAL_DATE = new JdlTokenType("LocalDate");
  IElementType NUM_LONG = new JdlTokenType("Long");
  IElementType NUM_STRING = new JdlTokenType("String");
  IElementType NUM_TEXT_BLOB = new JdlTokenType("TextBlob");
  IElementType NUM_ZONED_DATE_TIME = new JdlTokenType("ZonedDateTime");
  IElementType OF = new JdlTokenType("of");
  IElementType ON = new JdlTokenType("on");
  IElementType OPERATOR = new JdlTokenType("operator");
  IElementType OR = new JdlTokenType("|");
  IElementType OR_EQ = new JdlTokenType("|=");
  IElementType OR_OR = new JdlTokenType("||");
  IElementType OR_OR_EQ = new JdlTokenType("||=");
  IElementType PART = new JdlTokenType("part");
  IElementType PLUS = new JdlTokenType("+");
  IElementType PLUS_EQ = new JdlTokenType("+=");
  IElementType PLUS_PLUS = new JdlTokenType("++");
  IElementType QUEST = new JdlTokenType("?");
  IElementType QUEST_DOT = new JdlTokenType("?.");
  IElementType QUEST_DOT_DOT = new JdlTokenType("?..");
  IElementType QUEST_QUEST = new JdlTokenType("??");
  IElementType QUEST_QUEST_EQ = new JdlTokenType("??=");
  IElementType RBRACE = new JdlTokenType("}");
  IElementType RBRACKET = new JdlTokenType("]");
  IElementType REM = new JdlTokenType("%");
  IElementType REM_EQ = new JdlTokenType("%=");
  IElementType REQUIRED = new JdlTokenType("required");
  IElementType RETHROW = new JdlTokenType("rethrow");
  IElementType RETURN = new JdlTokenType("return");
  IElementType RPAREN = new JdlTokenType(")");
  IElementType SEMICOLON = new JdlTokenType(";");
  IElementType SET = new JdlTokenType("set");
  IElementType SHOW = new JdlTokenType("show");
  IElementType SH_COMMENT = new JdlTokenType("shell comment");
  IElementType SL_COMMENT = new JdlTokenType("line comment");
  IElementType STATIC = new JdlTokenType("static");
  IElementType SUPER = new JdlTokenType("super");
  IElementType SWITCH = new JdlTokenType("switch");
  IElementType SYNC = new JdlTokenType("sync");
  IElementType THIS = new JdlTokenType("this");
  IElementType THROW = new JdlTokenType("throw");
  IElementType TRUE = new JdlTokenType("true");
  IElementType TRY = new JdlTokenType("try");
  IElementType TYPEDEF = new JdlTokenType("typedef");
  IElementType T_WRONG = new JdlTokenType("wrong token");
  IElementType UP_ID = new JdlTokenType("UP_ID");
  IElementType VAR = new JdlTokenType("var");
  IElementType VOID = new JdlTokenType("void");
  IElementType WHILE = new JdlTokenType("while");
  IElementType WITH = new JdlTokenType("with");
  IElementType XOR = new JdlTokenType("^");
  IElementType XOR_EQ = new JdlTokenType("^=");
  IElementType YIELD = new JdlTokenType("yield");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == APPLICATION_ENTITIES) {
        return new JdlApplicationEntitiesImpl(node);
      }
      else if (type == APPLICATION_TYPE_BODY) {
        return new JdlApplicationTypeBodyImpl(node);
      }
      else if (type == APPLICATION_TYPE_BODY_INNER) {
        return new JdlApplicationTypeBodyInnerImpl(node);
      }
      else if (type == APPLICATION_TYPE_DEFINITION) {
        return new JdlApplicationTypeDefinitionImpl(node);
      }
      else if (type == COMPONENT_NAME) {
        return new JdlComponentNameImpl(node);
      }
      else if (type == DIRECTIVE_TYPE_BODY) {
        return new JdlDirectiveTypeBodyImpl(node);
      }
      else if (type == DIRECTIVE_TYPE_DEFINITION) {
        return new JdlDirectiveTypeDefinitionImpl(node);
      }
      else if (type == ENTITY_NAMES) {
        return new JdlEntityNamesImpl(node);
      }
      else if (type == ENTITY_TYPE_BODY) {
        return new JdlEntityTypeBodyImpl(node);
      }
      else if (type == ENTITY_TYPE_BODY_INNER) {
        return new JdlEntityTypeBodyInnerImpl(node);
      }
      else if (type == ENTITY_TYPE_DEFINITION) {
        return new JdlEntityTypeDefinitionImpl(node);
      }
      else if (type == ENTRY) {
        return new JdlEntryImpl(node);
      }
      else if (type == ENUM_CONSTANT_DECLARATION) {
        return new JdlEnumConstantDeclarationImpl(node);
      }
      else if (type == ENUM_TYPE_BODY_INNER) {
        return new JdlEnumTypeBodyInnerImpl(node);
      }
      else if (type == ENUM_TYPE_DEFINITION) {
        return new JdlEnumTypeDefinitionImpl(node);
      }
      else if (type == FIELD_MEMBER) {
        return new JdlFieldMemberImpl(node);
      }
      else if (type == ID) {
        return new JdlIdImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
