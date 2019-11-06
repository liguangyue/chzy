package com.chzyplus.goods.service;

import com.chzyplus.goods.entity.PmsProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chzyplus.goods.vo.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * <p>
 * 产品分类 服务类
 * </p>
 *
 * @author zscat
 * @since 2019-04-19
 */
public interface IPmsProductCategoryService extends IService<PmsProductCategory> {

    List<PmsProductCategoryWithChildrenItem> listWithChildren();

    int updateNavStatus(List<Long> ids, Integer navStatus);

    int updateShowStatus(List<Long> ids, Integer showStatus);

    boolean updateAnd(PmsProductCategory entity);

    boolean saveAnd(PmsProductCategory entity);
}
