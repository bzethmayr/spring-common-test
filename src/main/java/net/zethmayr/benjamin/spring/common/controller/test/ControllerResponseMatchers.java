package net.zethmayr.benjamin.spring.common.controller.test;

import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.startsWith;

public class ControllerResponseMatchers {
    public static Matcher<String> looksLikeHtml5() {
        return startsWith("<!DOCTYPE html>");
    }
    public static Matcher<String> looksLikeAJsonObject() {
        return startsWith("{");
    }
    public static Matcher<String> looksLikeAJsonArray() {
        return startsWith("[");
    }
}
