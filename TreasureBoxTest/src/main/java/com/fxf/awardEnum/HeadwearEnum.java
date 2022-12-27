package com.fxf.awardEnum;

/**
 * @Classname GoldGiftEnum
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/3/2 21:07
 * @Created by 饭小范
 */
public enum HeadwearEnum {

    headwaer1(200,"头饰1",1),
    headwaer2(500,"头饰2",2),
    headwaer3(700,"头饰3",3),
    headwaer4(1200,"头饰4",4),
    headwaer5(1500,"头饰5",5),
    ;
    private final int value;

    private final String giftName;
    private final int code;

    HeadwearEnum(int value, String giftName, int code) {
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
        for (HeadwearEnum goldGift : HeadwearEnum.values()) {
            if(goldGift.getValue() == value){
                return goldGift.getGiftName();
            }
        }
        return "";
    }

    public int getCode(int code){
        for (HeadwearEnum goldGift : HeadwearEnum.values()) {
            if(goldGift.getCode() == code){
                return goldGift.getValue();
            }
        }
        return 0;
    }
    public static HeadwearEnum randomType(HeadwearEnum[] values,Long gold){
        int i = 0;
        HeadwearEnum value = null;
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
