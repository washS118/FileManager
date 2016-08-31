package com.gauldin.io;

//Data Types
import com.gaulin.io.filemanager.FileManager;

//Managers
import com.gaulin.io.filemanager.AutoClosingManager;
import com.gaulin.io.filemanager.PersistantConnectionManager;

/**
 * 
 * @author Lucas Gauldin
 * @version 1.0
 *
 */
public class IoController {

	public static FileManager GetAutoClosingManager(){
		return new AutoClosingManager();
	}
	
	public static FileManager GetPersistantConnectionManager(){
		return new PersistantConnectionManager();
	}
	
}
