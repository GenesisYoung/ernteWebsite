package com.genesisstudio.ernteweb.config;

import org.springframework.stereotype.Component;

@Component
public class Util {
    public static String transToImgUrl(String imgId) {
        return "http://localhost:8080/file/download?id=" + imgId;
    }
}
