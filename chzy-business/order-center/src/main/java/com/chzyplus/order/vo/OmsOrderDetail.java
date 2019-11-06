package com.chzyplus.order.vo;


import com.chzyplus.order.entity.OmsOrder;
import com.chzyplus.order.entity.OmsOrderItem;
import com.chzyplus.order.entity.OmsOrderOperateHistory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单详情信息
 * https://github.com/shenzhuan/chzyplus on 2018/10/11.
 */
public class OmsOrderDetail extends OmsOrder {
    @Getter
    @Setter
    private List<OmsOrderItem> orderItemList;
    @Getter
    @Setter
    private List<OmsOrderOperateHistory> historyList;
}
