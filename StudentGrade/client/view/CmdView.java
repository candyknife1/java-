package client.view;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import client.net.SimpleClient;
import client.view.Getgrade;
import client.view.Getinfo;
import client.view.Addinfo;
public class CmdView {
    private String ip;

    public void run() {
        boolean flag = true;
        
        File file = new File("ip.txt");
        if (file.exists()) {
            Scanner sc = new Scanner(System.in);
            System.out.print("是否使用之前的IP地址？(y/n): ");
            String choice = sc.nextLine().toLowerCase();
            if (choice.equals("y")) {
                try {
                    Scanner fileScanner = new Scanner(file);
                    ip = fileScanner.nextLine();
                    fileScanner.close();
                } catch (IOException e) {
                    System.out.println("读取IP地址失败！");
                    e.printStackTrace();
                }
            } else {
                inputNewIp();
            }
        } else {
            inputNewIp();
        }

        while (flag) {
            display();
            int n = input();
            flag = process(n);
        }
    }

    private void display() {
        System.out.println("学生成绩查询菜单：");
        System.out.println("1. Get Student Grade");
        System.out.println("2. Get Student Information");
        System.out.println("3. Add Student Information");
        System.out.println("0. Exit");
    }

    private int input() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        return n;
    }

    private boolean process(int n) {
        boolean flag = true;
        if (n == 1) {
           Getgrade cj=new Getgrade(ip);
            String grade = cj.getGrade();
            System.out.println("grade = " + grade);
        } else if (n == 2) {
            Getinfo info=new Getinfo(ip);
            String studentInfo = info.getStudentInfo();
            String result = info.getInfo(studentInfo);
            System.out.println("Student Information: " + result);
        }  else if (n == 3) {
      Addinfo add=new Addinfo(ip);
      add.inputNewStudentGrade();
      }
          else if (n == 0) {
            flag = false;
        } else {
            System.out.println("(0-3)!!");
        }
        return flag;
    }

      

    private void inputNewIp() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入服务器IP地址：");
        ip = sc.nextLine();
        try {
            FileWriter writer = new FileWriter("ip.txt");
            writer.write(ip);
            writer.close();
        } catch (IOException e) {
            System.out.println("保存IP地址失败！");
            e.printStackTrace();
        }
    }
}
