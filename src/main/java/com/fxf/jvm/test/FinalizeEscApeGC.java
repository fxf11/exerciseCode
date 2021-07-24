package com.fxf.jvm.test;

/**
 *
 * 此代码演示了两点：
 *1.对象可以在被GC时自我拯救。
 *2.这种自救的机会只有一次，因为一个对象的finalize（）方法最多只会被系统自动调用一次
 *
 * @author 饭小范
 * @version 1.0
 * @description: TODO JVM 一次对象的自我拯救演示
 * @date 2021/7/23 22:44
 */
public class FinalizeEscApeGC {

    public static FinalizeEscApeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("我还活着");

    }
    @Override
    protected void finalize()throws Throwable{
        super.finalize();
        System.out.println("finalize mehtod executed！");
        FinalizeEscApeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscApeGC();
        //对象第一次成功拯救自己
        SAVE_HOOK = null;

        System.gc();

        //因为finalieze方法的优先级很低，所以暂停0.5s等待他

        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("对象已死");
        }
        //下面这段代码与上面的完全相同，但是这次自救却失败了
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("对象已死");
        }


    }



}
