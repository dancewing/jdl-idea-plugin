package io.github.jhipster.jdl;

import java.util.*;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static io.github.jhipster.jdl.JdlTokenTypes.*;
import static io.github.jhipster.jdl.psi.JdlTypes.*;

%%

%{
  private static final class State {
    final int lBraceCount;
    final int state;

    private State(int state, int lBraceCount) {
      this.state = state;
      this.lBraceCount = lBraceCount;
    }

    @Override
    public String toString() {
      return "yystate = " + state + (lBraceCount == 0 ? "" : "lBraceCount = " + lBraceCount);
    }
  }

  protected final Stack<State> myStateStack = new Stack<>();
  protected int myLeftBraceCount;

  private void pushState(int state) {
    myStateStack.push(new State(yystate(), myLeftBraceCount));
    myLeftBraceCount = 0;
    yybegin(state);
  }

  private void popState() {
    State state = myStateStack.pop();
    myLeftBraceCount = state.lBraceCount;
    yybegin(state.state);
  }

  public _JdlLexer() {
    this(null);
  }
%}

%public
%class _JdlLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType

%eof{
  myLeftBraceCount = 0;
  myStateStack.clear();
%eof}

%xstate MULTI_LINE_COMMENT_STATE QUO_STRING THREE_QUO_STRING APOS_STRING THREE_APOS_STRING SHORT_TEMPLATE_ENTRY LONG_TEMPLATE_ENTRY

PATTERN=\/[^*].*\/
DIGIT=[0-9]
HEX_DIGIT=[0-9a-fA-F]
LETTER=[a-z]|[A-Z]
WHITE_SPACE=[ \n\t\f]+
PROGRAM_COMMENT="#""!"[^\n]*
SINGLE_LINE_COMMENT="/""/"[^\n]*
SINGLE_LINE_DOC_COMMENT="/""/""/"[^\n]*
SINGLE_LINE_COMMENTED_COMMENT="/""/""/""/"[^\n]*

MULTI_LINE_DEGENERATE_COMMENT = "/*" "*"+ "/"
MULTI_LINE_COMMENT_START      = "/*"
MULTI_LINE_DOC_COMMENT_START  = "/**"
MULTI_LINE_COMMENT_END        = "*/"

