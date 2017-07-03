package com.Milagepergallon;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Milagecalculator extends JFrame {

	private JPanel contentPane;
	private JTextField Gallons;
	private JTextField Miles;
	private JTextField textField;
	private JTextField Carmodel;
	private JTextField Customer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Milagecalculator frame = new Milagecalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Milagecalculator() {
		setTitle("Milage Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Gallons = new JTextField();
		Gallons.setFont(new Font("Tahoma", Font.BOLD, 14));
		Gallons.setBounds(402, 215, 199, 47);
		contentPane.add(Gallons);
		Gallons.setColumns(10);
		
		Miles = new JTextField();
		Miles.setFont(new Font("Tahoma", Font.BOLD, 15));
		Miles.setBounds(402, 293, 199, 47);
		contentPane.add(Miles);
		Miles.setColumns(10);
		
		JButton btnNewButton = new JButton("MPG");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try{
				
				Connection connection;
				PreparedStatement ps;
				connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/car?autoReconnect=true&useSSL=false","root","root");
				ps= connection.prepareStatement("INSERT into datasheet 'customer name',' car model','gallons','miles' WHERE"
					+ " 'customer name'=? AND' car model'=? AND 'gallons'=? AND'miles'=?");
				ps.setString(1,Customer.getText());
				ps.setString(2, Carmodel.getText());
				ps.setString(3, Gallons.getText());;
				ps.setString(4, Miles.getText());
				ResultSet result=ps.executeQuery();
				
				}
				catch(Exception e)
				{
					
				}
				
				
				
				
				float gallon=0;
				float miles=0;
				float mpg;
				
				//logic
				gallon= Float.parseFloat(Gallons.getText());
				miles= Float.parseFloat(Miles.getText());
				mpg=miles/gallon;
				textField.setText(Float.toString(mpg));
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(421, 362, 169, 40);
		
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setForeground(Color.RED);
		textField.setFont(new Font("Tahoma", Font.BOLD, 22));
		textField.setBounds(402, 420, 199, 47);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMilagePerGallon = new JLabel("Milage Per Gallon (MPG)");
		lblMilagePerGallon.setForeground(Color.BLUE);
		lblMilagePerGallon.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMilagePerGallon.setBounds(96, 420, 281, 40);
		contentPane.add(lblMilagePerGallon);
		
		JLabel lblNewLabel = new JLabel(" Number of Gallons :");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(90, 215, 242, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Number of Miles on Full Tank :");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(96, 298, 296, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome to Milage Calculator");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2.setBounds(113, 11, 399, 46);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblCarModel = new JLabel("Car Model :");
		lblCarModel.setForeground(Color.RED);
		lblCarModel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCarModel.setBounds(96, 165, 152, 26);
		contentPane.add(lblCarModel);
		
		Carmodel = new JTextField();
		Carmodel.setFont(new Font("Tahoma", Font.BOLD, 16));
		Carmodel.setBounds(402, 157, 199, 47);
		contentPane.add(Carmodel);
		Carmodel.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Customer Name :");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(89, 98, 169, 40);
		contentPane.add(lblNewLabel_3);
		
		Customer = new JTextField();
		Customer.setFont(new Font("Tahoma", Font.BOLD, 16));
		Customer.setBounds(402, 98, 199, 48);
		contentPane.add(Customer);
		Customer.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 744, 483);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.CYAN);
		lblNewLabel_4.setIcon(new ImageIcon("F:\\javaa\\img.png"));
		
		
		lblNewLabel_4.setBounds(0, 0, 734, 472);
		panel.add(lblNewLabel_4);
	}
}
