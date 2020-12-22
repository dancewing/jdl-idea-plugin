// This is a generated file. Not intended for manual editing.
package io.github.jhipster.jdl.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static io.github.jhipster.jdl.psi.JdlTypes.*;
import static io.github.jhipster.jdl.parser.JdlParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class JdlParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return jdlFile(b, l + 1);
  }

  /* ********************************************************** */
  // '*' | entity_names
  public static boolean application_entities(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_entities")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, APPLICATION_ENTITIES, "<application entities>");
    r = consumeToken(b, MUL);
    if (!r) r = entity_names(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '{' application_type_body_inner '}'
  public static boolean application_type_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_type_body")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, APPLICATION_TYPE_BODY, null);
    r = consumeToken(b, LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, application_type_body_inner(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // application_entities
  public static boolean application_type_body_inner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_type_body_inner")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, APPLICATION_TYPE_BODY_INNER, "<application type body inner>");
    r = application_entities(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'application' application_type_body?
  public static boolean application_type_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_type_definition")) return false;
    if (!nextTokenIs(b, APPLICATION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, APPLICATION);
    r = r && application_type_definition_1(b, l + 1);
    exit_section_(b, m, APPLICATION_TYPE_DEFINITION, r);
    return r;
  }

  // application_type_body?
  private static boolean application_type_definition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_type_definition_1")) return false;
    application_type_body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // << nonStrictID >>
  public static boolean componentName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentName")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPONENT_NAME, "<component name>");
    r = nonStrictID(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'service' | 'paginate' | 'microservice'
  static boolean directive_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive_name")) return false;
    if (!nextTokenIs(b, "", DIRECTIVE_MICROSERVICE, DIRECTIVE_PAGINATE, DIRECTIVE_SERVICE)) return false;
    boolean r;
    r = consumeToken(b, DIRECTIVE_SERVICE);
    if (!r) r = consumeToken(b, DIRECTIVE_PAGINATE);
    if (!r) r = consumeToken(b, DIRECTIVE_MICROSERVICE);
    return r;
  }

  /* ********************************************************** */
  // '{' '}'
  public static boolean directive_type_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive_type_body")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LBRACE, RBRACE);
    exit_section_(b, m, DIRECTIVE_TYPE_BODY, r);
    return r;
  }

  /* ********************************************************** */
  // directive_name directive_type_body?
  public static boolean directive_type_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive_type_definition")) return false;
    if (!nextTokenIs(b, "<directive type definition>", DIRECTIVE_MICROSERVICE, DIRECTIVE_PAGINATE, DIRECTIVE_SERVICE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DIRECTIVE_TYPE_DEFINITION, "<directive type definition>");
    r = directive_name(b, l + 1);
    r = r && directive_type_definition_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // directive_type_body?
  private static boolean directive_type_definition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive_type_definition_1")) return false;
    directive_type_body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // componentName (',' componentName)*
  public static boolean entity_names(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_names")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENTITY_NAMES, "<entity names>");
    r = componentName(b, l + 1);
    r = r && entity_names_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' componentName)*
  private static boolean entity_names_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_names_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!entity_names_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "entity_names_1", c)) break;
    }
    return true;
  }

  // ',' componentName
  private static boolean entity_names_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_names_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && componentName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{' entity_type_body_inner '}'
  public static boolean entity_type_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_type_body")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENTITY_TYPE_BODY, null);
    r = consumeToken(b, LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, entity_type_body_inner(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // field_member*
  public static boolean entity_type_body_inner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_type_body_inner")) return false;
    Marker m = enter_section_(b, l, _NONE_, ENTITY_TYPE_BODY_INNER, "<entity type body inner>");
    while (true) {
      int c = current_position_(b);
      if (!field_member(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "entity_type_body_inner", c)) break;
    }
    exit_section_(b, l, m, true, false, JdlParser::simple_scope_recover);
    return true;
  }

  /* ********************************************************** */
  // 'entity' componentName entity_type_body?
  public static boolean entity_type_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_type_definition")) return false;
    if (!nextTokenIs(b, ENTITY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENTITY_TYPE_DEFINITION, null);
    r = consumeToken(b, ENTITY);
    r = r && componentName(b, l + 1);
    p = r; // pin = 2
    r = r && entity_type_definition_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // entity_type_body?
  private static boolean entity_type_definition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_type_definition_2")) return false;
    entity_type_body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // application_type_definition | entity_type_definition | enum_type_definition | directive_type_definition
  public static boolean entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENTRY, "<entry>");
    r = application_type_definition(b, l + 1);
    if (!r) r = entity_type_definition(b, l + 1);
    if (!r) r = enum_type_definition(b, l + 1);
    if (!r) r = directive_type_definition(b, l + 1);
    exit_section_(b, l, m, r, false, JdlParser::entry_recover);
    return r;
  }

  /* ********************************************************** */
  // !(<<nonStrictID>> | 'application' | 'entity' |  'enum' | 'service' | 'paginate' | 'microservice')
  static boolean entry_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !entry_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // <<nonStrictID>> | 'application' | 'entity' |  'enum' | 'service' | 'paginate' | 'microservice'
  private static boolean entry_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nonStrictID(b, l + 1);
    if (!r) r = consumeToken(b, APPLICATION);
    if (!r) r = consumeToken(b, ENTITY);
    if (!r) r = consumeToken(b, ENUM);
    if (!r) r = consumeToken(b, DIRECTIVE_SERVICE);
    if (!r) r = consumeToken(b, DIRECTIVE_PAGINATE);
    if (!r) r = consumeToken(b, DIRECTIVE_MICROSERVICE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // componentName
  public static boolean enumConstantDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumConstantDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM_CONSTANT_DECLARATION, "<enum constant declaration>");
    r = componentName(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'enum' componentName '{' enumConstantDeclaration (',' enumConstantDeclaration)* ','? '}'
  public static boolean enum_type_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_type_definition")) return false;
    if (!nextTokenIs(b, ENUM)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENUM_TYPE_DEFINITION, null);
    r = consumeToken(b, ENUM);
    r = r && componentName(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, consumeToken(b, LBRACE));
    r = p && report_error_(b, enumConstantDeclaration(b, l + 1)) && r;
    r = p && report_error_(b, enum_type_definition_4(b, l + 1)) && r;
    r = p && report_error_(b, enum_type_definition_5(b, l + 1)) && r;
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (',' enumConstantDeclaration)*
  private static boolean enum_type_definition_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_type_definition_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enum_type_definition_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_type_definition_4", c)) break;
    }
    return true;
  }

  // ',' enumConstantDeclaration
  private static boolean enum_type_definition_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_type_definition_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && enumConstantDeclaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean enum_type_definition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_type_definition_5")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // field_type componentName field_validation?
  public static boolean field_member(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_member")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_MEMBER, "<field member>");
    r = field_type(b, l + 1);
    r = r && componentName(b, l + 1);
    r = r && field_member_2(b, l + 1);
    exit_section_(b, l, m, r, false, JdlParser::field_member_recover);
    return r;
  }

  // field_validation?
  private static boolean field_member_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_member_2")) return false;
    field_validation(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // !(<<nonStrictID>> | field_type | '}' )
  static boolean field_member_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_member_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !field_member_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // <<nonStrictID>> | field_type | '}'
  private static boolean field_member_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_member_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nonStrictID(b, l + 1);
    if (!r) r = field_type(b, l + 1);
    if (!r) r = consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'String' | 'Integer' | 'Long' | 'BigDecimal' | 'Float' | 'Double' | 'Enum' | 'Boolean' | 'LocalDate' | 'ZonedDateTime' | 'Blob' | 'AnyBlob' | 'ImageBlob' | 'TextBlob'
  static boolean field_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_type")) return false;
    if (!nextTokenIs(b, "", NUM_ANY_BLOB, NUM_BIG_DECIMAL,
      NUM_BLOB, NUM_BOOELAN, NUM_DOUBLE, NUM_ENUM, NUM_FLOAT, NUM_IMAGE_BLOB,
      NUM_INT, NUM_LOCAL_DATE, NUM_LONG, NUM_STRING, NUM_TEXT_BLOB, NUM_ZONED_DATE_TIME)) return false;
    boolean r;
    r = consumeToken(b, NUM_STRING);
    if (!r) r = consumeToken(b, NUM_INT);
    if (!r) r = consumeToken(b, NUM_LONG);
    if (!r) r = consumeToken(b, NUM_BIG_DECIMAL);
    if (!r) r = consumeToken(b, NUM_FLOAT);
    if (!r) r = consumeToken(b, NUM_DOUBLE);
    if (!r) r = consumeToken(b, NUM_ENUM);
    if (!r) r = consumeToken(b, NUM_BOOELAN);
    if (!r) r = consumeToken(b, NUM_LOCAL_DATE);
    if (!r) r = consumeToken(b, NUM_ZONED_DATE_TIME);
    if (!r) r = consumeToken(b, NUM_BLOB);
    if (!r) r = consumeToken(b, NUM_ANY_BLOB);
    if (!r) r = consumeToken(b, NUM_IMAGE_BLOB);
    if (!r) r = consumeToken(b, NUM_TEXT_BLOB);
    return r;
  }

  /* ********************************************************** */
  // 'required'
  static boolean field_validation(PsiBuilder b, int l) {
    return consumeToken(b, REQUIRED);
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, ID, r);
    return r;
  }

  /* ********************************************************** */
  // entry*
  static boolean jdlFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jdlFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!entry(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "jdlFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // !'}'
  static boolean simple_scope_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_scope_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
