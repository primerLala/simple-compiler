import java_cup.runtime.*;

%%

%public
%class Scanner
%implements sym

%line
%column

%cup
%cupdebug

%{
  StringBuffer string = new StringBuffer();
  
  private Symbol symbol(int type) {
    return new MySymbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new MySymbol(type, yyline+1, yycolumn+1, value);
  }
%}

/* White spaces */
WhiteSpace = [ \t\f\r\n\v]

/* comments: no need to worry about them: assume the C preprocessor
 * was already executed - it strips away comments 
 */

/* Identifiers: TODO - make them general, as described in Section
 * 6.4.2.1 in the ANSI C document. Ignore "universal-character-name"
 * and "other implementation-defined characters" mentioned in Section
 * 6.4.2.1.
 */

/* Replace this placeholder with your own definitions */
Identifier = [A-Za-z_][A-Za-z_0-9]*

/* Integer literals: TODO - handle integer literals as described in
 * Section 6.4.4.1 of the ANSI C document. For simplicity, do NOT
 * handle the 'long long' cases. But DO handle long, unsigned,
 * hexadecimal, and octal constants.
 */

/* Replace this placeholder with your own definitions */
DecInteger = 0 | [1-9][0-9]*
OctInteger = 0[0-7][0-7]*
HexInteger = 0[xX][1-9a-fA-F][0-9a-fA-F]*

DecIntegerLiteral = {DecInteger} [uU]?
OctIntegerLiteral = {OctInteger} [uU]?
HexIntegerLiteral = {HexInteger} [uU]?

LongDecIntegerLiteral = {DecInteger} ( [lL] | [uU][lL] | [lL][uU] )
LongOctIntegerLiteral = {OctInteger} ( [lL] | [uU][lL] | [lL][uU] )
LongHexIntegerLiteral = {HexInteger} ( [lL] | [uU][lL] | [lL][uU] )

/* Floating point literals: TODO - handle floating point literals as 
 * described in Section 6.4.4.2 of the ANSI C document. For
 * simplicity, do NOT handle the 'long double' cases. But DO handle
 * hexadecimal floating constants, e/E and p/P notation, and f/F
 * suffixes.
 */        

/* Replace this placeholder with your own definitions */
HexDigit = [0-9a-fA-F]
HexExpPart = [pP][+-]?[0-9]+
HexFloat = 0[xX] ( {HexDigit}+ \.? {HexDigit}* | \. {HexDigit}+ ) {HexExpPart}
HexDoubleLiteral = {HexFloat} [lL]?
HexFloatLiteral = {HexFloat} [fF]

ExponentPart = [eE][+-]?[0-9]+
Float = ( [0-9]+ ( \. [0-9]* {ExponentPart}? | {ExponentPart} ) | \. [0-9]+ {ExponentPart}? )
DoubleLiteral = ( {Float} [lL]? | {HexDoubleLiteral} )
FloatLiteral = ( {Float} [fF] | {HexFloatLiteral} )

%%

