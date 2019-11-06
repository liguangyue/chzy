package com.chzyplus.marking.service;

import com.chzyplus.marking.entity.SmsFlashPromotion;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 限时购表 服务类
 * </p>
 *
 * @author zscat
 * @since 2019-04-19
 */
public interface ISmsFlashPromotionService extends IService<SmsFlashPromotion> {
    /**
     * 修改上下线状态
     */
    int updateStatus(Long id, Integer status);
}
