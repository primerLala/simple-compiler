package com.zll.scanner;

import com.zll.main.UserInterface;
import com.zll.parser.sym;
import com.zll.token.MySymbol;
import com.zll.token.TokenData;
import com.zll.token.TokenType;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LexerAnalyzer {

    UserInterface ui;
    private Map<String, TokenData> tokenMap;

    /**
     * Constructor
     *
     * @param pUI UserInterface class, this can act as a controller
     */
    public LexerAnalyzer(UserInterface pUI) {
        this.tokenMap = new HashMap<String, TokenData>();
        ui = pUI;
    }

    /**
     * Adds token to the token hash table
     *
     * @param pToken     token string
     * @param pTokenType token family
     * @param pLine      token line
     * @param pColumn    token column
     */
    public void addToken(String pToken, TokenType pTokenType, int pLine, int pColumn) {
        if (this.tokenMap.containsKey(pToken)) {
            this.tokenMap.get(pToken).addPosition(pLine, pColumn);
        } else {
            this.tokenMap.put(pToken, new TokenData(pTokenType, pLine, pColumn));
        }
    }

    /**
     * Receives a reader with the source file to be analysed. Loops to read all the tokens and
     * classifies them into their respective families
     *
     * @param sourceFile
     * @throws java.io.IOException
     */
    public void analyzeFile(Reader sourceFile) throws IOException {
        ScannerC scanner = new ScannerC(sourceFile);
        MySymbol symbol;

        while (true) {
            // Gets current token from Lexer
            symbol = (MySymbol) scanner.next_token();

            if (symbol.sym == sym.EOF) {
                // End of file, do nothing.
                break;
            }

            switch (symbol.sym) {
                case sym.QMARK:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.SHORT:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.SIGNED:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.SUB_ASSGN:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.IDENTIFIER:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.GT:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.MOD_ASSGN:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.CONST:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.NOTEQ:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym._BOOL:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.REGISTER:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.ENUM:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.RBRACK:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.SIZEOF:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.LSHIFT_ASSGN:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.COMMA:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.RBRACE:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.MULT_ASSGN:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.RPAREN:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.LBRACK:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.LT:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.BIT_XOR:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.DOUBLE:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.STRUCT:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.LBRACE:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.LPAREN:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.INTEGER_LITERAL:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.NOT:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym._COMPLEX:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.ADD_ASSGN:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym._IMAGINARY:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.INLINE:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.FLOAT:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.GOTO:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.ASSGN:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.MOD:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.LONG:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.PLUS:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.WHILE:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.UNION:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.EQUAL:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.BITOR_ASSGN:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.BIT_COMPL:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.CHAR:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.RSHIFT_ASSGN:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.SWITCH:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.DO:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.FOR:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.STAR:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.VOID:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.EXTERN:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.DIV:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.BIT_OR:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.RETURN:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.ELSE:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.RESTRICT:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.BREAK:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.GTEQ:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.DOT:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.INT:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.AMPER:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.EOF:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.SEMICOLON:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.DEFAULT:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.DECREMENT:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.BITXOR_ASSGN:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.MINUS:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.LTEQ:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.OR:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.error:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.INDIR_SEL:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.CONTINUE:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.IF:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.UNSIGNED:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.COLON:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.DIV_ASSGN:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.VOLATILE:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.CASE:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.PLUSPLUS:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.RSHIFT:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.BITAND_ASSGN:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.AND:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.ELLIPSIS:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.STATIC:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.LSHIFT:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.TYPEDEF:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.AUTO:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                case sym.FLOATING_POINT_LITERAL:
                    this.addToken(scanner.yytext(), TokenType.valueOf(symbol.sym), symbol.getLine(), symbol.getColumn());
                    break;
                default:
                    // Unknown token
                    break;
            }
        }
    }

    /**
     * Recieves string and parses it to BufferedReader so Lexer can analyze it
     *
     * @param pString
     * @return
     */
    public Reader fromStringToReader(String pString) {
        File tempFile = new File("temp.txt");
        PrintWriter writer;
        Reader reader = null;
        try {
            writer = new PrintWriter(tempFile);
            writer.print(pString);
            writer.close();
            reader = new BufferedReader(new FileReader("temp.txt"));
        } catch (FileNotFoundException exception) {
            // Catch exception
        }
        return reader;
    }

    /**
     * Prints tokens with their respective data. Testing purposes only
     */
    public void printAll() {
        TokenData tokenData;

        for (String key : this.tokenMap.keySet()) {
            tokenData = this.tokenMap.get(key);
            String lines = "";
            String columns = "";
            String errorLines = "";
            String errorColumns = "";
            for (Integer mkey : tokenMap.get(key).getPositionDictionary().keySet()) {
                if (tokenData.getTokenType().toString().contains("ERROR")) {
                    errorLines += mkey + ", ";
                    errorColumns += tokenMap.get(key).getPositionDictionary().get(mkey) + ", ";
                } else {
                    lines += mkey + ", ";
                    columns += tokenMap.get(key).getPositionDictionary().get(mkey) + ", ";
                }
            }
            lines = lines.substring(0, lines.lastIndexOf(",") < 0 ? 0 : lines.lastIndexOf(","));
            columns = columns.substring(0, columns.lastIndexOf(",") < 0 ? 0 : columns.lastIndexOf(","));
            errorLines = errorLines.substring(0, errorLines.lastIndexOf(",") < 0 ? 0 : errorLines.lastIndexOf(","));
            errorColumns = errorColumns.substring(0, errorColumns.lastIndexOf(",") < 0 ? 0 : errorColumns.lastIndexOf(","));
//            if (tokenData.getTokenType().toString().contains("ERROR"))
//                ui.getDmErrorTable().addRow(new Object[]{key, tokenData.getTokenType().toString().toString(), errorLines, errorColumns});
//            else
                ui.getDmTokenTable().addRow(new Object[]{key.toString(), tokenData.getTokenType().toString(), lines, columns});
        }
    }
}
