package client.view;
import client.net.SimpleClient;
import java.util.Scanner;
public class Getinfo{
private String ip;
public Getinfo(String ip){
this.ip=ip;
}
 public String getStudentInfo() {
        String code = "A02";
        String commandStr = getCommandCode(code);
        SimpleClient sc = new SimpleClient(ip, 4330, commandStr);
        String responseStr = sc.run();
        return responseStr;
    }

  public String getInfo(String studentInfo) {
        String InfoStr = "None";
        String[] result = studentInfo.split(",");
        if (result.length != 4) {
            InfoStr = "None";
        } else {
            InfoStr = "学号:" + result[0].trim() + "  姓名:" + result[1].trim() + "  年龄:" + result[2].trim() + "  成绩:" + result[3].trim();
        }
        return InfoStr;
    }


  public String getCommandCode(String code) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input student code:");
        String sid = sc.nextLine();
        String result = code + "-" + sid;
        return result;
    }

}