package com.gauldin.io;

import com.gauldin.io.filemanager.AutoClosingManager;
import com.gauldin.io.filemanager.FileManager;
import com.gauldin.io.filemanager.PersistantConnectionManager;

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
