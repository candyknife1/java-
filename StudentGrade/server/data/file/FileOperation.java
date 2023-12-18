package server.data.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;

import server.data.DataAble;

public class FileOperation implements DataAble {
    private String name;

    public FileOperation(String name) {
        this.name = name;
    }

    public String getGrade(String code) {
        String grade = "None";
        try {
            BufferedReader br = new BufferedReader(new FileReader(name));
            String tempLine = "";
            while ((tempLine = br.readLine()) != null) {
                if (tempLine.trim().length() > 0) {
                    String[] term = tempLine.split(",");
                    if (term.length == 4) {
                        if (code.equals(term[0].trim())) {
                            grade = term[3].trim();
                            break; 
                        }
                    }
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return grade;
    }
       
   
    public String getStudentInfo(String code){
    String studentInfo="None";
    try{
        BufferedReader br = new BufferedReader(new FileReader(name));
        String tempLine="";
        while((tempLine = br.readLine()) != null){     
          if(tempLine.trim().length()>0){ 
            String[] term=tempLine.split(",");
              if(term.length==4){
                 if(code.equals(term[0].trim())){
                  studentInfo=tempLine.trim();
                   break;
                  }
  
               }
          }
        }br.close();
   }catch (FileNotFoundException e){
      e.printStackTrace();
     }catch(IOException e){
       e.printStackTrace();
       }
   return studentInfo;
  }

  public void addStudentInfo(String studentInfo) {
    try (FileWriter fw = new FileWriter(name,true);
         BufferedWriter writer = new BufferedWriter(fw);
         PrintWriter printWriter = new PrintWriter(writer)) {
        printWriter.println(studentInfo);
    } catch (IOException e) {
        e.printStackTrace();
    }
}


}
