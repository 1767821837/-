package com.view.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.shoppDao.Products;
import com.model.shoppDao.ProductsDao;
import com.view.qianduan.JFview;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Adminlookshopping extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminlookshopping frame = new Adminlookshopping(new Products());
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
	public Adminlookshopping(Products pro) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(JFview.class.getResource("/images/qianduan/logo.png")).getImage()); 
		setSize( 659, 687);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u6807\u9898\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label = new JLabel("\u5C0F\u6807\u9898\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("\u539F\u4EF7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("\u73B0\u4EF7\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("\u5E93\u5B58\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("\u751F\u4EA7\u65E5\u671F\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
	
		
		JLabel label_4 = new JLabel("\u4FEE\u6539\u4EA7\u54C1\u4FE1\u606F");
		label_4.setFont(new Font("宋体", Font.PLAIN, 25));
		
		textField = new JTextField(pro.getName());
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		textField.setColumns(10);
		
		textField_1 = new JTextField(pro.getSubtitle());
		textField_1.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_1.setColumns(10);
		
		textField_2 = new JTextField(pro.getOriginalprice()+"");
		textField_2.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_2.setColumns(10);
		
		textField_3 = new JTextField(pro.getPromoteprice()+"");
		textField_3.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_3.setColumns(10);
		
		textField_4 = new JTextField(pro.getStock()+"");
		textField_4.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_4.setColumns(10);
		
		textField_5 = new JTextField(pro.getCreateDate()+"");
		textField_5.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_5.setColumns(10);
		
		
		
		JButton button = new JButton("\u4FDD\u5B58");
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Products pros=new Products();
				pros.setName(textField.getText());
				pros.setSubtitle(textField_1.getText());
				pros.setOriginalprice(Double.parseDouble(textField_2.getText()));
				pros.setPromoteprice(Double.parseDouble(textField_3.getText()));
				pros.setStock(Integer.parseInt(textField_4.getText()));
				pros.setCreateDate(textField_5.getText());
				pros.setId(pro.getId());
				ProductsDao prodao=new ProductsDao();
				prodao.upteproduct(pros);
				dispose();
				JOptionPane.showMessageDialog(null, "修改成功");
				
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 27));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(199)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_4)
								.addComponent(button)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(74)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(label_1)
								.addComponent(label_2)
								.addComponent(label_3))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textField_1)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
									.addComponent(textField_2)
									.addComponent(textField_4)
									.addComponent(textField_5))
								.addComponent(textField_3))))
					.addContainerGap(154, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(label_4)
					.addGap(89)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(69))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
