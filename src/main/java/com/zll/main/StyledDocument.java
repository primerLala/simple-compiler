package com.zll.main; /**
 * Tecnológico de Costa Rica
 * Escuela de Ingeniería en Computación
 *
 * Created by:
 *
 * Fabián Lizarme Urdánegui
 * Alexis Gamboa Soto
 * José Mario Marín Brenes
 *
 * As a project for the Compilers and Intepreters course
 *
 * April 2014
 */


import javax.swing.text.*;
import java.awt.*;

public class StyledDocument extends DefaultStyledDocument {

    final StyleContext cont = StyleContext.getDefaultStyleContext();
    final AttributeSet attr = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.RED);
    final AttributeSet attrBlack = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
    final AttributeSet attrBlue = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
    final String literalRegex = "(\\s)*(auto|char|break|case|char|const|continue|default|do|"
            + "double|else|enum|extern|float|for|goto|if|inline|long|register|restrict|return|int|"
            + "short|signed|sizeof|static|struct|switch|typedef|union|unsigned|void|volatile|while|"
            + "_Alignas|_Alignof|_Atomic|_Bool|_Complex|_Generic|_Imaginary|_Noreturn|_Static_assert|_Thread_local|__func__)";

    @Override
    public void remove(int offs, int len) throws BadLocationException {
        super.remove(offs, len);

        String text = getText(0, getLength());
        int before = findLastNonWordChar(text, offs);
        if (before < 0) before = 0;
        int after = findFirstNonWordChar(text, offs);

        if (text.substring(before, after).matches(literalRegex)) {
            setCharacterAttributes(before, after - before, attr, false);
        } else {
            setCharacterAttributes(before, after - before, attrBlack, false);
        }
    }

    @Override
    public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
        super.insertString(offset, str, a);

        String text = getText(0, getLength());
        int before = findLastNonWordChar(text, offset);
        if (before < 0) before = 0;
        int after = findFirstNonWordChar(text, offset + str.length());
        int wordL = before;
        int wordR = before;


        while (wordR <= after) {
            if (wordR == after || String.valueOf(text.charAt(wordR)).matches("\\s")) {
                if (text.substring(wordL, wordR).matches(literalRegex))
                    setCharacterAttributes(wordL, wordR - wordL, attr, false);
                else
                    setCharacterAttributes(wordL, wordR - wordL, attrBlack, false);
                wordL = wordR;
            }
            wordR++;
        }
        String[] txt = text.split("\"");
        for (int index = 0; index < txt.length; index++) {
            if (text.indexOf("\"" + txt[index] + "\"") >= 0 && index % 2 == 1) {
                int indexOfWord = text.indexOf("\"" + txt[index] + "\"");
                setCharacterAttributes(indexOfWord,
                        txt[index].length() + 2, attrBlue, false);
                //setCharacterAttributes()
            }
        }
    }

    private int findFirstNonWordChar(String text, int index) {
        while (index < text.length()) {
            if (String.valueOf(text.charAt(index)).matches("\\s")) {
                break;
            }
            index++;
        }
        return index;
    }

    private int findLastNonWordChar(String text, int index) {
        while (--index >= 0) {
            if (String.valueOf(text.charAt(index)).matches("\\s")) {
                break;
            }
        }
        return index;
    }

}
