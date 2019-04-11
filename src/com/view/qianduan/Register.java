package com.view.qianduan;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;

import com.control.userControl;
import com.model.userDao.User;
import com.model.userDao.userDao;
import com.util.CheckChar;
import com.util.ValidCode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Register extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private ValidCode vcode = new ValidCode(); 
	private  ImageIcon userphoto;
	private userDao userdao=new userDao();
	ImageIcon back=new ImageIcon(Register.class.getResource("/images/qianduan/return.png"));
 	/**
	 * Create the panel.
	 */
	public Register(JFrame f) {
		JButton fanhui=new JButton();
		fanhui.setBounds(10, 10, 50, 50);
		
		fanhui.setIcon(back);
		fanhui.setOpaque(false);
		fanhui.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				Login login=new Login();
				login.setVisible(true);
				
			}
		});
		
		JLabel label = new JLabel("\u624B\u673A\u53F7\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel label_1 = new JLabel("\u9A8C\u8BC1\u7801\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setOpaque(false);
		textField.setToolTipText("请输入11位手机号");
		
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setOpaque(false);
		textField_1.setToolTipText("输入验证码");
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(CheckChar.checkNum(textField.getText())) {
					long l=Long.parseLong(textField.getText());
					}else {
						JOptionPane.showMessageDialog(null, "请输入数字");
						textField.setText(null);
					}

			}
		});
		textSet(textField);
		textSet(textField_1);
		JButton button = new JButton("\u540C\u610F\u5E76\u6CE8\u518C");
		button.setForeground(Color.BLUE);
		button.setFont(new Font("宋体", Font.PLAIN, 25));
//		getRootPane().setDefaultButton(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().length()!=0&&textField.getText().length()==11) {
			if(CheckChar.checkNum(textField.getText())){
						if(isValidCodeRight()) {
							vcode.nextCode();
							long l=Long.parseLong(textField.getText());
							User user=new User();
							user.setId(l);
						
							if(userControl.VerificationId(user)) {
							
								f.dispose();
								JFview j=new JFview();
								Register2 r=new Register2(user,j);
								j.getContentPane().add(r);
								j.setVisible(true);
							}else {
								
									JOptionPane.showMessageDialog(textField_1,"账号存在");
								textField.setText("");
								textField_1.setText("");
							
							}
							
				}else {
					JOptionPane.showMessageDialog(textField_1,"验证码不正确");
					vcode.nextCode();
					textField_1.setText("");

				}
				}else {
					JOptionPane.showMessageDialog(textField,"请输入真确格式的手机号");
					textField.setText("");
					textField_1.setText("");
				}
				}else {
					JOptionPane.showMessageDialog(textField,"请输入真确格式的手机号");
					textField.setText("");
					textField_1.setText("");
				}
			
			}
				
			
		
		});
		JLabel label_2 = new JLabel("\u5DF2\u9605\u8BFB\u540C\u610F\u4E00\u4E0B\u534F\u8BAE");
		label_2.setFont(new Font("宋体", Font.PLAIN, 12));
		vcode.setBounds(272, 241, 100, 30);
		JLabel label_3 = new JLabel("\u300A\u5929\u732B\u670D\u52A1\u534F\u8BAE\u300B\u3001\u300A\u9690\u79C1\u6743\u653F\u7B56\u300B");
		label_3.setFont(new Font("宋体", Font.BOLD, 15));
		JLabel user=new JLabel();
		userphoto=new ImageIcon(Register.class.getResource("/images/qianduan/userName.png"));
		user.setBounds(38, 155, 40, 30);
		user.setIcon(userphoto);
		this.add(user);
		this.add(vcode);
		this.add(fanhui);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(74)
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_3))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(64)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(144)
							.addComponent(button)))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(157)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addComponent(button)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addComponent(label_3))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
    public boolean isValidCodeRight() {  
        if(textField_1 == null) {  
            return false;  
        }else if(vcode == null) {  
            return true;  
        }else if(vcode.getCode().toLowerCase() .equals(textField_1.getText().toLowerCase())) {  
            return true;  
        }else   
            return false;  
    }  
    public void textSet(JTextField field) {  
        field.setBackground(new Color(255, 255, 255));  
        field.setPreferredSize(new Dimension(150, 28));  
        MatteBorder border = new MatteBorder(0, 0, 2, 0, new Color(192, 192,  
        192));  
        field.setBorder(border);  
    }  
}
