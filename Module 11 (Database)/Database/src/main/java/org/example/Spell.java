package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Spell {
    private final Set<String> wordList;
    private final String regEx;


    public Spell(Set<String> wordList, String regEx) {
        this.wordList = wordList;
        this.regEx = regEx;
    }

    public void check(String text) {
        List<String> notInDic = new ArrayList<>();
        System.out.println("Words that aren't in the dictionary: ");
        for (String word : text.split(" ")) {
            String regWord = word.replaceAll(regEx, "");
            if (!wordList.contains(regWord)) {
                notInDic.add(regWord);
            }
        }
        if (notInDic.isEmpty()) {
            System.out.println(" (empty).");
        } else {
            System.out.println(notInDic);
        }
    }
}
