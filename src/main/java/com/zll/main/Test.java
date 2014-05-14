package com.zll.main;

import java_cup.parser;


import java.io.FileReader;

/**
 * @Author Jiale Zheng
 * On 14-5-14.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        parser p=new parser(new Scanner(new FileReader(args[0])));
        p.parse();
    }
}
