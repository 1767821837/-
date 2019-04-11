package com.view.home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import com.model.shoppDao.Products;
import com.model.shoppDao.ProductsDao;
import com.model.shoppDao.order_;
import com.model.shoppDao.order_Dao;
import com.model.userDao.User;
import com.view.qianduan.JFview;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JSpinner;
import javax.swing.JTabbedPane;

public class shoppingcat1 extends JFrame {

	private JPanel contentPane;
	private order_ ord;
	private order_Dao orderdao=new order_Dao();
	private  int curentPageIndex=1;        //当前页码                    
	private  int countPerpage=5;        //每页显示条数  
	private  int pageCount;           //总页数  
	private  int recordCount;           //总记录条数  
	private int num;
	private boolean  bool=false;
	private	JPanel jp ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shoppingcat1 frame = new shoppingcat1(new User());
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
	public shoppingcat1(User user) {
		
		setIconImage(new ImageIcon(JFview.class.getResource("/images/qianduan/logo.png")).getImage()); 
		JLabel lblNewLabel = new JLabel(curentPageIndex+"/"+pageCount);
	        
		List<order_> list=orderdao.finduserordercar(user,"购物车");
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
			num=curentPageIndex*5;
		}
		}
//		setDefaultCloseOperation(JFrame.);
		setSize(818, 697);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.addMouseListener(new MouseListener() {
			
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
//				if(bool) {
//					setVisible(false);
//				dispose();	
//			}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				bool=true;
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			
			
				
			}
		});
		JLabel label = new JLabel("\u5546\u54C1\u4FE1\u606F");
		
		JLabel label_1 = new JLabel("\u5355\u4EF7");
		
		JLabel label_2 = new JLabel("\u6570\u91CF");
	
		
		JLabel label_3 = new JLabel("\u91D1\u989D");
		
		JPanel panel_1 = new JPanel();
	
		System.out.println(list.size());
		for(int i=(curentPageIndex-1)*5;i<num;i++) {
			jp=new JPanel();
			jp.setSize(new Dimension(600, 70));
			jp.setLayout(null);
			ord=list.get(i);
			ProductsDao prodao=new ProductsDao();
			Products progoods=	prodao.findgoods(ord.getName());
				//图片
				JLabel jl=new JLabel();
				jl.setIcon(new ImageIcon("src\\images\\homepage\\img\\productSingle_small\\"+progoods.getId()+".jpg"));
			jl.setBounds(10, 0, 60, 60);
			//单价
			JLabel  jl2=new JLabel(ord.getPrice()+"");
			jl2.setFont(new Font("宋体",Font.PLAIN,25));
			jl2.setForeground(Color.RED);
			jl2.setBounds(370, 0, 100, 26);
			//名称
			JLabel jl1=new JLabel(ord.getName());
			jl1.setBounds(80, 0, 250, 60);
			//数量
			JSpinner js=new JSpinner();
			js.setBounds(500, 10, 60, 30);
			js.setValue(ord.getNumber());
			JLabel jl3=new JLabel();
			
			//金额
			
			JLabel jl4=new JLabel(ord.getMoney()+"");
			jl4.setFont(new Font("宋体",Font.PLAIN,25));
			jl4.setForeground(Color.RED);
			jl4.setBounds(580, 0, 150, 26);
			JButton jb=new JButton("删除");
			jb.setBounds(690, 0, 60, 30);
			jb.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {

					int res=JOptionPane.showConfirmDialog(null, "确认删除？", "是否继续", JOptionPane.YES_NO_OPTION);
					              if(res==JOptionPane.YES_OPTION){ 
					                  order_Dao orddao=new order_Dao();
					                		  String s= jl1.getText();
					                		  order_ order=new order_();
					                		  order.setName(s);
					                		  order.setUid(ord.getUid());
					                		  order.setStatus("购物车");
//					                		 orddao.deleteordercar();
					                		  orddao.deleteordercar(order);
					                		  dispose();
					                		  shoppingcat1 shoppin=new shoppingcat1(user);
					                		  shoppin.setVisible(true);		            	  
					                }
					             
					
				}
			});
			jp.add(jl);
			jp.add(jl1);
			jp.add(jl2);
			jp.add(js);
			jp.add(jl3);
			jp.add(jl4);
			jp.add(jb);
			panel_1.add(jp);
			js.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					jl4.setText(ord.getPrice()*(int)js.getValue()+"");
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					jl4.setText(ord.getPrice()*(int)js.getValue()+"");
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					jl4.setText(ord.getPrice()*(int)js.getValue()+"");
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					jl4.setText(ord.getPrice()*(int)js.getValue()+"");
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					jl4.setText(ord.getPrice()*(int)js.getValue()+"");
					
				}
			});
		
			jp.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String s=jl1.getText();
					ProductsDao prodao=new ProductsDao();
					Products pro=prodao.findgoods(s);
					System.out.println(s);
					watchShopping whtch=new watchShopping(user, pro);
					whtch.setVisible(true);
					
					
				}
			});
			
		}
		//上一页
		JButton btnNewButton = new JButton("\u4E0A\u4E00\u9875");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				curentPageIndex--;
				if(curentPageIndex<1) {
					JOptionPane.showMessageDialog(null, "没有上一页");
					curentPageIndex++;
				}else {
					panel_1.removeAll();
					for(int i=(curentPageIndex-1)*5;i<curentPageIndex*5;i++) {
						lblNewLabel.setText(curentPageIndex+"/"+pageCount);
						jp=new JPanel();
						jp.setSize(new Dimension(600, 70));
						jp.setLayout(null);
						ord=list.get(i);
						//图片
						ProductsDao prodao=new ProductsDao();
						Products progoods=	prodao.findgoods(ord.getName());
							//图片
							JLabel jl=new JLabel();
							jl.setIcon(new ImageIcon("src\\images\\homepage\\img\\productSingle_small\\"+progoods.getId()+".jpg"));
						jl.setBounds(10, 0, 60, 60);
						//单价
						JLabel  jl2=new JLabel(ord.getPrice()+"");
						jl2.setFont(new Font("宋体",Font.PLAIN,25));
						jl2.setForeground(Color.RED);
						jl2.setBounds(370, 0, 100, 26);
						//名称
						JLabel jl1=new JLabel(ord.getName());
						jl1.setBounds(80, 0, 250, 60);
						//数量
						JSpinner js=new JSpinner();
						js.setBounds(500, 10, 60, 30);
						js.setValue(ord.getNumber());
						JLabel jl3=new JLabel();
						
						//金额
						
						JLabel jl4=new JLabel(ord.getMoney()+"");
						jl4.setFont(new Font("宋体",Font.PLAIN,25));
						jl4.setForeground(Color.RED);
						jl4.setBounds(580, 0, 150, 26);
						JButton jb=new JButton("删除");
						jb.setBounds(690, 0, 60, 30);
						jb.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								
								int res=JOptionPane.showConfirmDialog(null, "确认删除？", "是否继续", JOptionPane.YES_NO_OPTION);
								              if(res==JOptionPane.YES_OPTION){ 
								                  order_Dao orddao=new order_Dao();
								                		  String s= jl1.getText();
								                		  order_ order=new order_();
								                		  order.setName(s);
								                		  order.setUid(ord.getUid());
								                		  order.setStatus("购物车");
//								                		 orddao.deleteordercar();
								                		  orddao.deleteordercar(order);
								                		  dispose();
								                		  shoppingcat1 shoppin=new shoppingcat1(user);
								                		  shoppin.setVisible(true);		            	  
								                }
								             
								
							}
						});
						jp.add(jl);
						jp.add(jl1);
						jp.add(jl2);
						jp.add(js);
						jp.add(jl3);
						jp.add(jl4);
						jp.add(jb);
						panel_1.add(jp);
						panel_1.updateUI();
						js.addMouseListener(new MouseListener() {
							
							@Override
							public void mouseReleased(MouseEvent e) {
								jl4.setText(ord.getPrice()*(int)js.getValue()+"");
								
							}
							
							@Override
							public void mousePressed(MouseEvent e) {
								jl4.setText(ord.getPrice()*(int)js.getValue()+"");
								
							}
							
							@Override
							public void mouseExited(MouseEvent e) {
								jl4.setText(ord.getPrice()*(int)js.getValue()+"");
								
							}
							
							@Override
							public void mouseEntered(MouseEvent e) {
								jl4.setText(ord.getPrice()*(int)js.getValue()+"");
								
							}
							
							@Override
							public void mouseClicked(MouseEvent e) {
								jl4.setText(ord.getPrice()*(int)js.getValue()+"");
								
							}
						});
					
						jp.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								String s=jl1.getText();
								ProductsDao prodao=new ProductsDao();
								Products pro=prodao.findgoods(s);
								System.out.println(s);
								watchShopping whtch=new watchShopping(user, pro);
								whtch.setVisible(true);
								
								
							}
						});
						
					}
				}
				
			}
		});
	//下一页
		JButton btnNewButton_1 = new JButton("\u4E0B\u4E00\u9875");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				curentPageIndex++;
				if(curentPageIndex>pageCount) {
					JOptionPane.showMessageDialog(null, "没有下一页");
					curentPageIndex--;
				}else if(curentPageIndex==pageCount){
					panel_1.removeAll();
			
					for(int i=(curentPageIndex-1)*5;i<list.size();i++) {
						lblNewLabel.setText(curentPageIndex+"/"+pageCount);
						jp=new JPanel();
						jp.setSize(new Dimension(600, 70));
						jp.setLayout(null);
						ord=list.get(i);
						ProductsDao prodao=new ProductsDao();
						Products progoods=	prodao.findgoods(ord.getName());
							//图片
							JLabel jl=new JLabel();
							jl.setIcon(new ImageIcon("src\\images\\homepage\\img\\productSingle_small\\"+progoods.getId()+".jpg"));
						jl.setBounds(10, 0, 60, 60);
						//单价
						JLabel  jl2=new JLabel(ord.getPrice()+"");
						jl2.setFont(new Font("宋体",Font.PLAIN,25));
						jl2.setForeground(Color.RED);
						jl2.setBounds(370, 0, 100, 26);
						//名称
						JLabel jl1=new JLabel(ord.getName());
						jl1.setBounds(80, 0, 250, 60);
						//数量
						JSpinner js=new JSpinner();
						js.setBounds(500, 10, 60, 30);
						js.setValue(ord.getNumber());
						JLabel jl3=new JLabel();
						
						//金额
						
						JLabel jl4=new JLabel(ord.getMoney()+"");
						jl4.setFont(new Font("宋体",Font.PLAIN,25));
						jl4.setForeground(Color.RED);
						jl4.setBounds(580, 0, 150, 26);
						JButton jb=new JButton("删除");
						jb.setBounds(690, 0, 60, 30);
						jb.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								String s=jl1.getText();
								System.out.println(s);
								int res=JOptionPane.showConfirmDialog(null, "确认删除？", "是否继续", JOptionPane.YES_NO_OPTION);
								            
								if(res==JOptionPane.YES_OPTION){ 
								                  order_Dao orddao=new order_Dao();
								                		 
								                		  order_ order=new order_();
								                		  order.setName(s);
								                		  order.setUid(user.getId()+"");
								                		  order.setStatus("购物车");
//								                		 orddao.deleteordercar();
								                		  orddao.deleteordercar(order);
								                		  jp.removeAll();
								                		  panel_1.updateUI();            	  
								                }
								             
								
							}
						});
						jp.add(jl);
						jp.add(jl1);
						jp.add(jl2);
						jp.add(js);
						jp.add(jl3);
						jp.add(jl4);
						jp.add(jb);
						panel_1.add(jp);
						panel_1.updateUI();
						js.addMouseListener(new MouseListener() {
							
							@Override
							public void mouseReleased(MouseEvent e) {
								jl4.setText(ord.getPrice()*(int)js.getValue()+"");
								
							}
							
							@Override
							public void mousePressed(MouseEvent e) {
								jl4.setText(ord.getPrice()*(int)js.getValue()+"");
								
							}
							
							@Override
							public void mouseExited(MouseEvent e) {
								jl4.setText(ord.getPrice()*(int)js.getValue()+"");
								
							}
							
							@Override
							public void mouseEntered(MouseEvent e) {
								jl4.setText(ord.getPrice()*(int)js.getValue()+"");
								
							}
							
							@Override
							public void mouseClicked(MouseEvent e) {
								jl4.setText(ord.getPrice()*(int)js.getValue()+"");
								
							}
						});
					
						jp.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								String s=jl1.getText();
								ProductsDao prodao=new ProductsDao();
								Products pro=prodao.findgoods(s);
								System.out.println(s);
								watchShopping whtch=new watchShopping(user, pro);
								whtch.setVisible(true);
								
								
							}
						});
				}
				}	else {
					panel_1.removeAll();
					for(int i=(curentPageIndex-1)*5;i<curentPageIndex*5;i++) {
						
						lblNewLabel.setText(curentPageIndex+"/"+pageCount);
						jp=new JPanel();
						jp.setSize(new Dimension(600, 70));
						jp.setLayout(null);
						ord=list.get(i);
						ProductsDao prodao=new ProductsDao();
						Products progoods=	prodao.findgoods(ord.getName());
							//图片
							JLabel jl=new JLabel();
							jl.setIcon(new ImageIcon("src\\images\\homepage\\img\\productSingle_small\\"+progoods.getId()+".jpg"));
						jl.setBounds(10, 0, 60, 60);
						//单价
						JLabel  jl2=new JLabel(ord.getPrice()+"");
						jl2.setFont(new Font("宋体",Font.PLAIN,25));
						jl2.setForeground(Color.RED);
						jl2.setBounds(370, 0, 100, 26);
						//名称
						JLabel jl1=new JLabel(ord.getName());
						jl1.setBounds(80, 0, 250, 60);
						//数量
						JSpinner js=new JSpinner();
						js.setBounds(500, 10, 60, 30);
						js.setValue(ord.getNumber());
						JLabel jl3=new JLabel();
						
						//金额
						
						JLabel jl4=new JLabel(ord.getMoney()+"");
						jl4.setFont(new Font("宋体",Font.PLAIN,25));
						jl4.setForeground(Color.RED);
						jl4.setBounds(580, 0, 150, 26);
						JButton jb=new JButton("删除");
						jb.setBounds(690, 0, 60, 30);
						jb.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								
								int res=JOptionPane.showConfirmDialog(null, "确认删除？", "是否继续", JOptionPane.YES_NO_OPTION);
								              if(res==JOptionPane.YES_OPTION){ 
								                  order_Dao orddao=new order_Dao();
								                		  String s= jl1.getText();
								                		  order_ order=new order_();
								                		  order.setName(s);
								                		  order.setUid(ord.getUid());
								                		  order.setStatus("购物车");
//								                		 orddao.deleteordercar();
								                		  orddao.deleteordercar(order);
								                		  dispose();
								                		  shoppingcat1 shoppin=new shoppingcat1(user);
								                		  shoppin.setVisible(true);		            	  
								                }
								             
								
							}
						});
						jp.add(jl);
						jp.add(jl1);
						jp.add(jl2);
						jp.add(js);
						jp.add(jl3);
						jp.add(jl4);
						jp.add(jb);
						panel_1.add(jp);
						js.addMouseListener(new MouseListener() {
							
							@Override
							public void mouseReleased(MouseEvent e) {
								jl4.setText(ord.getPrice()*(int)js.getValue()+"");
								
							}
							
							@Override
							public void mousePressed(MouseEvent e) {
								jl4.setText(ord.getPrice()*(int)js.getValue()+"");
								
							}
							
							@Override
							public void mouseExited(MouseEvent e) {
								jl4.setText(ord.getPrice()*(int)js.getValue()+"");
								
							}
							
							@Override
							public void mouseEntered(MouseEvent e) {
								jl4.setText(ord.getPrice()*(int)js.getValue()+"");
								
							}
							
							@Override
							public void mouseClicked(MouseEvent e) {
								jl4.setText(ord.getPrice()*(int)js.getValue()+"");
								
							}
						});
					
						jp.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								String s=jl1.getText();
								ProductsDao prodao=new ProductsDao();
								Products pro=prodao.findgoods(s);
								System.out.println(s);
								watchShopping whtch=new watchShopping(user, pro);
								whtch.setVisible(true);
								
								
							}
						});
					
					}
					
				}	
			}
		});
		
		
		
		lblNewLabel.setText(curentPageIndex+"/"+pageCount);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(156)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
					.addComponent(label_1)
					.addGap(85)
					.addComponent(label_2)
					.addGap(65)
					.addComponent(label_3)
					.addGap(132))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(220)
					.addComponent(btnNewButton)
					.addGap(38)
					.addComponent(lblNewLabel)
					.addGap(52)
					.addComponent(btnNewButton_1)
					.addContainerGap(278, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(label_3))
					.addGap(39)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton)
						.addComponent(lblNewLabel))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(new GridLayout(5, 1));
		contentPane.setLayout(gl_contentPane);
		
		
	}
}
