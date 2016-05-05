package com.gaulin.filemanager;

public class FileController {

	public static FileManager GetAutoClosingManager(){
		return new AutoClosingManager();
	}
	
	public static FileManager GetPersistantConnectionManager(){
		return new PersistantConnectionManager();
	}
	
}
