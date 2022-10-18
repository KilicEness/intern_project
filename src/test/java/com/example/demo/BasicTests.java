package com.example.demo;

import com.example.demo.util.StringUtil;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * Basic Unit Test'lerin Yazılacağı Class
 */
public class BasicTests {

    @Test
    void stringUtilIsEmptyTest() {
        assertTrue(StringUtil.isEmpty(""));
        assertEquals(StringUtil.isEmpty("asdsadas"), false);
        assertFalse(StringUtil.isEmpty("asdsadas"));
    }

    @Test
    void exceptionTest() {
        assertThrows(Exception.class, () -> {
            StringUtil.toUpperCaseAndGet(null);
        });
    }

    //TODO StringUtil getSubString test et. getSubString (eren, 1, 2), e

    //TODO StringUtil turkceKarakterleriIngYap test et. ("öğretmen") "ogretmen"

    @Test
    void stringUtilGetSubStringTest() {

        assertEquals(StringUtil.getSubString("eren", 1, 2), "r");
    }

    @Test
    void stringUtilTurkceKarakterleriIngYapTest() {
        assertEquals(StringUtil.turkceKarakterleriIngYap("öğretmen"), "ogretmen");
    }

    @Test
    void stringUtilToUpperCaseAndGet() throws Exception {
        assertEquals(StringUtil.toUpperCaseAndGet("enes"), "ENES");


    }

}
