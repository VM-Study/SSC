package org.example;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/java";
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "admin";
    public static final String TABLE = "dictionarycol";
    public static final String REGEX = "[^A-Za-z]";
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        MyJDBC myJDBC = new MyJDBC(JDBC_URL, USERNAME, PASSWORD, TABLE);
        Set<String> wordList = myJDBC.loadDB();

        Spell spell = new Spell(wordList, REGEX);
        System.out.println("Enter the text to check:");
        String text = SCANNER.nextLine();

        System.out.println("Text: '" + text + "'");
        spell.check(text);

    }
}
