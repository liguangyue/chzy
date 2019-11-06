package com.chzyplus.goods.vo;


import com.chzyplus.goods.entity.PmsProductAttribute;
import com.chzyplus.goods.entity.PmsProductAttributeCategory;

import java.util.List;

/**
 * 包含有分类下属性的dto
 * https://github.com/shenzhuan/chzyplus on 2018/5/24.
 */
public class PmsProductAttributeCategoryItem extends PmsProductAttributeCategory {
    private List<PmsProductAttribute> productAttributeList;

    public List<PmsProductAttribute> getProductAttributeList() {
        return productAttributeList;
    }

    public void setProductAttributeList(List<PmsProductAttribute> productAttributeList) {
        this.productAttributeList = productAttributeList;
    }
}