RAW_SINGLE_QUOTED_STRING= "r" ((\" ([^\"\n])* \"?) | ("'" ([^\'\n])* \'?))
RAW_TRIPLE_QUOTED_STRING= "r" ({RAW_TRIPLE_QUOTED_LITERAL} | {RAW_TRIPLE_APOS_LITERAL})

RAW_TRIPLE_QUOTED_LITERAL = {THREE_QUO}  ([^\"] | \"[^\"] | \"\"[^\"])* {THREE_QUO}?
RAW_TRIPLE_APOS_LITERAL   = {THREE_APOS} ([^\'] | \'[^\'] | \'\'[^\'])* {THREE_APOS}?

THREE_QUO =  (\"\"\")
THREE_APOS = (\'\'\')

SHORT_TEMPLATE_ENTRY=\${IDENTIFIER_NO_DOLLAR}

IDENTIFIER_START_NO_DOLLAR={LETTER}|"_"
IDENTIFIER_START={IDENTIFIER_START_NO_DOLLAR}
IDENTIFIER_PART_NO_DOLLAR={IDENTIFIER_START_NO_DOLLAR}|{DIGIT}
IDENTIFIER_PART={IDENTIFIER_START}|{DIGIT}
IDENTIFIER={IDENTIFIER_START}{IDENTIFIER_PART}*
IDENTIFIER_NO_DOLLAR={IDENTIFIER_START_NO_DOLLAR}{IDENTIFIER_PART_NO_DOLLAR}*

PACKAGE_NAME= ({IDENTIFIER}+("."{IDENTIFIER})*)

NUMERIC_LITERAL = {NUMBER} | {HEX_NUMBER}
NUMBER = ({DIGIT}+ ("." {DIGIT}+)? {EXPONENT}?) | ("." {DIGIT}+ {EXPONENT}?)
EXPONENT = [Ee] ["+""-"]? {DIGIT}*
HEX_NUMBER = 0 [Xx] {HEX_DIGIT}*

%%

<YYINITIAL> "{"                { return LBRACE; }
<YYINITIAL> "}"                { return RBRACE; }
//<LONG_TEMPLATE_ENTRY> "{"      { myLeftBraceCount++; return LBRACE; }
//<LONG_TEMPLATE_ENTRY> "}"      {
//                                   if (myLeftBraceCount == 0) {
//                                     popState();
//                                     return LONG_TEMPLATE_ENTRY_END;
//                                   }
//                                   myLeftBraceCount--;
//                                   return RBRACE;
//                               }

<YYINITIAL, LONG_TEMPLATE_ENTRY> {WHITE_SPACE}                   { return WHITE_SPACE;             }

// single-line comments
<YYINITIAL, LONG_TEMPLATE_ENTRY> {SINGLE_LINE_COMMENTED_COMMENT} { return SINGLE_LINE_COMMENT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> {SINGLE_LINE_DOC_COMMENT}       { return SINGLE_LINE_DOC_COMMENT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> {SINGLE_LINE_COMMENT}           { return SINGLE_LINE_COMMENT;     }
<YYINITIAL>                      {PROGRAM_COMMENT}               { return SINGLE_LINE_COMMENT;     }

// multi-line comments
<YYINITIAL, LONG_TEMPLATE_ENTRY> {MULTI_LINE_DEGENERATE_COMMENT} { return MULTI_LINE_COMMENT;      } // without this rule /*****/ is parsed as doc comment and /**/ is parsed as not closed doc comment

// next rules return temporary IElementType's that are rplaced with DartTokenTypesSets#MULTI_LINE_COMMENT or DartTokenTypesSets#MULTI_LINE_DOC_COMMENT in com.jetbrains.lang.dart.lexer.DartLexer
<YYINITIAL, LONG_TEMPLATE_ENTRY> {MULTI_LINE_DOC_COMMENT_START}  { pushState(MULTI_LINE_COMMENT_STATE); return MULTI_LINE_DOC_COMMENT_START;                                                             }
<YYINITIAL, LONG_TEMPLATE_ENTRY> {MULTI_LINE_COMMENT_START}      { pushState(MULTI_LINE_COMMENT_STATE); return MULTI_LINE_COMMENT_START;                                                                 }

<MULTI_LINE_COMMENT_STATE>       {MULTI_LINE_COMMENT_START}      { pushState(MULTI_LINE_COMMENT_STATE); return MULTI_LINE_COMMENT_BODY;                                                                  }
<MULTI_LINE_COMMENT_STATE>       [^]                             {                                      return MULTI_LINE_COMMENT_BODY;                                                                  }
<MULTI_LINE_COMMENT_STATE>       {MULTI_LINE_COMMENT_END}        { popState();                          return yystate() == MULTI_LINE_COMMENT_STATE
                                                                                                               ? MULTI_LINE_COMMENT_BODY // inner comment closed
                                                                                                               : MULTI_LINE_COMMENT_END; }

// reserved words
<YYINITIAL, LONG_TEMPLATE_ENTRY> "assert"               { return ASSERT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "application"          { return APPLICATION; } //add
<YYINITIAL, LONG_TEMPLATE_ENTRY> "relationship"         { return RELATIONSHIP; } //add
<YYINITIAL, LONG_TEMPLATE_ENTRY> "break"                { return BREAK; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "case"                 { return CASE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "catch"                { return CATCH; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "class"                { return CLASS; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "const"                { return CONST; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "continue"             { return CONTINUE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "config"               { return AP_CONFIG; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "default"              { return DEFAULT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "do"                   { return DO; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "else"                 { return ELSE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "enum"                 { return ENUM; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "entity"               { return ENTITY; } //add
<YYINITIAL, LONG_TEMPLATE_ENTRY> "entities"             { return AP_ENTITIES; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "extends"              { return EXTENDS; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "false"                { return FALSE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "final"                { return FINAL; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "finally"              { return FINALLY; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "for"                  { return FOR; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "if"                   { return IF; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "in"                   { return IN; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "is"                   { return IS; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "new"                  { return NEW; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "null"                 { return NULL; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "rethrow"              { return RETHROW; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "return"               { return RETURN; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "super"                { return SUPER; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "switch"               { return SWITCH; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "this"                 { return THIS; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "throw"                { return THROW; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "true"                 { return TRUE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "try"                  { return TRY; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "var"                  { return VAR; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "void"                 { return VOID; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "while"                { return WHILE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "with"                 { return WITH; }


// BUILT_IN_IDENTIFIER (can be used as normal identifiers)
<YYINITIAL, LONG_TEMPLATE_ENTRY> "abstract"             { return ABSTRACT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "as"                   { return AS; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "covariant"            { return COVARIANT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "deferred"             { return DEFERRED; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "export"               { return EXPORT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "extension"            { return EXTENSION; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "external"             { return EXTERNAL; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "factory"              { return FACTORY; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "get"                  { return GET; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "implements"           { return IMPLEMENTS; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "import"               { return IMPORT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "library"              { return LIBRARY; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "mixin"                { return MIXIN; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "operator"             { return OPERATOR; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "part"                 { return PART; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "set"                  { return SET; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "static"               { return STATIC; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "typedef"              { return TYPEDEF; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "sync"                 { return SYNC; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "async"                { return ASYNC; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "await"                { return AWAIT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "yield"                { return YIELD; }

<YYINITIAL, LONG_TEMPLATE_ENTRY> "microservice"         { return OPTION_MICRO_SERVICE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "paginate"             { return OPTION_PAGINATE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "service"              { return OPTION_SERVICE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "skipClient"           { return OPTION_SKIP_CLIENT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "skipServer"           { return OPTION_SKIP_SERVER; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "noFluentMethod"       { return OPTION_NO_FLUENT_METHOD; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "filter"               { return OPTION_FILTER; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "readOnly"             { return OPTION_READONLY; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "dto"                  { return OPTION_DTO; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "search"               { return OPTION_SEARCH; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "angularSuffix"        { return OPTION_ANGULAR_SUFFIX; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "clientRootFolder"     { return OPTION_CLIENT_ROOT_FOLDER; }

<YYINITIAL, LONG_TEMPLATE_ENTRY> "baseName"               { return CFG_BASE_NAME; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "applicationType"        { return CFG_APPLICATION_TYPE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "packageName"            { return CFG_PACKAGE_NAME; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "serviceDiscoveryType"   { return CFG_SERVICE_DISCOVERY_TYPE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "authenticationType"     { return CFG_AUTHENTICATION_TYPE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "databaseType"           { return CFG_DATABASE_TYPE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "prodDatabaseType"       { return CFG_PROD_DATABASE_TYPE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "devDatabaseType"        { return CFG_DEV_DATABASE_TYPE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "cacheProvider"          { return CFG_CACHE_PROVIDER; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "enableHibernateCache"   { return CFG_ENABLE_HIBERNATE_CACHE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "buildTool"              { return CFG_BUILD_TOOL; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "clientFramework"        { return CFG_CLIENT_FRAMEWORK; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "useSass"                { return CFG_USE_SASS; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "testFrameworks"         { return CFG_TEST_FRAMEWORKS; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "serverPort"             { return CFG_SERVER_PORT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "skipUserManagement"     { return CFG_SKIP_USER_MANAGEMENT; }
/*

<YYINITIAL, LONG_TEMPLATE_ENTRY> "gateway"              { return CFG_OPTION_GATEWAY; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "monolith"             { return CFG_OPTION_MONOLITH; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "microservice"         { return CFG_OPTION_MICROSERVICE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "uaa"                  { return CFG_OPTION_UAA; }

<YYINITIAL, LONG_TEMPLATE_ENTRY> "eureka"             { return CFG_OPTION_EUREKA; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "consul"             { return CFG_OPTION_CONSUL; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "nacos"              { return CFG_OPTION_NACOS; }

<YYINITIAL, LONG_TEMPLATE_ENTRY> "jwt"                 { return CFG_OPTION_JWT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "oauth2"              { return CFG_OPTION_OAUTH2; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "session"             { return CFG_OPTION_SESSION; }

<YYINITIAL, LONG_TEMPLATE_ENTRY> "sql"                 { return CFG_OPTION_SQL; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "mongodb"             { return CFG_OPTION_MONGODB; }

<YYINITIAL, LONG_TEMPLATE_ENTRY> "mysql"               { return CFG_OPTION_MYSQL; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "mariadb"             { return CFG_OPTION_MARIADB; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "postgresql"          { return CFG_OPTION_POSTGRESQL; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "oracle"              { return CFG_OPTION_ORACLE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "mssql"               { return CFG_OPTION_MSSQL; }

<YYINITIAL, LONG_TEMPLATE_ENTRY> "ehcache"             { return CFG_OPTION_EHCACHE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "caffeine"            { return CFG_OPTION_CAFFEINE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "hazelcast"           { return CFG_OPTION_HAZELCAST; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "infinispan"          { return CFG_OPTION_INFINISPAN; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "memcached"           { return CFG_OPTION_MEMCACHED; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "redis"               { return CFG_OPTION_REDIS; }

<YYINITIAL, LONG_TEMPLATE_ENTRY> "maven"               { return CFG_OPTION_MAVEN; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "gradle"              { return CFG_OPTION_GRADLE; }

<YYINITIAL, LONG_TEMPLATE_ENTRY> "angularX"            { return CFG_OPTION_ANGULARX; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "vue"                 { return CFG_OPTION_VUE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "react"               { return CFG_OPTION_REACT; }

<YYINITIAL, LONG_TEMPLATE_ENTRY> "gatling"              { return CFG_OPTION_GATLING; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "cucumber"             { return CFG_OPTION_CUCUMBER; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "protractor"           { return CFG_OPTION_PROTRACTOR; }
*/


<YYINITIAL, LONG_TEMPLATE_ENTRY> "String"               { return NUM_STRING; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "Integer"              { return NUM_INT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "Long"                 { return NUM_LONG; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "BigDecimal"           { return NUM_BIG_DECIMAL; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "Float"                { return NUM_FLOAT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "Double"               { return NUM_DOUBLE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "Boolean"              { return NUM_BOOELAN; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "LocalDate"            { return NUM_LOCAL_DATE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "Instant"              { return NUM_INSTANT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "ZonedDateTime"        { return NUM_ZONED_DATE_TIME; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "Blob"                 { return NUM_BLOB; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "AnyBlob"              { return NUM_ANY_BLOB; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "ImageBlob"            { return NUM_IMAGE_BLOB; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "TextBlob"             { return NUM_TEXT_BLOB; }

<YYINITIAL, LONG_TEMPLATE_ENTRY> "OneToMany"            { return ONE_TO_MANY; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "OneToOne"             { return ONE_TO_ONE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "ManyToOne"            { return MANY_TO_ONE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "ManyToMany"           { return MANY_TO_MANY; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "to"                   { return TO; }



// next are not listed in spec, but they seem to have the same sense as BUILT_IN_IDENTIFIER: somewhere treated as keywords, but can be used as normal identifiers
<YYINITIAL, LONG_TEMPLATE_ENTRY> "on"                   { return ON; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "of"                   { return OF; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "native"               { return NATIVE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "show"                 { return SHOW; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "hide"                 { return HIDE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "late"                 { return LATE; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "required"             { return REQUIRED; }

<YYINITIAL, LONG_TEMPLATE_ENTRY> {IDENTIFIER}           { return IDENTIFIER; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> {PACKAGE_NAME}         { return PACKAGE_NAME; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "["                { return LBRACKET; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "]"                { return RBRACKET; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "("                { return LPAREN; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> ")"                { return RPAREN; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> ";"                { return SEMICOLON; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "-"                { return MINUS; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "-="               { return MINUS_EQ; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "--"               { return MINUS_MINUS; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "+"                { return PLUS; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "++"               { return PLUS_PLUS; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "+="               { return PLUS_EQ; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "/"                { return DIV; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "/="               { return DIV_EQ; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "*"                { return MUL; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "*="               { return MUL_EQ; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "~/"               { return INT_DIV; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "~/="              { return INT_DIV_EQ; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "%="               { return REM_EQ; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "%"                { return REM; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "~"                { return BIN_NOT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "!"                { return NOT; }

<YYINITIAL, LONG_TEMPLATE_ENTRY> "=>"               { return EXPRESSION_BODY_DEF; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "="                { return EQ; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "=="               { return EQ_EQ; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "!="               { return NEQ; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "."                { return DOT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> ".."               { return DOT_DOT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "?.."              { return QUEST_DOT_DOT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "..."              { return DOT_DOT_DOT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "...?"             { return DOT_DOT_DOT_QUEST; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> ","                { return COMMA; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> ":"                { return COLON; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> ">"                { return GT; }
//<YYINITIAL, LONG_TEMPLATE_ENTRY> ">="               { return GT_EQ;    } breaks mixin app parsing
//<YYINITIAL, LONG_TEMPLATE_ENTRY> ">>"               { return GT_GT;    } breaks generics parsing
//<YYINITIAL, LONG_TEMPLATE_ENTRY> ">>="              { return GT_GT_EQ; } breaks mixin app parsing
<YYINITIAL, LONG_TEMPLATE_ENTRY> "<"                { return LT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "<="               { return LT_EQ; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "<<"               { return LT_LT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "<<="              { return LT_LT_EQ; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "?"                { return QUEST; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "?."               { return QUEST_DOT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "??"               { return QUEST_QUEST; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "??="              { return QUEST_QUEST_EQ; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "|"                { return OR; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "|="               { return OR_EQ; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "||"               { return OR_OR; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "||="              { return OR_OR_EQ; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "^"                { return XOR; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "^="               { return XOR_EQ; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "&"                { return AND; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "&="               { return AND_EQ; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "&&"               { return AND_AND; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "&&="              { return AND_AND_EQ; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "@"                { return AT; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> "#"                { return HASH; }

<YYINITIAL, LONG_TEMPLATE_ENTRY> {NUMERIC_LITERAL}  { return NUMBER; }
<YYINITIAL, LONG_TEMPLATE_ENTRY> {PATTERN}          { return PATTERN; }

// raw strings
//<YYINITIAL, LONG_TEMPLATE_ENTRY> {RAW_TRIPLE_QUOTED_STRING} { return RAW_TRIPLE_QUOTED_STRING; }
//<YYINITIAL, LONG_TEMPLATE_ENTRY> {RAW_SINGLE_QUOTED_STRING} { return RAW_SINGLE_QUOTED_STRING; }

// string start
//<YYINITIAL, LONG_TEMPLATE_ENTRY>      \"                  { pushState(QUO_STRING);        return OPEN_QUOTE;    }
//<YYINITIAL, LONG_TEMPLATE_ENTRY>      \'                  { pushState(APOS_STRING);       return OPEN_QUOTE;    }
//<YYINITIAL, LONG_TEMPLATE_ENTRY>      {THREE_QUO}         { pushState(THREE_QUO_STRING);  return OPEN_QUOTE;    }
//<YYINITIAL, LONG_TEMPLATE_ENTRY>      {THREE_APOS}        { pushState(THREE_APOS_STRING); return OPEN_QUOTE;    }
// correct string end
//<QUO_STRING>                          \"                  { popState();                   return CLOSING_QUOTE; }
//<APOS_STRING>                         \'                  { popState();                   return CLOSING_QUOTE; }
//<THREE_QUO_STRING>                    {THREE_QUO}         { popState();                   return CLOSING_QUOTE; }
//<THREE_APOS_STRING>                   {THREE_APOS}        { popState();                   return CLOSING_QUOTE; }
<QUO_STRING, APOS_STRING>             \n                  { popState();                   return WHITE_SPACE;   } // not closed single-line string literal. Do not return BAD_CHARACTER here because red highlighting of bad \n looks awful
// string content
//<QUO_STRING>                          ([^\\\"\n\$] | (\\ [^\n]))*   {                return REGULAR_STRING_PART; }
//<APOS_STRING>                         ([^\\\'\n\$] | (\\ [^\n]))*   {                return REGULAR_STRING_PART; }
//<THREE_QUO_STRING>                    ([^\\\"\$])*                  {                return REGULAR_STRING_PART; }
//<THREE_QUO_STRING>                    (\"[^\"]) | (\"\"[^\"])       { yypushback(1); return REGULAR_STRING_PART; } // pushback because we could capture '\' that escapes something
//<THREE_APOS_STRING>                   ([^\\\'\$])*                  {                return REGULAR_STRING_PART; }
//<THREE_APOS_STRING>                   (\'[^\']) | (\'\'[^\'])       { yypushback(1); return REGULAR_STRING_PART; } // pushback because we could capture '\' that escapes something
//<THREE_QUO_STRING, THREE_APOS_STRING> (\\[^])                       {                return REGULAR_STRING_PART; } // escape sequence
// bad string interpolation (no identifier after '$')
//<QUO_STRING, APOS_STRING, THREE_QUO_STRING, THREE_APOS_STRING> \$   { return SHORT_TEMPLATE_ENTRY_START; }
// short string interpolation
//<QUO_STRING, APOS_STRING, THREE_QUO_STRING, THREE_APOS_STRING> {SHORT_TEMPLATE_ENTRY}      { pushState(SHORT_TEMPLATE_ENTRY);
//                                                                                             yypushback(yylength() - 1);
//                                                                                             return SHORT_TEMPLATE_ENTRY_START;}
// Only *this* keyword is itself an expression valid in this position
// *null*, *true* and *false* are also keywords and expression, but it does not make sense to put them
// in a string template for it'd be easier to just type them in without a dollar
<SHORT_TEMPLATE_ENTRY> "this"          { popState(); return THIS; }
<SHORT_TEMPLATE_ENTRY> {IDENTIFIER_NO_DOLLAR}    { popState(); return IDENTIFIER; }

<YYINITIAL, MULTI_LINE_COMMENT_STATE, QUO_STRING, THREE_QUO_STRING, APOS_STRING, THREE_APOS_STRING, SHORT_TEMPLATE_ENTRY, LONG_TEMPLATE_ENTRY> [^] { return BAD_CHARACTER; }
