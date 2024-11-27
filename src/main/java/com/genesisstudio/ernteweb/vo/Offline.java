package com.genesisstudio.ernteweb.vo;

import com.genesisstudio.ernteweb.domain.OfflineSpots;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Offline extends OfflineSpots {
    private String[] spotsVO;
}
