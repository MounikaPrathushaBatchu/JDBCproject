package com.eg.jdbc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FirstApp {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstApp window = new FirstApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FirstApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblValue = new JLabel("value 1");
		lblValue.setBounds(34, 29, 46, 14);
		frame.getContentPane().add(lblValue);
		
		JLabel lblValue_1 = new JLabel("value 2");
		lblValue_1.setBounds(34, 74, 46, 14);
		frame.getContentPane().add(lblValue_1);
		
		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int val1 = 0,val2 = 0,sum = 0;
				val1 = Integer.parseInt(textField.getText());
				val2 = Integer.parseInt(textField_1.getText());
				sum = val1 + val2;
				textField_2.setText(String.valueOf(sum));	
			}
		});
		btnAdd.setBounds(174, 120, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		textField = new JTextField();
		textField.setBounds(174, 26, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(174, 71, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblResult = new JLabel("result : ");
		lblResult.setBounds(34, 196, 46, 14);
		frame.getContentPane().add(lblResult);
		
		textField_2 = new JTextField();
		textField_2.setBounds(177, 193, 86, 20);
		textField_2.setEditable(false);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
	}
}
