package Fall;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Registration {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
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
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration From");
		lblNewLabel.setFont(new Font("Gill Sans", Font.BOLD, 13));
		lblNewLabel.setBounds(137, 24, 128, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(49, 74, 112, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(152, 69, 182, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Address:");
		lblNewLabel_2.setBounds(49, 117, 112, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(152, 112, 182, 66);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Gender:");
		lblNewLabel_3.setBounds(49, 202, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		final JRadioButton rbMale = new JRadioButton("Male");
		rbMale.setBounds(152, 198, 70, 23);
		frame.getContentPane().add(rbMale);
		
		final JRadioButton rbFemale = new JRadioButton("Female");
		rbFemale.setBounds(234, 198, 89, 23);
		frame.getContentPane().add(rbFemale);
		
		JLabel lblNewLabel_4 = new JLabel("Age:");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(49, 245, 112, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(152, 240, 182, 26);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_5 = new JLabel("Mobile:");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(49, 288, 112, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(152, 283, 182, 26);
		frame.getContentPane().add(textField_3);
		
		JLabel lblNewLabel_6 = new JLabel("Gmail:");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(49, 331, 112, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(152, 326, 182, 26);
		frame.getContentPane().add(textField_4);
		
		JLabel lblNewLabel_7 = new JLabel("User Name:");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(49, 374, 112, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(152, 369, 182, 26);
		frame.getContentPane().add(textField_5);
		
		JLabel lblNewLabel_8 = new JLabel("Password:");
		lblNewLabel_8.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(49, 420, 112, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(152, 415, 182, 26);
		frame.getContentPane().add(textField_6);
		

        final JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "JomRebSour2023001***XX0482?/+821");


                    String query = "INSERT INTO registration (name, address, gender, age, mobile, email, username, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement ps = con.prepareStatement(query);


                    ps.setString(1, textField.getText());
                    ps.setString(2, textField_1.getText());
                    ps.setString(3, rbMale.isSelected() ? "Male" : "Female");
                    ps.setInt(4, Integer.parseInt(textField_2.getText()));
                    ps.setInt(5, Integer.parseInt(textField_3.getText()));
                    ps.setString(6, textField_4.getText());
                    ps.setString(7, textField_5.getText());
                    ps.setString(8, textField_6.getText());

                    int i = ps.executeUpdate();
                    JOptionPane.showMessageDialog(btnRegister, i + " Record added successfully!");
                    ps.close();
                    con.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(btnRegister, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
	
		
		
		btnRegister.setBounds(77, 482, 117, 29);
		frame.getContentPane().add(btnRegister);
		
		JButton btnNewButton_Reset = new JButton("Reset");
		btnNewButton_Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				rbMale.setSelected(false);
			    rbFemale.setSelected(false);
				
			}
		});
		btnNewButton_Reset.setBounds(206, 482, 117, 29);
		frame.getContentPane().add(btnNewButton_Reset);
		
	}
}











