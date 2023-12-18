package client.view;
import client.net.SimpleClient;
import java.util.Scanner;
public class Addinfo{
private String ip;
public Addinfo(String ip){
this.ip=ip;
}

public void inputNewStudentGrade() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter student information (Format: 学号,姓名,年龄,成绩):");
    String studentInfo = sc.nextLine();
    String response = sendNewStudentGrade(studentInfo);
    System.out.println("Server response: " + response);
  }

    private String getCommandCode(String code) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input student code:");
        String sid = sc.nextLine();
        String result = code + "-" + sid;
        return result;
    }

   private String sendNewStudentGrade(String studentInfo) {
    String code = "A03";
    String commandStr =code+"-"+studentInfo;
    SimpleClient sc = new SimpleClient(ip,4330,commandStr);
    return sc.run();
}

} 