<YYINITIAL> {

  /* Keywords: TODO - add all keywords from Section 6.4.1 */

  "auto"                         { return symbol(AUTO); }
  "break"                        { return symbol(BREAK); }
  "case"                         { return symbol(CASE); }
  "char"                         { return symbol(CHAR); }
  "const"                        { return symbol(CONST); }
  "continue"                     { return symbol(CONTINUE); }
  "default"                      { return symbol(DEFAULT); }
  "do"                           { return symbol(DO); }
  "double"                       { return symbol(DOUBLE); }
  "else"                         { return symbol(ELSE); }
  "enum"                         { return symbol(ENUM); }
  "extern"                       { return symbol(EXTERN); }
  "float"                        { return symbol(FLOAT); }
  "for"                          { return symbol(FOR); }
  "goto"                         { return symbol(GOTO); }
  "if"                           { return symbol(IF); }
  "inline"                       { return symbol(INLINE); }
  "int"                          { return symbol(INT); }
  "long"                         { return symbol(LONG); }
  "register"                     { return symbol(REGISTER); }
  "restrict"                     { return symbol(RESTRICT); }
  "return"                       { return symbol(RETURN); }
  "short"                        { return symbol(SHORT); }
  "signed"                       { return symbol(SIGNED); }
  "sizeof"                       { return symbol(SIZEOF); }
  "static"                       { return symbol(STATIC); }
  "struct"                       { return symbol(STRUCT); }
  "switch"                       { return symbol(SWITCH); }
  "typedef"                      { return symbol(TYPEDEF); }
  "union"                        { return symbol(UNION); }
  "unsigned"                     { return symbol(UNSIGNED); }
  "void"                         { return symbol(VOID); }
  "volatile"                     { return symbol(VOLATILE); }
  "while"                        { return symbol(WHILE); }
  "_Bool"                        { return symbol(_BOOL); }
  "_Complex"                     { return symbol(_COMPLEX); }
  "_Imaginary"                   { return symbol(_IMAGINARY); }
  
  /* Punctuators: TODO - add all punctuators from Section 6.4.6 except
  for the last eight punctuators */

  "("                            { return symbol(LPAREN); }
  ")"                            { return symbol(RPAREN); }
  "{"                            { return symbol(LBRACE); }
  "}"                            { return symbol(RBRACE); }
  "["                            { return symbol(LBRACK); }
  "]"                            { return symbol(RBRACK); }
  "."                            { return symbol(DOT); }
  "->"                           { return symbol(INDIR_SEL); }
  "++"                           { return symbol(PLUSPLUS); }
  "--"                           { return symbol(DECREMENT); }
  "&"                            { return symbol(AMPER); }
  "*"                            { return symbol(STAR); }
  "+"                            { return symbol(PLUS); }
  "-"                            { return symbol(MINUS); }
  "~"                            { return symbol(BIT_COMPL); }
  "!"                            { return symbol(NOT); }
  "/"                            { return symbol(DIV); }
  "%"                            { return symbol(MOD); }
  "<<"                           { return symbol(LSHIFT); }
  ">>"                           { return symbol(RSHIFT); }
  "<"                            { return symbol(LT); }
  ">"                            { return symbol(GT); }
  "<="                           { return symbol(LTEQ); }
  ">="                           { return symbol(GTEQ); }
  "=="                           { return symbol(EQUAL); }
  "!="                           { return symbol(NOTEQ); }
  "^"                            { return symbol(BIT_XOR); }
  "|"                            { return symbol(BIT_OR); }
  "&&"                           { return symbol(AND); }
  "||"                           { return symbol(OR); }
  "?"                            { return symbol(QMARK); }
  ":"                            { return symbol(COLON); }
  ";"                            { return symbol(SEMICOLON); }
  "..."                          { return symbol(ELLIPSIS); }
  "="                            { return symbol(ASSGN); }
  "*="                           { return symbol(MULT_ASSGN); }
  "/="                           { return symbol(DIV_ASSGN); }
  "%="                           { return symbol(MOD_ASSGN); }
  "+="                           { return symbol(ADD_ASSGN); }
  "-="                           { return symbol(SUB_ASSGN); }
  "<<="                          { return symbol(LSHIFT_ASSGN); }
  ">>="                          { return symbol(RSHIFT_ASSGN); }
  "&="                           { return symbol(BITAND_ASSGN); }
  "^="                           { return symbol(BITXOR_ASSGN); }
  "|="                           { return symbol(BITOR_ASSGN); }
  ","                            { return symbol(COMMA); }

  
  /* Integer literals: TODO - for any such literal, the token type
   * should be INTEGER_LITERAL, as shown below. The attribute value
   * should be either a Java Integer object (for values that are not
   * 'long') or a Java Long object (for values that are 'long'). You
   * can assume that the value of the literal is always small enough
   * to fit in a Java Integer or Long, respectively. For example, if
   * the literal is "17", "0x11", or "021", you should create a Java
   * Integer object containing the Java 'int' value 17. 
   */

  /* replace this placeholder with your own definitions */
  {DecIntegerLiteral}            { return symbol(INTEGER_LITERAL, Integer.valueOf(yytext().replaceAll("[uU]",""),10)); }
  {HexIntegerLiteral}            { return symbol(INTEGER_LITERAL, Integer.valueOf(yytext().replaceAll("[uU]","").substring(2),16)); }
  {OctIntegerLiteral}            { return symbol(INTEGER_LITERAL, Integer.valueOf(yytext().replaceAll("[uU]","").substring(1),8)); }
  
  // Longs
  {LongDecIntegerLiteral}            { return symbol(INTEGER_LITERAL, Long.valueOf(yytext().replaceAll("[uUlL]","").substring(0),10)); }
  {LongHexIntegerLiteral}            { return symbol(INTEGER_LITERAL, Long.valueOf(yytext().replaceAll("[uUlL]","").substring(2),16)); }
  {LongOctIntegerLiteral}            { return symbol(INTEGER_LITERAL, Long.valueOf(yytext().replaceAll("[uUlL]","").substring(1),8)); }

  /* Floating-point literals: TODO - for any such literal, the token
   * type should be FLOATING_POINT_LITERAL, as shown below. The
   * attribute value should be either a Java Float object (for values
   * that are 'float') or a Java Double object (for values that are
   * 'double'). You can assume that the value of the literal is always
   * small enough to fit in a Java Float or Double, respectively. For
   * example, if the literal is ".5625f", "5625e-4f", or "0X1.2p-1f",
   * you should create a Java Float object containing the Java 'float'
   * value 0.5625.
   */

  /* replace this placeholder with your own definitions */
  {DoubleLiteral}                { return symbol(FLOATING_POINT_LITERAL, Double.valueOf(yytext().replaceAll("[lL]",""))); }
  {FloatLiteral}                { return symbol(FLOATING_POINT_LITERAL, Float.valueOf(yytext())); }
  
  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }

  /* identifiers */ 
  {Identifier}                   { return symbol(IDENTIFIER, yytext()); }  
}

/* error fallback */
.|\n                             { throw new RuntimeException("Illegal character \""+yytext()+
                                                              "\" at line "+(yyline+1)+", column "+(yycolumn+1)); }
<<EOF>>                          { return symbol(EOF); }
