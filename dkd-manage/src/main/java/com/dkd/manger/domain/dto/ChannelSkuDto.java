package com.dkd.manger.domain.dto;

import lombok.Data;

@Data
public class ChannelSkuDto {
    private String innerCode;
    private String channelCode;
    private Long skuId;
}
