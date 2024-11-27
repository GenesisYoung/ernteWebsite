package com.genesisstudio.ernteweb.vo;

import com.genesisstudio.ernteweb.domain.DetailContent;
import com.genesisstudio.ernteweb.domain.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Detail extends Product {
    private String[] bigImages;
    private String leftImage;
    private List<DetailContent> contents;
}
