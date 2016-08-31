package com.gaulin.io.filemanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

public abstract class FileManager {
	protected int currentReadLine = 0;
	protected File readFile;
	protected BufferedReader reader;
	public abstract void OpenReader();
	public abstract String ReadLine(int line);
	public abstract String ReadNextLine();
	public abstract void CloseReader();
	public abstract void SetReadFile(String filename);
	
	protected int currentWriteLine = 0;
	protected File writeFile;
	protected BufferedWriter writer;
	public abstract void OpenWriter();
	public abstract void WriteLine(String line);
	public abstract void CloseWriter();
	public abstract void SetWriteFile(String filename);
}
