package com.view.qianduan;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.control.userControl;
import com.model.userDao.User;
import com.model.userDao.userDao;
import com.util.Buttonzhezhi;
import com.util.CheckChar;
import com.view.admin.adminJf;
import com.view.home.Homepage;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
    private userDao userdao=new userDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(new ImageIcon(JFview.class.getResource("/images/qianduan/logo.png")).getImage()); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 500, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	JLabel back=new JLabel();
	back.setIcon(new ImageIcon(Login.class.getResource("/images/qianduan/loginback.jpg")));
	back.setBounds(0, 0, 530, 500);
	this.getLayeredPane().add(back,new Integer(Integer.MIN_VALUE));
	((JPanel)this.getContentPane()).setOpaque(false);
		JLabel lblNewLabel = new JLabel();
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/images/qianduan/userName.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setToolTipText("请输入正确的手机号码");
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/images/qianduan/password.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		textField = new JTextField(11);
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setToolTipText("输入11位手机号码");
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 20));
		passwordField.setToolTipText("请输入6-16位密码");
		  
		textField.setBackground(new Color(255, 255, 255));  
		textField.setPreferredSize(new Dimension(150, 28));  
		        MatteBorder border = new MatteBorder(0, 0, 2, 0, new Color(192, 192,  
		        192));  
		        textField.setBorder(border);  
		
		        passwordField.setBackground(new Color(255, 255, 255));  
		        passwordField.setPreferredSize(new Dimension(150, 28));  
				       
		        passwordField.setBorder(border);  
		passwordField.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				User user=new User();
					
					System.out.println(user.getId());
					if(CheckChar.checkNum(textField.getText())) {
						
						user.setId(Long.parseLong(textField.getText()));
				if(textField.getText().length()==11) {
					
				if(userControl.VerificationId(user)) {
					JOptionPane.showMessageDialog(textField, "账号不存在");
					textField.setText(null);
					passwordField.setText(null);
				}
				
			}else {
				JOptionPane.showMessageDialog(textField, "请正确输入11位手机号");
				textField.setText(null);
				}
					}else {
						JOptionPane.showMessageDialog(textField, "请输入数字");
						textField.setText(null);
						passwordField.setText(null);
					}
				}
		});
		
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.setBackground(Color.ORANGE);
		loginButton.setForeground(Color.BLUE);
		loginButton.setFont(new Font("宋体", Font.PLAIN, 22));
		this.getRootPane().setDefaultButton(loginButton);
		loginButton.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
			final	long user=Long.parseLong(textField.getText());
			final	String password=passwordField.getText();
				User users=new User();
				users.setId(user);
				users.setLoginpassword(password);
			if( textField.getText().length()==11) {
				if(password.length()>=6) {
					User userLogin=userControl.validateLogon(users);
				if(userLogin!=null) {
					if(userLogin.getAdmin().equals("否")) {
							dispose();
							long l=Long.parseLong( textField.getText());
							System.out.println(l);
							userLogin.setId(l);
					 Homepage home=new Homepage(userLogin);
				        	  home.setVisible(true);
					}else if(userLogin.getAdmin().equals("是")){
						adminJf admin=new adminJf();
						admin.setVisible(true);
						dispose();
					}
				}else {
					JOptionPane.showMessageDialog(passwordField,"密码错误");
					passwordField.setText(null);
				}
				}
				else if(passwordField.getText().length()==0){
					JOptionPane.showMessageDialog(passwordField,"密码不能为空");
					passwordField.setText(null);
				}
				
			}else if(textField.getText().trim().length()==0){
				JOptionPane.showMessageDialog(textField,"账号不能为空");
			}else {
				JOptionPane.showMessageDialog(textField,"请输入11位手机号码");
				textField.setText(null);
			}
				
			}
		});
		JButton registerButton = new JButton("\u6CE8\u518C");
		registerButton.setBackground(Color.ORANGE);
		registerButton.setForeground(Color.BLUE);
		registerButton.setFont(new Font("宋体", Font.PLAIN, 22));
		registerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			dispose();
			JFview j=new JFview();	
			Register r=new Register(j);
			j.getContentPane().add(r);
			j.setVisible(true);
			}
		});
		
		JLabel findbutton = new JLabel("\u5FD8\u8BB0\u5BC6\u7801\uFF1F");
		findbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFview j=new JFview();
				Findpasword find=new Findpasword(j);
				j.getContentPane().add(find);
				j.setVisible(true);

			}
		});
		findbutton.setFont(new Font("宋体", Font.PLAIN, 15));
		
		
		findbutton.setBorder(null);
		findbutton.setOpaque(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(166)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(108, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_1)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(registerButton)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(passwordField)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(findbutton)
									.addComponent(loginButton)))))
					.addGap(102))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(88)
					.addComponent(lblNewLabel)
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(findbutton)
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginButton)
						.addComponent(registerButton)))
		);
		contentPane.setLayout(gl_contentPane);
	}
	

}
