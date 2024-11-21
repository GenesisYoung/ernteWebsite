package com.genesisstudio.ernteweb.vo;

import com.genesisstudio.ernteweb.domain.Product;
import lombok.Data;

import java.util.List;

@Data
public class HomeVO {
    private String[] screenImages;
    private String[] productsSeries;
    private List<Product> products;
    private List<News> news;
}
