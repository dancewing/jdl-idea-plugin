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
  // componentName
  static boolean annotation_name(PsiBuilder b, int l) {
    return componentName(b, l + 1);
  }

  /* ********************************************************** */
  // 'config' application_config_body
  public static boolean application_config(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_config")) return false;
    if (!nextTokenIs(b, AP_CONFIG)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, APPLICATION_CONFIG, null);
    r = consumeToken(b, AP_CONFIG);
    p = r; // pin = 1
    r = r && application_config_body(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '{' config_item (','|';')? (config_item (','|';')?)* '}'
  public static boolean application_config_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_config_body")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && config_item(b, l + 1);
    r = r && application_config_body_2(b, l + 1);
    r = r && application_config_body_3(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, APPLICATION_CONFIG_BODY, r);
    return r;
  }

  // (','|';')?
  private static boolean application_config_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_config_body_2")) return false;
    application_config_body_2_0(b, l + 1);
    return true;
  }

  // ','|';'
  private static boolean application_config_body_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_config_body_2_0")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  // (config_item (','|';')?)*
  private static boolean application_config_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_config_body_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!application_config_body_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "application_config_body_3", c)) break;
    }
    return true;
  }

  // config_item (','|';')?
  private static boolean application_config_body_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_config_body_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_item(b, l + 1);
    r = r && application_config_body_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (','|';')?
  private static boolean application_config_body_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_config_body_3_0_1")) return false;
    application_config_body_3_0_1_0(b, l + 1);
    return true;
  }

  // ','|';'
  private static boolean application_config_body_3_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_config_body_3_0_1_0")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // 'application' application_type_body
  public static boolean application_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_definition")) return false;
    if (!nextTokenIs(b, APPLICATION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, APPLICATION_DEFINITION, null);
    r = consumeToken(b, APPLICATION);
    p = r; // pin = 1
    r = r && application_type_body(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'entities' ('*' | include_entity_names) ('except' exclude_entity_names)?
  public static boolean application_entities(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_entities")) return false;
    if (!nextTokenIs(b, AP_ENTITIES)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AP_ENTITIES);
    r = r && application_entities_1(b, l + 1);
    r = r && application_entities_2(b, l + 1);
    exit_section_(b, m, APPLICATION_ENTITIES, r);
    return r;
  }

  // '*' | include_entity_names
  private static boolean application_entities_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_entities_1")) return false;
    boolean r;
    r = consumeToken(b, MUL);
    if (!r) r = include_entity_names(b, l + 1);
    return r;
  }

  // ('except' exclude_entity_names)?
  private static boolean application_entities_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_entities_2")) return false;
    application_entities_2_0(b, l + 1);
    return true;
  }

  // 'except' exclude_entity_names
  private static boolean application_entities_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_entities_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "except");
    r = r && exclude_entity_names(b, l + 1);
    exit_section_(b, m, null, r);
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
  // application_config application_entities option_definitions?
  static boolean application_type_body_inner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_type_body_inner")) return false;
    if (!nextTokenIs(b, AP_CONFIG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = application_config(b, l + 1);
    r = r && application_entities(b, l + 1);
    r = r && application_type_body_inner_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // option_definitions?
  private static boolean application_type_body_inner_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_type_body_inner_2")) return false;
    option_definitions(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // argumentListPart (',' argumentListPart)* ','?
  public static boolean argumentList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT_LIST, "<argument list>");
    r = argumentListPart(b, l + 1);
    r = r && argumentList_1(b, l + 1);
    r = r && argumentList_2(b, l + 1);
    exit_section_(b, l, m, r, false, JdlParser::argument_list_recover);
    return r;
  }

  // (',' argumentListPart)*
  private static boolean argumentList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argumentList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argumentList_1", c)) break;
    }
    return true;
  }

  // ',' argumentListPart
  private static boolean argumentList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && argumentListPart(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean argumentList_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentList_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // argumentValue
  static boolean argumentListPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentListPart")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = argumentValue(b, l + 1);
    exit_section_(b, l, m, r, false, JdlParser::argument_list_part_recover);
    return r;
  }

  /* ********************************************************** */
  // componentName
  public static boolean argumentValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT_VALUE, "<argument value>");
    r = componentName(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !(')' | ',')
  static boolean argument_list_part_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_part_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !argument_list_part_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ')' | ','
  private static boolean argument_list_part_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_part_recover_0")) return false;
    boolean r;
    r = consumeToken(b, RPAREN);
    if (!r) r = consumeToken(b, COMMA);
    return r;
  }

  /* ********************************************************** */
  // !(')')
  static boolean argument_list_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '(' argumentList? ')'
  static boolean arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && arguments_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // argumentList?
  private static boolean arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments_1")) return false;
    argumentList(b, l + 1);
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
  // config_array_item_key '['config_array_item_values ']'
  public static boolean config_array_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_array_item")) return false;
    if (!nextTokenIs(b, "<config array item>", LANGUAGES, TESTFRAMEWORKS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_ARRAY_ITEM, "<config array item>");
    r = config_array_item_key(b, l + 1);
    r = r && consumeToken(b, LBRACKET);
    r = r && config_array_item_values(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'languages'|'testFrameworks'
  public static boolean config_array_item_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_array_item_key")) return false;
    if (!nextTokenIs(b, "<config array item key>", LANGUAGES, TESTFRAMEWORKS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_ARRAY_ITEM_KEY, "<config array item key>");
    r = consumeToken(b, LANGUAGES);
    if (!r) r = consumeToken(b, TESTFRAMEWORKS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean config_array_item_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_array_item_value")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, CONFIG_ARRAY_ITEM_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // config_array_item_value(','config_array_item_value)*
  static boolean config_array_item_values(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_array_item_values")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_array_item_value(b, l + 1);
    r = r && config_array_item_values_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (','config_array_item_value)*
  private static boolean config_array_item_values_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_array_item_values_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!config_array_item_values_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "config_array_item_values_1", c)) break;
    }
    return true;
  }

  // ','config_array_item_value
  private static boolean config_array_item_values_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_array_item_values_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && config_array_item_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // config_boolean_item_key config_boolean_item_value
  public static boolean config_boolean_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_boolean_item")) return false;
    if (!nextTokenIs(b, "<config boolean item>", ENABLEHIBERNATECACHE, ENABLESWAGGERCODEGEN,
      ENABLETRANSLATION, REACTIVE, SKIPCLIENT, SKIPSERVER, SKIPUSERMANAGEMENT, USESASS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_BOOLEAN_ITEM, "<config boolean item>");
    r = config_boolean_item_key(b, l + 1);
    r = r && config_boolean_item_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'enableHibernateCache'|'enableSwaggerCodegen'|'enableTranslation'|'reactive'|'skipClient'|'skipServer'|'skipUserManagement'|'useSass'
  public static boolean config_boolean_item_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_boolean_item_key")) return false;
    if (!nextTokenIs(b, "<config boolean item key>", ENABLEHIBERNATECACHE, ENABLESWAGGERCODEGEN,
      ENABLETRANSLATION, REACTIVE, SKIPCLIENT, SKIPSERVER, SKIPUSERMANAGEMENT, USESASS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_BOOLEAN_ITEM_KEY, "<config boolean item key>");
    r = consumeToken(b, ENABLEHIBERNATECACHE);
    if (!r) r = consumeToken(b, ENABLESWAGGERCODEGEN);
    if (!r) r = consumeToken(b, ENABLETRANSLATION);
    if (!r) r = consumeToken(b, REACTIVE);
    if (!r) r = consumeToken(b, SKIPCLIENT);
    if (!r) r = consumeToken(b, SKIPSERVER);
    if (!r) r = consumeToken(b, SKIPUSERMANAGEMENT);
    if (!r) r = consumeToken(b, USESASS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'true' | 'false'
  public static boolean config_boolean_item_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_boolean_item_value")) return false;
    if (!nextTokenIs(b, "<config boolean item value>", FALSE, TRUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_BOOLEAN_ITEM_VALUE, "<config boolean item value>");
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // config_string_item | config_boolean_item | package_name_config_item | config_number_item | config_array_item
  public static boolean config_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_ITEM, "<config item>");
    r = config_string_item(b, l + 1);
    if (!r) r = config_boolean_item(b, l + 1);
    if (!r) r = package_name_config_item(b, l + 1);
    if (!r) r = config_number_item(b, l + 1);
    if (!r) r = config_array_item(b, l + 1);
    exit_section_(b, l, m, r, false, JdlParser::simple_scope_recover);
    return r;
  }

  /* ********************************************************** */
  // config_number_item_key config_number_item_value
  public static boolean config_number_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_number_item")) return false;
    if (!nextTokenIs(b, SERVERPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_number_item_key(b, l + 1);
    r = r && config_number_item_value(b, l + 1);
    exit_section_(b, m, CONFIG_NUMBER_ITEM, r);
    return r;
  }

  /* ********************************************************** */
  // 'serverPort'
  public static boolean config_number_item_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_number_item_key")) return false;
    if (!nextTokenIs(b, SERVERPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SERVERPORT);
    exit_section_(b, m, CONFIG_NUMBER_ITEM_KEY, r);
    return r;
  }

  /* ********************************************************** */
  // NUMBER
  public static boolean config_number_item_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_number_item_value")) return false;
    if (!nextTokenIs(b, NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMBER);
    exit_section_(b, m, CONFIG_NUMBER_ITEM_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // config_string_item_key config_string_item_value
  public static boolean config_string_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_string_item")) return false;
    if (!nextTokenIs(b, "<config string item>", APPLICATIONTYPE, AUTHENTICATIONTYPE,
      BASENAME, BUILDTOOL, CACHEPROVIDER, CLIENTFRAMEWORK, CLIENTPACKAGEMANAGER, CLIENTTHEME,
      CLIENTTHEMEVARIANT, DATABASETYPE, DEVDATABASETYPE, DTOSUFFIX, ENTITYSUFFIX, JHIPREFIX,
      MESSAGEBROKER, NATIVELANGUAGE, PRODDATABASETYPE, SEARCHENGINE, SERVICEDISCOVERYTYPE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_STRING_ITEM, "<config string item>");
    r = config_string_item_key(b, l + 1);
    r = r && config_string_item_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'applicationType'|'authenticationType'|'baseName'|'buildTool'|'cacheProvider'|'clientFramework'|'clientPackageManager'|'clientTheme'|'clientThemeVariant'|'databaseType'|'devDatabaseType'|'dtoSuffix'|'entitySuffix'|'jhiPrefix'|'messageBroker'|'nativeLanguage'|'prodDatabaseType'|'searchEngine'|'serviceDiscoveryType'
  public static boolean config_string_item_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_string_item_key")) return false;
    if (!nextTokenIs(b, "<config string item key>", APPLICATIONTYPE, AUTHENTICATIONTYPE,
      BASENAME, BUILDTOOL, CACHEPROVIDER, CLIENTFRAMEWORK, CLIENTPACKAGEMANAGER, CLIENTTHEME,
      CLIENTTHEMEVARIANT, DATABASETYPE, DEVDATABASETYPE, DTOSUFFIX, ENTITYSUFFIX, JHIPREFIX,
      MESSAGEBROKER, NATIVELANGUAGE, PRODDATABASETYPE, SEARCHENGINE, SERVICEDISCOVERYTYPE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_STRING_ITEM_KEY, "<config string item key>");
    r = consumeToken(b, APPLICATIONTYPE);
    if (!r) r = consumeToken(b, AUTHENTICATIONTYPE);
    if (!r) r = consumeToken(b, BASENAME);
    if (!r) r = consumeToken(b, BUILDTOOL);
    if (!r) r = consumeToken(b, CACHEPROVIDER);
    if (!r) r = consumeToken(b, CLIENTFRAMEWORK);
    if (!r) r = consumeToken(b, CLIENTPACKAGEMANAGER);
    if (!r) r = consumeToken(b, CLIENTTHEME);
    if (!r) r = consumeToken(b, CLIENTTHEMEVARIANT);
    if (!r) r = consumeToken(b, DATABASETYPE);
    if (!r) r = consumeToken(b, DEVDATABASETYPE);
    if (!r) r = consumeToken(b, DTOSUFFIX);
    if (!r) r = consumeToken(b, ENTITYSUFFIX);
    if (!r) r = consumeToken(b, JHIPREFIX);
    if (!r) r = consumeToken(b, MESSAGEBROKER);
    if (!r) r = consumeToken(b, NATIVELANGUAGE);
    if (!r) r = consumeToken(b, PRODDATABASETYPE);
    if (!r) r = consumeToken(b, SEARCHENGINE);
    if (!r) r = consumeToken(b, SERVICEDISCOVERYTYPE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER | 'microservice'
  public static boolean config_string_item_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_string_item_value")) return false;
    if (!nextTokenIs(b, "<config string item value>", IDENTIFIER, OPTION_MICRO_SERVICE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_STRING_ITEM_VALUE, "<config string item value>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, OPTION_MICRO_SERVICE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // metadata* 'entity' entity_name entity_type_body?
  public static boolean entity_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_definition")) return false;
    if (!nextTokenIs(b, "<entity definition>", AT, ENTITY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENTITY_DEFINITION, "<entity definition>");
    r = entity_definition_0(b, l + 1);
    r = r && consumeToken(b, ENTITY);
    p = r; // pin = 2
    r = r && report_error_(b, entity_name(b, l + 1));
    r = p && entity_definition_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // metadata*
  private static boolean entity_definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_definition_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!metadata(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "entity_definition_0", c)) break;
    }
    return true;
  }

  // entity_type_body?
  private static boolean entity_definition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_definition_3")) return false;
    entity_type_body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // componentName
  static boolean entity_name(PsiBuilder b, int l) {
    return componentName(b, l + 1);
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
  static boolean entity_type_body_inner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_type_body_inner")) return false;
    Marker m = enter_section_(b, l, _NONE_);
    while (true) {
      int c = current_position_(b);
      if (!field_member(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "entity_type_body_inner", c)) break;
    }
    exit_section_(b, l, m, true, false, JdlParser::simple_scope_recover);
    return true;
  }

  /* ********************************************************** */
  // application_definition | entity_definition | enum_definition | option_definition | relationship_definition
  static boolean entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = application_definition(b, l + 1);
    if (!r) r = entity_definition(b, l + 1);
    if (!r) r = enum_definition(b, l + 1);
    if (!r) r = option_definition(b, l + 1);
    if (!r) r = relationship_definition(b, l + 1);
    exit_section_(b, l, m, r, false, JdlParser::entry_recover);
    return r;
  }

  /* ********************************************************** */
  // !('@' | 'application' | 'entity' |  'enum' | 'service' | 'paginate' | 'microservice' | 'relationship')
  static boolean entry_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !entry_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '@' | 'application' | 'entity' |  'enum' | 'service' | 'paginate' | 'microservice' | 'relationship'
  private static boolean entry_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_recover_0")) return false;
    boolean r;
    r = consumeToken(b, AT);
    if (!r) r = consumeToken(b, APPLICATION);
    if (!r) r = consumeToken(b, ENTITY);
    if (!r) r = consumeToken(b, ENUM);
    if (!r) r = consumeToken(b, OPTION_SERVICE);
    if (!r) r = consumeToken(b, OPTION_PAGINATE);
    if (!r) r = consumeToken(b, OPTION_MICRO_SERVICE);
    if (!r) r = consumeToken(b, RELATIONSHIP);
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
  // metadata* 'enum' enum_name '{' enumConstantDeclaration (',' enumConstantDeclaration)* ','? '}'
  public static boolean enum_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition")) return false;
    if (!nextTokenIs(b, "<enum definition>", AT, ENUM)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENUM_DEFINITION, "<enum definition>");
    r = enum_definition_0(b, l + 1);
    r = r && consumeToken(b, ENUM);
    p = r; // pin = 2
    r = r && report_error_(b, enum_name(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LBRACE)) && r;
    r = p && report_error_(b, enumConstantDeclaration(b, l + 1)) && r;
    r = p && report_error_(b, enum_definition_5(b, l + 1)) && r;
    r = p && report_error_(b, enum_definition_6(b, l + 1)) && r;
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // metadata*
  private static boolean enum_definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!metadata(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_definition_0", c)) break;
    }
    return true;
  }

  // (',' enumConstantDeclaration)*
  private static boolean enum_definition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enum_definition_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_definition_5", c)) break;
    }
    return true;
  }

  // ',' enumConstantDeclaration
  private static boolean enum_definition_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && enumConstantDeclaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean enum_definition_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_definition_6")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // componentName
  static boolean enum_name(PsiBuilder b, int l) {
    return componentName(b, l + 1);
  }

  /* ********************************************************** */
  // entity_name (',' entity_name)*
  public static boolean exclude_entity_names(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exclude_entity_names")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXCLUDE_ENTITY_NAMES, "<exclude entity names>");
    r = entity_name(b, l + 1);
    r = r && exclude_entity_names_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' entity_name)*
  private static boolean exclude_entity_names_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exclude_entity_names_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!exclude_entity_names_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "exclude_entity_names_1", c)) break;
    }
    return true;
  }

  // ',' entity_name
  private static boolean exclude_entity_names_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exclude_entity_names_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && entity_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // metadata* field_name field_type_definition field_validations? (','|';')?
  public static boolean field_member(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_member")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_MEMBER, "<field member>");
    r = field_member_0(b, l + 1);
    r = r && field_name(b, l + 1);
    r = r && field_type_definition(b, l + 1);
    r = r && field_member_3(b, l + 1);
    r = r && field_member_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // metadata*
  private static boolean field_member_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_member_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!metadata(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "field_member_0", c)) break;
    }
    return true;
  }

  // field_validations?
  private static boolean field_member_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_member_3")) return false;
    field_validations(b, l + 1);
    return true;
  }

  // (','|';')?
  private static boolean field_member_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_member_4")) return false;
    field_member_4_0(b, l + 1);
    return true;
  }

  // ','|';'
  private static boolean field_member_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_member_4_0")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // componentName
  static boolean field_name(PsiBuilder b, int l) {
    return componentName(b, l + 1);
  }

  /* ********************************************************** */
  // componentName
  public static boolean field_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_TYPE, "<field type>");
    r = componentName(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER | 'String' | 'Integer' | 'Long' | 'BigDecimal' | 'Float' | 'Double' | 'Enum' | 'Boolean' | 'LocalDate' | 'Instant'| 'ZonedDateTime' | 'Blob' | 'AnyBlob' | 'ImageBlob' | 'TextBlob'
  public static boolean field_type_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_type_definition")) return false;
    if (!nextTokenIs(b, "<field type definition>", IDENTIFIER, NUM_ANY_BLOB,
      NUM_BIG_DECIMAL, NUM_BLOB, NUM_BOOELAN, NUM_DOUBLE, NUM_ENUM, NUM_FLOAT,
      NUM_IMAGE_BLOB, NUM_INSTANT, NUM_INT, NUM_LOCAL_DATE, NUM_LONG, NUM_STRING, NUM_TEXT_BLOB, NUM_ZONED_DATE_TIME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_TYPE_DEFINITION, "<field type definition>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, NUM_STRING);
    if (!r) r = consumeToken(b, NUM_INT);
    if (!r) r = consumeToken(b, NUM_LONG);
    if (!r) r = consumeToken(b, NUM_BIG_DECIMAL);
    if (!r) r = consumeToken(b, NUM_FLOAT);
    if (!r) r = consumeToken(b, NUM_DOUBLE);
    if (!r) r = consumeToken(b, NUM_ENUM);
    if (!r) r = consumeToken(b, NUM_BOOELAN);
    if (!r) r = consumeToken(b, NUM_LOCAL_DATE);
    if (!r) r = consumeToken(b, NUM_INSTANT);
    if (!r) r = consumeToken(b, NUM_ZONED_DATE_TIME);
    if (!r) r = consumeToken(b, NUM_BLOB);
    if (!r) r = consumeToken(b, NUM_ANY_BLOB);
    if (!r) r = consumeToken(b, NUM_IMAGE_BLOB);
    if (!r) r = consumeToken(b, NUM_TEXT_BLOB);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'required' | 'unique' | minlength | maxlength | min | max | minbytes | maxbytes | pattern
  public static boolean field_validation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_validation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_VALIDATION, "<field validation>");
    r = consumeToken(b, REQUIRED);
    if (!r) r = consumeToken(b, "unique");
    if (!r) r = minlength(b, l + 1);
    if (!r) r = maxlength(b, l + 1);
    if (!r) r = min(b, l + 1);
    if (!r) r = max(b, l + 1);
    if (!r) r = minbytes(b, l + 1);
    if (!r) r = maxbytes(b, l + 1);
    if (!r) r = pattern(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // field_validation (field_validation)*
  public static boolean field_validations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_validations")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_VALIDATIONS, "<field validations>");
    r = field_validation(b, l + 1);
    r = r && field_validations_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (field_validation)*
  private static boolean field_validations_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_validations_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!field_validations_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "field_validations_1", c)) break;
    }
    return true;
  }

  // (field_validation)
  private static boolean field_validations_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_validations_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = field_validation(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
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
  // entity_name (',' entity_name)*
  public static boolean include_entity_names(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_entity_names")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INCLUDE_ENTITY_NAMES, "<include entity names>");
    r = entity_name(b, l + 1);
    r = r && include_entity_names_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' entity_name)*
  private static boolean include_entity_names_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_entity_names_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!include_entity_names_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "include_entity_names_1", c)) break;
    }
    return true;
  }

  // ',' entity_name
  private static boolean include_entity_names_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_entity_names_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && entity_name(b, l + 1);
    exit_section_(b, m, null, r);
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
  // 'max' '(' NUMBER ')'
  static boolean max(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "max")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "max");
    r = r && consumeTokens(b, 0, LPAREN, NUMBER, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'maxbytes' '(' NUMBER ')'
  static boolean maxbytes(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "maxbytes")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "maxbytes");
    r = r && consumeTokens(b, 0, LPAREN, NUMBER, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'maxlength' '(' NUMBER ')'
  static boolean maxlength(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "maxlength")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "maxlength");
    r = r && consumeTokens(b, 0, LPAREN, NUMBER, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '@' annotation_name arguments?
  public static boolean metadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AT);
    r = r && annotation_name(b, l + 1);
    r = r && metadata_2(b, l + 1);
    exit_section_(b, m, METADATA, r);
    return r;
  }

  // arguments?
  private static boolean metadata_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata_2")) return false;
    arguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'min' '(' NUMBER ')'
  static boolean min(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "min")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "min");
    r = r && consumeTokens(b, 0, LPAREN, NUMBER, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'minbytes' '(' NUMBER ')'
  static boolean minbytes(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "minbytes")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "minbytes");
    r = r && consumeTokens(b, 0, LPAREN, NUMBER, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'minlength' '(' NUMBER ')'
  static boolean minlength(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "minlength")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "minlength");
    r = r && consumeTokens(b, 0, LPAREN, NUMBER, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // option_name option_type_body
  public static boolean option_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option_definition")) return false;
    if (!nextTokenIs(b, "<option definition>", OPTION_ANGULAR_SUFFIX, OPTION_CLIENT_ROOT_FOLDER,
      OPTION_DTO, OPTION_FILTER, OPTION_MICRO_SERVICE, OPTION_NO_FLUENT_METHOD, OPTION_PAGINATE, OPTION_READONLY,
      OPTION_SEARCH, OPTION_SERVICE, SKIPCLIENT, SKIPSERVER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OPTION_DEFINITION, "<option definition>");
    r = option_name(b, l + 1);
    p = r; // pin = 1
    r = r && option_type_body(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // !(option_name | '}')
  static boolean option_definition_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option_definition_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !option_definition_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // option_name | '}'
  private static boolean option_definition_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option_definition_recover_0")) return false;
    boolean r;
    r = option_name(b, l + 1);
    if (!r) r = consumeToken(b, RBRACE);
    return r;
  }

  /* ********************************************************** */
  // option_definition*
  public static boolean option_definitions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option_definitions")) return false;
    Marker m = enter_section_(b, l, _NONE_, OPTION_DEFINITIONS, "<option definitions>");
    while (true) {
      int c = current_position_(b);
      if (!option_definition(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "option_definitions", c)) break;
    }
    exit_section_(b, l, m, true, false, JdlParser::option_definition_recover);
    return true;
  }

  /* ********************************************************** */
  // 'service' | 'paginate' | 'microservice' | 'skipClient' | 'skipServer' | 'noFluentMethod' | 'filter' | 'readOnly' | 'dto' | 'search' | 'angularSuffix' | 'clientRootFolder'
  public static boolean option_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option_name")) return false;
    if (!nextTokenIs(b, "<option name>", OPTION_ANGULAR_SUFFIX, OPTION_CLIENT_ROOT_FOLDER,
      OPTION_DTO, OPTION_FILTER, OPTION_MICRO_SERVICE, OPTION_NO_FLUENT_METHOD, OPTION_PAGINATE, OPTION_READONLY,
      OPTION_SEARCH, OPTION_SERVICE, SKIPCLIENT, SKIPSERVER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPTION_NAME, "<option name>");
    r = consumeToken(b, OPTION_SERVICE);
    if (!r) r = consumeToken(b, OPTION_PAGINATE);
    if (!r) r = consumeToken(b, OPTION_MICRO_SERVICE);
    if (!r) r = consumeToken(b, SKIPCLIENT);
    if (!r) r = consumeToken(b, SKIPSERVER);
    if (!r) r = consumeToken(b, OPTION_NO_FLUENT_METHOD);
    if (!r) r = consumeToken(b, OPTION_FILTER);
    if (!r) r = consumeToken(b, OPTION_READONLY);
    if (!r) r = consumeToken(b, OPTION_DTO);
    if (!r) r = consumeToken(b, OPTION_SEARCH);
    if (!r) r = consumeToken(b, OPTION_ANGULAR_SUFFIX);
    if (!r) r = consumeToken(b, OPTION_CLIENT_ROOT_FOLDER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ('*' | include_entity_names) 'with' option_type_value ('except' exclude_entity_names)?
  static boolean option_type_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option_type_body")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = option_type_body_0(b, l + 1);
    r = r && consumeToken(b, WITH);
    r = r && option_type_value(b, l + 1);
    r = r && option_type_body_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '*' | include_entity_names
  private static boolean option_type_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option_type_body_0")) return false;
    boolean r;
    r = consumeToken(b, MUL);
    if (!r) r = include_entity_names(b, l + 1);
    return r;
  }

  // ('except' exclude_entity_names)?
  private static boolean option_type_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option_type_body_3")) return false;
    option_type_body_3_0(b, l + 1);
    return true;
  }

  // 'except' exclude_entity_names
  private static boolean option_type_body_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option_type_body_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "except");
    r = r && exclude_entity_names(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean option_type_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option_type_value")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, OPTION_TYPE_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // 'packageName' package_name_identifier
  public static boolean package_name_config_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "package_name_config_item")) return false;
    if (!nextTokenIs(b, PACKAGENAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PACKAGENAME);
    r = r && package_name_identifier(b, l + 1);
    exit_section_(b, m, PACKAGE_NAME_CONFIG_ITEM, r);
    return r;
  }

  /* ********************************************************** */
  // PACKAGE_NAME
  public static boolean package_name_identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "package_name_identifier")) return false;
    if (!nextTokenIs(b, PACKAGE_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PACKAGE_NAME);
    exit_section_(b, m, PACKAGE_NAME_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // 'pattern' '(' PATTERN ')'
  static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "pattern");
    r = r && consumeTokens(b, 0, LPAREN, PATTERN, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{' relationship_items (','|';')? (relationship_items (','|';')?)* '}'
  public static boolean relationship_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_body")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && relationship_items(b, l + 1);
    r = r && relationship_body_2(b, l + 1);
    r = r && relationship_body_3(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, RELATIONSHIP_BODY, r);
    return r;
  }

  // (','|';')?
  private static boolean relationship_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_body_2")) return false;
    relationship_body_2_0(b, l + 1);
    return true;
  }

  // ','|';'
  private static boolean relationship_body_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_body_2_0")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  // (relationship_items (','|';')?)*
  private static boolean relationship_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_body_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!relationship_body_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "relationship_body_3", c)) break;
    }
    return true;
  }

  // relationship_items (','|';')?
  private static boolean relationship_body_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_body_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relationship_items(b, l + 1);
    r = r && relationship_body_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (','|';')?
  private static boolean relationship_body_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_body_3_0_1")) return false;
    relationship_body_3_0_1_0(b, l + 1);
    return true;
  }

  // ','|';'
  private static boolean relationship_body_3_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_body_3_0_1_0")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // 'relationship' relationship_type relationship_body
  public static boolean relationship_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_definition")) return false;
    if (!nextTokenIs(b, RELATIONSHIP)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RELATIONSHIP_DEFINITION, null);
    r = consumeToken(b, RELATIONSHIP);
    p = r; // pin = 1
    r = r && report_error_(b, relationship_type(b, l + 1));
    r = p && relationship_body(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '(' entity_name ')'
  public static boolean relationship_field_display_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_field_display_name")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && entity_name(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, RELATIONSHIP_FIELD_DISPLAY_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // entity_name
  public static boolean relationship_field_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_field_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RELATIONSHIP_FIELD_NAME, "<relationship field name>");
    r = entity_name(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // metadata* relationship_source_type relationship_source_type_options? 'to' relationship_target_type relationship_target_type_options?
  public static boolean relationship_items(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_items")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RELATIONSHIP_ITEMS, "<relationship items>");
    r = relationship_items_0(b, l + 1);
    r = r && relationship_source_type(b, l + 1);
    r = r && relationship_items_2(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && relationship_target_type(b, l + 1);
    r = r && relationship_items_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // metadata*
  private static boolean relationship_items_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_items_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!metadata(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "relationship_items_0", c)) break;
    }
    return true;
  }

  // relationship_source_type_options?
  private static boolean relationship_items_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_items_2")) return false;
    relationship_source_type_options(b, l + 1);
    return true;
  }

  // relationship_target_type_options?
  private static boolean relationship_items_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_items_5")) return false;
    relationship_target_type_options(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // entity_name
  public static boolean relationship_source_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_source_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RELATIONSHIP_SOURCE_TYPE, "<relationship source type>");
    r = entity_name(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // relationship_type_options
  public static boolean relationship_source_type_options(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_source_type_options")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relationship_type_options(b, l + 1);
    exit_section_(b, m, RELATIONSHIP_SOURCE_TYPE_OPTIONS, r);
    return r;
  }

  /* ********************************************************** */
  // entity_name
  public static boolean relationship_target_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_target_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RELATIONSHIP_TARGET_TYPE, "<relationship target type>");
    r = entity_name(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // relationship_type_options
  public static boolean relationship_target_type_options(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_target_type_options")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relationship_type_options(b, l + 1);
    exit_section_(b, m, RELATIONSHIP_TARGET_TYPE_OPTIONS, r);
    return r;
  }

  /* ********************************************************** */
  // 'OneToOne' | 'OneToMany' | 'ManyToOne' | 'ManyToMany'
  public static boolean relationship_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_type")) return false;
    if (!nextTokenIs(b, "<relationship type>", MANY_TO_MANY, MANY_TO_ONE, ONE_TO_MANY, ONE_TO_ONE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RELATIONSHIP_TYPE, "<relationship type>");
    r = consumeToken(b, ONE_TO_ONE);
    if (!r) r = consumeToken(b, ONE_TO_MANY);
    if (!r) r = consumeToken(b, MANY_TO_ONE);
    if (!r) r = consumeToken(b, MANY_TO_MANY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '{' relationship_field_name relationship_field_display_name? 'required'? '}'
  static boolean relationship_type_options(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_type_options")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && relationship_field_name(b, l + 1);
    r = r && relationship_type_options_2(b, l + 1);
    r = r && relationship_type_options_3(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // relationship_field_display_name?
  private static boolean relationship_type_options_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_type_options_2")) return false;
    relationship_field_display_name(b, l + 1);
    return true;
  }

  // 'required'?
  private static boolean relationship_type_options_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationship_type_options_3")) return false;
    consumeToken(b, REQUIRED);
    return true;
  }

  /* ********************************************************** */
  // !(','| ';' | '}')
  static boolean simple_scope_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_scope_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !simple_scope_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ','| ';' | '}'
  private static boolean simple_scope_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_scope_recover_0")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, RBRACE);
    return r;
  }

}
