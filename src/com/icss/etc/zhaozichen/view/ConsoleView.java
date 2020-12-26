package com.icss.etc.zhaozichen.view;

import com.icss.etc.zhaozichen.user.StudentManager;
import com.icss.etc.zhaozichen.util.PropertiesUtil;

import java.util.Scanner;

/**
 * @title:
 * @fileName: ${fileName}
 * @description:
 * @copyright:
 * @company: 个人
 * @author: zhaozichen
 * @date: 2020/12/26 9:47
 * @version: V1.0
 */
public class ConsoleView {

    /**
     * 功能描述:
     *
     * @throws
     * @auther zhaozichen
     * @date 2020/12/26 9:56
     */
    public void mainView() {
        //用户登录
        userLoginView();
        //学生管理
        studentManagerView();
    }

    /**
     * 功能描述:用户登录
     *
     * @param
     * @return
     * @throws
     * @auther zhaozichen
     * @date 2020/12/26 10:05
     */
    private void userLoginView() {
        Scanner scanner = new Scanner(System.in);
        String username = "";
        String password = "";
        while (true) {
            System.out.println("请输入用户名：");
            username = scanner.nextLine();
            System.out.println("请输入密码：");
            password = scanner.nextLine();
            if ("".equals(username) || "".equals(password)) {
                System.out.println("用户名或密码不可为空！");
            } else if (!username.equals(PropertiesUtil.getInstance().getValue("username"))
                    && !password.equals(PropertiesUtil.getInstance().getValue("password"))) {
                System.out.println("用户名或密码输入错误！");
            } else {
                break;
            }
        }
    }

    /**
     * 功能描述: 学生管理
     *
     * @param
     * @return
     * @throws
     * @auther zhaozichen
     * @date 2020/12/26 10:04
     */
    private void studentManagerView() {
        System.out.println("|***************功能菜单****************|");
        System.out.println("1-添加学生信息");
        System.out.println("2-学生信息列表");
        System.out.println("3-修改学生信息");
        System.out.println("4-删除学生信息");
        System.out.println("0-退出登录");
        Scanner scanner = new Scanner(System.in);

        StudentManager sm = new StudentManager();
        while (true) {
            System.out.println("请输入菜单序号：");
            String menuNum = scanner.nextLine();
            if (!"0".equals(menuNum)) {
                switch (menuNum) {
                    case "1":
                        sm.addStudent();
                        break;
                    case "2":
                        sm.getStudents();
                        break;
                    case "3":
                        sm.updateStudent();
                        break;
                    case "4":
                        sm.deleteStudent();
                        break;
                    default:
                        System.out.println("输入错误");
                        break;
                }
            } else {
                System.out.println("退出登录");
                break;
            }
        }
    }

}
