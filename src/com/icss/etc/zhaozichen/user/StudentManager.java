package com.icss.etc.zhaozichen.user;

import com.icss.etc.zhaozichen.net.HttpSendUtils;
import com.icss.etc.zhaozichen.pojo.Student;
import com.icss.etc.zhaozichen.util.HAUtils;

import java.util.List;
import java.util.Scanner;

/**
 * @title: 学生管理
 * @fileName: ${fileName}
 * @description:
 * @copyright:
 * @company: 个人
 * @author: zhaozichen
 * @date: 2020/12/26 9:48
 * @version: V1.0
 */
public class StudentManager {

    private static String IP = "222.186.174.9";

    private static int PROT = 42104;

    public void addStudent() {
        System.out.println("***添加学生***");
        Scanner scanner = new Scanner(System.in);
        String isCommit = "";
        while (true) {
            Student student = new Student();
            System.out.println("请输入学生姓名：");
            student.setName(scanner.nextLine());
            System.out.println("请输入学生年龄：");
            student.setAge(scanner.nextLine());
            System.out.println("请输入学生出生日期：");
            student.setDay(scanner.nextLine());
            System.out.println("是否提交：1 是, 2 否");
            isCommit = scanner.nextLine();
            if ("1".equals(isCommit)) {
                student.setType("1");
                Object obj = HttpSendUtils.getInstance().send(IP, PROT, student);
                if (HAUtils.objToList(obj, Student.class).size() > 0) {
                    System.out.println("添加学生成功！");
                }
                break;
            } else {
                System.out.println("输入错误请重试！");
            }
        }

    }

    public void getStudents() {
        System.out.println("***查询学生***");
        Object o = HttpSendUtils.getInstance().send(IP, PROT, new Student("2"));
        List<Student> students = HAUtils.objToList(o, Student.class);
        System.out.println("编号      姓名      年龄      出生日期");
        students.forEach(student -> {
            System.out.println(student.getId() + "        " + student.getName() + "       " +
                    student.getAge() + "        " + student.getDay());
        });
    }


    public void updateStudent() {
        System.out.println("***修改学生***");
        Scanner scanner = new Scanner(System.in);
        String isCommit = "";
        while (true) {
            Student student = new Student();
            System.out.println("请输入学生id：");
            student.setId(scanner.nextLine());
            System.out.println("请输入学生姓名：");
            student.setName(scanner.nextLine());
            System.out.println("请输入学生年龄：");
            student.setAge(scanner.nextLine());
            System.out.println("请输入学生出生日期：");
            student.setDay(scanner.nextLine());
            System.out.println("是否提交：1 是, 2 否");
            isCommit = scanner.nextLine();
            if ("1".equals(isCommit)) {
                student.setType("3");
                Object obj = HttpSendUtils.getInstance().send(IP, PROT, student);
                if (HAUtils.objToList(obj, Student.class).size() > 0) {
                    System.out.println("修改学生成功！");
                }
                break;
            } else {
                System.out.println("输入错误请重试！");
            }
        }
    }

    public void deleteStudent() {
        System.out.println("***删除学生***");
        System.out.println("请输入需要删除的学生id：");
        Scanner scanner = new Scanner(System.in);
        List<Student> students = HAUtils.objToList(HttpSendUtils.getInstance().send(IP, PROT,
                new Student(scanner.nextLine(), "4")), Student.class);
        if (students.size()>0){
            System.out.println("删除成功！");
        }
    }
}
