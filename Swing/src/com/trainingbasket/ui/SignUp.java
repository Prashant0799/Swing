package com.trainingbasket.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;

import javax.swing.JRadioButton;
import org.jdatepicker.impl.JDatePanelImpl;

import com.trainingbasket.bean.User;
import com.trainingbasket.dao.UserDAO;

import org.jdatepicker.DateModel;

import java.util.List;
import java.util.Properties;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SignUp {

	UserDAO userDAO = null;
	public JFrame frame;
	private JTextField txtStudentId;
	private JTextField txtDOB;
	private JTextField txtAddress;
	private JTextField txtPhoneNumber;
	private JTextField txtRollNumber;
	private JTextField txtStudentName;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtEmailAddress;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
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
	public SignUp() {
		initialize();

		try {
			userDAO = new UserDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			JOptionPane.showMessageDialog(txtRollNumber, e.getMessage());
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setForeground(Color.BLUE);
		frame.setBounds(0, -57, 648, 627);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

//		JButton btnNew = new JButton("New");
//		btnNew.setForeground(Color.BLACK);
//		btnNew.setBounds(514, 177, 97, 25);
//		frame.getContentPane().add(btnNew);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(514, 223, 97, 25);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!validateTextFields()) {
						User user = new User();
						user.setAddress(txtAddress.getText());
						user.setDob(txtDOB.getText());
						user.setEmailAddress(txtEmailAddress.getText());
						user.setName(txtStudentName.getText());
						user.setPassword(txtPassword.getText());
						user.setPhoneNumber(txtPhoneNumber.getText());
						user.setRollNumber(Integer.parseInt(txtRollNumber.getText()));
						user.setUserName(txtUserName.getText());

						userDAO = new UserDAO();
						userDAO.insertUser(user);
					} else {

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

					JOptionPane.showMessageDialog(btnSave, "OOPS .. Something went wrong" + e1.getMessage());
				}

			}

			private boolean validateTextFields() {
				boolean isleftBlank = false;
				if (txtAddress.getText().equals("")) {
					JOptionPane.showMessageDialog(btnSave, " Address can not be leaft blank");
					isleftBlank = true;
				}
				if (txtDOB.getText().equals("")) {

				}
				if (txtEmailAddress.getText().equals("")) {

				}
				if (txtPassword.getText().equals("")) {

				}
				if (txtPhoneNumber.getText().equals("")) {

				}
				if (txtRollNumber.getText().equals("")) {

				}
				if (txtStudentName.getText().equals("")) {

				}
				if (txtUserName.getText().equals("")) {

				}
				return isleftBlank;
			}
		});
		frame.getContentPane().add(btnSave);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnSearch.setBounds(514, 262, 97, 25);
		frame.getContentPane().add(btnSearch);

		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 610, 405);
		panel.setBackground(Color.BLACK);
		panel.setForeground(Color.RED);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		txtStudentId = new JTextField();
		txtStudentId.setEnabled(false);
		txtStudentId.setBounds(295, 96, 116, 22);
		panel.add(txtStudentId);
		txtStudentId.setColumns(10);

		JLabel lblWelcomeSignupStudent = new JLabel("Student Signup Utility\r\n");
		lblWelcomeSignupStudent.setForeground(Color.WHITE);
		lblWelcomeSignupStudent.setBounds(201, 30, 212, 25);
		panel.add(lblWelcomeSignupStudent);
		lblWelcomeSignupStudent.setFont(new Font("Tahoma", Font.BOLD, 18));

		JLabel lblStudentId = new JLabel("Student ID (AutoGen.)");
		lblStudentId.setBounds(85, 102, 198, 16);
		panel.add(lblStudentId);
		lblStudentId.setForeground(Color.WHITE);
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setForeground(Color.WHITE);
		lblStudentName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStudentName.setBounds(85, 137, 105, 16);
		panel.add(lblStudentName);

		txtStudentName = new JTextField();
		txtStudentName.setColumns(10);
		txtStudentName.setBounds(295, 131, 116, 22);
		panel.add(txtStudentName);

		txtUserName = new JTextField();
		txtUserName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				txtUserName.setText(txtStudentName.getText());
				txtPassword.setText("password@college");
			}
		});
		txtUserName.setEditable(false);
		txtUserName.setColumns(10);
		txtUserName.setBounds(295, 302, 116, 22);
		panel.add(txtUserName);

		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(85, 308, 105, 16);
		panel.add(lblUsername);

		txtPassword = new JTextField();
		txtPassword.setEditable(false);
		txtPassword.setColumns(10);
		txtPassword.setBounds(295, 335, 116, 22);
		panel.add(txtPassword);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(85, 341, 105, 16);
		panel.add(lblPassword);

		txtDOB = new JTextField();
		txtDOB.setBounds(297, 162, 116, 22);
		panel.add(txtDOB);
		txtDOB.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				// "c"

				String dobTxt = txtDOB.getText();
				String[] dmy = dobTxt.split("-");
				if (dmy.length != 3) {
					JOptionPane.showMessageDialog(lblStudentId, "KIndly Enter a valid DOB Sample : DD-MM-YYYY");
				}

			}
		});
		txtDOB.setColumns(10);

		JLabel lblStudentDob = new JLabel("Student DOB");
		lblStudentDob.setBounds(85, 169, 105, 16);
		panel.add(lblStudentDob);
		lblStudentDob.setForeground(Color.WHITE);
		lblStudentDob.setFont(new Font("Tahoma", Font.PLAIN, 16));

		txtAddress = new JTextField();
		txtAddress.setBounds(297, 197, 116, 22);
		panel.add(txtAddress);
		txtAddress.setColumns(10);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(85, 204, 125, 16);
		panel.add(lblAddress);
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));

		txtPhoneNumber = new JTextField();
		txtPhoneNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		txtPhoneNumber.setBounds(297, 232, 116, 22);
		panel.add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(85, 239, 125, 16);
		panel.add(lblPhoneNumber);
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));

		txtRollNumber = new JTextField();
		txtRollNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					int userId = userDAO.getMaxUserId();
					userId = ++userId;
					txtRollNumber.setText(String.valueOf(userId));

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

					JOptionPane.showMessageDialog(lblUsername, e1.getMessage());
				}
			}

		});
		txtRollNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		txtRollNumber.setBounds(297, 267, 116, 22);
		panel.add(txtRollNumber);
		txtRollNumber.setColumns(10);

		JLabel lblRollNumber = new JLabel("Roll Number");
		lblRollNumber.setBounds(85, 271, 125, 22);
		panel.add(lblRollNumber);
		lblRollNumber.setForeground(Color.WHITE);
		lblRollNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setForeground(Color.WHITE);
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmailAddress.setBounds(85, 376, 105, 16);
		panel.add(lblEmailAddress);

		txtEmailAddress = new JTextField();
		txtEmailAddress.setColumns(10);
		txtEmailAddress.setBounds(295, 370, 116, 22);
		panel.add(txtEmailAddress);

		String colNames[] = { "User Id", "Name", "Date Of Birth", "Address", "Phone Number", "Roll Number ",
				"User Name ", "Password ", "Email Id" };
		;
		Object data[][] = new Object[][] {
			{
			"dasd","dasda","dasdas","dadas","dada","dasda","dada","","",""	
			}
		};

		table = new JTable(data, colNames);
		table.setBounds(607, 431, -580, 136);
		frame.getContentPane().add(table);
	}
}
