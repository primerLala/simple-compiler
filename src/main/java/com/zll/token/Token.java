package com.zll.token;

public class Token {
    private TokenType tokenType;
    private int line;
    private int column;

    public Token(TokenType tokenType, int line, int column) {
        this.tokenType = tokenType;
        this.line = line;
        this.column = column;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

}
