package com.dkd.manger.domain.vo;

import com.dkd.manger.domain.TbPartner;
import lombok.Data;

@Data
public class PartnerVo extends TbPartner {
    /**
     * 节点数
     */
    private int nodeCount;
}
