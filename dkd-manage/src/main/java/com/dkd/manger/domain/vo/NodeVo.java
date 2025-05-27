package com.dkd.manger.domain.vo;

import com.dkd.manger.domain.Node;
import com.dkd.manger.domain.Region;
import com.dkd.manger.domain.TbPartner;
import lombok.Data;

@Data
public class NodeVo extends Node {

    // 设备数量
    private Integer vmCount;
    // 区域
    private Region region;
    //  合作商
    private TbPartner partner;
}
