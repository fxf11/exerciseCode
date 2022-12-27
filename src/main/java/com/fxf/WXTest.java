package com.fxf;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.util.Date;

/**
 * @Classname WXTest
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/3/8 21:58
 * @Created by 饭小范
 */
public class WXTest{

//    public static void main(String[] args) throws InterruptedException {
//        // 好友昵称
//        String friendNickName = "大大大大大宝贝";
////        String friendNickName = "不器";
//
//        while(true){
//            searchMyFriendAndSend(friendNickName);
//        }
//    }
//
//    private static void searchMyFriendAndSend(String friendNickName) throws InterruptedException {
//        // 创建Robot对象
//        Robot robot = getRobot();
//        //打开微信 Ctrl+Alt+W
//        assert robot != null;
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_ALT);
//        robot.keyPress(KeyEvent.VK_W);
//        //释放Ctrl按键，像Ctrl，退格键，删除键这样的功能性按键，在按下后一定要释放
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.keyRelease(KeyEvent.VK_ALT);
//
//        // 该延迟不能少，否则无法搜索
//        robot.delay(1000);
//
//        // Ctrl + F 搜索指定好友
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_F);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//
//        // 将好友昵称发送到剪切板
//        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
//        Transferable tText = new StringSelection(friendNickName);
//        clip.setContents(tText, null);
//        // 以下两行按下了ctrl+v，完成粘贴功能
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.delay(1000);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.delay(1000);
//
//        // 发送消息
//        sendMsg();
//    }
//
//    private static void sendMsg() throws InterruptedException {
//        String[] mottoes = {
//                "我只爱你四天，春天夏天秋天冬天！",
//                "我只爱你三天，昨天,今天,明天！",
//                "我只爱你两天，白天，黑天！",
//                "我只爱你一天，每一天！",
//                "[玫瑰]亲亲亲亲亲！",
//                "嘿嘿我的宝节日快乐嘿嘿嘿",
//                "[奸笑]"
//        };
//        for (String motto : mottoes) {
//            sendOneMsg(motto);
//        }
//        Thread.sleep(2000);
//
////        sendOneMsg("[得意]就问你，腻不腻害！");
//    }
//
//    private static void sendOneMsg(String msg) {
//        // 创建Robot对象
//        Robot robot = getRobot();
//        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
//        // 将字符串复制到剪切板
//        Transferable tText = new StringSelection(msg);
//        clip.setContents(tText, null);
//        // 以下两行按下了ctrl+v，完成粘贴功能
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        // 回车发送
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.delay(1000);
//    }

//    private static Robot getRobot(){
//        // 创建Robot对象
//        Robot robot = null;
//        try {
//            robot = new Robot();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//        return robot;
//    }


    public static void main(String[] args) {
//        Integer a = 1, b = 2, c = null;
//        System.out.println(true ? a*b : c); // 2
//        System.out.println(false ? a*b : c); // NPE
//        String str1 = "abcd";
//
//        String str2 = "abcd";
//
//        String str3 = new String("abcd");
//
//        String str4 = new String("abcd");
//
//        System.out.println(str1==str2);//true地址一样
//
//        System.out.println(str3==str4);//false,但地址不一样
//
//        System.out.println(str3.equals(str3));//true,值一样
//        System.out.println(str2.equals(str3));//true,值一样
//        System.out.println((str1+"a")==(str2+"a"));//false;进行了+连接地址不一样



    }

//        public static void method(String param) {
//            switch (param) {
//// 肯定不是进入这里
//                case "sth":
//                    System.out.println("it's sth");
//                    break;
//// 也不是进入这里
//                case "null":
//                    System.out.println("it's null");
//                    break;
//// 也不是进入这里
//                default:
//                    System.out.println("default");
//            }
//        }


}
