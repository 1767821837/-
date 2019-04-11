package com.view.home;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.userDao.User;
import com.model.userDao.userDao;
import com.view.qianduan.JFview;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * 收货地址
 * @author 17678
 *
 */
public class Setings extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultComboBoxModel model = new DefaultComboBoxModel();
	private DefaultComboBoxModel model1 = new DefaultComboBoxModel();
	private DefaultComboBoxModel model2 = new DefaultComboBoxModel();
	private String [] paovince = {"四川","重庆"};
	private String [] city_1 = {"成都市","乐山市","宜宾市"};
	private String [] city_2= {"重庆市"};
	
	private String [] city_1county_1 = { "锦江区","青羊区","金牛区","武侯区",
			"成华区","龙泉驿区","青白江区","新都区","温江县",
			"金堂县","双流县","郫县","大邑县","蒲江县","新津县"};
	private String  [] city_1county_2= {
			"市中区","沙湾区","五通桥区",
			"金口河区","犍为县","井研县","夹江县",
			"沐川县","峨眉山"		
	};
	private String  [] city_1county_3= {
			"宜宾县","南溪县","江安县","长宁县","高　县","珙　县","筠连县","兴文县"		
	};
	private String  [] city_2county_1= {
			"万州区","涪陵区","渝中区","大渡口区","江北区","沙坪坝区"	
	};
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox com_1;
	private JComboBox com_2;
	private JComboBox com_3;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			
			Setings dialog = new Setings(new User());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	/**
	 * Create the dialog.
	 */
	public Setings(User user) {
		setIconImage(new ImageIcon(JFview.class.getResource("/images/qianduan/logo.png")).getImage()); 
		setBounds(100, 100, 501, 618);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u6536\u8D27\u4EBA\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("\u6240\u5728\u5730\u533A\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
	
		
		JLabel label_3 = new JLabel("\u8BE6\u7EC6\u5730\u5740\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_4 = new JLabel("\u90AE\u7F16\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));
		
		textField = new JTextField(user.getPost());
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		textField.setColumns(10);
		
		textField_1 = new JTextField(user.getMobile());
		textField_1.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_1.setColumns(10);
		
		textField_2 = new JTextField(user.getReceiver());
		textField_2.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_3.setColumns(10);
		
		for (int i = 0, n = paovince.length; i < n; i++) {
			 model.addElement(paovince[i]);
		}
		com_1= new JComboBox(model);
	com_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox source = (JComboBox) e.getSource();
				String s = (String) source.getSelectedItem();
				try {
				if(s.equals("四川")) {
					model1.removeAllElements();
					for (int i = 0; i < city_1.length; i++) {
						model1.addElement(city_1[i]);
						}
					model2.removeAllElements();
					for (int i = 0; i < city_1county_1.length; i++) {
						model2.addElement(city_1county_1[i]);
						}
					}else if(s.equals("重庆"))
							{
						model1.removeAllElements();
						for (int i = 0; i < city_2.length; i++) {
							model1.addElement(city_2[i]);
						
						}
						model2.removeAllElements();
						for (int i = 0; i < city_2county_1.length; i++) {
							model2.addElement(city_2county_1[i]);
						
						}
						
						}else {
							System.out.println("asd");
						}
				
			} catch (Exception e1) {
				System.out.println(e1);
			}}
		
	});
	
	for (int i = 0; i < city_1.length; i++) {
		model1.addElement(city_1[i]);
		}	
	com_2= new JComboBox(model1);
		com_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox source = (JComboBox) e.getSource();
				String m = (String) source.getSelectedItem();
				if(m.equals("成都市")) {
					model2.removeAllElements();
					for (int i = 0; i < city_1county_1.length; i++) {
						model2.addElement(city_1county_1[i]);
						
						}
					}else if(m.equals("乐山市"))
							{
						model2.removeAllElements();
						for (int i = 0; i < city_1county_2.length; i++) {
							model2.addElement(city_1county_2[i]);
						
						}}
					else if(m.equals("宜宾市")){
						model2.removeAllElements();
						for (int i = 0; i < city_1county_3.length; i++) {
							model2.addElement(city_1county_3[i]);
						}
					}
						else {
							model2.removeAllElements();
							for (int i = 0; i < city_2county_1.length; i++) {
								model2.addElement(city_2county_1[i]);
						}
						}
		
				
				
			}
			
		});
		for (int i = 0; i < city_1county_1.length; i++) {
			model2.addElement(city_1county_1[i]);
			
			}
		com_3= new JComboBox(model2);
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField_2.getText().length()>0) {
					if(textField_1.getText().length()>0) {
						if(textField.getText().length()>0) {
							if(textField_3.getText().length()>0) {
								user.setAddress(com_1.getSelectedItem().toString()+com_2.getSelectedItem().toString()+com_3.getSelectedItem().toString()+textField_3.getText());
								user.setMobile(textField_1.getText());
								user.setPost(textField.getText());
								user.setReceiver(textField_2.getText());
								System.out.println(user.toString());
								userDao userdao=new userDao();
								userdao.updateaddress(user); 
								System.out.println(user.toString());
								JOptionPane.showMessageDialog(null, "保存成功");
								dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "请输入详细地址");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "请输入邮编");
						}
					}else {
						JOptionPane.showMessageDialog(null, "请输入电话号码");
					}
				}else {
					JOptionPane.showMessageDialog(null, "请输入收获人");
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 25));
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(label)
								.addComponent(label_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
									.addComponent(label_4)
									.addComponent(label_2))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
									.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
										.addComponent(com_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(com_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(com_3, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED))))
							.addComponent(label_3)))
					.addGap(129))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(159)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(252, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(93)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(com_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(com_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(com_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(81)
					.addComponent(btnNewButton)
					.addContainerGap(60, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
