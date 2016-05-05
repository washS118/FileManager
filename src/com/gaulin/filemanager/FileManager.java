package com.gaulin.filemanager;

import java.io.File;

public abstract class FileManager {
	protected int currentReadLine = 0;
	protected File readFile;
	public abstract void OpenReader();
	public abstract void ReadLine(int line);
	public abstract void ReadNextLine();
	public abstract void CloseReader();
	public abstract void SetReadFile(String filename);
	
	protected int currentWriteLine = 0;
	protected File writeFile;
	public abstract void OpenWriter();
	public abstract void WriteLine();
	public abstract void CloseWriter();
	public abstract void SetWriteFile(String filename);
}
