package com.gaulin.filemanager;

import java.io.File;

public class PersistantConnectionManager extends FileManager {

	@Override
	public void OpenReader() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ReadLine(int line) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ReadNextLine() {
		// TODO Auto-generated method stub

	}

	@Override
	public void CloseReader() {
		// TODO Auto-generated method stub

	}

	@Override
	public void SetReadFile(String filename) {
		readFile = new File(filename);
	}

	@Override
	public void OpenWriter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void WriteLine() {
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