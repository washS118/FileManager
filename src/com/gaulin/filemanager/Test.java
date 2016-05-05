package com.gaulin.filemanager;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileManager manager = FileController.GetAutoClosingManager();
		manager.SetReadFile("Test.txt");
		String text = manager.ReadLine(2);
		System.out.println(text);
	}

}
