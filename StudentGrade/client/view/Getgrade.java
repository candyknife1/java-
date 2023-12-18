package client.view;
import java.util.Scanner;
import client.net.SimpleClient;

public class Getgrade{
private String ip;
public Getgrade(String ip){
this.ip=ip;
}

public String getGrade() {
        String code = "A01";
        String commandStr = getCommandCode(code);
        SimpleClient sc = new SimpleClient(ip, 4330, commandStr);
        String responseStr = sc.run();
        String result = getStudentGrade(responseStr);
        return result;
    }

public String getStudentGrade(String cmdStr) {
        String gradeStr = "None";
        String[] result = cmdStr.split("-");
        if (result.length != 2) {
            gradeStr = "None";
        } else {
            if ("A01".equals(result[0])) {
                gradeStr = result[1].trim();
            }
        }
        return gradeStr;
    }

public String getCommandCode(String code) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input student code:");
        String sid = sc.nextLine();
        String result = code + "-" + sid;
        return result;
    }

}
