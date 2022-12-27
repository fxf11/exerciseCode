package com.fxf.service.impl;

import com.fxf.awardEnum.GoldGiftEnum;
import com.fxf.awardEnum.HeadwearEnum;
import com.fxf.awardEnum.VIPEnum;
import com.fxf.service.TreasureBoxRewardService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Classname RewardServiceV1
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/3/2 21:05
 * @Created by 饭小范
 */
public class RewardServiceV1 implements TreasureBoxRewardService {




    @Override
    public List<String> openAward(Long goldNum) {

        Random random = new Random();
        Long startGold = goldNum;
        ArrayList<String> reward = new ArrayList<>();
        while (goldNum > 200 && goldNum <1200){
            int i = random.nextInt(100);
            if (i<20){
                GoldGiftEnum goldGiftEnum = GoldGiftEnum.randomType(GoldGiftEnum.values(),goldNum);
                goldNum-=goldGiftEnum.getValue();
                reward.add(goldGiftEnum.getGiftName());
            }else if(i<50){
                HeadwearEnum headwearEnum = HeadwearEnum.randomType(HeadwearEnum.values(),goldNum);
                if (headwearEnum!=null){
                    goldNum-=headwearEnum.getValue();
                    reward.add(headwearEnum.getGiftName());
                }
            }else {
                VIPEnum vipEnum = VIPEnum.randomType(VIPEnum.values(),goldNum);
                if (vipEnum != null){
                    goldNum-=vipEnum.getValue();
                    reward.add(vipEnum.getGiftName());
                }

            }

        }

        return reward;
    }
}
