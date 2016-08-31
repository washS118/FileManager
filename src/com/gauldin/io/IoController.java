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
	
	public static FileManager GetAutoClosingManager(String file){
		AutoClosingManager manager = new AutoClosingManager();
		manager.SetReadFile(file);
		manager.SetWriteFile(file);
		return new AutoClosingManager();
	}
	
	public static FileManager GetAutoClosingManager(String readFile, String writeFile){
		AutoClosingManager manager = new AutoClosingManager();
		manager.SetReadFile(readFile);
		manager.SetWriteFile(writeFile);
		return manager;
	}
	
	public static FileManager GetPersistentConnectionManager(){
		return new PersistentConnectionManager();
	}
	
	public static FileManager GetPersistentConnectionManager(String file){
		PersistentConnectionManager manager = new PersistentConnectionManager();
		manager.SetReadFile(file);
		manager.SetWriteFile(file);
		return manager;
	}
	
	public static FileManager GetPersistentConnectionManager(String readFile, String writeFile){
		PersistentConnectionManager manager = new PersistentConnectionManager();
		manager.SetReadFile(readFile);
		manager.SetWriteFile(writeFile);
		return manager;
	}
	
}
