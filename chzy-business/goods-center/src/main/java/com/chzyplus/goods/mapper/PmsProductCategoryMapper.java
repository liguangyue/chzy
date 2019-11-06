package com.chzyplus.goods.mapper;

import com.chzyplus.goods.entity.PmsProductCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chzyplus.goods.vo.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * <p>
 * 产品分类 Mapper 接口
 * </p>
 *
 * @author zscat
 * @since 2019-04-19
 */
public interface PmsProductCategoryMapper extends BaseMapper<PmsProductCategory> {

    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
