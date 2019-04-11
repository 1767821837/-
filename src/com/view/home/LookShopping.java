package com.view.home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.shoppDao.Products;
import com.model.shoppDao.ProductsDao;
import com.model.userDao.User;
import com.util.Buttonzhezhi;
import com.view.qianduan.Findpasword;
import com.view.qianduan.JFview;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;

public class LookShopping extends JFrame{

	private JPanel contentPane;
	private JLabel txtHi;
	private JTextField textField;
	private JButton button_1;
	private ProductsDao pr=new ProductsDao();
	private User user=new User();
	private Products pro;
	int i=0;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private  int curentPageIndex=1;        //当前页码                    
	private  int countPerpage=10;        //每页显示条数  
	private  int pageCount;           //总页数  
	private  int recordCount;           //总记录条数  
	private JPanel showshopping;
	private JPanel panel;
	JLabel label_1 ;
	private int num;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User user=new User();
					
					LookShopping frame = new LookShopping(user,"鞋");
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
	public LookShopping(User users,String sousuo) {  
		setIconImage(new ImageIcon(JFview.class.getResource("/images/qianduan/logo.png")).getImage()); 
		user=users;
		
		setSize( 1750, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		panel = new JPanel();
	
		List<Products> list=pr.AllGoods(sousuo);
		
		recordCount= list.size();
		
		if(recordCount!=0) {
		if(recordCount%countPerpage==0) {
			pageCount=recordCount/countPerpage;
		}else {
			pageCount =recordCount/countPerpage+1;
		}
		if(curentPageIndex==pageCount) {
		num=list.size();
		}
		else {
			num=curentPageIndex*10;
		}
		for( i=(curentPageIndex-1)*10;i<num;i++) {
			 showshopping=new JPanel();
			JLabel jl=new JLabel();
			showshopping.setLayout(null );
			 pro=list.get(i);
		
			
			jl.setIcon(new ImageIcon("src\\images\\homepage\\img\\productSingle_middle\\"+pro.getId()+".jpg"));
			JLabel jl1=new JLabel(pro.getName());
			jl1.setBounds(0, 200, 200, 80);
			 jl.setBounds(0, 0, 220, 190);
			jl1.setFont(new Font("宋体", Font.PLAIN, 15));
			JLabel qian=new JLabel();
			//价格if()
			JLabel jl3=new JLabel("¥");
			jl3.setFont(new Font("宋体",Font.BOLD,25));
			jl3.setBounds(0, 280, 150, 30);
			jl3.setForeground(Color.RED);
			JLabel jl4=new JLabel(pro.getPromoteprice()+"");
			jl4.setFont(new Font("宋体",Font.BOLD,25));
			jl4.setBounds(20, 280, 150, 30);
			jl4.setForeground(Color.RED);
			
			showshopping.add(jl4);
			showshopping.add(jl);
			showshopping.add(jl1);
			showshopping.add(jl3);
			if(pro.getStock()!=0) {
	
			showshopping.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					String s=jl1.getText();
					for(Products str:list) {
						if(str.getName().equals(s)) {
							watchShopping watch=new watchShopping(user,str);
							watch.setVisible(true);
						}
						
						
						
					}
//					
					
				}
			});
			}else {
				showshopping.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					JOptionPane.showMessageDialog(null, "商品已下架，无法购买");

					}
				});
				jl3.setText("已下架");
				jl4.setText(null);
				
			}
				panel.add(showshopping);
				panel.updateUI();
				repaint();
				
		}
		}
		else{
			JOptionPane.showMessageDialog(null, "没有该商品");
			dispose();
		}
		//回到主页
		JButton button = new JButton("\u5929\u732B\u9996\u9875");
		button.setIcon(new ImageIcon(LookShopping.class.getResource("/images/homepage/home1.png")));
		Buttonzhezhi.Button(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		
		txtHi = new JLabel();
		txtHi.setText("Hi,"+user.getVipname());
		txtHi.setFont(new Font("宋体", Font.PLAIN, 18));
		
		txtHi.setOpaque(false);
		txtHi.setBorder(null);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		textField.setColumns(10);
		//搜索
		button_1 = new JButton("\u641C\u7D22");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=textField.getText();
				textField.setText(null);
				List<Products> listsss=pr.AllGoods(s);
				if(listsss.size()!=0) {
					
					LookShopping lo=new LookShopping(user, s);
					lo.setVisible(true);
				dispose();
				
				}
				else {
					JOptionPane.showMessageDialog(null, "没有该类商品");
					
				}
				
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 25));
		
		btnNewButton = new JButton("\u4E0A\u4E00\u9875");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				curentPageIndex--;
				if(curentPageIndex<1) {
					JOptionPane.showMessageDialog(null, "没有上一页");
					curentPageIndex++;
				}
				
				else {
					 label_1.setText(curentPageIndex+"");
					panel.removeAll();
					for( i=(curentPageIndex-1)*10;i<curentPageIndex*10;i++) {
						 showshopping=new JPanel();
						 showshopping.setLayout(null);
						JLabel jl=new JLabel();
					
						 pro=list.get(i);
					
						 
						jl.setIcon(new ImageIcon("src\\images\\homepage\\img\\productSingle_middle\\"+pro.getId()+".jpg"));
						JLabel jl1=new JLabel(pro.getName());
						
						jl1.setFont(new Font("宋体", Font.PLAIN, 15));
						JLabel qian=new JLabel();
						jl1.setBounds(0, 200, 200, 80);
						 jl.setBounds(0, 0, 220, 190);
						JLabel jl3=new JLabel("¥");
						jl3.setFont(new Font("宋体",Font.BOLD,25));
						jl3.setBounds(0, 280, 150, 30);
						jl3.setForeground(Color.RED);
						JLabel jl4=new JLabel(pro.getPromoteprice()+"");
						jl4.setFont(new Font("宋体",Font.BOLD,25));
						jl4.setBounds(20, 280, 150, 30);
						jl4.setForeground(Color.RED);
						
						showshopping.add(jl4);
						showshopping.add(jl);
						showshopping.add(jl3);
						showshopping.add(jl1);
						if(pro.getStock()!=0) {
						showshopping.addMouseListener(new MouseListener() {
							
							@Override
							public void mouseReleased(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void mousePressed(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void mouseExited(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void mouseEntered(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void mouseClicked(MouseEvent e) {
								String s=jl1.getText();
								for(Products str:list) {
									if(str.getName().equals(s)) {
										watchShopping watch=new watchShopping(user,str);
										watch.setVisible(true);
									}
									
									
									
								}
//								
								
							}
						});
					}else {
						showshopping.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
							JOptionPane.showMessageDialog(null, "商品已下架，无法购买");

							}
						});
						jl3.setText("已下架");
						jl4.setText(null);
					}
						
							panel.add(showshopping);
							panel.repaint();
					}
				}
			}
		});
		
		btnNewButton_1 = new JButton("\u4E0B\u4E00\u9875");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 25));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				curentPageIndex++;
				if(curentPageIndex>pageCount) {
					JOptionPane.showMessageDialog(null, "没有下一页");
					curentPageIndex--;
				}
				
				else {
					label_1.setText(curentPageIndex+"");
					panel.removeAll();
					if(curentPageIndex==pageCount) {
						
						for( i=(curentPageIndex-1)*10;i<recordCount;i++) {
							 showshopping=new JPanel();
							 showshopping.setLayout(null);
							JLabel jl=new JLabel();
						
							 pro=list.get(i);
						
							 jl.setBounds(0, 0, 200, 100);
							jl.setIcon(new ImageIcon("src\\images\\homepage\\img\\productSingle_middle\\"+pro.getId()+".jpg"));
							JLabel jl1=new JLabel(pro.getName());
							jl1.setBounds(0, 200, 200, 80);
							 jl.setBounds(0, 0, 220, 190);
							jl1.setFont(new Font("宋体", Font.PLAIN, 15));
							JLabel qian=new JLabel();
							
							JLabel jl3=new JLabel("¥");
							jl3.setFont(new Font("宋体",Font.BOLD,25));
							jl3.setBounds(0, 280, 150, 30);
							jl3.setForeground(Color.RED);
							JLabel jl4=new JLabel(pro.getPromoteprice()+"");
							jl4.setFont(new Font("宋体",Font.BOLD,25));
							jl4.setBounds(20, 280, 150, 30);
							jl4.setForeground(Color.RED);
							
							showshopping.add(jl4);
							showshopping.add(jl);
							showshopping.add(jl3);
							showshopping.add(jl1);
							if(pro.getStock()!=0) {
								
							
							showshopping.addMouseListener(new MouseListener() {
								
								@Override
								public void mouseReleased(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mousePressed(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseExited(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseEntered(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseClicked(MouseEvent e) {
									String s=jl1.getText();
									for(Products str:list) {
										if(str.getName().equals(s)) {
											watchShopping watch=new watchShopping(user,str);
											watch.setVisible(true);
										}
										
										
										
									}
//									
									
								}
							});
							}else {
								showshopping.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
									JOptionPane.showMessageDialog(null, "商品已下架，无法购买");

									}
								});
								jl3.setText("已下架");
								jl4.setText(null);
							}
						
							
							panel.add(showshopping);
							panel.updateUI();
								
							
						}
					}
					else {
						label_1.setText(curentPageIndex+"");
					for( i=(curentPageIndex-1)*10;i<curentPageIndex*10;i++) {
						 showshopping=new JPanel();
						JLabel jl=new JLabel();
						showshopping.setLayout(null);
						 pro=list.get(i);
					
						 jl.setBounds(0, 0, 200, 100);
						jl.setIcon(new ImageIcon("src\\images\\homepage\\img\\productSingle_middle\\"+pro.getId()+".jpg"));
						JLabel jl1=new JLabel(pro.getName());
						jl1.setBounds(0, 200, 200, 80);
						 jl.setBounds(0, 0, 220, 190);
						jl1.setFont(new Font("宋体", Font.PLAIN, 15));
						JLabel qian=new JLabel();
						JLabel jl3=new JLabel("¥");
						jl3.setFont(new Font("宋体",Font.BOLD,25));
						jl3.setBounds(0, 280, 150, 30);
						jl3.setForeground(Color.RED);
						JLabel jl4=new JLabel(pro.getPromoteprice()+"");
						jl4.setFont(new Font("宋体",Font.BOLD,25));
						jl4.setBounds(20, 280, 150, 30);
						jl4.setForeground(Color.RED);
						
						showshopping.add(jl4);
						showshopping.add(jl);
						showshopping.add(jl3);
						showshopping.add(jl1);
						
					if(pro.getStock()!=0) {
						showshopping.addMouseListener(new MouseListener() {
							
							@Override
							public void mouseReleased(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void mousePressed(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void mouseExited(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void mouseEntered(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void mouseClicked(MouseEvent e) {
								String s=jl1.getText();
								for(Products str:list) {
									if(str.getName().equals(s)) {
										watchShopping watch=new watchShopping(user,str);
										watch.setVisible(true);
									}
									
									
									
								}
//								
								
							}
						});
					}else {
						showshopping.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
							JOptionPane.showMessageDialog(null, "商品已下架，无法购买");

							}
						});
						jl3.setText("已下架");
						jl4.setText(null);
					}
							panel.add(showshopping);
							panel.updateUI();
						
					}}
				}
			}
		});
		
		JLabel label = new JLabel("/");
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		
		 label_1 = new JLabel(curentPageIndex+"");
		
		JLabel label_2 = new JLabel(pageCount+"");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(button)
					.addGap(18)
					.addComponent(txtHi, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addGap(388)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(button_1)
					.addContainerGap(640, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(739, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(67)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_2)
					.addGap(39)
					.addComponent(btnNewButton_1)
					.addGap(588))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1722, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(button)
							.addComponent(txtHi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(48)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 713, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(label_1)
						.addComponent(label)
						.addComponent(btnNewButton_1)
						.addComponent(label_2))
					.addGap(57))
		);
		panel.setLayout(new GridLayout(2,5));
		contentPane.setLayout(gl_contentPane);
	}
}