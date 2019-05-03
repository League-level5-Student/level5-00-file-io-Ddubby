package Checkpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Checkpoint implements ActionListener{
	
	public JFrame frame = new JFrame();
	public JPanel panel = new JPanel();
	public JTextArea area = new JTextArea(50, 50);
	public JButton save = new JButton();
	public JButton load = new JButton();
	public int num = 0;
	public static void main(String[] args) {
		Checkpoint checkpoint = new Checkpoint();
		checkpoint.GUI();
	}
	
	void GUI() {
		frame.setVisible(true);
		frame.add(panel);
		panel.add(area);
		panel.add(save);
		panel.add(load);
		save.setText("Save");
		load.setText("Load");
		save.addActionListener(this);
		load.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == save) {
			num++;
			File file = new File("src/Checkpoint/file" + num);
			try {
				FileWriter writer = new FileWriter(file);
				writer.write(area.getText());
				writer.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			

		}
		if (e.getSource() == load) {
			String answer = JOptionPane.showInputDialog(null, "Which file?");
			int fileNum = Integer.parseInt(answer);
			try {
				FileReader reader = new FileReader("src/Checkpoint/file" + fileNum);
				int c = reader.read();
				while (c != -1) {
					System.out.print((char) c);
					c = reader.read();
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
