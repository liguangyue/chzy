package com.chzyplus.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chzyplus.goods.entity.PmsProductAttribute;
import com.chzyplus.goods.vo.ProductAttrInfo;

import java.util.List;

/**
 * <p>
 * 商品属性参数表 服务类
 * </p>
 *
 * @author zscat
 * @since 2019-04-19
 */
public interface IPmsProductAttributeService extends IService<PmsProductAttribute> {

    List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId);

    boolean saveAndUpdate(PmsProductAttribute entity);
}
