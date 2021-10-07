package com.example.sort.entity;

/**
 * @ClassName ShopEntity
 * @Description TODO
 * @Author Zhi Qiang
 * @Email 1745984453@qq.com
 * @Date 2021/10/7 21:35
 * @Version 1.0
 * @ClassDescription
 */
public class ShopEntity {
    private String  goodsDefaultIcon ; //默认图标
    private Long  goodsDefaultPrice  ; //默认价格

    public ShopEntity() {
    }

    public ShopEntity(String goodsDefaultIcon, Long goodsDefaultPrice) {
        this.goodsDefaultIcon = goodsDefaultIcon;
        this.goodsDefaultPrice = goodsDefaultPrice;
    }

    public String getGoodsDefaultIcon() {
        return goodsDefaultIcon;
    }

    public void setGoodsDefaultIcon(String goodsDefaultIcon) {
        this.goodsDefaultIcon = goodsDefaultIcon;
    }

    public Long getGoodsDefaultPrice() {
        return goodsDefaultPrice;
    }

    public void setGoodsDefaultPrice(Long goodsDefaultPrice) {
        this.goodsDefaultPrice = goodsDefaultPrice;
    }

    @Override
    public String toString() {
        return "ShopEntity{" +
                "goodsDefaultIcon='" + goodsDefaultIcon + '\'' +
                ", goodsDefaultPrice=" + goodsDefaultPrice +
                '}';
    }
}
