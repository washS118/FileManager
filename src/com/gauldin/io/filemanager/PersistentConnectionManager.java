package com.gauldin.io.filemanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PersistentConnectionManager extends FileManager {

	public PersistentConnectionManager(){
		
	}
	
	public PersistentConnectionManager(String file){
		SetReadFile(file);
		SetWriteFile(file);
	}
	
	public PersistentConnectionManager(String readFile, String writeFile){
		SetReadFile(readFile);
		SetWriteFile(writeFile);
	}
	
	/**
	 * Opens a File Reader class allowing the user to
	 * access data from files.
	 */
	@Override
	public void OpenReader() {
		FileReader fileReader;
		try {
			fileReader = new FileReader(readFile);
			reader = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}

	/**
	 * Reads the data at the specified line;
	 * @param line
	 * @return
	 */
	@Override
	public String ReadLine(int line) {
		currentReadLine = 0;
		String readLine = "";
		try {
			
			readLine = reader.readLine();
			currentReadLine++;
			while(readLine != null && currentReadLine != line){
				readLine = reader.readLine();
				currentReadLine++;
			}
		} catch (IOException e) {
			e.printStackTrace();
			readLine = "";
		}
		
		return readLine;
	}

	/**
	 * Reads the data at the next line of the file
	 * @return
	 */
	@Override
	public String ReadNextLine() {
		String readLine = "";
		try {
			currentReadLine++;
			readLine = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return readLine;
	}

	/**
	 * Closes the reader
	 */
	@Override
	public void CloseReader() {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Sets the target file to filename
	 * @param filename
	 */
	@Override
	public void SetReadFile(String filename) {
		readFile = new File(filename);
	}

	@Override
	public void OpenWriter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void WriteLine(String line) {
		// TODO Auto-generated method stub

	}

	@Override
	public void CloseWriter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void SetWriteFile(String filename) {
		writeFile = new File(filename);
	}

}
