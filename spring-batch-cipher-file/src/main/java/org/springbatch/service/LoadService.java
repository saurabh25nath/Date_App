package org.springbatch.service;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

@Service
public class LoadService {
	
	
	public void deleteFileIfExits(String path) 
    { 
		System.out.println("My outputFilePath ========= "+path);
        try
        { 
            Files.deleteIfExists(Paths.get(path)); 
            System.out.println("Old Output File deleted successfully...");
        } 
        catch(NoSuchFileException e) 
        { 
            System.out.println("No such file/directory exists"); 
        } 
        catch(DirectoryNotEmptyException e) 
        { 
            System.out.println("Directory is not empty."); 
        } 
        catch(IOException e) 
        { 
            System.out.println("Invalid permissions."); 
        } 
          
        System.out.println("Deletion successful."); 
    } 

}
