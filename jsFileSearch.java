package jsFileSearch;

import org.apache.commons.io.FileUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class jsFileSearch {
	
	/* This program ask for user input of Directory location,
	then it looks for the file format with (.js) in the given directory. */
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter file directory: ");
		String str = reader.next();
		System.out.println("Your selected directory is: " + str);
		
		int i = checkDirectory(str);
		if(i == 1){
			searchFile(str);
		}
	}
	
	/* Checks if the file directory exist or not.
	If file directory exist, returns 1.
	If file directory does not exist, returns 0. */
	public static int checkDirectory(String userDir1){
		Path path = Paths.get(userDir1);
		
		if(Files.exists(path)){
			System.out.println("File directory " + path + " Exist");
			return 1;
		}else{
			System.out.println("File directory " + path + " Does not exist");
			return 0;
		}
	}
	
	/* Search for the (.js) file inside the directory.
	Outputs a text file (directoryList.txt) containing list of (.js) files. */
	public static void searchFile(String userDir2){
		File root = new File(userDir2);
		String[] file_extension = { "js" };
	    boolean recursive = true;
	    Collection files = FileUtils.listFiles(root, file_extension, recursive);
	    
	    try{
	    	PrintWriter writer = new PrintWriter("directoryList.txt", "UTF-8");
	    	for(Iterator iterator = files.iterator(); iterator.hasNext();){
		    	File file = (File) iterator.next();
		    	System.out.println(file.getAbsolutePath());
		    	writer.println(file.getAbsolutePath());
		    }
	    	writer.close();
	    } catch(IOException e){
	    	e.printStackTrace();
	    }
	}
}
