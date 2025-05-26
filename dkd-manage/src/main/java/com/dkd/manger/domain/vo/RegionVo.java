package com.dkd.manger.domain.vo;

import com.dkd.manger.domain.Region;
import lombok.Data;

@Data
public class RegionVo extends Region {
    /**
     * 点位数量
     */
    private int nodeCount;
}
