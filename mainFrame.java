package Flipcart;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JTextArea;

public class mainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField user_id1;
	private JTextField name;
	private JTextField phone;
	private JTextField email;
	private JPasswordField password1;
	private JPasswordField password2;
	private JTextField dob;
	private JTextField gender;
	private JTextField address;
	private JTextField user_id;
	private JPasswordField password;
	private JTextField textField;
	private JTextField quantity;
	private JTextField account;
	private JTextField bank;
	private JTextField rate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
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
	public mainFrame() {
		setForeground(Color.WHITE);
		setFont(null);
		setTitle("Flipkart");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lakshman\\Downloads\\iconfinder_flipkart_1220366 (2).png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 814);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		Panel plogin = new Panel();
		plogin.setBackground(Color.WHITE);
		contentPane.add(plogin, "name_589788631161562");
		plogin.setLayout(null);
		
		JPanel main = new JPanel();
		main.setLayout(null);
		main.setBackground(Color.WHITE);
		contentPane.add(main, "name_630308786807811");
		
		JPanel psignup = new JPanel();
		psignup.setForeground(new Color(255, 255, 255));
		psignup.setLayout(null);
		psignup.setBackground(Color.WHITE);
		contentPane.add(psignup, "name_589825498076871");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\flipkart background3.jpeg"));
		lblNewLabel.setBounds(0, 0, 465, 724);
		plogin.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Sign for accessing My orders and Wishlist.... ");
		lblNewLabel_3.setFont(new Font("Arial Black", lblNewLabel_3.getFont().getStyle(), lblNewLabel_3.getFont().getSize() + 1));
		lblNewLabel_3.setBounds(470, 25, 366, 30);
		plogin.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Enter your credientials here.");
		lblNewLabel_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(477, 170, 178, 30);
		plogin.add(lblNewLabel_4);
		
		user_id = new JTextField();
		user_id.setFont(new Font("Segoe UI Semilight", Font.ITALIC, 15));
		user_id.setBounds(629, 234, 116, 30);
		plogin.add(user_id);
		user_id.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(629, 300, 116, 30);
		plogin.add(password);
		
		JButton btnsignup = new JButton("New User/Sign Up");
		btnsignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				plogin.setVisible(false);
				psignup.setVisible(true);
				
			}
		});
		btnsignup.setBounds(518, 426, 137, 30);
		plogin.add(btnsignup);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "");
					Statement stmt= con.createStatement();
			
					String sql="select * from login_info where user_id='"+user_id.getText()+"' and password='"+password.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql); 
					if(rs.next()){
						JOptionPane.showMessageDialog(null, "login successful...");
						plogin.setVisible(false);
						main.setVisible(true);				
					}
					else
						JOptionPane.showMessageDialog(null, "login credientials incorrect...");
					con.close();			}
				catch(Exception e){System.out.println(e);}
			}
		});
		btnSignIn.setBounds(685, 426, 97, 30);
		plogin.add(btnSignIn);
		
		JButton btnSkip = new JButton("Skip");
		btnSkip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plogin.setVisible(false);
				main.setVisible(true);	
			}
		});
		btnSkip.setBounds(763, 680, 97, 30);
		plogin.add(btnSkip);
		
		JLabel lblNewLabel_1 = new JLabel("User Id.");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(536, 234, 81, 30);
		plogin.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPassword.setBounds(536, 300, 81, 30);
		plogin.add(lblPassword);

		
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\Screenshot_20190417-212235 (1).png"));
		label_1.setBounds(112, 0, 760, 137);
		psignup.add(label_1);
		
		JLabel lblEnterYourDetails = new JLabel("Enter your details here..");
		lblEnterYourDetails.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		lblEnterYourDetails.setBounds(34, 173, 279, 30);
		psignup.add(lblEnterYourDetails);
		
		JLabel label_4 = new JLabel("User Name");
		label_4.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		label_4.setBounds(34, 244, 100, 30);
		psignup.add(label_4);
		
		JLabel label_5 = new JLabel("Name");
		label_5.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		label_5.setBounds(34, 298, 100, 30);
		psignup.add(label_5);
		
		JLabel label_6 = new JLabel("Password");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		label_6.setBounds(34, 348, 100, 30);
		psignup.add(label_6);
		
		JLabel label_7 = new JLabel("Phone number");
		label_7.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		label_7.setBounds(339, 244, 124, 30);
		psignup.add(label_7);
		
		JLabel label_8 = new JLabel("Email Id");
		label_8.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		label_8.setBounds(343, 298, 100, 30);
		psignup.add(label_8);
		
		JLabel label_9 = new JLabel("Gender");
		label_9.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		label_9.setBounds(339, 348, 100, 30);
		psignup.add(label_9);
		
		user_id1 = new JTextField();
		user_id1.setFont(new Font("Harrington", Font.BOLD | Font.ITALIC, 16));
		user_id1.setColumns(10);
		user_id1.setBounds(197, 242, 116, 30);
		psignup.add(user_id1);
		
		name = new JTextField();
		name.setFont(new Font("Harrington", Font.BOLD | Font.ITALIC, 16));
		name.setColumns(10);
		name.setBounds(197, 296, 116, 30);
		psignup.add(name);
		
		phone = new JTextField();
		phone.setFont(new Font("Harrington", Font.BOLD | Font.ITALIC, 16));
		phone.setColumns(10);
		phone.setBounds(494, 242, 116, 30);
		psignup.add(phone);
		
		email = new JTextField();
		email.setFont(new Font("Harrington", Font.BOLD | Font.ITALIC, 16));
		email.setColumns(10);
		email.setBounds(494, 296, 116, 30);
		psignup.add(email);
		
		JLabel lblReenterPassword = new JLabel("Re-Enter Password");
		lblReenterPassword.setForeground(Color.BLACK);
		lblReenterPassword.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		lblReenterPassword.setBounds(34, 401, 150, 30);
		psignup.add(lblReenterPassword);
		
		password1 = new JPasswordField();
		password1.setBounds(197, 347, 116, 30);
		psignup.add(password1);
		
		password2 = new JPasswordField();
		password2.setBounds(197, 400, 116, 30);
		psignup.add(password2);
		
		JLabel label_11 = new JLabel("D.O.B");
		label_11.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		label_11.setBounds(339, 401, 100, 30);
		psignup.add(label_11);
		
		dob = new JTextField();
		dob.setFont(new Font("Harrington", Font.BOLD | Font.ITALIC, 16));
		dob.setColumns(10);
		dob.setBounds(494, 404, 116, 30);
		psignup.add(dob);
		
		JButton button = new JButton("Sign Up");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "");
					Statement stmt= con.createStatement();					
					String sql="insert into login_info values('"+user_id1.getText()+"','"+password1.getText()+"')";
					String sql1="insert into user_info values('"+user_id1.getText()+"','"+name.getText()+"','"+gender.getText()+"','"+address.getText()+"','"+dob.getText()+"','"+phone.getText()+"','"+email.getText()+"')";
					int r = stmt.executeUpdate(sql); 
					int a = stmt.executeUpdate(sql1); 
					if(r>0 & a>0){	
						JOptionPane.showMessageDialog(null, "signup successful...");
						plogin.setVisible(true);
						psignup.setVisible(false);
					}
				   else {
					   JOptionPane.showMessageDialog(null, "incorrect...");
				   }
				   con.close();	
				}
	   			 catch(SQLException e){
					JOptionPane.showMessageDialog(null, e);
				 }
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
			}
		});
		button.setBounds(500, 627, 97, 30);
		psignup.add(button);
		
		gender = new JTextField();
		gender.setFont(new Font("Harrington", Font.BOLD | Font.ITALIC, 16));
		gender.setColumns(10);
		gender.setBounds(494, 351, 116, 30);
		psignup.add(gender);
		
		JLabel lblMForMale = new JLabel("M for male,F for female..");
		lblMForMale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMForMale.setBounds(629, 365, 144, 16);
		psignup.add(lblMForMale);
		
		JLabel lblAddress = new JLabel("address");
		lblAddress.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		lblAddress.setBounds(34, 464, 100, 30);
		psignup.add(lblAddress);
		
		address = new JTextField();
		address.setFont(new Font("Harrington", Font.BOLD | Font.ITALIC, 16));
		address.setColumns(10);
		address.setBounds(197, 462, 246, 30);
		psignup.add(address);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\download.jpg"));
		lblNewLabel_2.setBounds(12, 0, 100, 115);
		psignup.add(lblNewLabel_2);
		
		JLabel lblYyyymmddFormat = new JLabel("yyyy-mm-dd format");
		lblYyyymmddFormat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblYyyymmddFormat.setBounds(629, 415, 144, 16);
		psignup.add(lblYyyymmddFormat);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 0, 887, 100);
		main.add(panel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(103, 57, 573, 30);
		panel_1.add(textField);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\magnifying-glass-icon.png"));
		button_1.setBorder(null);
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(71, 57, 30, 30);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_2.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\notification (1).png"));
		button_2.setBorder(null);
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(803, 13, 30, 30);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\shopping-cart (2).png"));
		button_3.setBorder(null);
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(845, 13, 30, 30);
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("");
		
		button_4.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\menu.png"));
		button_4.setBorder(null);
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(12, 9, 30, 30);
		panel_1.add(button_4);
		
		JLabel label = new JLabel("Flipkart");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 24));
		label.setBounds(103, 9, 89, 30);
		panel_1.add(label);
		
		JLabel label_3 = new JLabel("Explore");
		label_3.setVerticalAlignment(SwingConstants.BOTTOM);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		label_3.setBounds(105, 34, 50, 18);
		panel_1.add(label_3);
		
		JLabel label_10 = new JLabel("Plus");
		label_10.setForeground(Color.YELLOW);
		label_10.setFont(new Font("HP Simplified", Font.PLAIN, 15));
		label_10.setBounds(153, 34, 31, 16);
		panel_1.add(label_10);
		
		JLabel label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\flipkart_icon-icons.com_62718.png"));
		label_14.setBounds(61, 13, 30, 30);
		panel_1.add(label_14);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.BLACK);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 100, 887, 100);
		main.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 9, 0, 0));
		
		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_5.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\mobile2.png"));
		panel_2.add(button_5);
		
		JButton button_7 = new JButton("New button");
		button_7.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\rsz_screenshot_20190418-121858.png"));
		button_7.setBackground(Color.WHITE);
		panel_2.add(button_7);
		
		JButton button_6 = new JButton("");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_6.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\Webp.net-resizeimage (1).png"));
		panel_2.add(button_6);
		
		JButton button_8 = new JButton("");
		button_8.setBackground(Color.WHITE);
		button_8.setIcon(new ImageIcon("C:\\Users\\lakshman\\Desktop\\Screenshot_20190429-195140.png"));
		panel_2.add(button_8);
		
		JButton button_9 = new JButton("");
		button_9.setIcon(new ImageIcon("C:\\Users\\lakshman\\Desktop\\Screenshot_20190429-195308.png"));
		panel_2.add(button_9);
		
		JButton button_10 = new JButton("");
		button_10.setIcon(new ImageIcon("C:\\Users\\lakshman\\Desktop\\Screenshot_20190429-195333.png"));
		panel_2.add(button_10);
		
		JButton button_11 = new JButton("");
		button_11.setIcon(new ImageIcon("C:\\Users\\lakshman\\Desktop\\Screenshot_20190429-195411.png"));
		panel_2.add(button_11);
		
		JButton button_12 = new JButton("");
		button_12.setIcon(new ImageIcon("C:\\Users\\lakshman\\Desktop\\Screenshot_20190429-195457.png"));
		panel_2.add(button_12);
		
		JButton button_13 = new JButton("");
		button_13.setIcon(new ImageIcon("C:\\Users\\lakshman\\Desktop\\Screenshot_20190429-195615.png"));
		panel_2.add(button_13);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 200, 887, 25);
		main.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 9, 0, 0));
		
		JLabel label_12 = new JLabel("Moblies");
		label_12.setBackground(Color.WHITE);
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 15));
		panel_3.add(label_12);
		
		JLabel lblElectronics = new JLabel("Fashion");
		lblElectronics.setBackground(Color.WHITE);
		lblElectronics.setHorizontalAlignment(SwingConstants.CENTER);
		lblElectronics.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 15));
		panel_3.add(lblElectronics);
		
		JLabel label_13 = new JLabel("Electronics");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 15));
		panel_3.add(label_13);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 15));
		panel_3.add(lblHome);
		
		JLabel lblBeauty = new JLabel("Beauty");
		lblBeauty.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeauty.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 15));
		panel_3.add(lblBeauty);
		
		JLabel lblAppliances = new JLabel("Appliances");
		lblAppliances.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppliances.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 15));
		panel_3.add(lblAppliances);
		
		JLabel lblToysBaby = new JLabel("Toys & Baby");
		lblToysBaby.setHorizontalAlignment(SwingConstants.CENTER);
		lblToysBaby.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 15));
		panel_3.add(lblToysBaby);
		
		JLabel lblTravel = new JLabel("Travel");
		lblTravel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTravel.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 15));
		panel_3.add(lblTravel);
		
		JLabel lblSportsMore = new JLabel("Sports&More");
		lblSportsMore.setHorizontalAlignment(SwingConstants.CENTER);
		lblSportsMore.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 15));
		panel_3.add(lblSportsMore);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(0, 225, 887, 180);
		main.add(panel_4);
		panel_4.setLayout(null);
		
		JButton button_31 = new JButton("");
		
		button_31.setBorderPainted(false);
		button_31.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\back.png"));
		button_31.setBackground(Color.WHITE);
		button_31.setBounds(0, 13, 27, 139);
		panel_4.add(button_31);
		
		JButton button_32 = new JButton("");
		button_32.setBorderPainted(false);
		button_32.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\right-arrow.png"));
		button_32.setBackground(Color.WHITE);
		
		button_32.setBounds(860, 13, 27, 139);
		panel_4.add(button_32);
		
		Panel panel = new Panel();
		panel.setBounds(27, 0, 833, 180);
		panel_4.add(panel);
		panel.setLayout(null);
		
		JButton button_33 = new JButton("");
		button_33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_33.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\Screenshot_20190429-201426-833x180.png"));
		button_33.setBounds(0, 0, 833, 180);
		panel.add(button_33);
		
		Panel panel_5 = new Panel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(0, 405, 882, 120);
		main.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 8, 0, 0));
		
		JPanel product = new JPanel();
		product.setLayout(null);
		product.setBackground(Color.WHITE);
		contentPane.add(product, "name_637546629486185");
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(0, 40, 882, 713);
		product.add(panel_6);
		
		JLabel oprice = new JLabel("00");
		oprice.setFont(new Font("Nirmala UI", Font.BOLD, 22));
		oprice.setBounds(167, 277, 76, 24);
		panel_6.add(oprice);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\REDMI7PRO_2_30.png"));
		
		panel_5.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\Screenshot_20190429-212726-126x120.png"));
		btnNewButton_3.setBackground(Color.WHITE);
		
		panel_5.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\Screenshot_20190429-212727-126x120.png"));
		btnNewButton_4.setBackground(Color.WHITE);
		
		panel_5.add(btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\Screenshot_20190429-212759-126x120.png"));
		
		btnNewButton_2.setBackground(Color.WHITE);
		panel_5.add(btnNewButton_2);
		
		JButton btnNewButton_5 = new JButton("");
		
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\Screenshot_20190429-212951-126x120.png"));
		btnNewButton_5.setBackground(Color.WHITE);
		panel_5.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("");
		
		btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\Screenshot_20190429-213002-126x120.png"));
		btnNewButton_6.setBackground(Color.WHITE);
		panel_5.add(btnNewButton_6);
		
		JButton btnNewButton = new JButton("");
		
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\Screenshot_20190429-213025-126x120.png"));
		btnNewButton.setBackground(Color.WHITE);
		panel_5.add(btnNewButton);
		
		Panel panel_15 = new Panel();
		panel_15.setBackground(Color.BLUE);
		panel_15.setBounds(0, 525, 887, 232);
		main.add(panel_15);
		panel_15.setLayout(null);
		
		Panel panel_16 = new Panel();
		panel_16.setBackground(Color.WHITE);
		panel_16.setBounds(30, 30, 827, 202);
		panel_15.add(panel_16);
		panel_16.setLayout(new GridLayout(1, 6, 0, 0));
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\Screenshot_20190429-220420-137x202.png"));
		panel_16.add(btnNewButton_7);
		
		JButton btnNewButton_10 = new JButton("New button");
		btnNewButton_10.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\Screenshot_20190429-220448-137x202.png"));
		panel_16.add(btnNewButton_10);
		
		JButton btnNewButton_12 = new JButton("");
		btnNewButton_12.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\Screenshot_20190429-220515-137x202.png"));
		panel_16.add(btnNewButton_12);
		
		JButton btnNewButton_11 = new JButton("");
		btnNewButton_11.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\Screenshot_20190429-220547-137x202.png"));
		panel_16.add(btnNewButton_11);
		
		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\Screenshot_20190429-221659-137x202.png"));
		panel_16.add(btnNewButton_9);
		
		JButton btnNewButton_8 = new JButton("\r\n");
		btnNewButton_8.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\Screenshot_20190429-221706-137x202.png"));
		panel_16.add(btnNewButton_8);
		
		JLabel lblNewLabel_5 = new JLabel("Deals of the day...");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(30, 0, 138, 29);
		panel_15.add(lblNewLabel_5);
		
		JButton btnKnowMore = new JButton("View All");
		btnKnowMore.setBounds(782, 3, 93, 20);
		panel_15.add(btnKnowMore);
		
		Panel panel_7 = new Panel();
		panel_7.setBounds(0, 673, 882, 40);
		panel_6.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton button_14 = new JButton("ADD TO CART");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Added to your cart!");
			}
		});
		button_14.setBackground(Color.WHITE);
		panel_7.add(button_14);
		
		JButton button_15 = new JButton("BUY NOW");
		button_15.setForeground(Color.RED);
		button_15.setBackground(Color.WHITE);
		panel_7.add(button_15);
		
		JLabel iname = new JLabel("ITEM NAME");
		iname.setFont(new Font("Berlin Sans FB", iname.getFont().getStyle() & ~Font.BOLD | Font.ITALIC, iname.getFont().getSize() + 4));
		iname.setBounds(0, 248, 870, 30);
		panel_6.add(iname);
		
		JLabel label_22 = new JLabel("");
		label_22.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\rupee-indian.png"));
		label_22.setBounds(144, 277, 24, 24);
		panel_6.add(label_22);
		
		
		
		JLabel label_24 = new JLabel("original price");
		label_24.setBounds(62, 285, 81, 16);
		panel_6.add(label_24);
		
		JLabel label_25 = new JLabel("");
		label_25.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\rupee-indian.png"));
		label_25.setBounds(471, 277, 24, 24);
		panel_6.add(label_25);
		
		JLabel dprice = new JLabel("00");
		dprice.setFont(new Font("Nirmala UI", Font.BOLD, 22));
		dprice.setBounds(500, 277, 76, 24);
		panel_6.add(dprice);
		
		JLabel label_27 = new JLabel("Discount price");
		label_27.setBounds(362, 285, 97, 16);
		panel_6.add(label_27);
		
		JLabel label_28 = new JLabel("Description");
		label_28.setFont(new Font("Nirmala UI", Font.BOLD, 22));
		label_28.setBounds(0, 314, 143, 30);
		panel_6.add(label_28);
		
		JLabel description = new JLabel("nice product\r\n\r\n\r\n\r\n\r\n");
		description.setVerticalAlignment(SwingConstants.TOP);
		description.setHorizontalTextPosition(SwingConstants.LEFT);
		description.setToolTipText("");
		description.setHorizontalAlignment(SwingConstants.CENTER);
		description.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		description.setBounds(0, 357, 882, 264);
		panel_6.add(description);
		
		Panel panel_8 = new Panel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(173, 255, 47));
		panel_8.setBounds(10, 619, 67, 30);
		panel_6.add(panel_8);
		
		JLabel label_30 = new JLabel("");
		label_30.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\star.png"));
		label_30.setHorizontalAlignment(SwingConstants.CENTER);
		label_30.setBounds(38, 3, 24, 24);
		panel_8.add(label_30);
		
		JLabel rating = new JLabel("4.5");
		rating.setFont(new Font("MV Boli", Font.PLAIN, 18));
		rating.setBounds(0, 3, 40, 24);
		panel_8.add(rating);
		
		JButton button_16 = new JButton("view reviews");
		button_16.setBounds(167, 619, 111, 30);
		panel_6.add(button_16);
		
		JLabel no_rating = new JLabel("456");
		no_rating.setBounds(83, 633, 24, 16);
		panel_6.add(no_rating);
		
		JLabel lblReviews = new JLabel("reviews");
		lblReviews.setBounds(107, 633, 50, 16);
		panel_6.add(lblReviews);
		
		JLabel pimage = new JLabel("");
		pimage.setBounds(259, 0, 250, 250);
		panel_6.add(pimage);
		pimage.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\flipcart icon.png"));
		pimage.setHorizontalAlignment(SwingConstants.CENTER);
		pimage.setBackground(Color.WHITE);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(Color.BLUE);
		panel_9.setBounds(0, 0, 882, 40);
		product.add(panel_9);
		
		JButton button_17 = new JButton("");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				product.setVisible(false);
				main.setVisible(true);
			}
	   });
		button_17.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\left-arrow (1).png"));
		button_17.setForeground(Color.WHITE);
		button_17.setBorder(null);
		button_17.setBackground(Color.BLUE);
		button_17.setBounds(12, 5, 30, 30);
		panel_9.add(button_17);
		
		JButton button_18 = new JButton("");
		button_18.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\shopping-cart (2).png"));
		button_18.setForeground(Color.WHITE);
		button_18.setBorder(null);
		button_18.setBackground(Color.BLUE);
		button_18.setBounds(840, 5, 30, 30);
		panel_9.add(button_18);
		
		JButton button_19 = new JButton("");
		button_19.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\magnifying-glass-icon.png"));
		button_19.setForeground(Color.WHITE);
		button_19.setBorder(null);
		button_19.setBackground(Color.BLUE);
		button_19.setBounds(799, 5, 30, 30);
		panel_9.add(button_19);
		
		JPanel plist = new JPanel();
		plist.setLayout(null);
		contentPane.add(plist, "name_651566774622215");
		
		Panel panel_10 = new Panel();
		panel_10.setLayout(null);
		panel_10.setBounds(0, 1, 882, 125);
		plist.add(panel_10);
		
		Panel panel_11 = new Panel();
		panel_11.setBackground(Color.BLUE);
		panel_11.setBounds(0, 0, 882, 62);
		panel_10.add(panel_11);
		
		Panel panel_12 = new Panel();
		panel_12.setBackground(Color.WHITE);
		panel_12.setBounds(0, 62, 882, 62);
		panel_10.add(panel_12);
		panel_12.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton button_20 = new JButton("sort");
		panel_12.add(button_20);
		
		JButton button_21 = new JButton("New button");
		panel_12.add(button_21);
		
		JButton button_22 = new JButton("New button");
		button_22.setBounds(0, 126, 882, 125);
		plist.add(button_22);
		
		JButton button_23 = new JButton("New button");
		button_23.setBounds(0, 251, 882, 125);
		plist.add(button_23);
		
		JButton button_24 = new JButton("New button");
		button_24.setBounds(0, 376, 882, 125);
		plist.add(button_24);
		
		JButton button_25 = new JButton("New button");
		button_25.setBounds(0, 501, 882, 125);
		plist.add(button_25);
		
		JButton button_26 = new JButton("New button");
		button_26.setBounds(0, 626, 882, 125);
		plist.add(button_26);
		
		JPanel buynow = new JPanel();
		buynow.setLayout(null);
		contentPane.add(buynow, "name_653645230361818");
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setForeground(Color.BLACK);
		panel_13.setBackground(Color.BLUE);
		panel_13.setBounds(0, 0, 887, 40);
		buynow.add(panel_13);
		
		JButton button_27 = new JButton("");
		
		button_27.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\left-arrow (1).png"));
		button_27.setBounds(12, 5, 30, 30);
		panel_13.add(button_27);
		
		JLabel label_2 = new JLabel("BUY NOW");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(54, 5, 83, 30);
		panel_13.add(label_2);
		
		JLabel label_32 = new JLabel("TOTAL PRICE");
		label_32.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_32.setBounds(80, 663, 130, 30);
		buynow.add(label_32);
		
		JLabel tprice = new JLabel("00");
		tprice.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		tprice.setBounds(243, 662, 63, 30);
		buynow.add(tprice);
		
		JButton button_29 = new JButton("BUY NOW");
		button_29.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		button_29.setBounds(741, 714, 113, 30);
		buynow.add(button_29);
		
		JLabel label_26 = new JLabel("RS");
		label_26.setBounds(80, 376, 30, 30);
		buynow.add(label_26);
		label_26.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_26.setBackground(Color.YELLOW);
		
		JLabel pprice = new JLabel("00");
		pprice.setBounds(143, 376, 85, 30);
		buynow.add(pprice);
		pprice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pprice.setBackground(Color.YELLOW);
		
		JLabel label_23 = new JLabel("NAME");
		label_23.setBounds(51, 314, 525, 49);
		buynow.add(label_23);
		label_23.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		
		JLabel label_31 = new JLabel("QUANTITY");
		label_31.setBounds(518, 171, 96, 30);
		buynow.add(label_31);
		label_31.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		quantity = new JTextField();
		quantity.setBounds(674, 171, 60, 30);
		buynow.add(quantity);
		quantity.setColumns(10);
		
		JButton btnConform = new JButton("Conform");
		btnConform.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConform.setBounds(712, 529, 97, 30);
		buynow.add(btnConform);
		
		JLabel lblEnterPaymentDetails = new JLabel("Enter payment details..");
		lblEnterPaymentDetails.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblEnterPaymentDetails.setBounds(41, 74, 169, 30);
		buynow.add(lblEnterPaymentDetails);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblAccountNumber.setBounds(80, 117, 130, 30);
		buynow.add(lblAccountNumber);
		
		JLabel lblBankName = new JLabel("Bank name");
		lblBankName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblBankName.setBounds(81, 167, 130, 30);
		buynow.add(lblBankName);
		
		account = new JTextField();
		account.setBounds(228, 119, 181, 30);
		buynow.add(account);
		account.setColumns(10);
		
		bank = new JTextField();
		bank.setColumns(10);
		bank.setBounds(228, 173, 181, 30);
		buynow.add(bank);
		
		JPanel review = new JPanel();
		review.setLayout(null);
		contentPane.add(review, "name_753594673598386");
		
		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBackground(Color.BLUE);
		panel_14.setBounds(0, 0, 882, 40);
		review.add(panel_14);
		
		JLabel label_21 = new JLabel("REVIEW");
		label_21.setForeground(Color.WHITE);
		label_21.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_21.setBounds(38, 5, 61, 30);
		panel_14.add(label_21);
		
		JButton button_28 = new JButton("");
		button_28.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\left-arrow (1).png"));
		button_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				review.setVisible(false);
				main.setVisible(true);
			}
		});
		button_28.setBounds(5, 5, 30, 30);
		panel_14.add(button_28);
		
		JLabel title = new JLabel("PNAME");
		title.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		title.setBounds(97, 150, 603, 30);
		review.add(title);
		
		JLabel label_33 = new JLabel("RATE THE PRODUCT");
		label_33.setFont(new Font("Rockwell Condensed", Font.PLAIN, 17));
		label_33.setBounds(97, 224, 127, 30);
		review.add(label_33);
		
		JLabel label_34 = new JLabel("COMMENT");
		label_34.setFont(new Font("Rockwell Condensed", Font.PLAIN, 17));
		label_34.setBounds(97, 295, 127, 30);
		review.add(label_34);
		
		rate = new JTextField();
		rate.setColumns(10);
		rate.setBounds(255, 229, 116, 30);
		review.add(rate);
		
		JLabel label_35 = new JLabel("(rate out of 5)");
		label_35.setBounds(410, 243, 107, 16);
		review.add(label_35);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(255, 295, 239, 127);
		review.add(scrollPane);
		
		JTextArea comment = new JTextArea();
		scrollPane.setViewportView(comment);
		
		JButton button_30 = new JButton("SUBMIT");
		button_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pu_id=0;
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "");
					Statement stmt= con.createStatement();
					String sql="select max(purchase_id) as pu_id from purchase_details";
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()){
						pu_id =rs.getInt("pu_id");
					}int pro_id1=0;
					String str2=iname.getText();
					String sqla="select product_id from product where name='"+str2+"'"; 
					ResultSet r1=stmt.executeQuery(sqla);
					
					while(r1.next()){
						pro_id1=r1.getInt("product_id");	
					}
					String sql1="insert into review values("+pu_id+",'"+pro_id1+"','"+rating.getText()+"','"+comment.getText()+"')";
					int r = stmt.executeUpdate(sql1); 
					if(r>0){	
						main.setVisible(true);
					}
				   else
					   JOptionPane.showMessageDialog(null, "incorrect...");
				   con.close();			}
	   			 catch(SQLException e1){
					JOptionPane.showMessageDialog(null, e1);
				 }
				catch (ClassNotFoundException e2) {
					e2.printStackTrace();
				}				
				
			}
		});
		button_30.setBounds(570, 538, 97, 30);
		review.add(button_30);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "");
					Statement stmt= con.createStatement();					
					String sql1="select * from product where product_id=1";
					ResultSet rs= stmt.executeQuery(sql1); 
					while(rs.next()){
						oprice.setText(rs.getString("price"));
						dprice.setText(rs.getString("discount_price"));
						description.setText(rs.getString("description"));
						no_rating.setText(rs.getString("no_ratings"));
						iname.setText(rs.getString("name"));
						pimage.setIcon(new ImageIcon (rs.getString("image")));
						
					}
					main.setVisible(false);
					product.setVisible(true);
					
				   con.close();			}
	   			 catch(SQLException se){
					JOptionPane.showMessageDialog(null, se);
				 }
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user_id.getText() != null && !user_id.getText().isEmpty()){
				pprice.setText(dprice.getText());
				product.setVisible(false);
				buynow.setVisible(true);
			    }
			    else{
				JOptionPane.showMessageDialog(null, "not signed...");
			    }
			}
		});
		button_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buynow.setVisible(false);
				product.setVisible(true);
			}
		});
		btnConform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int p_id1=0;
				tprice.setText(String.valueOf((Integer.parseInt(quantity.getText()) * Integer.parseInt(pprice.getText()))));
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "");
					Statement stmt= con.createStatement();	
					String sql="select max(purchase_id) as pu_id1 from account_details";
					ResultSet r4=stmt.executeQuery(sql);
					while(r4.next()){
						p_id1 =r4.getInt("pu_id1");
					}
					if(p_id1==0){
						p_id1=0;
					}
					p_id1=p_id1+1;
					String sql2="insert into account_details values('"+p_id1+"','"+user_id.getText()+"','"+account.getText()+"','"+bank.getText()+"')";
				    stmt.executeUpdate(sql2); 
				   
				   
				    con.close();			}
	   			  catch(SQLException e3){
					  JOptionPane.showMessageDialog(null,e3);
				 }
				catch (ClassNotFoundException e4) {
					JOptionPane.showMessageDialog(null,e4);
					
				}
			
			}
		});
		button_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int p_id = 0;
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "");
					Statement stmt= con.createStatement();
					String sql="select max(purchase_id) as pu_id from purchase_details";
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()){
						p_id =rs.getInt("pu_id");
					}int pro_id=0;
					String str2=iname.getText();
					String sqla="select product_id from product where name='"+str2+"'"; 
					ResultSet r1=stmt.executeQuery(sqla);
					while(r1.next()){
						pro_id=r1.getInt("product_id");	
					}
					p_id=p_id+1;
					String sql1="insert into purchase_details values("+p_id+",'"+user_id.getText()+"','"+pro_id+"','"+quantity.getText()+"','"+tprice.getText()+"')";
					int r = stmt.executeUpdate(sql1); 
					if(r>0){	
						JOptionPane.showMessageDialog(null, "order placed...");
						review.setVisible(true);
						buynow.setVisible(false);
						String sq="select * from product where product_id='"+pro_id+"'";
						ResultSet rs1= stmt.executeQuery(sq); 
						while(rs1.next()){
							title.setText(rs1.getString("name"));	
						}	
					}
				   else
					   JOptionPane.showMessageDialog(null, "incorrect...");
				   con.close();			}
	   			 catch(SQLException e1){
					JOptionPane.showMessageDialog(null, e1);
				 }
				catch (ClassNotFoundException e2) {
					e2.printStackTrace();
				}
				
			}
		});
		
		
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "");
					Statement stmt= con.createStatement();					
					String sql1="select * from product where product_id=5";
					ResultSet rs= stmt.executeQuery(sql1); 
					while(rs.next()){
						oprice.setText(rs.getString("price"));
						dprice.setText(rs.getString("discount_price"));
						description.setText(rs.getString("description"));
						no_rating.setText(rs.getString("no_ratings"));
						iname.setText(rs.getString("name"));
						pimage.setIcon(new ImageIcon (rs.getString("image")));
						
					}
					main.setVisible(false);
					product.setVisible(true);
					
				   con.close();			}
	   			 catch(SQLException se){
					JOptionPane.showMessageDialog(null, se);
				 }
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "");
					Statement stmt= con.createStatement();					
					String sql1="select * from product where product_id=6";
					ResultSet rs= stmt.executeQuery(sql1); 
					while(rs.next()){
						oprice.setText(rs.getString("price"));
						dprice.setText(rs.getString("discount_price"));
						description.setText(rs.getString("description"));
						no_rating.setText(rs.getString("no_ratings"));
						iname.setText(rs.getString("name"));
						pimage.setIcon(new ImageIcon (rs.getString("image")));
						
					}
					main.setVisible(false);
					product.setVisible(true);
					
				   con.close();			}
	   			 catch(SQLException se){
					JOptionPane.showMessageDialog(null, se);
				 }
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		button_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				button_33.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\Screenshot_20190429-202742-833x180.png"));
			}
		});
		button_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				button_33.setIcon(new ImageIcon("C:\\Users\\lakshman\\Downloads\\Screenshot_20190429-203210-833x180.png"));
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "");
					Statement stmt= con.createStatement();					
					String sql1="select * from product where product_id=8";
					ResultSet rs= stmt.executeQuery(sql1); 
					while(rs.next()){
						oprice.setText(rs.getString("price"));
						dprice.setText(rs.getString("discount_price"));
						description.setText(rs.getString("description"));
						no_rating.setText(rs.getString("no_ratings"));
						iname.setText(rs.getString("name"));
						pimage.setIcon(new ImageIcon (rs.getString("image")));
						
					}
					main.setVisible(false);
					product.setVisible(true);
					
				   con.close();			}
	   			 catch(SQLException se){
					JOptionPane.showMessageDialog(null, se);
				 }
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "");
					Statement stmt= con.createStatement();					
					String sql1="select * from product where product_id=10";
					ResultSet rs= stmt.executeQuery(sql1); 
					while(rs.next()){
						oprice.setText(rs.getString("price"));
						dprice.setText(rs.getString("discount_price"));
						description.setText(rs.getString("description"));
						no_rating.setText(rs.getString("no_ratings"));
						iname.setText(rs.getString("name"));
						pimage.setIcon(new ImageIcon (rs.getString("image")));
						
					}
					main.setVisible(false);
					product.setVisible(true);
					
				   con.close();			}
	   			 catch(SQLException se){
					JOptionPane.showMessageDialog(null, se);
				 }
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "");
					Statement stmt= con.createStatement();					
					String sql1="select * from product where product_id=11";
					ResultSet rs= stmt.executeQuery(sql1); 
					while(rs.next()){
						oprice.setText(rs.getString("price"));
						dprice.setText(rs.getString("discount_price"));
						description.setText(rs.getString("description"));
						no_rating.setText(rs.getString("no_ratings"));
						iname.setText(rs.getString("name"));
						pimage.setIcon(new ImageIcon (rs.getString("image")));
						
					}
					main.setVisible(false);
					product.setVisible(true);
					
				   con.close();			}
	   			 catch(SQLException se){
					JOptionPane.showMessageDialog(null, se);
				 }
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "");
					Statement stmt= con.createStatement();					
					String sql1="select * from product where product_id=12";
					ResultSet rs= stmt.executeQuery(sql1); 
					while(rs.next()){
						oprice.setText(rs.getString("price"));
						dprice.setText(rs.getString("discount_price"));
						description.setText(rs.getString("description"));
						no_rating.setText(rs.getString("no_ratings"));
						iname.setText(rs.getString("name"));
						pimage.setIcon(new ImageIcon (rs.getString("image")));
						
					}
					main.setVisible(false);
					product.setVisible(true);
					
				   con.close();			}
	   			 catch(SQLException se){
					JOptionPane.showMessageDialog(null, se);
				 }
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}
}
