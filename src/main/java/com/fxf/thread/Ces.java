package com.fxf.thread;

import java.util.ArrayList;
import java.util.List;

    /**
     * @author 饭小范
     * @version 1.0
     * @description: TODO
     * @date 2021/9/12 11:54
     */
    public class Ces {
        public static void generate(int n){
            int slice_index = 1; int count = 1;
            while (count <=n){
                List<Integer> target = range(slice_index, slice_index+5);
                if(target.get(2)<count && slice_index+5<=n){
                    slice_index += 1;
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                for(Integer i: target){
                    if (i==count){
                        sb.append(String.format("'%d%s',", i, "*" ));
                    }else{
                        sb.append(String.format("'%d%s',", i, ""));
                    }
                }
                System.out.println(String.format("%d: [%s]", count, sb.substring(0, sb.length()-1)));
                count+=1;
            }

        }
        private static List<Integer> range(int start, int end){
            List<Integer> l = new ArrayList<Integer>();
            for(int i = start; i<end; i++){
                l.add(i); }return l;
        }
        public static void main(String[] args) {
            generate(6);
        }
    }

