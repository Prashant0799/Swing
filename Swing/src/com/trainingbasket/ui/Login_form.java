package com.trainingbasket.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.color.CMMException;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import com.trainingbasket.dao.LoginUser;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login_form {
	JComboBox cmbTypeLogin = new JComboBox();
	JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_form window = new Login_form();
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
	public Login_form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 630, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setBackground(Color.BLACK);
		lblUserName.setBounds(222, 184, 120, 29);
		lblUserName.setFont(new Font("Consolas", Font.BOLD, 18));
		frame.getContentPane().add(lblUserName);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(222, 226, 111, 29);
		lblPassword.setFont(new Font("Consolas", Font.BOLD, 18));
		frame.getContentPane().add(lblPassword);

		textField = new JTextField();
		textField.setBounds(354, 178, 156, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 612, 58);
		panel.setBackground(Color.BLACK);
		frame.getContentPane().add(panel);

		JLabel label = new JLabel("");
		panel.add(label);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(0, 56, 612, 387);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Consolas", Font.BOLD, 22));
		lblWelcome.setBounds(279, 33, 114, 16);
		panel_3.add(lblWelcome);

		JButton btnNewButton = new JButton("CANCEL");

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(btnNewButton, "Do really want to exit", "Exit Confirm", 1) == 0) {
					System.exit(0);
				}
				// System.out.println(userRes);
			}
		});

		btnNewButton.setFont(new Font("Consolas", Font.BOLD, 18));
		btnNewButton.setBackground(SystemColor.desktop);
		btnNewButton.setBounds(244, 285, 122, 31);
		panel_3.add(btnNewButton);

		String loginUsers[] = new String[] { "Admin=1234=FACULTY", "Hridesh=1234=STudent", "Ashwini=456=Student" };

		JButton btnNewButton_1 = new JButton("LOGIN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(btnNewButton_1, "PLease Enter User Id It can not be left blank",
							"Empty UserName Error", 2);
				}
				if (passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(btnNewButton_1, "PLease Enter Password It can not be left blank",
							"Empty Password Error", 2);
				}
				LoginUser user = new LoginUser();
				if (user.loginUser(textField.getText(), passwordField.getText())) {
					JOptionPane.showMessageDialog(btnNewButton_1, "Welcome Login Succeed");
					Student studentform = new Student();
					studentform.frame.setVisible(true);
					frame.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(btnNewButton_1, "Error Login was failed " + textField.getText()
							+ " was not found or password fiven is incorrect");

				}

//				for (String user : loginUsers) {
//					String userData[] = user.split("=");
//					if (userData[0].equals(textField.getText()) && userData[1].equals(passwordField.getText())
//							&& (userData[2].toLowerCase()
//									.equals(cmbTypeLogin.getSelectedItem().toString().toLowerCase()))) {
//						Student studentform = new Student();
//						studentform.frame.setVisible(true);
//						frame.setVisible(false);
//						break;
//					}

//					else if (userData[0].equals(textField.getText()) && userData[1].equals(passwordField.getText())
//							&& (userData[2].toLowerCase()
//									.equals(cmbTypeLogin.getSelectedItem().toString().toLowerCase()))) {
//						Faculty facultyform = new Faculty();
//						facultyform.frame.setVisible(true);
//						frame.setVisible(false);
//						break;
//					} else {
//						JOptionPane.showMessageDialog(btnNewButton_1,
//								"Invalid Login Please Check your User Id Password Given ", "Login Error", 0);
//					}
			}
		});
		btnNewButton_1.setFont(new Font("Consolas", Font.BOLD, 18));
		btnNewButton_1.setBounds(390, 285, 114, 29);
		panel_3.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PRASHANT\\Desktop\\images.jpg"));
		lblNewLabel.setBounds(52, 115, 102, 119);
		panel_3.add(lblNewLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(353, 169, 159, 29);
		panel_3.add(passwordField);

		cmbTypeLogin.setModel(new DefaultComboBoxModel(new String[] { "FACULTY", "HOD", "STUDENT", "SECURITY STAFF" }));
		cmbTypeLogin.setBounds(353, 211, 159, 22);
		panel_3.add(cmbTypeLogin);

		JLabel lblTypeLogin = new JLabel("Password");
		lblTypeLogin.setForeground(Color.WHITE);
		lblTypeLogin.setFont(new Font("Consolas", Font.BOLD, 18));
		lblTypeLogin.setBounds(219, 214, 111, 29);
		panel_3.add(lblTypeLogin);

		JButton btnSignup = new JButton("Signup");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp signUp = new SignUp();
				signUp.frame.setVisible(true);
			}
		});
		btnSignup.setBounds(52, 287, 97, 25);
		panel_3.add(btnSignup);
	}
}
