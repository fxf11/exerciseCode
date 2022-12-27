package com.fxf.awardEnum;

/**
 * @Classname GoldGiftEnum
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/3/2 21:07
 * @Created by 饭小范
 */
public enum VIPEnum {

    V1(1000,"V1",1),
    V2(2000,"v2",2),
    V3(3000,"v3",3),
    V4(4000,"v4",4),
    V5(5000,"v5",5),
    ;
    private final int value;

    private final String giftName;
    private final int code;

    VIPEnum(int value, String giftName, int code) {
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
        for (VIPEnum goldGift : VIPEnum.values()) {
            if(goldGift.getValue() == value){
                return goldGift.getGiftName();
            }
        }
        return "";
    }

    public int getCode(int code){
        for (VIPEnum goldGift : VIPEnum.values()) {
            if(goldGift.getCode() == code){
                return goldGift.getValue();
            }
        }
        return 0;
    }

    public static VIPEnum randomType(VIPEnum[] values,Long gold){
        VIPEnum value = null;
        int i = 0;
        while (value == null && i <=5){
            value = values[(int) (Math.random() * values.length)];
            i++;
        }
        if (value == null || value.getValue() >= gold){
            value = null;
        }
        return value;
    }
}
