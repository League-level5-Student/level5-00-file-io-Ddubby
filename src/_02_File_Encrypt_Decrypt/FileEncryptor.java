package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public static void main(String[] args) {

		String message = JOptionPane.showInputDialog("Enter a message:");
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/test.txt");

			for (int i = message.length(); i > 0; i--) {
				fw.write(message.substring(i - 1, i));	
			}

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
