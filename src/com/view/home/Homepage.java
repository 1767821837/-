package com.view.home;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.model.shoppDao.Products;
import com.model.shoppDao.ProductsDao;
import com.model.shoppDao.categroy;
import com.model.userDao.User;
import com.util.Buttonzhezhi;
import com.view.qianduan.JFview;
import com.view.qianduan.Login;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.event.MouseAdapter;

public class Homepage extends JFrame {
	

	private JPanel contentPane;

	 int index=1;
	 private static ImageIcon homlogo;
	 private static ImageIcon background;
	
	 private JTextField textField;
	 static ProductsDao productsDao=new ProductsDao();
	 private static List<categroy> lists;
	 ImageIcon[] imgs = {
            new ImageIcon(Homepage.class.getResource("/images/homepage/轮播1.png")),
            new ImageIcon(Homepage.class.getResource("/images/homepage/轮播2.png")),
            new ImageIcon(Homepage.class.getResource("/images/homepage/轮播3.png")),
            new ImageIcon(Homepage.class.getResource("/images/homepage/轮播4.png"))
   };
	 private JTextField textField_1;

static {
	try { 
		
		lists=productsDao.categroy(); 
		
		background=new ImageIcon(Homepage.class.getResource("/images/homepage/background.jpg"));
		homlogo=new ImageIcon(Homepage.class.getResource("/images/homepage/logo.jpg"));
	} catch (Exception e) {
		// TODO: handle exception
	}
}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage(new User());
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
	public Homepage(User user) {
		setIconImage(new ImageIcon(JFview.class.getResource("/images/qianduan/logo.png")).getImage()); 
		System.out.println(user.toString());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 1500, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel = new JPanel();
		//菜单栏
		JList list=new JList();
		list.setFont(new Font("宋体",Font.BOLD, 30));

		list.setBounds(20, 0, 180, 700);
		String []str = new String[lists.size()];
		
		for(int i=0;i<lists.size();i++) {
			categroy cate=lists.get(i);
			str[i]=cate.getName();
		}
		list.setListData(str);
		list.setOpaque(false);
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int i=list.getSelectedIndex();
				String s=str[i];
				List<Products> listtt=productsDao.AllGoods(s);
				if(listtt.size()!=0) {
				
				LookShopping look=new LookShopping(user, s);
				look.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "没有该商品");
				}
			}
		});
		  ((JPanel)this.getContentPane()).setOpaque(false);
			
			panel_1.setOpaque(false);
		
		JPanel panel_2 = new JPanel();
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(0, 0, 1200, 90);
		lblNewLabel.setIcon(imgs[1]);
		panel_2.add(lblNewLabel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1472, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 1472, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 728, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel();
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				
				LookShopping look=new LookShopping(user,"");
				look.setVisible(true);
		
				
			}
		});
		label_1.setIcon(new ImageIcon(Homepage.class.getResource("/images/homepage/background.jpg")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(37)
					.addComponent(list)
					.addGap(43)
					.addComponent(label_1)
					.addContainerGap(386, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addComponent(list))
					.addContainerGap(205, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_1.setColumns(10);
		//搜索
		JButton button = new JButton("\u641C\u7D22");
		this.getRootPane().setDefaultButton(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str=textField_1.getText();
				List<Products> listtt=productsDao.AllGoods(str);
				if(listtt.size()!=0) {
				
				LookShopping look=new LookShopping(user, str);
				look.setVisible(true);
				textField_1.setText(null);
				}
				else {
					JOptionPane.showMessageDialog(null, "没有该商品");
				}
				
				
				
				
				
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 26));
		
		JLabel label = new JLabel("\u6B22\u8FCE\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel(user.getVipname());
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 17));
		
		JButton btnNewButton = new JButton("我的订单");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myorder my=new myorder(user);
				my.setVisible(true);
			}
		});
		
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		
		
		JButton btnNewButton_1 = new JButton("\u8D2D\u7269\u8F66");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shoppingcat1 shop=new shoppingcat1(user);
				shop.setVisible(true);
			}
		});
		
		
		JButton button_1 = new JButton("个人中心");
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		//设置按钮
		Buttonzhezhi.Button(button_1);
		Buttonzhezhi.Button(btnNewButton);
		Buttonzhezhi.Button(btnNewButton_1);
		button_1.setBorder(null);
		btnNewButton.setBorder(null);
		btnNewButton_1.setBorder(null);
		
		JPopupMenu popup=new JPopupMenu();
		
		JMenuItem jm=new JMenuItem("收货地址");
		JMenu jm1=new JMenu("安全设置");
		
		JMenuItem jm2=new JMenuItem("关于我们");
		JMenuItem jm4=new JMenuItem("修改密码");
		JMenuItem jm5=new JMenuItem("修改支付密码");
		JMenu jm6=new JMenu("退出");
		JMenuItem jm7=new JMenuItem("退出登录");
		JMenuItem jm8=new JMenuItem("退出程序");
		jm.setFont(new Font("宋体",Font.PLAIN,15));
		popup.add(jm);
		popup.add(jm1);
		popup.add(jm2);
		jm6.add(jm7);
		jm6.add(jm8);
		jm1.add(jm4);
		jm1.add(jm5);
		popup.add(jm6);
		
		 
		jm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Setings dialog = new Setings(user);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				
			}
		});
		jm4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Securityset frame = new Securityset(user,"修改登录密码");
				
				
				
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
			}
		});
		jm5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	Securityset frame = new Securityset(user,"修改支付密码");
				
			
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
			}
		});
		jm2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Aboutwe frame = new Aboutwe();
				frame.setVisible(true);
				 Timer timer = new Timer(3000,new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	frame.setVisible(false);
			            	frame.dispose();
			            }
			        });
			        timer.start();
			      // 30秒 后执行该任务  
			    
				
			}
		});
		
	button_1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				popup.show(button_1,e.getX(), e.getY());
			
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				popup.show(button_1,e.getX(), e.getY());
				
			}
		});
		jm7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 int res=JOptionPane.showConfirmDialog(null, "是否退出登录", "是否继续", JOptionPane.YES_NO_OPTION);
				                 if(res==JOptionPane.YES_OPTION){ 
				                       dispose();
				                       Login lo=new Login();
				                       lo.setVisible(true);
				               }
			}
		});
jm8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int res=JOptionPane.showConfirmDialog(null, "是否退出程序", "是否继续", JOptionPane.YES_NO_OPTION);
                if(res==JOptionPane.YES_OPTION){ 
                      System.exit(0);
              }
				
			}
		});
		
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addGap(393)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button)
					.addGap(131)
					.addComponent(btnNewButton)
					.addGap(36)
					.addComponent(btnNewButton_1)
					.addGap(35)
					.addComponent(button_1)
					.addContainerGap(133, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(label)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(button)
							.addComponent(btnNewButton)
							.addComponent(button_1)
							.addComponent(btnNewButton_1)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		 Timer timer = new Timer(2000,new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	lblNewLabel.setIcon(imgs[index%imgs.length]);
	            	index++;
	            	lblNewLabel.repaint();
	            }
	        });
	        timer.start();
		
	}
}
