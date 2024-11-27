package com.genesisstudio.ernteweb.vo;

import com.genesisstudio.ernteweb.domain.Manuals;
import com.genesisstudio.ernteweb.domain.Recepies;
import lombok.Data;

import java.util.List;

@Data
public class DownloadVO {
    private List<Manuals> manuals;
    private List<Recepies> recipes;
}
