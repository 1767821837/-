package com.view.qianduan;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.control.userControl;
import com.model.userDao.User;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;

public class findpasswords extends JPanel {
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Create the panel.
	 */
	public findpasswords(User user,JFrame f) {
		
		JLabel label = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel label_1 = new JLabel("\u8BBE\u7F6E\u65B0\u5BC6\u7801");
		label_1.setFont(new Font("宋体", Font.PLAIN, 25));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel label_2 = new JLabel("\u518D\u6B21\u8F93\u5165\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton button = new JButton("\u786E\u8BA4\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordField.getText().equals(passwordField_1.getText())) {
			user.setLoginpassword(passwordField.getText());
			userControl.uppasswordcon(user);
			  JOptionPane op = new JOptionPane("密码重置成功",JOptionPane.INFORMATION_MESSAGE);  
		      final JDialog dialog = op.createDialog("修改密码成功");  
		        
		      // 创建一个新计时器  
		      Timer timer = new Timer();  

		      // 30秒 后执行该任务  
		      timer.schedule(new TimerTask() {  
		          public void run() { 
		        	 f.dispose();
		              dialog.setVisible(false);  
		              dialog.dispose();  
		          }  
		      }, 1500);  

		      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);  
		      dialog.setAlwaysOnTop(true);  
		      dialog.setModal(false);  
		      dialog.setVisible(true); 
		      Login lo=new Login();
		      lo.setVisible(true);
		   
			}else {
				JOptionPane.showMessageDialog(button, "密码不一致");
			}
				
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 25));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(167)
							.addComponent(label_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_2)
								.addComponent(label))
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField_1)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(172)
							.addComponent(button)))
					.addContainerGap(103, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(86)
					.addComponent(label_1)
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(73))
		);
		setLayout(groupLayout);

	}
}
