package com.gaulin.filemanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Provides highly abstracted access to file I/O.
 * Do not use in resource limited or performance oriented applications.
 * 
 * @author Lucas Gauldin
 * @version 1.0
 *
 */
public class AutoClosingManager extends FileManager {

	private static final Exception IOException = null;

	/**
	 * DO NOT USE
	 * Prints an error message to the console.
	 * The opening and closing of files is handled automatically
	 */
	@Override
	public void OpenReader() {
		System.err.println("Please do not attempt to open a file manually when using an Auto-Closing instance");		
	}

	/**
	 * Returns a given line of a file
	 * @param line the line to read
	 * @return the line specified by parameter.
	 * returns null if line does not exist and sets currentReadLine to after the last file
	 */
	@Override
	public String ReadLine(int line){
		OpenPrivateReader();
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
		} finally{
			ClosePrivateReader();
		}
		
		return readLine;
	}

	/**
	 * Reads the next line in the file.
	 * @return line
	 */
	@Override
	public String ReadNextLine(){
		return ReadLine(currentReadLine + 1);
	}

	/**
	 * DO NOT USE
	 * Prints an error message to the console.
	 * The opening and closing of files is handled automatically
	 */
	@Override
	public void CloseReader() {
		System.err.println("Please do not attempt to close a file manually when using an Auto-Closing instance");
	}

	/**
	 * Sets read file to filename
	 * @param filename specifies file for reader
	 */
	@Override
	public void SetReadFile(String filename) {
		readFile = new File(filename);
	}

	/**
	 * DO NOT USE
	 * Prints an error message to the console.
	 * The opening and closing of files is handled automatically
	 */
	@Override
	public void OpenWriter() {
		System.err.println("Please do not attempt to open a file manually when using an Auto-Closing instance");
	}

	/**
	 * Writes a string of text to a new line.
	 * 
	 * @param line The string to write to the file.
	 */
	@Override
	public void WriteLine(String line) {
		try {
			OpenPrivateWriter();
			writer.newLine();
			writer.write(line);
			ClosePrivateWriter();
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * DO NOT USE
	 * Prints an error message to the console.
	 * The opening and closing of files is handled automatically
	 */
	@Override
	public void CloseWriter() {
		System.err.println("Please do not attempt to close a file manually when using an Auto-Closing instance");
	}

	/**
	 * Sets write file to filename.
	 * 
	 * @param filename file to perform write operations on.
	 */
	@Override
	public void SetWriteFile(String filename) {
		writeFile = new File(filename);
	}
	
	private void OpenPrivateReader(){
		FileReader fileReader;
		try {
			fileReader = new FileReader(readFile);
			reader = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void ClosePrivateReader(){
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void OpenPrivateWriter(){
		FileWriter fileWriter;
		try{
			fileWriter = new FileWriter(writeFile, true);
			writer = new BufferedWriter(fileWriter);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private void ClosePrivateWriter(){
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
