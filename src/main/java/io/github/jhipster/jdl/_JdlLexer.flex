package io.github.jhipster.jdl;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static io.github.jhipster.jdl.psi.JdlTypes.*;

%%

%{
  public _JdlLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _JdlLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

BLANK=[ \t\n\x0B\f\r]
NL=(\n)*
UP_ID=[A-Z]+[a-zA-Z0-9]*
LOW_ID=[a-z]+[a-zA-Z0-9]*
IDENTIFIER=[a-zA-Z][a-zA-Z0-9]*

%%
<YYINITIAL> {
  {WHITE_SPACE}        { return WHITE_SPACE; }

  "application"        { return KW_APPLICATION; }
  "enum"               { return KW_ENUM; }
  "entity"             { return KW_ENTITY; }
  "required"           { return V_REQUIRED; }
  "service"            { return DIRECTIVE_SERVICE; }
  "paginate"           { return DIRECTIVE_PAGINATE; }
  "microservice"       { return DIRECTIVE_MICROSERVICE; }
  "shell comment"      { return SH_COMMENT; }
  "line comment"       { return SL_COMMENT; }
  "block comment"      { return ML_COMMENT; }
  "}"                  { return T_RBRACE; }
  "("                  { return T_LPAREN; }
  ")"                  { return T_RPAREN; }
  "["                  { return T_LBRACK; }
  "]"                  { return T_RBRACK; }
  "{"                  { return T_LBRACE; }
  "\\n"                { return LINEFEED; }
  "String"             { return NUM_STRING; }
  "Integer"            { return NUM_INT; }
  "Long"               { return NUM_LONG; }
  "BigDecimal"         { return NUM_BIG_DECIMAL; }
  "Float"              { return NUM_FLOAT; }
  "Double"             { return NUM_DOUBLE; }
  "Enum"               { return NUM_ENUM; }
  "Boolean"            { return NUM_BOOELAN; }
  "LocalDate"          { return NUM_LOCAL_DATE; }
  "ZonedDateTime"      { return NUM_ZONED_DATE_TIME; }
  "Blob"               { return NUM_BLOB; }
  "AnyBlob"            { return NUM_ANY_BLOB; }
  "ImageBlob"          { return NUM_IMAGE_BLOB; }
  "TextBlob"           { return NUM_TEXT_BLOB; }
  "wrong token"        { return T_WRONG; }
  "COMMENT"            { return COMMENT; }

  {BLANK}              { return BLANK; }
  {NL}                 { return NL; }
  {UP_ID}              { return UP_ID; }
  {LOW_ID}             { return LOW_ID; }
  {IDENTIFIER}         { return IDENTIFIER; }

}

[^] { return BAD_CHARACTER; }
