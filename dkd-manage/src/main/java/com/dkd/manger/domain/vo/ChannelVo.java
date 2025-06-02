package com.dkd.manger.domain.vo;

import com.dkd.manger.domain.Channel;
import com.dkd.manger.domain.Sku;
import lombok.Data;

@Data
public class ChannelVo extends Channel {

    private Sku  sku;
}
