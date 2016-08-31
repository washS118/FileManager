package com.gauldin.io.filemanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class FileManager {
	protected int currentReadLine = 0;
	protected File readFile;
	protected BufferedReader reader;
	public abstract void OpenReader() throws FileNotFoundException;
	public abstract String ReadLine(int line) throws IOException;
	public abstract String ReadNextLine() throws IOException;
	public abstract void CloseReader() throws IOException;
	public abstract void SetReadFile(String filename);
	
	protected int currentWriteLine = 0;
	protected File writeFile;
	protected BufferedWriter writer;
	public abstract void OpenWriter() throws IOException;
	public abstract void WriteLine(String line) throws IOException;
	public abstract void CloseWriter() throws IOException;
	public abstract void SetWriteFile(String filename);
}
