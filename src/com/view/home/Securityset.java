package com.view.home;
/**
 * 修改密码
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.control.userControl;
import com.model.userDao.User;
import com.view.qianduan.JFview;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Securityset extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private  userControl usercontrol=new userControl();
	private JLabel lblNewLabel;


	/**
	 * @return the lblNewLabel
	 */
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	/**
	 * @param lblNewLabel the lblNewLabel to set
	 */
	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Securityset(User user ,String str) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setIconImage(new ImageIcon(JFview.class.getResource("/images/qianduan/logo.png")).getImage()); 
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u539F\u5BC6\u7801\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("\u518D\u6B21\u8F93\u5165\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 18));
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton button = new JButton("\u786E\u8BA4\u4FEE\u6539");
		button.setFont(new Font("宋体", Font.PLAIN, 25));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(passwordField.getText().equals(passwordField_2.getText())) {
					if(str.equals("修改登录密码")) {
						user.setLoginpassword(passwordField_1.getText());
						String s=passwordField.getText();
						if(userControl.setnewloginpassword(user,s))
					{
							dispose();
							JOptionPane.showMessageDialog(passwordField, "修改成功");
						}else {
							JOptionPane.showMessageDialog(passwordField, "原密码错误");
							passwordField.setText(null);
							passwordField_1.setText(null);
							passwordField_2.setText(null);
						}
						
					}
					else {
						user.setPaypassword(passwordField_1.getText());
						String s=passwordField.getText();
						if(userControl.setnewpaypassword(user,s))
					{
							dispose();
							JOptionPane.showMessageDialog(passwordField, "修改成功");
						}else {
							JOptionPane.showMessageDialog(passwordField, "原密码错误");
							passwordField.setText(null);
							passwordField_1.setText(null);
							passwordField_2.setText(null);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(button, "两次密码不一致");
				}
				
			}
		});
		lblNewLabel = new JLabel(str);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_2)
								.addComponent(label_1)
								.addComponent(label))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField_2)
								.addComponent(passwordField_1)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(147)
							.addComponent(button))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(181)
							.addComponent(lblNewLabel)))
					.addContainerGap(102, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addComponent(lblNewLabel)
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(passwordField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
