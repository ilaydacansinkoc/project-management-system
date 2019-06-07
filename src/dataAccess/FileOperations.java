package dataAccess;

import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import domain.Project;

public class FileOperations {
	
	private static final String filepath = System.getProperty("user.dir") + "\\x.txt";
	
	public static List<Project> readFile() {
		
		//TODO read file
		return null;
		
	}
	
	public static void writeFile(List<Project> listOfProjects) {
		
		for(Project p : listOfProjects)
			writeObjectToFile(p);
		System.out.println("Saved on " + filepath);
			
		
	}
	
	private static void writeObjectToFile(Object serObj) {

		try {

			FileOutputStream fileOut = new FileOutputStream(filepath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(serObj);
			objectOut.close();
			System.out.println("The Object  was succesfully written to a file");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
