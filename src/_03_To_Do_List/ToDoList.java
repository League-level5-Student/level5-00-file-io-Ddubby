package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 * 
	 * When add task is clicked: ask the user for a task and save it to an array
	 * list
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	ArrayList<String> tasks = new ArrayList<String>();

	public static void main(String[] args) {
		ToDoList list = new ToDoList();
		list.GUI();
	}

	public void GUI() {
		frame.setVisible(true);
		frame.add(panel);
		panel.add(button);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		button.setText("Add Task");
		button1.setText("View Tasks");
		button2.setText("Remove Task");
		button3.setText("Save List");
		button4.setText("Load List");
		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button) {
			tasks.add(JOptionPane.showInputDialog("Enter a task:"));
		}
		if (e.getSource() == button1) {
			for (int i = 1; i < tasks.size() + 1; i++) {
				System.out.println(i + ". " + tasks.get(i - 1));
			}
		}
		if (e.getSource() == button2) {
			String answer = JOptionPane.showInputDialog("Remove task:");
			int num = Integer.parseInt(answer);
			tasks.remove(num - 1);
		}
		if (e.getSource() == button3) {
			String fileName = JOptionPane.showInputDialog("File Name:");
			for (int i = 0; i < tasks.size(); i++) {
				try {
					FileWriter fw = new FileWriter("src/_03_To_Do_List/" + fileName + ".txt", true);

					fw.write(tasks.get(i));

					fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			tasks.clear();
		}
		if (e.getSource() == button4) {
			String fileName = JOptionPane.showInputDialog("File Name:");
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/" + fileName + ".txt"));

				String line = br.readLine();
				while (line != null) {
					System.out.println(line);
					line = br.readLine();
				}

				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		}
	}
}