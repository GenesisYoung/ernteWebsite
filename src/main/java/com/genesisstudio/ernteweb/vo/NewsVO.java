package com.genesisstudio.ernteweb.vo;

import lombok.Data;

import java.util.List;

@Data
public class NewsVO {
    private long total;
    private List<News> news;
}
