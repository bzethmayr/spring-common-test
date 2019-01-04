package net.zethmayr.benjamin.spring.common.controller.test;

import org.junit.Test;

import static net.zethmayr.benjamin.spring.common.controller.test.ControllerResponseMatchers.looksLikeAJsonArray;
import static net.zethmayr.benjamin.spring.common.controller.test.ControllerResponseMatchers.looksLikeAJsonObject;
import static net.zethmayr.benjamin.spring.common.controller.test.ControllerResponseMatchers.looksLikeHtml5;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class ControllerResponseMatchersTest {
    @Test
    public void exampleLooksLikeHtml5() {
        assertThat("<!DOCTYPE html>", looksLikeHtml5());
        assertThat("<html>", not(looksLikeHtml5()));
        assertThat("{\"foo\":", not(looksLikeHtml5()));
    }

    @Test
    public void exampleLooksLikeJsonObject() {
        assertThat("{\"foo\":", looksLikeAJsonObject());
        assertThat("[\"foo\",", not(looksLikeAJsonObject()));
        assertThat("<html>", not(looksLikeAJsonObject()));
    }

    @Test
    public void exampleLooksLikeJsonArray() {
        assertThat("[\"foo\",", looksLikeAJsonArray());
        assertThat("{\"foo\":", not(looksLikeAJsonArray()));
        assertThat("<html>", not(looksLikeAJsonArray()));
    }
}
