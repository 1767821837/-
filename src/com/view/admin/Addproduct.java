package com.view.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.shoppDao.Products;
import com.model.shoppDao.ProductsDao;
import com.model.shoppDao.categroy;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Addproduct extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private ProductsDao prodao=new ProductsDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Addproduct dialog = new Addproduct();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Addproduct() {
		setSize( 614, 671);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		JLabel label = new JLabel("\u589E\u52A0\u5546\u54C1");
		label.setFont(new Font("宋体", Font.PLAIN, 30));
		JLabel label_1 = new JLabel("\u5546\u54C1\u5206\u7C7B\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		JLabel label_2 = new JLabel("\u5546\u54C1\u6807\u9898\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("\u5C0F\u6807\u9898\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_4 = new JLabel("\u539F\u4EF7\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_5 = new JLabel("\u73B0\u4EF7\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_6 = new JLabel("\u5E93\u5B58\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_7 = new JLabel("\u751F\u4EA7\u65E5\u671F\uFF1A");
		label_7.setFont(new Font("宋体", Font.PLAIN, 18));
		//分类
		List<categroy> catgroy= prodao.categroy();
		
		String []obj=new String [catgroy.size()];
		for(int i=0;i<catgroy.size();i++) {
			obj[i]=catgroy.get(i).getName();
		}
		JComboBox comboBox = new JComboBox(obj);
		comboBox.setFont(new Font("宋体", Font.PLAIN, 18));
		//标题
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		textField.setColumns(10);
		//小标题
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		//原价
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_2.setColumns(10);
		//现价
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_3.setColumns(10);
		//库存
		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_4.setColumns(10);
		//shijian
		textField_5 = new JTextField();
		textField_5.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_5.setColumns(10);
		
		JButton button = new JButton("\u4FDD\u5B58");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_5.getText().length()!=0&&textField_4.getText().length()!=0&&textField_3.getText().length()!=0&&textField_2.getText().length()!=0&&textField.getText().length()!=0) {
				Products pro = new Products();
				pro.setName(textField.getText());
				pro.setSubtitle(textField_1.getText());
				pro.setOriginalprice(Double.parseDouble(textField_2.getText()));
				pro.setPromoteprice(Double.parseDouble(textField_3.getText()));
				for(int i=0;i<catgroy.size();i++) {
					if(comboBox.getSelectedItem()==catgroy.get(i).getName()) {
					pro.setCid(catgroy.get(i).getId());	
					}
				}
				pro.setStock(Integer.parseInt(textField_4.getText()));
				pro.setCreateDate(textField_5.getText());
				
				prodao.addproduct(pro);
				
				
				int res=JOptionPane.showConfirmDialog(null, "添加成功", "是否继续添加", JOptionPane.YES_NO_OPTION);
	              if(res==JOptionPane.YES_OPTION){ 
	            	  textField.setText(null);
	            	  textField_1.setText(null);
	            	  textField_2.setText(null);
	            	  textField_3.setText(null);
	            	  textField_4.setText(null);
	            	  textField_5.setText(null);
	              
	              }else {
	            	  dispose();
	              }
				
				
			}else {
				JOptionPane.showMessageDialog(null, "信息不能为空");
			}
				}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 30));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(226)
							.addComponent(label))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(94)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_2)
								.addComponent(label_1)
								.addComponent(label_3)
								.addComponent(label_4)
								.addComponent(label_5)
								.addComponent(label_6)
								.addComponent(label_7))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_2)
								.addComponent(textField_1)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textField_5)
									.addComponent(textField_4)
									.addComponent(textField_3)
									.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)))))
					.addContainerGap(134, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(230)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(229, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(51)
					.addComponent(label)
					.addGap(51)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_7)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addComponent(button)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
