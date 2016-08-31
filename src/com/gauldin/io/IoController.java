package com.gauldin.io;

import com.gauldin.io.filemanager.AutoClosingManager;
import com.gauldin.io.filemanager.FileManager;
import com.gauldin.io.filemanager.PersistentConnectionManager;

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
	
	public static FileManager GetPersistentConnectionManager(){
		return new PersistentConnectionManager();
	}
	
}
