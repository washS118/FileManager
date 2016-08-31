package com.gauldin.io.filemanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PersistentConnectionManager extends FileManager {
	
	/**
	 * Opens a File Reader class allowing the user to
	 * access data from files.
	 * @throws FileNotFoundException 
	 */
	@Override
	public void OpenReader() throws FileNotFoundException {
		FileReader fileReader = new FileReader(readFile);
		reader = new BufferedReader(fileReader);		
	}

	/**
	 * Reads the data at the specified line;
	 * @param line
	 * @return
	 * @throws IOException 
	 */
	@Override
	public String ReadLine(int line) throws IOException {
		currentReadLine = 0;
		String readLine = reader.readLine();
		currentReadLine++;
		while(readLine != null && currentReadLine != line){
			readLine = reader.readLine();
			currentReadLine++;
		}		
		return readLine;
	}

	/**
	 * Reads the data at the next line of the file
	 * @return
	 * @throws IOException 
	 */
	@Override
	public String ReadNextLine() throws IOException {
		currentReadLine++;
		String readLine = reader.readLine();
		return readLine;
	}

	/**
	 * Closes the reader
	 * @throws IOException 
	 */
	@Override
	public void CloseReader() throws IOException {
		reader.close();
	}

	/**
	 * Sets the target file to filename
	 * @param filename
	 */
	@Override
	public void SetReadFile(String filename) {
		readFile = new File(filename);
	}

	/**
	 * Opens a file writer
	 * @throws IOException 
	 */
	@Override
	public void OpenWriter() throws IOException{
		FileWriter fileWriter = new FileWriter(writeFile, true);
		writer = new BufferedWriter(fileWriter);
	}

	/**
	 * Writes a line to the file
	 * @throws IOException 
	 */
	@Override
	public void WriteLine(String line) throws IOException {
		writer.write(line);
		writer.newLine();
	}

	/**
	 * Closes the file writer
	 * @throws IOException 
	 */
	@Override
	public void CloseWriter() throws IOException {
		writer.close();
	}

	/**
	 * Sets the target writer wile
	 */
	@Override
	public void SetWriteFile(String filename) {
		writeFile = new File(filename);
	}

}
