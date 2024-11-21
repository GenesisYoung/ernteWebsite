package com.genesisstudio.ernteweb.vo;

import com.genesisstudio.ernteweb.domain.Events;
import lombok.Data;

import java.util.List;

@Data
public class AboutVO {
    private List<Events> events;
    private String[] hornors;
    private String[] products;
}
