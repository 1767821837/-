package com.view.home;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.model.shoppDao.Products;
import com.model.shoppDao.order_;
import com.model.shoppDao.order_Dao;
import com.model.userDao.User;
import com.model.userDao.userDao;

import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Payinterface extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private order_Dao orderdao=new order_Dao();
	private  SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss " );
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Payinterface dialog = new Payinterface(new User(),new order_(),new Products());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Payinterface(User user,order_ ord,Products pro) {
		setSize( 588, 610);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int res=JOptionPane.showConfirmDialog(null, "取消购买？", "是否继续", JOptionPane.YES_NO_OPTION);
	              if(res==JOptionPane.YES_OPTION){ 
	              
	              dispose();
	              }
			}
		});
		JLabel lblNewLabel = new JLabel("\u6536\u8D27\u5730\u5740\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("\u4EF7\u683C\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("\u8BA2\u5355\u53F7\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel(user.getAddress());
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel(user.getMobile());
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3 = new JLabel(ord.getName());
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_4 = new JLabel(ord.getOrderCode());
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_5 = new JLabel("¥"+ord.getMoney());
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 25));
		
		JLabel label_4 = new JLabel("\u6570\u91CF\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JSpinner spinner = new JSpinner();
		spinner.setValue(ord.getNumber());
		spinner.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				lblNewLabel_5.setText("¥"+pro.getPromoteprice()*(int)spinner.getValue()+"");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_5.setText("¥"+pro.getPromoteprice()*(int)spinner.getValue()+"");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_5.setText("¥"+pro.getPromoteprice()*(int)spinner.getValue()+"");
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_5.setText("¥"+pro.getPromoteprice()*(int)spinner.getValue()+"");
				
			}
		});
		JButton button = new JButton("\u7ACB\u5373\u652F\u4ED8");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((int)spinner.getValue()>0) {
				JPasswordField pwd = new JPasswordField(); 
				Object[] message = {"请输入支付密码:", pwd}; 
				int res = JOptionPane.showConfirmDialog(null, message, "支付密码:", 
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE); 
				user.setPaypassword(pwd.getText());
				userDao userdao=new  userDao();
				if(userdao.Verificationpaypassword(user)!=null) {
					Date da=new Date();
					ord.setPayDate(sdf.format(da));
					ord.setNumber((int)spinner.getValue());
					ord.setMoney(pro.getPromoteprice()*ord.getNumber());
					orderdao.addorder(user, ord,pro);
				Paysuccess pays= new Paysuccess(user,ord.getMoney()+"");
				pays.setVisible(true);
				 Timer timer = new Timer(3500,new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	pays.setVisible(false);
			            	pays.dispose();
			            }
			        });
			        timer.start();
				  dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "支付密码错误");
			}
			}else {
				JOptionPane.showMessageDialog(null, "请输入数量");
			}
				}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(272, Short.MAX_VALUE)
					.addComponent(button_1)
					.addGap(58)
					.addComponent(button)
					.addGap(44))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_4)
						.addComponent(label_2)
						.addComponent(label)
						.addComponent(lblNewLabel)
						.addComponent(label_1)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_5)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(87)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(lblNewLabel_4))
					.addGap(49)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(lblNewLabel_5))
					.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addGap(39))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
