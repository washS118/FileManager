package com.gauldin.io;

import java.io.IOException;

import com.gauldin.io.filemanager.FileManager;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileManager manager = IoController.GetPersistentConnectionManager("Test.txt");
		
		String test1;
		try {			
			//Test the Writer
			manager.OpenWriter();
			for(int i = 0; i < 3; i++){
				manager.WriteLine("Yay");
			}
			manager.CloseWriter();
			
			manager.OpenReader();
			test1 = manager.ReadNextLine();
			String test2 = manager.ReadNextLine();
			manager.CloseReader();
			System.out.println(test1 + "," + test2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
