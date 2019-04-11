package com.view.qianduan;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.control.userControl;
import com.model.userDao.User;
import com.model.userDao.userDao;
import com.util.CheckChar;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
public class Register2 extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField againPasswordField;
   private ImageIcon back;
   private JPasswordField passwordField_1;
	/**
	 * Create the panel.
	 */
	public Register2(User user ,JFrame f) {
		JButton fanhui=new JButton();
		fanhui.setBounds(10, 10, 50, 50);
		back=new ImageIcon(Register.class.getResource("/images/qianduan/return.png"));
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
		JLabel vipName = new JLabel("\u4F1A\u5458\u540D\uFF1A");
		vipName.setFont(new Font("宋体", Font.PLAIN, 18));
		vipName.setToolTipText("会员名只可设置一次，无法更改");
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		textField.setColumns(12);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 18));
		
		againPasswordField = new JPasswordField();
		againPasswordField.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton button = new JButton("\u6CE8\u518C");
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()>=5) {
				if(CheckChar.checkChinese(textField.getText())) {
				
					
					if(passwordField.getText().equals(againPasswordField.getText())) {
						if(CheckChar.checkChars(passwordField.getText())) {
							user.setLoginpassword(passwordField.getText());
							user.setVipname(textField.getText());
							
							JPasswordField pwd = new JPasswordField(); 
							Object[] message = {"再次输入支付密码输入密码:", pwd}; 
							int res = JOptionPane.showConfirmDialog(passwordField_1, message, "再次输入支付密码:", 
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE); 
							System.out.println(pwd.getPassword());
							System.out.println(passwordField_1.getText());
							if(pwd.getText().equals(passwordField_1.getText())) {
								user.setPaypassword(passwordField_1.getText());
							if(userControl.VerificationVipName(user)) {
								f.dispose();
								  JOptionPane op = new JOptionPane("进行安全设置",JOptionPane.INFORMATION_MESSAGE);  
							      final JDialog dialog = op.createDialog("注册成功");  
						
							      // 创建一个新计时器  
							      Timer timer = new Timer();  

							      // 30秒 后执行该任务  
							      timer.schedule(new TimerTask() {  
							          public void run() {  
							              dialog.setVisible(false);  
							              dialog.dispose();  
							          }  
							      }, 1000);  

							      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);  
							      dialog.setAlwaysOnTop(true);  
							      dialog.setModal(false);  
							      dialog.setVisible(true);  
							   
							      JFview m=new JFview();
									Userinformation u=new Userinformation(user, m);
									m.getContentPane().add(u);
									m.setVisible(true);
							
								
								}else {
									JOptionPane.showMessageDialog(textField, "会员名存在");
									textField.setText("");
									passwordField.setText("");
									againPasswordField.setText("");
									passwordField_1.setText("");
								}
							}
								else {
							
									JOptionPane.showMessageDialog(textField, "错误", "两次密码不相同",JOptionPane.INFORMATION_MESSAGE);
									passwordField.setText(null);
									passwordField_1.setText(null);
									againPasswordField.setText(null);
							}

							}else{
								JOptionPane.showMessageDialog(textField, "密码不合法");
							
								passwordField.setText("");
								againPasswordField.setText("");
								passwordField_1.setText("");
								
							}
						}else {
							JOptionPane.showMessageDialog(textField, "两次密码不正确");
							passwordField.setText("");
							againPasswordField.setText("");
							passwordField_1.setText("");
						}
					}else {
						JOptionPane.showMessageDialog(textField, "会员账号不合法");
						textField.setText(null);
						passwordField.setText("");
						againPasswordField.setText("");
						passwordField_1.setText("");
					}
					
				}else {
					JOptionPane.showMessageDialog(textField, "会员账号不能小于5位");
					textField.setText(null);
					passwordField.setText("");
					againPasswordField.setText("");
					passwordField_1.setText("");
				}
		
			}}
		);
		
		JButton back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("宋体", Font.PLAIN, 20));
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			JFview f1=new JFview();
				Register r=new Register(f1);
				f1.getContentPane().add(r);
				f1.setVisible(true);
				f.dispose();
			
			
			}
		});
		this.add(fanhui);
		
		JLabel label = new JLabel("\u652F\u4ED8\u5BC6\u7801\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(back)
							.addGap(70)
							.addComponent(button))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(vipName)
								.addComponent(label_2)
								.addComponent(label_1)
								.addComponent(label))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField_1)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(againPasswordField)
									.addComponent(passwordField)
									.addComponent(textField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)))))
					.addContainerGap(144, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(121)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(vipName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_2)
						.addComponent(againPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(back))
					.addGap(39))
		);
		setLayout(groupLayout);
		
	}
}
