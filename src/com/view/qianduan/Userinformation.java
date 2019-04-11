 package com.view.qianduan;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.control.userControl;
import com.model.userDao.User;

import java.awt.Color;

public class Userinformation extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
    private ImageIcon back;
	private JComboBox comboBox;
	private userControl  usec=new userControl();
	/**
	 * Create the panel.
	 */
	public Userinformation(User user,JFrame f ) {
		
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
		JLabel label = new JLabel("\u771F\u5B9E\u59D3\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("\u8BBE\u7F6E\u5BC6\u4FDD\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		 comboBox = new JComboBox();
		 comboBox.setToolTipText("设置您的密保答案");
		comboBox.setFont(new Font("宋体", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--\u9009\u62E9\u5BC6\u4FDD\u95EE\u9898--", "\u4F60\u597D\u670B\u53CB\u7684\u540D\u5B57\uFF1F", "\u4F60\u7684\u751F\u65E5\uFF1F", "\u4F60\u7684\u8001\u5E08\u7684\u540D\u5B57\uFF1F", "\u4F60\u7684\u6BCD\u6821\u540D\u79F0\uFF1F"}));
		
		JLabel lblNewLabel = new JLabel("\u7B54\u6848\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setToolTipText("密保答案");
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setToolTipText("请输入您的真实姓名");
		JButton button = new JButton("\u786E\u8BA4");
		button.setBackground(Color.CYAN);
		button.setFont(new Font("宋体", Font.PLAIN, 23));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()>0) {
				if(textField_1.getText().length()>=3) {
					
					user.setRealname(textField_1.getText());
					user.setAnswer(textField.getText());
					user.setSecurity((String)comboBox.getSelectedItem());
					System.out.println(user.toString());
					usec.lastVerification(user);
					 f.dispose();
					 JOptionPane op = new JOptionPane("注册完成",JOptionPane.INFORMATION_MESSAGE);  
				      final JDialog dialog = op.createDialog("成功");  
				         Login login=new Login();
				         dialog.setVisible(true);
					      login.setVisible(true);
				      // 创建一个新计时器  
				      Timer timer = new Timer();  

				      // 2秒 后执行该任务  
				      timer.schedule(new TimerTask() {  
				          public void run() {  
				              dialog.setVisible(false);  
				              dialog.dispose();  
				            
				             
				            
				          }  
				      }, 1000); 
				      
				} else {
					JOptionPane.showMessageDialog(button, "密保答案不能小于3位");
				}
				}
				else {
					JOptionPane.showMessageDialog(button, "请输入正确的姓名");
				}
				
			}
		});
		this.add(fanhui);
		JLabel label_2 = new JLabel("\u586B\u5199\u5B89\u5168\u4FE1\u606F");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("宋体", Font.PLAIN, 30));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(fanhui, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(63)
							.addComponent(label_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(98)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label)
								.addComponent(label_1)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField)
								.addComponent(textField_1)
								.addComponent(comboBox, 0, 173, Short.MAX_VALUE))))
					.addContainerGap(75, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(187, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(184))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(fanhui, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addComponent(label_2)))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(59)
					.addComponent(button)
					.addGap(55))
		);
		setLayout(groupLayout);

	}
	public static void main(String[] args) {
		JFview f=new JFview();
		User user=null;
		Userinformation u=new Userinformation(user, f);
		f.getContentPane().add(u);
		f.setVisible(true);
	}
}
