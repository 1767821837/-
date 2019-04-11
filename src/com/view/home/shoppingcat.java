package com.view.home;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class shoppingcat extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			shoppingcat dialog = new shoppingcat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public shoppingcat() {
		setSize(850,611);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JPanel jp=new JPanel();
		
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel("\u5546\u54C1\u4FE1\u606F");
		
		JLabel label_1 = new JLabel("\u5355\u4EF7");
		
		JLabel label_2 = new JLabel("\u6570\u91CF");
		
		JLabel label_3 = new JLabel("\u91D1\u989D");
//		  JTabbedPane tp = new JTabbedPane();
//		  tp.add(contentPanel);
//		  tp.add(jp);
//		
//		  tp.setTitleAt(0, "购物车");
//	        tp.setTitleAt(1, "我的订单");
//	        tp.setFont(new Font("宋体", Font.PLAIN, 22));
//	        setContentPane(tp);
//		
		for(int i=0;i<10;i++) {
		
		}
		
		
		
		
		
		
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(159)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
					.addComponent(label_1)
					.addGap(177)
					.addComponent(label_2)
					.addGap(60)
					.addComponent(label_3)
					.addGap(81))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_3)
						.addComponent(label_2)
						.addComponent(label_1))
					.addGap(47)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(388, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(shoppingcat.class.getResource("/images/homepage/img/productSingle_small/10157.jpg")));
		lblNewLabel_1.setBounds(39, 13, 64, 57);
		panel.setLayout(null);
		panel.add(lblNewLabel_1);
		contentPanel.setLayout(gl_contentPanel);
	}
}
