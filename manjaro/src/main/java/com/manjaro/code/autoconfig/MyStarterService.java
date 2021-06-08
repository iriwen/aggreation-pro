package com.manjaro.code.autoconfig;

/**
 * created by iriwen on 2020/06/24.
 */

public class MyStarterService {

    private String words;

    private String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String sayHello() {
        return "the first starter, " + words;
    }
}
