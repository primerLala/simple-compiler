import java_cup.runtime.*;

%%

%class LexicalAnalysis
%column
%line
%cup

%{

	   private Symbol symbol(int type) {
		   return new Symbol(type, yyline, yycolumn);
   	   }

 	   private Symbol symbol(int type, Object val) {
		   return new Symbol(type, yyline, yycolumn, val);
   	   }
%}

//所有注释情况的正则表达式
leftbrace = "/*"
rightbrace = "*/"
comment_body = ( [^*] | \*+ [^/*] )*
comment = {leftbrace}{comment_body}{rightbrace}
single_comment = "//".*

//字母，数字和变量名的正则表达式
letter          = [A-Za-z]
digit           = [0-9]+
alphanumeric    = {letter}|{digit}
other_id_char   = [_]
identifier      = ({letter}|other_id_char)({alphanumeric}|{other_id_char})*
identifier2     = @{identifier}

//关于整数的后缀
integer_suffix = U|u|L|l|UL|Ul|uL|ul|LU|Lu|lU|lu

//16进制
hex_digit = {digit} |A|B|C|D|E|F|a|b|c|d|e|f
integer_literal = {digit} ({integer_suffix})? | 0x({hex_digit})+ ({integer_suffix})? | 0X({hex_digit})+ ({integer_suffix})?

//关于实数等的后缀
real_type_suffix = F|f|D|d|M|m

//科学计数法来表示小数
sign = "+"|"-"
exponent_part = e({sign})? {digit} | E({sign})? {digit}
real_literal = ({digit})? "." {digit} ({exponent_part})? ({real_type_suffix})? |
				{digit} {exponent_part} ({real_type_suffix})? |
				{digit} {real_type_suffix}



//定义Unicode码（“\u00222”）和 ASCII码（"\0x40"）
hex_escape = x{hex_digit} ({hex_digit}({hex_digit} {hex_digit}?)?)?
unicode_escape = u{hex_digit} {hex_digit} {hex_digit} {hex_digit} | U{hex_digit} {hex_digit} {hex_digit} {hex_digit} {hex_digit} {hex_digit} {hex_digit} {hex_digit}
escape_sequence = "'"|'"'|"\"|0|a|b|f|n|r|t|v|{hex_escape}|{unicode_escape}

//字符的正则表达式
char_literal = "'"[^'\\]"'" | "'""\\"{escape_sequence}"'"

string_literal = \"([^\\\"]|\\.)*\" | @\"([^\\\"]|\\.)*\"

%%
/*Aqui estao definidos os possiveis tokens que podem ser encontrados numa calculadora simples*/
	"abstract" { return symbol(sym.ABSTRACT); }
	"as" { return symbol(sym.AS, new Integer(yyline)); }
	"base" { return symbol(sym.BASE); }
	"bool" { return symbol(sym.BOOL); }
	"break" { return symbol(sym.BREAK); }
	"byte" { return symbol(sym.BYTE); }
	"case" { return symbol(sym.CASE); }
	"catch" { return symbol(sym.CATCH); }
	"char" { return symbol(sym.CHAR); }
	"checked" { return symbol(sym.CHECKED); }
	"class" { return symbol(sym.CLASS, new Integer(yyline)); }
	"const" { return symbol(sym.CONST); }
	"continue" { return symbol(sym.CONTINUE); }
	"decimal" { return symbol(sym.DECIMAL); }
	"default" { return symbol(sym.DEFAULT); }
	"delegate" { return symbol(sym.DELEGATE); }
	"do" { return symbol(sym.DO); }
	"double" { return symbol(sym.DOUBLE); }
	"else" { return symbol(sym.ELSE); }
	"enum" { return symbol(sym.ENUM); }
	"event" { return symbol(sym.EVENT); }
	"explicit" { return symbol(sym.EXPLICIT); }
	"extern" { return symbol(sym.EXTERN); }
	"false" { return symbol(sym.FALSE); }
	"finally" { return symbol(sym.FINALLY); }
	"fixed" { return symbol(sym.FIXED); }
	"float" { return symbol(sym.FLOAT); }
	"for" { return symbol(sym.FOR, new Integer(yyline)); }
	"foreach" { return symbol(sym.FOREACH); }
	"goto" { return symbol(sym.GOTO); }
	"if" { return symbol(sym.IF); }
	"implicit" { return symbol(sym.IMPLICIT); }
	"in" { return symbol(sym.IN); }
	"int" { return symbol(sym.INT); }
	"interface" { return symbol(sym.INTERFACE); }
	"internal" { return symbol(sym.INTERNAL); }
	"is" { return symbol(sym.IS, new Integer(yyline)); }
	"lock" { return symbol(sym.LOCK); }
	"long" { return symbol(sym.LONG); }
	"namespace" { return symbol(sym.NAMESPACE); }
	"new" { return symbol(sym.NEW); }
	"null" { return symbol(sym.NULL); }
	"object" { return symbol(sym.OBJECT); }
	"operator" { return symbol(sym.OPERATOR); }
	"out" { return symbol(sym.OUT); }
	"override" { return symbol(sym.OVERRIDE); }
	"params" { return symbol(sym.PARAMS); }
	"private" { return symbol(sym.PRIVATE); }
	"protected" { return symbol(sym.PROTECTED); }
	"public" { return symbol(sym.PUBLIC); }
	"readonly" { return symbol(sym.READONLY); }
	"ref" { return symbol(sym.REF); }
	"return" { return symbol(sym.RETURN); }
	"sbyte" { return symbol(sym.SBYTE); }
	"sealed" { return symbol(sym.SEALED); }
	"short" { return symbol(sym.SHORT); }
	"sizeof" { return symbol(sym.SIZEOF); }
	"stackalloc" { return symbol(sym.STACKALLOC); }
	"static" { return symbol(sym.STATIC); }
	"string" { return symbol(sym.STRING); }
	"struct" { return symbol(sym.STRUCT); }
	"switch" { return symbol(sym.SWITCH); }
	"this" { return symbol(sym.THIS); }
	"throw" { return symbol(sym.THROW); }
	"true" { return symbol(sym.TRUE); }
	"try" { return symbol(sym.TRY); }
	"typeof" { return symbol(sym.TYPEOF); }
	"uint" { return symbol(sym.UINT); }
	"ulong" { return symbol(sym.ULONG); }
	"unchecked" { return symbol(sym.UNCHECKED); }
	"unsafe" { return symbol(sym.UNSAFE); }
	"ushort" { return symbol(sym.USHORT); }
	"using" { return symbol(sym.USING); }
	"virtual" { return symbol(sym.VIRTUAL); }
	"void" { return symbol(sym.VOID); }
	"volatile" { return symbol(sym.VOLATILE); }
	"while" { return symbol(sym.WHILE); }
	"get" { return symbol(sym.GET); }
	"set" { return symbol(sym.SET); }
	"add" { return symbol(sym.ADD); }
	"remove" { return symbol(sym.REMOVE); }

	"{"					{ return symbol(sym.LCBRACE); }
    "}"					{ return symbol(sym.RCBRACE); }
    "["					{ return symbol(sym.LBRACKET); }
    "]"					{ return symbol(sym.RBRACKET); }
    "."					{ return symbol(sym.DOT); }
    ","					{ return symbol(sym.COMMA); }
    ":"					{ return symbol(sym.COLON); }
    ";"					{ return symbol(sym.SEMICOLON, new Integer(yyline)); }
    "%"					{ return symbol(sym.PERCENT); }
    "&"					{ return symbol(sym.AMPERSAND); }
    "|"					{ return symbol(sym.BAR); }
    "^"					{ return symbol(sym.CARET); }
    "!"					{ return symbol(sym.EXCLAM); }
    "~"					{ return symbol(sym.TILDE); }
    "="					{ return symbol(sym.EQUAL, new Integer(yyline)); }
    "<"					{ return symbol(sym.LESS, new Integer(yyline)); }
    ">"					{ return symbol(sym.GREATER, new Integer(yyline)); }
    "?"					{ return symbol(sym.QUESTION); }
    "++"				{ return symbol(sym.INCREMENT); }
    "--"				{ return symbol(sym.DECREMENT); }
    "&&"				{ return symbol(sym.AMPERSANDAMPERSAND); }
    "||"				{ return symbol(sym.BARBAR); }
    "<<"				{ return symbol(sym.LSHIFT); }
    ">>"				{ return symbol(sym.RSHIFT); }
    "=="				{ return symbol(sym.EQUALEQUAL, new Integer(yyline)); }
    "!="				{ return symbol(sym.NOTEQUAL, new Integer(yyline)); }
    "<="				{ return symbol(sym.LESSEQUAL, new Integer(yyline)); }
    ">="				{ return symbol(sym.GREETEREQUAL, new Integer(yyline)); }
    "+="				{ return symbol(sym.PLUSEQUAL); }
    "-="				{ return symbol(sym.MINUSEQUAL); }
    "*="				{ return symbol(sym.STAREQUAL); }
    "/="				{ return symbol(sym.DIVIDEIEQUAL); }
    "%="				{ return symbol(sym.PERCENTEQUAL); }
    "&="				{ return symbol(sym.AMPERSANDEQUAL); }
    "|="				{ return symbol(sym.BAREQUAL); }
    "^="				{ return symbol(sym.CARETEQUAL); }
    "<<="				{ return symbol(sym.LSHIFTEQUAL); }
    ">>="				{ return symbol(sym.RSHIFTEQUAL); }
   // "->"				{ return symbol(sym.POINTER); }
    "(" 				{ return symbol(sym.LBRACKET, new Integer(yyline)); }
    ")" 				{ return symbol(sym.RBRACKET); }
	"-" 				{ return symbol(sym.MINUS, new Integer(yyline)); }
	"+" 				{ return symbol(sym.PLUS, new Integer(yyline)); }
	"/" 				{ return symbol(sym.DIVIDE, new Integer(yyline)); }
	"*" 				{ return symbol(sym.TIMES, new Integer(yyline)); }
	"assembly"			{ return symbol(sym.ASSEMBLY); }
	"field"				{ return symbol(sym.FIELD); }
    "method"            { return symbol(sym.METHOD); }
    "module"			{ return symbol(sym.MODULE); }
    "param"				{ return symbol(sym.PARAM); }
    "property"			{ return symbol(sym.PROPERTY); }
    "type"				{ return symbol(sym.TYPE); }

	[ \r\n\t\f] { /*nao faz nada*/ }
	{comment} {  }
	{single_comment} {  }
	{identifier}    { return symbol(sym.IDENT, new String(yytext())); }
	{identifier2}    { return symbol(sym.IDENTARROBA, new String(yytext())); }
	{integer_literal}    { return symbol(sym.INTEGERLITERAL, new Integer(yytext())); }
	{real_literal}    { return symbol(sym.REALLITERAL, new Double(yytext())); }
	{char_literal}    { return symbol(sym.CHARLITERAL, new Character(yytext().charAt(1))); }
	{string_literal}    { return symbol(sym.STRINGLITERAL, new String(yytext())); }
	<<EOF>> { return symbol(sym.EOF); }