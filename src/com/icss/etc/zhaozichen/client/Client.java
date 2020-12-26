package com.icss.etc.zhaozichen.client;

import com.icss.etc.zhaozichen.view.ConsoleView;

/**
 * @title: 客户端入口
 * @fileName:
 * @description:
 * @copyright:
 * @company: 个人
 * @author: zhaozichen
 * @date: 2020/12/26 9:38
 * @version: V1.0
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("|*****************欢迎访问学生管理系统********************|");
        ConsoleView cv = new ConsoleView();
        cv.mainView();
    }
}
