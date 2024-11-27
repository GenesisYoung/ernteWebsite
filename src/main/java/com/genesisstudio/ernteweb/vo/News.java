package com.genesisstudio.ernteweb.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data()
public class News extends com.genesisstudio.ernteweb.domain.News {
    private String dateYear;
    private String dateVO;
    private String path;
}
