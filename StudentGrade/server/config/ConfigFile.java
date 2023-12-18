package server.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConfigFile{
	
	public String getSource(){
		String name = "server\\config\\student.cfg";
		
		String result = "file";
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(name));
			String tempLine = br.readLine();
			if(tempLine.trim().length() > 0){
				String [] term = tempLine.split("=");
				if(term.length ==2){
					result = term[1].trim();
				}
			}
			br.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		return result;
	}
}