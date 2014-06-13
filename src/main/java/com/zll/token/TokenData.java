package com.zll.token;

import java.util.*;

public class TokenData {

    private TokenType tokenType;

    public TokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    private Map<Integer,List<Integer>> positionDictionary;

    public TokenData(TokenType pTokenType, int pLine, int pColumn) {
        this.tokenType = pTokenType;
        this.positionDictionary = new HashMap<Integer,List<Integer>>();
        this.positionDictionary.put(pLine, Arrays.asList(pColumn));
    }

    public void addPosition(int pLine,int pColumn) {
        List<Integer> newColumnList = new ArrayList<Integer>();
        if (this.positionDictionary.containsKey(pLine)){
            newColumnList =  new ArrayList<Integer>(this.positionDictionary.get(pLine));
        }
        newColumnList.add(pColumn);
        this.positionDictionary.put(pLine, newColumnList);
    }

    public Map<Integer, List<Integer>> getPositionDictionary() {
        return positionDictionary;
    }

    

}
