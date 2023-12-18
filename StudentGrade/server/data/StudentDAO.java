package server.data;

import server.data.DataAble;
import server.data.file.FileOperation;

public class StudentDAO{
private DataAble fp;

   public StudentDAO(){
   fp=new FileOperation("grade.txt");
   }

   public String getGrade(String code){
   return fp.getGrade(code);
   }

   public String getStudentInfo(String code){
   return fp.getStudentInfo(code);
   }

   public void addStudentInfo(String info){
     fp.addStudentInfo(info);
   }
}