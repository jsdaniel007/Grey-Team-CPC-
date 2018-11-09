/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpcapplication;
/**
 *
 * @author kyle addy and Taylor Perry
 * 
 */
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


public class  Library {
      public static void main(String[] args) throws IOException{
                    
    }
   
    Library() {//contructor
        // gets the username of the current user
        String username = System.getProperty("user.name");
        
        //creats a file instance of the library and its path
        File file=new File("C:\\Users\\" + username +"\\Documents\\cpcapplication\\library");
        boolean exists = file.isDirectory();
        
        //if the library directory does not exist then create it else do nothing
        if (!exists){
            System.out.println("The Library does not exist");
                  
            if (file.mkdir()) {
                System.out.println("Library was created!");
                 System.out.println("Library Path: C:\\Users\\" + username +"\\Documents\\cpcapplication\\library");
            } else {
                System.out.println("Failed to create the Library!");
            }
        }
        else{
        System.out.println("The Library exist");
        }
    }
    
    
    private static void addAFile(File src) throws FileNotFoundException, IOException {
        
        //checks to see if the file that is being added to the Library directory exist
        if (src.exists()){
            
            //gets the username of the current user
            String username = System.getProperty("user.name");
            
            //creats a file instance of the destination file
            File dest=new File("C:\\Users\\" + username +"\\Documents\\cpcapplication\\library\\" + src.getName());

            //creates the file into the Library directory
            dest.createNewFile();

            //creates the options used for the copy
            CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
            };
            
            //copy the contents of the file to the destination file in the Library directory
             Files.copy(src.toPath(), dest.toPath(), options);
             System.out.println("File: " +dest.getName() + " has been copied to the Library");
        } else
        {
            System.out.println("File does not exist or path is bad");
        }
        
    }
}
    
     