package _20_IO_package;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File file=new File("Output.txt");
			FileWriter writer=new FileWriter(file);
			BufferedWriter bufferedWriter=new BufferedWriter(writer);
			bufferedWriter.write(" i love you \n i like you");
			bufferedWriter.write(" my test");
			bufferedWriter.flush();
			bufferedWriter.close();
		}catch(Exception e){
			e.getStackTrace();
		}
		
		try {
			File file=new File("Output.txt");
			FileWriter writer=new FileWriter(file,true);
			BufferedWriter bufferdeWriter=new BufferedWriter(writer);
			
			bufferdeWriter.write(" human");
			bufferdeWriter.flush();
//			bufferdeWriter.close();
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		
		try {
			File file=new File("Output.txt");
			FileReader file_reader=new FileReader(file);
			BufferedReader bufferedReadeer=new BufferedReader(file_reader);
			while (true) {
				String line=bufferedReadeer.readLine();
				if(line==null) {
					break;
				}
				System.out.println(line);
			}
			bufferedReadeer.close();
		}catch(Exception e) {
			e.getStackTrace();
		}
	}

}
