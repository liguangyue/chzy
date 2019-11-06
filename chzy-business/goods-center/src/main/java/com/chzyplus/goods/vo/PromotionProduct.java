package com.chzyplus.goods.vo;


import com.chzyplus.goods.entity.PmsProduct;
import com.chzyplus.goods.entity.PmsProductFullReduction;
import com.chzyplus.goods.entity.PmsProductLadder;
import com.chzyplus.goods.entity.PmsSkuStock;

import java.util.List;

/**
 * https://github.com/shenzhuan/chzyplus on 2018/8/27.
 * 商品的促销信息，包括sku、打折优惠、满减优惠
 */
public class PromotionProduct extends PmsProduct {
    //商品库存信息
    private List<PmsSkuStock> skuStockList;
    //商品打折信息
    private List<PmsProductLadder> productLadderList;
    //商品满减信息
    private List<PmsProductFullReduction> productFullReductionList;

    public List<PmsSkuStock> getSkuStockList() {
        return skuStockList;
    }

    public void setSkuStockList(List<PmsSkuStock> skuStockList) {
        this.skuStockList = skuStockList;
    }

    public List<PmsProductLadder> getProductLadderList() {
        return productLadderList;
    }

    public void setProductLadderList(List<PmsProductLadder> productLadderList) {
        this.productLadderList = productLadderList;
    }

    public List<PmsProductFullReduction> getProductFullReductionList() {
        return productFullReductionList;
    }

    public void setProductFullReductionList(List<PmsProductFullReduction> productFullReductionList) {
        this.productFullReductionList = productFullReductionList;
    }
}
