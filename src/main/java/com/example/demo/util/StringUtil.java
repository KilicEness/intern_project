package com.example.demo.util;

public class StringUtil {

    private StringUtil() {

    }

    public static boolean isNotEmpty(String val) {
        return val != null && val.length() > 0;
    }

    public static boolean isEmpty(String val) {
        return !isNotEmpty(val);
    }

    public static String toUpperCaseAndGet(String val) throws Exception {
        if (isEmpty(val)) {
            throw new Exception("val null !!!!");
        }
        return val.toUpperCase();
    }

    public static String getSubString(String val, int beginIndex, int endIndex) {
        int start = val.length() < beginIndex ? 0 : beginIndex;
        int end = val.length() < endIndex ? val.length() + 1 : endIndex;
        return val.substring(start, end);
    }

    public static String turkceKarakterleriIngYap(String val) {
        val = val.replace("ç", "c");
        val = val.replace("ğ", "g");
        val = val.replace("ı", "i");
        val = val.replace("ö", "o");
        val = val.replace("ş", "s");
        val = val.replace("ü", "u");
        return val;
    }


}
