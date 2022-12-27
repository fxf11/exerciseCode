package com.fxf.awardEnum;

/**
 * @Classname GoldGiftEnum
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/3/2 21:07
 * @Created by 饭小范
 */
public enum GoldGiftEnum {

    gift1(20,"金币礼物1",1),
    gift2(200,"金币礼物2",2),
    gift3(300,"金币礼物3",3),
    gift4(900,"金币礼物4",4),
    gift5(700,"金币礼物5",5),
    gift6(1,"金币礼物6",6),
    ;
    private final int value;

    private final String giftName;
    private final int code;

    GoldGiftEnum(int value, String giftName,int code) {
        this.value = value;
        this.giftName = giftName;
        this.code = code;
    }

    @Override
    public String toString() {
        return "{\"value\":" + value + ",\"giftName\":\"" + giftName + "\"}";
    }

    public int getValue() {
        return this.value;
    }

    public String getGiftName() {
        return giftName;
    }

    public int getCode() {
        return code;
    }

    public String get(int value){
        for (GoldGiftEnum goldGift : GoldGiftEnum.values()) {
            if(goldGift.getValue() == value){
                return goldGift.getGiftName();
            }
        }
        return "";
    }

    public int getCode(int code){
        for (GoldGiftEnum goldGift : GoldGiftEnum.values()) {
            if(goldGift.getCode() == code){
                return goldGift.getValue();
            }
        }
        return 0;
    }

    public static GoldGiftEnum randomType(GoldGiftEnum[] values,Long gold){
        GoldGiftEnum value = null;
        while (value == null){
            value = values[(int) (Math.random() * values.length)];
        }
        if (value.getValue() > gold){
            GoldGiftEnum.randomType(GoldGiftEnum.values(),gold);
        }
        return value;
    }
}
