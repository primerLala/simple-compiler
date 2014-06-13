package com.zll.token;

public enum TokenType {
    QMARK(75),
    SHORT(44),
    SIGNED(45),
    SUB_ASSGN(82),
    IDENTIFIER(25),
    GT(66),
    MOD_ASSGN(80),
    CONST(30),
    NOTEQ(70),
    _BOOL(55),
    REGISTER(42),
    ENUM(35),
    RBRACK(12),
    SIZEOF(46),
    LSHIFT_ASSGN(83),
    COMMA(14),
    RBRACE(10),
    MULT_ASSGN(78),
    RPAREN(8),
    LBRACK(11),
    LT(17),
    BIT_XOR(71),
    DOUBLE(3),
    STRUCT(48),
    LBRACE(9),
    LPAREN(7),
    INTEGER_LITERAL(23),
    NOT(62),
    _COMPLEX(56),
    ADD_ASSGN(81),
    _IMAGINARY(57),
    INLINE(40),
    FLOAT(37),
    GOTO(38),
    ASSGN(16),
    MOD(63),
    LONG(41),
    PLUS(19),
    WHILE(54),
    UNION(51),
    EQUAL(69),
    BITOR_ASSGN(87),
    BIT_COMPL(61),
    CHAR(29),
    RSHIFT_ASSGN(84),
    SWITCH(49),
    DO(33),
    FOR(4),
    STAR(22),
    VOID(6),
    EXTERN(36),
    DIV(21),
    BIT_OR(72),
    RETURN(5),
    ELSE(34),
    RESTRICT(43),
    BREAK(27),
    GTEQ(68),
    DOT(15),
    INT(2),
    AMPER(60),
    EOF(0),
    SEMICOLON(13),
    DEFAULT(32),
    DECREMENT(59),
    BITXOR_ASSGN(86),
    MINUS(20),
    LTEQ(67),
    OR(74),
    error(1),
    INDIR_SEL(58),
    CONTINUE(31),
    IF(39),
    UNSIGNED(52),
    COLON(76),
    DIV_ASSGN(79),
    VOLATILE(53),
    CASE(28),
    PLUSPLUS(18),
    RSHIFT(65),
    BITAND_ASSGN(85),
    AND(73),
    ELLIPSIS(77),
    STATIC(47),
    LSHIFT(64),
    TYPEDEF(50),
    AUTO(26),
    FLOATING_POINT_LITERAL(24);

    private int value = 0;

    private TokenType(int value) {    //    必须是private的，否则编译错误
        this.value = value;
    }

    public static TokenType valueOf(int value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 75:
                return QMARK;
            case 44:
                return SHORT;
            case 45:
                return SIGNED;
            case 82:
                return SUB_ASSGN;
            case 25:
                return IDENTIFIER;
            case 66:
                return GT;
            case 80:
                return MOD_ASSGN;
            case 30:
                return CONST;
            case 70:
                return NOTEQ;
            case 55:
                return _BOOL;
            case 42:
                return REGISTER;
            case 35:
                return ENUM;
            case 12:
                return RBRACK;
            case 46:
                return SIZEOF;
            case 83:
                return LSHIFT_ASSGN;
            case 14:
                return COMMA;
            case 10:
                return RBRACE;
            case 78:
                return MULT_ASSGN;
            case 8:
                return RPAREN;
            case 11:
                return LBRACK;
            case 17:
                return LT;
            case 71:
                return BIT_XOR;
            case 3:
                return DOUBLE;
            case 48:
                return STRUCT;
            case 9:
                return LBRACE;
            case 7:
                return LPAREN;
            case 23:
                return INTEGER_LITERAL;
            case 62:
                return NOT;
            case 56:
                return _COMPLEX;
            case 81:
                return ADD_ASSGN;
            case 57:
                return _IMAGINARY;
            case 40:
                return INLINE;
            case 37:
                return FLOAT;
            case 38:
                return GOTO;
            case 16:
                return ASSGN;
            case 63:
                return MOD;
            case 41:
                return LONG;
            case 19:
                return PLUS;
            case 54:
                return WHILE;
            case 51:
                return UNION;
            case 69:
                return EQUAL;
            case 87:
                return BITOR_ASSGN;
            case 61:
                return BIT_COMPL;
            case 29:
                return CHAR;
            case 84:
                return RSHIFT_ASSGN;
            case 49:
                return SWITCH;
            case 4:
                return FOR;
            case 22:
                return STAR;
            case 6:
                return VOID;
            case 36:
                return EXTERN;
            case 21:
                return DIV;
            case 72:
                return BIT_OR;
            case 5:
                return RETURN;
            case 34:
                return ELSE;
            case 43:
                return RESTRICT;
            case 27:
                return BREAK;
            case 68:
                return GTEQ;
            case 15:
                return DOT;
            case 2:
                return INT;
            case 60:
                return AMPER;
            case 0:
                return EOF;
            case 13:
                return SEMICOLON;
            case 32:
                return DEFAULT;
            case 59:
                return DECREMENT;
            case 86:
                return BITXOR_ASSGN;
            case 20:
                return MINUS;
            case 67:
                return LTEQ;
            case 74:
                return OR;
            case 1:
                return error;
            case 58:
                return INDIR_SEL;
            case 31:
                return CONTINUE;
            case 39:
                return IF;
            case 52:
                return UNSIGNED;
            case 76:
                return COLON;
            case 79:
                return DIV_ASSGN;
            case 53:
                return VOLATILE;
            case 28:
                return CASE;
            case 18:
                return PLUSPLUS;
            case 65:
                return RSHIFT;
            case 85:
                return BITAND_ASSGN;
            case 73:
                return AND;
            case 77:
                return ELLIPSIS;
            case 33:
                return DO;
            case 47:
                return STATIC;
            case 64:
                return LSHIFT;
            case 50:
                return TYPEDEF;
            case 26:
                return AUTO;
            case 24:
                return FLOATING_POINT_LITERAL;


            default:
                return null;
        }
    }

    public int value() {
        return this.value;
    }
}
