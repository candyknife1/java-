package server.parser;
import server.data.DataAble;
import server.data.StudentDAO;

public class Parser{
  public String run(String cmdString){
    String result="None";
    String strCommand[]=cmdString.split("-");
    if(strCommand.length==2){
      String command=strCommand[0].trim();
       String para=strCommand[1].trim();
       result=commandProcess(command,para);
      
    }
return result;
  }
   private String commandProcess(String cmd,String para){
     String result="None";


     if("A01".equals(cmd)){
       StudentDAO sd=new StudentDAO();
       result="A01-"+sd.getGrade(para);
     }


     else if("A02".equals(cmd)){
     StudentDAO sd=new StudentDAO();
      result="A02-"+sd.getStudentInfo(para);
     }

     else if ("A03".equals(cmd)) {
       StudentDAO sd=new StudentDAO();
          sd.addStudentInfo(para);
             result="A03-"+"添加成功";
      }
     else{
         System.out.println("Command error!,command="+cmd); 
      }
        return result;
   }
}