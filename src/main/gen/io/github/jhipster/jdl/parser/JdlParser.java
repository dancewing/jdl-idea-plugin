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
  // COMMENT? application_type_definition
  public static boolean application_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, APPLICATION_TYPE, "<application type>");
    r = application_type_0(b, l + 1);
    r = r && application_type_definition(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMMENT?
  private static boolean application_type_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_type_0")) return false;
    consumeToken(b, COMMENT);
    return true;
  }

  /* ********************************************************** */
  // application_type_body_inner {
  // }
  public static boolean application_type_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_type_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, APPLICATION_TYPE_BODY, "<application type body>");
    r = application_type_body_inner(b, l + 1);
    r = r && application_type_body_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // {
  // }
  private static boolean application_type_body_1(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // ()
  public static boolean application_type_body_inner(PsiBuilder b, int l) {
    Marker m = enter_section_(b);
    exit_section_(b, m, APPLICATION_TYPE_BODY_INNER, true);
    return true;
  }

  /* ********************************************************** */
  // mb_blanks 'application' mb_blanks brace_start application_type_body brace_end {
  // }
  public static boolean application_type_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_type_definition")) return false;
    if (!nextTokenIsFast(b, BLANK) &&
        !nextTokenIs(b, "<application type definition>", KW_APPLICATION)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, APPLICATION_TYPE_DEFINITION, "<application type definition>");
    r = mb_blanks(b, l + 1);
    r = r && consumeToken(b, KW_APPLICATION);
    r = r && mb_blanks(b, l + 1);
    r = r && brace_start(b, l + 1);
    r = r && application_type_body(b, l + 1);
    r = r && brace_end(b, l + 1);
    r = r && application_type_definition_6(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // {
  // }
  private static boolean application_type_definition_6(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // BLANK
  static boolean blank(PsiBuilder b, int l) {
    return consumeTokenFast(b, BLANK);
  }

  /* ********************************************************** */
  // <<eof>> | '}'
  static boolean brace_end(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_end")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eof(b, l + 1);
    if (!r) r = consumeToken(b, T_RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{'
  static boolean brace_start(PsiBuilder b, int l) {
    return consumeToken(b, T_LBRACE);
  }

  /* ********************************************************** */
  // 'service' | 'paginate' | 'microservice'
  static boolean directive_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive_name")) return false;
    boolean r;
    r = consumeToken(b, DIRECTIVE_SERVICE);
    if (!r) r = consumeToken(b, DIRECTIVE_PAGINATE);
    if (!r) r = consumeToken(b, DIRECTIVE_MICROSERVICE);
    return r;
  }

  /* ********************************************************** */
  // COMMENT? directive_type_definition
  public static boolean directive_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DIRECTIVE_TYPE, "<directive type>");
    r = directive_type_0(b, l + 1);
    r = r && directive_type_definition(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMMENT?
  private static boolean directive_type_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive_type_0")) return false;
    consumeToken(b, COMMENT);
    return true;
  }

  /* ********************************************************** */
  // enum_type_body_inner {
  // }
  public static boolean directive_type_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive_type_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DIRECTIVE_TYPE_BODY, "<directive type body>");
    r = enum_type_body_inner(b, l + 1);
    r = r && directive_type_body_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // {
  // }
  private static boolean directive_type_body_1(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // mb_blanks directive_name mb_blanks brace_start directive_type_body brace_end {
  // }
  public static boolean directive_type_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive_type_definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DIRECTIVE_TYPE_DEFINITION, "<directive type definition>");
    r = mb_blanks(b, l + 1);
    r = r && directive_name(b, l + 1);
    r = r && mb_blanks(b, l + 1);
    r = r && brace_start(b, l + 1);
    r = r && directive_type_body(b, l + 1);
    r = r && brace_end(b, l + 1);
    r = r && directive_type_definition_6(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // {
  // }
  private static boolean directive_type_definition_6(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // UP_ID+
  public static boolean entity_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENTITY_NAME, "<entity name>");
    r = consumeToken(b, UP_ID);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, UP_ID)) break;
      if (!empty_element_parsed_guard_(b, "entity_name", c)) break;
    }
    exit_section_(b, l, m, r, false, JdlParser::entity_name_recover);
    return r;
  }

  /* ********************************************************** */
  // !('{'|' ')
  static boolean entity_name_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_name_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !entity_name_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '{'|' '
  private static boolean entity_name_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_name_recover_0")) return false;
    boolean r;
    r = consumeToken(b, T_LBRACE);
    if (!r) r = consumeToken(b, " ");
    return r;
  }

  /* ********************************************************** */
  // COMMENT? entity_type_definition
  public static boolean entity_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENTITY_TYPE, "<entity type>");
    r = entity_type_0(b, l + 1);
    r = r && entity_type_definition(b, l + 1);
    exit_section_(b, l, m, r, false, JdlParser::brace_end);
    return r;
  }

  // COMMENT?
  private static boolean entity_type_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_type_0")) return false;
    consumeToken(b, COMMENT);
    return true;
  }

  /* ********************************************************** */
  // '{' entity_type_body_inner* '}'
  public static boolean entity_type_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_type_body")) return false;
    if (!nextTokenIs(b, T_LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_LBRACE);
    r = r && entity_type_body_1(b, l + 1);
    r = r && consumeToken(b, T_RBRACE);
    exit_section_(b, m, ENTITY_TYPE_BODY, r);
    return r;
  }

  // entity_type_body_inner*
  private static boolean entity_type_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_type_body_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!entity_type_body_inner(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "entity_type_body_1", c)) break;
    }
    return true;
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
  // mb_blanks 'entity' mb_blanks entity_name mb_blanks entity_type_body
  public static boolean entity_type_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_type_definition")) return false;
    if (!nextTokenIsFast(b, BLANK) &&
        !nextTokenIs(b, "<entity type definition>", KW_ENTITY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENTITY_TYPE_DEFINITION, "<entity type definition>");
    r = mb_blanks(b, l + 1);
    r = r && consumeToken(b, KW_ENTITY);
    r = r && mb_blanks(b, l + 1);
    r = r && entity_name(b, l + 1);
    r = r && mb_blanks(b, l + 1);
    r = r && entity_type_body(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // application_type | entity_type | enum_type | directive_type
  public static boolean entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENTRY, "<entry>");
    r = application_type(b, l + 1);
    if (!r) r = entity_type(b, l + 1);
    if (!r) r = enum_type(b, l + 1);
    if (!r) r = directive_type(b, l + 1);
    exit_section_(b, l, m, r, false, JdlParser::entry_recover);
    return r;
  }

  /* ********************************************************** */
  // entry*
  public static boolean entry_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_item")) return false;
    Marker m = enter_section_(b, l, _NONE_, ENTRY_ITEM, "<entry item>");
    while (true) {
      int c = current_position_(b);
      if (!entry(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "entry_item", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // !('application' | 'entity' |  'enum')
  static boolean entry_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !entry_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'application' | 'entity' |  'enum'
  private static boolean entry_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_recover_0")) return false;
    boolean r;
    r = consumeToken(b, KW_APPLICATION);
    if (!r) r = consumeToken(b, KW_ENTITY);
    if (!r) r = consumeToken(b, KW_ENUM);
    return r;
  }

  /* ********************************************************** */
  // COMMENT? enum_type_definition
  public static boolean enum_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM_TYPE, "<enum type>");
    r = enum_type_0(b, l + 1);
    r = r && enum_type_definition(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMMENT?
  private static boolean enum_type_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_type_0")) return false;
    consumeToken(b, COMMENT);
    return true;
  }

  /* ********************************************************** */
  // enum_type_body_inner {
  // }
  public static boolean enum_type_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_type_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM_TYPE_BODY, "<enum type body>");
    r = enum_type_body_inner(b, l + 1);
    r = r && enum_type_body_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // {
  // }
  private static boolean enum_type_body_1(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // ()
  public static boolean enum_type_body_inner(PsiBuilder b, int l) {
    Marker m = enter_section_(b);
    exit_section_(b, m, ENUM_TYPE_BODY_INNER, true);
    return true;
  }

  /* ********************************************************** */
  // mb_blanks 'enum' mb_blanks brace_start enum_type_body brace_end {
  // }
  public static boolean enum_type_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_type_definition")) return false;
    if (!nextTokenIsFast(b, BLANK) &&
        !nextTokenIs(b, "<enum type definition>", KW_ENUM)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM_TYPE_DEFINITION, "<enum type definition>");
    r = mb_blanks(b, l + 1);
    r = r && consumeToken(b, KW_ENUM);
    r = r && mb_blanks(b, l + 1);
    r = r && brace_start(b, l + 1);
    r = r && enum_type_body(b, l + 1);
    r = r && brace_end(b, l + 1);
    r = r && enum_type_definition_6(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // {
  // }
  private static boolean enum_type_definition_6(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // mb_nl COMMENT? mb_nl field_name mb_blanks field_type mb_blanks field_validation?
  public static boolean field_member(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_member")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_MEMBER, "<field member>");
    r = mb_nl(b, l + 1);
    r = r && field_member_1(b, l + 1);
    r = r && mb_nl(b, l + 1);
    r = r && field_name(b, l + 1);
    r = r && mb_blanks(b, l + 1);
    r = r && field_type(b, l + 1);
    r = r && mb_blanks(b, l + 1);
    r = r && field_member_7(b, l + 1);
    exit_section_(b, l, m, r, false, JdlParser::brace_end);
    return r;
  }

  // COMMENT?
  private static boolean field_member_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_member_1")) return false;
    consumeToken(b, COMMENT);
    return true;
  }

  // field_validation?
  private static boolean field_member_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_member_7")) return false;
    field_validation(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LOW_ID+
  static boolean field_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, LOW_ID);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, LOW_ID)) break;
      if (!empty_element_parsed_guard_(b, "field_name", c)) break;
    }
    exit_section_(b, l, m, r, false, JdlParser::field_name_recover);
    return r;
  }

  /* ********************************************************** */
  // !(field_type)
  static boolean field_name_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_name_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !field_name_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (field_type)
  private static boolean field_name_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_name_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = field_type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'String' | 'Integer'
  static boolean field_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_type")) return false;
    if (!nextTokenIs(b, "", NUM_INT, NUM_STRING)) return false;
    boolean r;
    r = consumeToken(b, NUM_STRING);
    if (!r) r = consumeToken(b, NUM_INT);
    return r;
  }

  /* ********************************************************** */
  // 'required'
  static boolean field_validation(PsiBuilder b, int l) {
    return consumeToken(b, V_REQUIRED);
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
  // entry_item*
  static boolean jdlFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jdlFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!entry_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "jdlFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // blank?
  static boolean mb_blanks(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mb_blanks")) return false;
    blank(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // nl*
  static boolean mb_nl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mb_nl")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nl(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mb_nl", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // <<something>> | <<withProtectedLastVariantPos (nls <<something>>)>>
  static boolean mb_nl_group(PsiBuilder b, int l, Parser _something) {
    if (!recursion_guard_(b, l, "mb_nl_group")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _something.parse(b, l);
    if (!r) r = withProtectedLastVariantPos(b, l + 1, mb_nl_group_1_0_$(_something));
    exit_section_(b, m, null, r);
    return r;
  }

  private static Parser mb_nl_group_1_0_$(Parser _something) {
    return (b, l) -> mb_nl_group_1_0(b, l + 1, _something);
  }

  // nls <<something>>
  private static boolean mb_nl_group_1_0(PsiBuilder b, int l, Parser _something) {
    if (!recursion_guard_(b, l, "mb_nl_group_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nls(b, l + 1);
    r = r && _something.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // separator*
  static boolean mb_separators(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mb_separators")) return false;
    while (true) {
      int c = current_position_(b);
      if (!separator(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mb_separators", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // NL
  static boolean nl(PsiBuilder b, int l) {
    return consumeTokenFast(b, NL);
  }

  /* ********************************************************** */
  // nl+
  static boolean nls(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nls")) return false;
    if (!nextTokenIsFast(b, NL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!nl(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nls", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<separated_item_head <<item_end>> <<element>> <<separated_recovery <<element_start>> <<item_end>>>>>> <<item_end>>
  static boolean separated_item(PsiBuilder b, int l, Parser _item_end, Parser _element, Parser _element_start) {
    if (!recursion_guard_(b, l, "separated_item")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = separated_item_head(b, l + 1, _item_end, _element, separated_recovery_$(_element_start, _item_end));
    p = r; // pin = 1
    r = r && _item_end.parse(b, l);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // !<<item_end>> <<element>>
  static boolean separated_item_head(PsiBuilder b, int l, Parser _item_end, Parser _element, Parser _separated_recovery) {
    if (!recursion_guard_(b, l, "separated_item_head")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = separated_item_head_0(b, l + 1, _item_end, _separated_recovery);
    p = r; // pin = 1
    r = r && _element.parse(b, l);
    exit_section_(b, l, m, r, p, _separated_recovery);
    return r || p;
  }

  // !<<item_end>>
  private static boolean separated_item_head_0(PsiBuilder b, int l, Parser _item_end, Parser _separated_recovery) {
    if (!recursion_guard_(b, l, "separated_item_head_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !_item_end.parse(b, l);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  static Parser separated_recovery_$(Parser _item_end, Parser _element_start) {
    return (b, l) -> separated_recovery(b, l + 1, _item_end, _element_start);
  }

  // !(<<item_end>> | <<element_start>>)
  static boolean separated_recovery(PsiBuilder b, int l, Parser _item_end, Parser _element_start) {
    if (!recursion_guard_(b, l, "separated_recovery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !separated_recovery_0(b, l + 1, _item_end, _element_start);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // <<item_end>> | <<element_start>>
  private static boolean separated_recovery_0(PsiBuilder b, int l, Parser _item_end, Parser _element_start) {
    if (!recursion_guard_(b, l, "separated_recovery_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item_end.parse(b, l);
    if (!r) r = _element_start.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ',' | NL
  static boolean separator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "separator")) return false;
    boolean r;
    r = consumeToken(b, ",");
    if (!r) r = consumeToken(b, NL);
    return r;
  }

  /* ********************************************************** */
  // separator+
  static boolean separators(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "separators")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = separator(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!separator(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "separators", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !'}'
  static boolean simple_scope_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_scope_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, T_RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
