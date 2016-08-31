package com.gauldin.io.filemanager;

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
	 * @throws IOException 
	 */
	@Override
	public String ReadLine(int line) throws IOException{
		OpenPrivateReader();
		currentReadLine = 0;
		String readLine = reader.readLine();
		currentReadLine++;
		while(readLine != null && currentReadLine != line){
			readLine = reader.readLine();
			currentReadLine++;
		}
		ClosePrivateReader();
		
		return readLine;
	}

	/**
	 * Reads the next line in the file.
	 * @return line
	 * @throws IOException 
	 */
	@Override
	public String ReadNextLine() throws IOException{
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
	 * @throws IOException 
	 */
	@Override
	public void WriteLine(String line) throws IOException {
		OpenPrivateWriter();
		writer.newLine();
		writer.write(line);
		ClosePrivateWriter();
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
	
	private void OpenPrivateReader() throws FileNotFoundException{
		FileReader fileReader = new FileReader(readFile);
		reader = new BufferedReader(fileReader);		
	}
	
	private void ClosePrivateReader() throws IOException{
		reader.close();
	}
	
	private void OpenPrivateWriter() throws IOException{
		FileWriter fileWriter = new FileWriter(writeFile, true);
		writer = new BufferedWriter(fileWriter);
	}
	
	private void ClosePrivateWriter() throws IOException{
		writer.close();
	}

}
