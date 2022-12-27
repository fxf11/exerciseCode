package com.fxf;

import com.fxf.service.TreasureBoxRewardService;
import com.fxf.service.impl.RewardServiceV1;

import java.util.List;
import java.util.Random;

/**
 * @Classname TreasureBox
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/3/2 20:58
 * @Created by 饭小范
 */
public class TreasureBox {

    private TreasureBoxRewardService treasureBoxRewardService;

    public TreasureBox(TreasureBoxRewardService treasureBoxRewardService){
        this.treasureBoxRewardService = treasureBoxRewardService;
    }

    public List<String> gerAward(Long goldNum) {
        return treasureBoxRewardService.openAward(goldNum);
    }

    public static void main(String[] args) {
        TreasureBox treasureBox = new TreasureBox(new RewardServiceV1());
        List<String> strings = treasureBox.gerAward(1000L);
        for (String string : strings) {
            System.out.println(string);
        }


    }
}
