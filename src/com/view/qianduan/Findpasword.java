package com.view.qianduan;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.control.userControl;
import com.model.userDao.User;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class Findpasword extends JPanel {
	User user=new User();
	private JTextField textField;
	private JTextField textField_1;
private ImageIcon back;
	/**
	 * Create the panel.
	 */
	public Findpasword(JFrame f) {
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
        this.add(fanhui);
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label = new JLabel("\u5BC6\u4FDD\u95EE\u9898\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("\u7B54\u6848\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--\u9009\u62E9\u5BC6\u4FDD\u95EE\u9898--", "\u4F60\u597D\u670B\u53CB\u7684\u540D\u5B57\uFF1F", "\u4F60\u7684\u751F\u65E5\uFF1F", "\u4F60\u7684\u8001\u5E08\u7684\u540D\u5B57\uFF1F", "\u4F60\u7684\u6BCD\u6821\u540D\u79F0\uFF1F"}));
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				user.setId(Long.parseLong(textField.getText()));
				
				if(userControl.VerificationId(user)) {
					
					JOptionPane.showMessageDialog(textField,"账号或会员名不存在");
					textField.setText(null);
		
				}
				
			}
		});
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setForeground(Color.BLUE);
		button.setFont(new Font("宋体", Font.PLAIN, 25));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setId(Long.parseLong(textField.getText()));
				user.setSecurity((String)comboBox.getSelectedItem());
				user.setAnswer(textField_1.getText());
				if(userControl.checkanswer(user)) {
					f.dispose();
					JFview j=new JFview();
					findpasswords fp=new findpasswords(user,j);
					j.getContentPane().add(fp);
					j.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(button, "密保或答案不正确");
					textField_1.setText(null);
				}
				
			}
			
		});
	
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(label_1)
								.addComponent(label))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField_1)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(172)
							.addComponent(button)))
					.addContainerGap(182, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(128)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(56)
					.addComponent(button)
					.addContainerGap(65, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
