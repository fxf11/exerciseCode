package com.fxf;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/7/26 22:29
 */
public class InetAddressTest {

    public static void main(String[] args) {
//        InetAddress byName = null;
//        try {
//            byName = InetAddress.getByName("192.168.10.14");
//            System.out.println(byName);
//
//
//            InetAddress inet = InetAddress.getByName("127.0.0.1");
//            System.out.println(inet);
//
//            InetAddress localHost = InetAddress.getLocalHost();
//            System.out.println(localHost);
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }

       double diamonSalary = 12.00 + new BigDecimal(580.00).divide(new BigDecimal(1500), 0).doubleValue();
        System.out.println(diamonSalary);
    }
}
