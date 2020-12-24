// This is a generated file. Not intended for manual editing.
package io.github.jhipster.jdl.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.github.jhipster.jdl.psi.impl.*;

public interface JdlTypes {

  IElementType APPLICATION_CONFIG = new JdlElementType("APPLICATION_CONFIG");
  IElementType APPLICATION_DEFINITION = new JdlElementType("APPLICATION_DEFINITION");
  IElementType APPLICATION_ENTITIES = new JdlElementType("APPLICATION_ENTITIES");
  IElementType ARGUMENT_LIST = new JdlElementType("ARGUMENT_LIST");
  IElementType ARGUMENT_VALUE = new JdlElementType("ARGUMENT_VALUE");
  IElementType COMPONENT_NAME = new JdlElementType("COMPONENT_NAME");
  IElementType CONFIG_ARRAY_ITEM = new JdlElementType("CONFIG_ARRAY_ITEM");
  IElementType CONFIG_ARRAY_ITEM_KEY = new JdlElementType("CONFIG_ARRAY_ITEM_KEY");
  IElementType CONFIG_ARRAY_ITEM_VALUE = new JdlElementType("CONFIG_ARRAY_ITEM_VALUE");
  IElementType CONFIG_BOOLEAN_ITEM = new JdlElementType("CONFIG_BOOLEAN_ITEM");
  IElementType CONFIG_BOOLEAN_ITEM_KEY = new JdlElementType("CONFIG_BOOLEAN_ITEM_KEY");
  IElementType CONFIG_BOOLEAN_ITEM_VALUE = new JdlElementType("CONFIG_BOOLEAN_ITEM_VALUE");
  IElementType CONFIG_NUMBER_ITEM = new JdlElementType("CONFIG_NUMBER_ITEM");
  IElementType CONFIG_NUMBER_ITEM_KEY = new JdlElementType("CONFIG_NUMBER_ITEM_KEY");
  IElementType CONFIG_NUMBER_ITEM_VALUE = new JdlElementType("CONFIG_NUMBER_ITEM_VALUE");
  IElementType CONFIG_STRING_ITEM = new JdlElementType("CONFIG_STRING_ITEM");
  IElementType CONFIG_STRING_ITEM_KEY = new JdlElementType("CONFIG_STRING_ITEM_KEY");
  IElementType CONFIG_STRING_ITEM_VALUE = new JdlElementType("CONFIG_STRING_ITEM_VALUE");
  IElementType ENTITY_DEFINITION = new JdlElementType("ENTITY_DEFINITION");
  IElementType ENUM_CONSTANT_DECLARATION = new JdlElementType("ENUM_CONSTANT_DECLARATION");
  IElementType ENUM_DEFINITION = new JdlElementType("ENUM_DEFINITION");
  IElementType FIELD_MEMBER = new JdlElementType("FIELD_MEMBER");
  IElementType FIELD_NAME = new JdlElementType("FIELD_NAME");
  IElementType FIELD_TYPE_DEFINITION = new JdlElementType("FIELD_TYPE_DEFINITION");
  IElementType ID = new JdlElementType("ID");
  IElementType METADATA = new JdlElementType("METADATA");
  IElementType OPTION_DEFINITION = new JdlElementType("OPTION_DEFINITION");
  IElementType OPTION_DEFINITIONS = new JdlElementType("OPTION_DEFINITIONS");
  IElementType OPTION_NAME = new JdlElementType("OPTION_NAME");
  IElementType OPTION_TYPE_BODY = new JdlElementType("OPTION_TYPE_BODY");
  IElementType OPTION_TYPE_VALUE = new JdlElementType("OPTION_TYPE_VALUE");
  IElementType PACKAGE_NAME_CONFIG_ITEM = new JdlElementType("PACKAGE_NAME_CONFIG_ITEM");
  IElementType PACKAGE_NAME_IDENTIFIER = new JdlElementType("PACKAGE_NAME_IDENTIFIER");
  IElementType RELATIONSHIP_DEFINITION = new JdlElementType("RELATIONSHIP_DEFINITION");
  IElementType RELATIONSHIP_FIELD_DISPLAY_NAME = new JdlElementType("RELATIONSHIP_FIELD_DISPLAY_NAME");
  IElementType RELATIONSHIP_FIELD_NAME = new JdlElementType("RELATIONSHIP_FIELD_NAME");
  IElementType RELATIONSHIP_ITEMS = new JdlElementType("RELATIONSHIP_ITEMS");
  IElementType RELATIONSHIP_SOURCE_TYPE = new JdlElementType("RELATIONSHIP_SOURCE_TYPE");
  IElementType RELATIONSHIP_TARGET_TYPE = new JdlElementType("RELATIONSHIP_TARGET_TYPE");
  IElementType RELATIONSHIP_TYPE = new JdlElementType("RELATIONSHIP_TYPE");
  IElementType RELATIONSHIP_TYPE_OPTIONS = new JdlElementType("RELATIONSHIP_TYPE_OPTIONS");

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
  IElementType BREAK = new JdlTokenType("break");
  IElementType CASE = new JdlTokenType("case");
  IElementType CATCH = new JdlTokenType("catch");
  IElementType CFG_APPLICATION_TYPE = new JdlTokenType("applicationType");
  IElementType CFG_AUTHENTICATION_TYPE = new JdlTokenType("authenticationType");
  IElementType CFG_BASE_NAME = new JdlTokenType("baseName");
  IElementType CFG_BUILD_TOOL = new JdlTokenType("buildTool");
  IElementType CFG_CACHE_PROVIDER = new JdlTokenType("cacheProvider");
  IElementType CFG_CLIENT_FRAMEWORK = new JdlTokenType("clientFramework");
  IElementType CFG_DATABASE_TYPE = new JdlTokenType("databaseType");
  IElementType CFG_DEV_DATABASE_TYPE = new JdlTokenType("devDatabaseType");
  IElementType CFG_ENABLE_HIBERNATE_CACHE = new JdlTokenType("enableHibernateCache");
  IElementType CFG_PACKAGE_NAME = new JdlTokenType("packageName");
  IElementType CFG_PROD_DATABASE_TYPE = new JdlTokenType("prodDatabaseType");
  IElementType CFG_SERVER_PORT = new JdlTokenType("serverPort");
  IElementType CFG_SERVICE_DISCOVERY_TYPE = new JdlTokenType("serviceDiscoveryType");
  IElementType CFG_SKIP_USER_MANAGEMENT = new JdlTokenType("skipUserManagement");
  IElementType CFG_TEST_FRAMEWORKS = new JdlTokenType("testFrameworks");
  IElementType CFG_USE_SASS = new JdlTokenType("useSass");
  IElementType CLASS = new JdlTokenType("class");
  IElementType COLON = new JdlTokenType(":");
  IElementType COMMA = new JdlTokenType(",");
  IElementType CONST = new JdlTokenType("const");
  IElementType CONTINUE = new JdlTokenType("continue");
  IElementType COVARIANT = new JdlTokenType("covariant");
  IElementType DEFAULT = new JdlTokenType("default");
  IElementType DEFERRED = new JdlTokenType("deferred");
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
  IElementType HEX_NUMBER = new JdlTokenType("HEX_NUMBER");
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
  IElementType LPAREN = new JdlTokenType("(");
  IElementType LT = new JdlTokenType("<");
  IElementType LT_EQ = new JdlTokenType("<=");
  IElementType LT_LT = new JdlTokenType("<<");
  IElementType LT_LT_EQ = new JdlTokenType("<<=");
  IElementType MANY_TO_MANY = new JdlTokenType("ManyToMany");
  IElementType MANY_TO_ONE = new JdlTokenType("ManyToOne");
  IElementType MINUS = new JdlTokenType("-");
  IElementType MINUS_EQ = new JdlTokenType("-=");
  IElementType MINUS_MINUS = new JdlTokenType("--");
  IElementType MIXIN = new JdlTokenType("mixin");
  IElementType MUL = new JdlTokenType("*");
  IElementType MUL_EQ = new JdlTokenType("*=");
  IElementType NATIVE = new JdlTokenType("native");
  IElementType NEQ = new JdlTokenType("!=");
  IElementType NEW = new JdlTokenType("new");
  IElementType NOT = new JdlTokenType("!");
  IElementType NULL = new JdlTokenType("null");
  IElementType NUMBER = new JdlTokenType("NUMBER");
  IElementType NUM_ANY_BLOB = new JdlTokenType("AnyBlob");
  IElementType NUM_BIG_DECIMAL = new JdlTokenType("BigDecimal");
  IElementType NUM_BLOB = new JdlTokenType("Blob");
  IElementType NUM_BOOELAN = new JdlTokenType("Boolean");
  IElementType NUM_DOUBLE = new JdlTokenType("Double");
  IElementType NUM_ENUM = new JdlTokenType("Enum");
  IElementType NUM_FLOAT = new JdlTokenType("Float");
  IElementType NUM_IMAGE_BLOB = new JdlTokenType("ImageBlob");
  IElementType NUM_INSTANT = new JdlTokenType("Instant");
  IElementType NUM_INT = new JdlTokenType("Integer");
  IElementType NUM_LOCAL_DATE = new JdlTokenType("LocalDate");
  IElementType NUM_LONG = new JdlTokenType("Long");
  IElementType NUM_STRING = new JdlTokenType("String");
  IElementType NUM_TEXT_BLOB = new JdlTokenType("TextBlob");
  IElementType NUM_ZONED_DATE_TIME = new JdlTokenType("ZonedDateTime");
  IElementType OF = new JdlTokenType("of");
  IElementType ON = new JdlTokenType("on");
  IElementType ONE_TO_MANY = new JdlTokenType("OneToMany");
  IElementType ONE_TO_ONE = new JdlTokenType("OneToOne");
  IElementType OPERATOR = new JdlTokenType("operator");
  IElementType OPTION_ANGULAR_SUFFIX = new JdlTokenType("angularSuffix");
  IElementType OPTION_CLIENT_ROOT_FOLDER = new JdlTokenType("clientRootFolder");
  IElementType OPTION_DTO = new JdlTokenType("dto");
  IElementType OPTION_FILTER = new JdlTokenType("filter");
  IElementType OPTION_MICRO_SERVICE = new JdlTokenType("microservice");
  IElementType OPTION_NO_FLUENT_METHOD = new JdlTokenType("noFluentMethod");
  IElementType OPTION_PAGINATE = new JdlTokenType("paginate");
  IElementType OPTION_READONLY = new JdlTokenType("readOnly");
  IElementType OPTION_SEARCH = new JdlTokenType("search");
  IElementType OPTION_SERVICE = new JdlTokenType("service");
  IElementType OPTION_SKIP_CLIENT = new JdlTokenType("skipClient");
  IElementType OPTION_SKIP_SERVER = new JdlTokenType("skipServer");
  IElementType OR = new JdlTokenType("|");
  IElementType OR_EQ = new JdlTokenType("|=");
  IElementType OR_OR = new JdlTokenType("||");
  IElementType OR_OR_EQ = new JdlTokenType("||=");
  IElementType PACKAGE_NAME = new JdlTokenType("PACKAGE_NAME");
  IElementType PART = new JdlTokenType("part");
  IElementType PATTERN = new JdlTokenType("PATTERN");
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
  IElementType RELATIONSHIP = new JdlTokenType("relationship");
  IElementType REM = new JdlTokenType("%");
  IElementType REM_EQ = new JdlTokenType("%=");
  IElementType REQUIRED = new JdlTokenType("required");
  IElementType RETHROW = new JdlTokenType("rethrow");
  IElementType RETURN = new JdlTokenType("return");
  IElementType RPAREN = new JdlTokenType(")");
  IElementType SEMICOLON = new JdlTokenType(";");
  IElementType SET = new JdlTokenType("set");
  IElementType SHOW = new JdlTokenType("show");
  IElementType STATIC = new JdlTokenType("static");
  IElementType SUPER = new JdlTokenType("super");
  IElementType SWITCH = new JdlTokenType("switch");
  IElementType SYNC = new JdlTokenType("sync");
  IElementType THIS = new JdlTokenType("this");
  IElementType THROW = new JdlTokenType("throw");
  IElementType TO = new JdlTokenType("to");
  IElementType TRUE = new JdlTokenType("true");
  IElementType TRY = new JdlTokenType("try");
  IElementType TYPEDEF = new JdlTokenType("typedef");
  IElementType T_WRONG = new JdlTokenType("wrong token");
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
      if (type == APPLICATION_CONFIG) {
        return new JdlApplicationConfigImpl(node);
      }
      else if (type == APPLICATION_DEFINITION) {
        return new JdlApplicationDefinitionImpl(node);
      }
      else if (type == APPLICATION_ENTITIES) {
        return new JdlApplicationEntitiesImpl(node);
      }
      else if (type == ARGUMENT_LIST) {
        return new JdlArgumentListImpl(node);
      }
      else if (type == ARGUMENT_VALUE) {
        return new JdlArgumentValueImpl(node);
      }
      else if (type == COMPONENT_NAME) {
        return new JdlComponentNameImpl(node);
      }
      else if (type == CONFIG_ARRAY_ITEM) {
        return new JdlConfigArrayItemImpl(node);
      }
      else if (type == CONFIG_ARRAY_ITEM_KEY) {
        return new JdlConfigArrayItemKeyImpl(node);
      }
      else if (type == CONFIG_ARRAY_ITEM_VALUE) {
        return new JdlConfigArrayItemValueImpl(node);
      }
      else if (type == CONFIG_BOOLEAN_ITEM) {
        return new JdlConfigBooleanItemImpl(node);
      }
      else if (type == CONFIG_BOOLEAN_ITEM_KEY) {
        return new JdlConfigBooleanItemKeyImpl(node);
      }
      else if (type == CONFIG_BOOLEAN_ITEM_VALUE) {
        return new JdlConfigBooleanItemValueImpl(node);
      }
      else if (type == CONFIG_NUMBER_ITEM) {
        return new JdlConfigNumberItemImpl(node);
      }
      else if (type == CONFIG_NUMBER_ITEM_KEY) {
        return new JdlConfigNumberItemKeyImpl(node);
      }
      else if (type == CONFIG_NUMBER_ITEM_VALUE) {
        return new JdlConfigNumberItemValueImpl(node);
      }
      else if (type == CONFIG_STRING_ITEM) {
        return new JdlConfigStringItemImpl(node);
      }
      else if (type == CONFIG_STRING_ITEM_KEY) {
        return new JdlConfigStringItemKeyImpl(node);
      }
      else if (type == CONFIG_STRING_ITEM_VALUE) {
        return new JdlConfigStringItemValueImpl(node);
      }
      else if (type == ENTITY_DEFINITION) {
        return new JdlEntityDefinitionImpl(node);
      }
      else if (type == ENUM_CONSTANT_DECLARATION) {
        return new JdlEnumConstantDeclarationImpl(node);
      }
      else if (type == ENUM_DEFINITION) {
        return new JdlEnumDefinitionImpl(node);
      }
      else if (type == FIELD_MEMBER) {
        return new JdlFieldMemberImpl(node);
      }
      else if (type == FIELD_NAME) {
        return new JdlFieldNameImpl(node);
      }
      else if (type == FIELD_TYPE_DEFINITION) {
        return new JdlFieldTypeDefinitionImpl(node);
      }
      else if (type == ID) {
        return new JdlIdImpl(node);
      }
      else if (type == METADATA) {
        return new JdlMetadataImpl(node);
      }
      else if (type == OPTION_DEFINITION) {
        return new JdlOptionDefinitionImpl(node);
      }
      else if (type == OPTION_DEFINITIONS) {
        return new JdlOptionDefinitionsImpl(node);
      }
      else if (type == OPTION_NAME) {
        return new JdlOptionNameImpl(node);
      }
      else if (type == OPTION_TYPE_BODY) {
        return new JdlOptionTypeBodyImpl(node);
      }
      else if (type == OPTION_TYPE_VALUE) {
        return new JdlOptionTypeValueImpl(node);
      }
      else if (type == PACKAGE_NAME_CONFIG_ITEM) {
        return new JdlPackageNameConfigItemImpl(node);
      }
      else if (type == PACKAGE_NAME_IDENTIFIER) {
        return new JdlPackageNameIdentifierImpl(node);
      }
      else if (type == RELATIONSHIP_DEFINITION) {
        return new JdlRelationshipDefinitionImpl(node);
      }
      else if (type == RELATIONSHIP_FIELD_DISPLAY_NAME) {
        return new JdlRelationshipFieldDisplayNameImpl(node);
      }
      else if (type == RELATIONSHIP_FIELD_NAME) {
        return new JdlRelationshipFieldNameImpl(node);
      }
      else if (type == RELATIONSHIP_ITEMS) {
        return new JdlRelationshipItemsImpl(node);
      }
      else if (type == RELATIONSHIP_SOURCE_TYPE) {
        return new JdlRelationshipSourceTypeImpl(node);
      }
      else if (type == RELATIONSHIP_TARGET_TYPE) {
        return new JdlRelationshipTargetTypeImpl(node);
      }
      else if (type == RELATIONSHIP_TYPE) {
        return new JdlRelationshipTypeImpl(node);
      }
      else if (type == RELATIONSHIP_TYPE_OPTIONS) {
        return new JdlRelationshipTypeOptionsImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
