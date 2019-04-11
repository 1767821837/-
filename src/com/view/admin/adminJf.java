package com.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.model.shoppDao.Products;
import com.model.shoppDao.ProductsDao;
import com.model.shoppDao.order_;
import com.model.shoppDao.order_Dao;
import com.model.userDao.User;
import com.model.userDao.userDao;
import com.util.Buttonzhezhi;
import com.view.home.shoppingcat1;
import com.view.home.watchShopping;
import com.view.qianduan.JFview;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class adminJf extends JFrame {

		private userDao userdao=new userDao();
		private List<User> list;
		private  String[] head;
		private Object [][]data=null;
	 	private Products pro;
	 	private order_ order_;
		private  int curentPageIndex=1;        //当前页码                    
		private  int countPerpage=7;        //每页显示条数  
		private  int pageCount;           //总页数  
		private  int recordCount;           //总记录条数  
		private int num;
		private order_Dao orderdao=new order_Dao();
		private JPanel jp ;
		ProductsDao prodao=new ProductsDao();
		//第二个面板翻页
		private  int curentPageIndex2=1;        //当前页码                    
		private  int countPerpage2=7;        //每页显示条数  
		private  int pageCount2;           //总页数  
		private  int recordCount2;           //总记录条数  
		private int num2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminJf frame = new adminJf();
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
	public adminJf() {
		setIconImage(new ImageIcon(JFview.class.getResource("/images/qianduan/logo.png")).getImage()); 
		List<Products> list=orderdao.adminfindallgoods();
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
					num=curentPageIndex*7;
				}
				}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 1000);
		setLocationRelativeTo(null);
//		setLayout(new BorderLayout());
		JTabbedPane tp = new JTabbedPane(JTabbedPane.TOP);
		tp.setFont(new Font("宋体",Font.BOLD,28));
		//头
		  JPanel p1 = new JPanel();
	        p1.setBounds(50, 50, 100, 500);
	    JLabel jlhead1=new JLabel("商品名称");
	    jlhead1.setBounds(150, 30, 200, 30);
	    jlhead1.setFont(new Font("宋体", Font.BOLD, 20));
	    JLabel jlhead2=new JLabel("库存");
	    jlhead2.setBounds(420, 30, 60, 30);
	    jlhead2.setFont(new Font("宋体", Font.BOLD, 20));
	    JLabel jlhead3=new JLabel("单价");
	    jlhead3.setBounds(580, 30, 60, 30);
	    jlhead3.setFont(new Font("宋体", Font.BOLD, 20));
	    
	    JLabel jlhead4=new JLabel("操作");
	    jlhead4.setBounds(750, 30, 60, 30);
	    jlhead4.setFont(new Font("宋体", Font.BOLD, 20));
	      p1.add(jlhead1);
	      p1.add(jlhead2);
	      p1.add(jlhead3);
	      p1.add(jlhead4);
	      JLabel lblNewLabel = new JLabel(curentPageIndex+"/"+pageCount);
	   
	      JPanel panel_1 = new JPanel();    
	      for(int i=(curentPageIndex-1)*7;i<num;i++) {
				jp=new JPanel();
				jp.setSize(new Dimension(600, 70));
				jp.setLayout(null);
				pro=list.get(i);
			
				//图片
				JLabel jl=new JLabel();
				jl.setIcon(new ImageIcon("src\\images\\homepage\\img\\productSingle_small\\"+pro.getId()+".jpg"));
				jl.setBounds(10, 0, 60, 60);
				//数量
				JLabel  jl2=new JLabel(pro.getStock()+"");
				jl2.setFont(new Font("宋体",Font.PLAIN,25));
				jl2.setBounds(400, 0, 100, 30);
				//名称
				JLabel jl1=new JLabel(pro.getName());
				jl1.setBounds(90, 0, 250, 60);
				//订单状态
				
				
				JButton  jl5=new JButton("修改");
				jl5.setFont(new Font("宋体",Font.BOLD,20));
				jl5.setBounds(740, 0, 80, 30);

				jl5.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {

						            	     ProductsDao prodao=new ProductsDao();
								             String s= jl1.getText();
								             for(Products productd:list) {
								            	 if(s.equals(productd.getName())) {
								            		
								            		 Adminlookshopping adin=new Adminlookshopping(productd);
								            		 adin.setVisible(true);	
								            		 
								            		 p1.updateUI();
								            	 }        						                		          	  
						                }
					}
				});
				//金额
				JButton  jl6=new JButton();
				jl6.setBounds(820, 0, 80, 30);
				jl6.setFont(new Font("宋体",Font.BOLD,20));
				if(pro.getStock()==0) {
					jl6.setText("已下架");
					Buttonzhezhi.Button(jl6);
					jl6.setForeground(Color.RED);
				}
				else {
					jl6.setText("下架");
					jl6.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							int in=JOptionPane.showConfirmDialog(null, "确认下架","是否下架？",JOptionPane.YES_NO_OPTION);
								if(in==JOptionPane.YES_OPTION) {
								prodao.deleteproduct(jl1.getText());	
								JOptionPane.showMessageDialog(null, "下架成功");
								jl6.setText("已下架");
								Buttonzhezhi.Button(jl6);
								jl2.setText("0");
								jl6.setForeground(Color.RED);
								}
							
						}
					});
				}
				
				jp.add(jl6);
				JLabel jl4=new JLabel(pro.getPromoteprice()+"");
				jl4.setFont(new Font("宋体",Font.PLAIN,25));
				jl4.setForeground(Color.RED);
				jl4.setBounds(530, 0, 150, 30);
				jp.add(jl);
				jp.add(jl1);
				jp.add(jl2);
				
			
				jp.add(jl4);
				jp.add(jl5);
				panel_1.add(jp);
			
			
				jl.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String s=jl1.getText();
						ProductsDao prodao=new ProductsDao();
						Products pro=prodao.findgoods(s);
						System.out.println(s);
//						watchShopping whtch=new watchShopping(user, pro);
//						whtch.setVisible(true);
						
						
					}
				});
				
			}
			//上一页
	      JButton btnNewButton_1 = new JButton("\u4E0A\u4E00\u9875");
	        btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
			
	        btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					   lblNewLabel.setText(curentPageIndex+"/"+pageCount);
					curentPageIndex--;
					if(curentPageIndex<1) {
						JOptionPane.showMessageDialog(null, "没有上一页");
						curentPageIndex++;
						
					}else {
						panel_1.removeAll();
//						label_1.setText(curentPageIndex+"/"+pageCount);
						for(int i=(curentPageIndex-1)*7;i<curentPageIndex*7;i++) {
							jp=new JPanel();
							jp.setSize(new Dimension(600, 70));
							jp.setLayout(null);
							pro=list.get(i);
							ProductsDao prodao=new ProductsDao();
							Products progoods=	prodao.findgoods(pro.getName());
								//图片
								JLabel jl=new JLabel();
								jl.setIcon(new ImageIcon("src\\images\\homepage\\img\\productSingle_small\\"+progoods.getId()+".jpg"));
							jl.setBounds(10, 0, 60, 60);
							//数量
							JLabel  jl2=new JLabel(pro.getStock()+"");
							jl2.setFont(new Font("宋体",Font.PLAIN,25));
							jl2.setBounds(400, 0, 100, 30);
							//名称
							JLabel jl1=new JLabel(pro.getName());
							jl1.setBounds(90, 0, 250, 60);
							//订单状态
						
							JButton  jl5=new JButton("修改");
							jl5.setFont(new Font("宋体",Font.BOLD,20));
							jl5.setBounds(740, 0, 80, 30);

							jl5.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {

									             ProductsDao prodao=new ProductsDao();
									             String s= jl1.getText();
									             for(Products productd:list) {
									            	 if(s.equals(productd.getName())) {
									            		 System.out.println(" 相同");
									            		 Adminlookshopping adin=new Adminlookshopping(productd);
									            		 adin.setVisible(true);
								                		 
									            	 }
		          	  
									                }
									             
									
								}
							});
							JButton  jl6=new JButton();
							jl6.setBounds(820, 0, 80, 30);
							jl6.setFont(new Font("宋体",Font.BOLD,20));
							if(pro.getStock()==0) {
								jl6.setText("已下架");
								Buttonzhezhi.Button(jl6);
								jl6.setForeground(Color.RED);
							}
							else {
								jl6.setText("下架");
								jl6.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										int in=JOptionPane.showConfirmDialog(null, "确认下架","是否下架？",JOptionPane.YES_NO_OPTION);
											if(in==JOptionPane.YES_OPTION) {
											prodao.deleteproduct(jl1.getText());	
											JOptionPane.showMessageDialog(null, "下架成功");
											jl6.setText("已下架");
											Buttonzhezhi.Button(jl6);
											jl6.setForeground(Color.RED);
											jl2.setText("0");
											}
										
									}
								});
							}
							
							jp.add(jl6);
							//金额
						
							
							JLabel jl4=new JLabel(pro.getPromoteprice()+"");
							jl4.setFont(new Font("宋体",Font.PLAIN,25));
							jl4.setForeground(Color.RED);
							jl4.setBounds(530, 0, 150, 30);
							jp.add(jl);
							jp.add(jl1);
							jp.add(jl2);
							
							
							jp.add(jl4);
							jp.add(jl5);
							panel_1.add(jp);
							panel_1.updateUI();
						
							jl.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									String s=jl1.getText();
									ProductsDao prodao=new ProductsDao();
									Products pro=prodao.findgoods(s);
									System.out.println(s);
//									watchShopping whtch=new watchShopping(user, pro);
//									whtch.setVisible(true);
									
									
								}
							});
							
						}
						
						}
						
				}
			});
	        btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
			//下一页
	        JButton btnNewButton_2 = new JButton("\u4E0B\u4E00\u9875");
	        btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
			
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					curentPageIndex++;
					if(curentPageIndex<pageCount) {
						panel_1.removeAll();
						lblNewLabel.setText(curentPageIndex+"/"+pageCount);
						
					for(int i=(curentPageIndex-1)*7;i<curentPageIndex*7;i++) {
						jp=new JPanel();
						jp.setSize(new Dimension(600, 70));
						jp.setLayout(null);
						pro=list.get(i);
						ProductsDao prodao=new ProductsDao();
						Products progoods=	prodao.findgoods(pro.getName());
							//图片
							JLabel jl=new JLabel();
							jl.setIcon(new ImageIcon("src\\images\\homepage\\img\\productSingle_small\\"+progoods.getId()+".jpg"));
						jl.setBounds(10, 0, 60, 60);
						//数量
						JLabel  jl2=new JLabel(pro.getStock()+"");
						jl2.setFont(new Font("宋体",Font.PLAIN,25));
						jl2.setBounds(400, 0, 100, 30);
						//名称
						JLabel jl1=new JLabel(pro.getName());
						jl1.setBounds(90, 0, 250, 60);
						//订单状态
					
						JButton  jl5=new JButton("修改");
						jl5.setFont(new Font("宋体",Font.BOLD,20));
						jl5.setBounds(740, 0, 80, 30);

						jl5.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {

								             ProductsDao prodao=new ProductsDao();
								             String s= jl1.getText();
								             for(Products productd:list) {
								            	 if(s.equals(productd.getName())) {
								            		 System.out.println(" 相同");
								            		 Adminlookshopping adin=new Adminlookshopping(productd);
								            		 adin.setVisible(true);
							                		
								            		 
								            	 }
								             }
	          	  
								                
								
							}
						});
						JButton  jl6=new JButton();
						jl6.setBounds(820, 0, 80, 30);
						jl6.setFont(new Font("宋体",Font.BOLD,20));
						if(pro.getStock()==0) {
							jl6.setText("已下架");
							Buttonzhezhi.Button(jl6);
							jl6.setForeground(Color.RED);
						}
						else {
							jl6.setText("下架");
							jl6.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									int in=JOptionPane.showConfirmDialog(null, "确认下架","是否下架？",JOptionPane.YES_NO_OPTION);
										if(in==JOptionPane.YES_OPTION) {
										prodao.deleteproduct(jl1.getText());	
										JOptionPane.showMessageDialog(null, "下架成功");
										jl6.setText("已下架");
										Buttonzhezhi.Button(jl6);
										jl2.setText("0");
										jl6.setForeground(Color.RED);
										}
									
								}
							});
						}
						
						jp.add(jl6);
						//金额
					
						
						JLabel jl4=new JLabel(pro.getPromoteprice()+"");
						jl4.setFont(new Font("宋体",Font.PLAIN,25));
						jl4.setForeground(Color.RED);
						jl4.setBounds(530, 0, 150, 30);
						jp.add(jl);
						jp.add(jl1);
						jp.add(jl2);
						
						
						
						jp.add(jl4);
						jp.add(jl5);
						panel_1.add(jp);
						panel_1.updateUI();
					
						jl.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								String s=jl1.getText();
								ProductsDao prodao=new ProductsDao();
								Products pro=prodao.findgoods(s);
								System.out.println(s);
//								watchShopping whtch=new watchShopping(user, pro);
//								whtch.setVisible(true);
								
								
							}
						});
						
					}}
					else if(curentPageIndex==pageCount) {
						panel_1.removeAll();
						lblNewLabel.setText(curentPageIndex+"/"+pageCount);
						for(int i=(curentPageIndex-1)*7;i<list.size();i++) {
							jp=new JPanel();
							jp.setSize(new Dimension(600, 70));
							jp.setLayout(null);
							pro=list.get(i);
							
							Products progoods=	prodao.findgoods(pro.getName());
								//图片
								JLabel jl=new JLabel();
								jl.setIcon(new ImageIcon("src\\images\\homepage\\img\\productSingle_small\\"+progoods.getId()+".jpg"));
							jl.setBounds(10, 0, 60, 60);
							//数量
							JLabel  jl2=new JLabel(pro.getStock()+"");
							jl2.setFont(new Font("宋体",Font.PLAIN,25));
							jl2.setBounds(400, 0, 100, 30);
							//名称
							JLabel jl1=new JLabel(pro.getName());
							jl1.setBounds(90, 0, 250, 60);
							//订单状态
							
						
							JButton  jl5=new JButton("修改");
							jl5.setFont(new Font("宋体",Font.BOLD,20));
							jl5.setBounds(740, 0, 80, 30);
							
							jl5.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {

							
									            	     ProductsDao prodao=new ProductsDao();
											             String s= jl1.getText();
											             for(Products productd:list) {
											            	 if(s.equals(productd.getName())) {
											            		 System.out.println(" 相同");
											            		 Adminlookshopping adin=new Adminlookshopping(productd);
											            		 adin.setVisible(true);
										                		 
											            	
											             }
									                		          	  
									                }
									             
									
								}
							});
							JButton  jl6=new JButton();
							jl6.setBounds(820, 0, 80, 30);
							jl6.setFont(new Font("宋体",Font.BOLD,20));
							if(pro.getStock()==0) {
								jl6.setText("已下架");
								Buttonzhezhi.Button(jl6);
								jl6.setForeground(Color.RED);
							}
							else {
								jl6.setText("下架");
								jl6.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										int in=JOptionPane.showConfirmDialog(null, "确认下架","是否下架？",JOptionPane.YES_NO_OPTION);
											if(in==JOptionPane.YES_OPTION) {
											prodao.deleteproduct(jl1.getText());	
											JOptionPane.showMessageDialog(null, "下架成功");
											jl6.setText("已下架");
											Buttonzhezhi.Button(jl6);
											jl2.setText("0");
											jl6.setForeground(Color.RED);
											}
										
									}
								});
							}
							
							jp.add(jl6);
							//金额
							
							
							JLabel jl4=new JLabel(pro.getPromoteprice()+"");
							jl4.setFont(new Font("宋体",Font.PLAIN,25));
							jl4.setForeground(Color.RED);
							jl4.setBounds(530, 0, 150, 30);
							jp.add(jl);
							jp.add(jl1);
							jp.add(jl2);
							
							
							jp.add(jl4);
							jp.add(jl5);
							panel_1.add(jp);
						panel_1.updateUI();
						
							jl.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									String s=jl1.getText();
									ProductsDao prodao=new ProductsDao();
									Products pro=prodao.findgoods(s);
									System.out.println(s);
//									watchShopping whtch=new watchShopping(user, pro);
//									whtch.setVisible(true);
									
									
								}
							});
							
						}
					}else {
						JOptionPane.showMessageDialog(null, "没有下一页了");
						curentPageIndex--;
					}
					
					
					
					
					
					
					
				}
			});
			JPopupMenu popup=new JPopupMenu();
			JMenuItem jm=new JMenuItem("增加分类");
			JMenuItem jm1=new JMenuItem("增加产品");
			popup.add(jm);
			popup.add(jm1);
			jm.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					addcatr  addc=new addcatr();
					addc.setVisible(true);
					
				}
			});
				jm1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Addproduct addp=new Addproduct();
					addp.setVisible(true);
					
				}
			});
			
			 JButton btnNewButton = new JButton("新增");
			 btnNewButton.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseClicked(MouseEvent e) {
			 		popup.show(btnNewButton, e.getX(),e.getY());
			 	}
			 });
			 
	         //放置设置
	         JPanel p = new JPanel();
	 
	
    
      p1.add(p, BorderLayout.NORTH);

  
     
	  //订单信息
      
      
      
      //煮面版
	        JPanel p2 = new JPanel();
	        p2.setBackground(Color.WHITE);
	        p2.setBounds(10, 150, 300, 60);
	        tp.add(p1);

	        GroupLayout gl_p1 = new GroupLayout(p1);
	        gl_p1.setHorizontalGroup(
	        	gl_p1.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_p1.createSequentialGroup()
	        			.addGroup(gl_p1.createParallelGroup(Alignment.LEADING)
	        				.addGroup(gl_p1.createSequentialGroup()
	        					.addContainerGap()
	        					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE))
	        				.addGroup(gl_p1.createSequentialGroup()
	        					.addGap(364)
	        					.addComponent(btnNewButton_1)
	        					.addPreferredGap(ComponentPlacement.RELATED)
	        					.addComponent(lblNewLabel)
	        					.addPreferredGap(ComponentPlacement.RELATED)
	        					.addComponent(btnNewButton_2)))
	        			.addContainerGap())
	        		.addGroup(Alignment.TRAILING, gl_p1.createSequentialGroup()
	        			.addContainerGap(833, Short.MAX_VALUE)
	        			.addComponent(btnNewButton)
	        			.addGap(31))
	        );
	        gl_p1.setVerticalGroup(
	        	gl_p1.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_p1.createSequentialGroup()
	        			.addGap(30)
	        			.addComponent(btnNewButton)
	        			.addGap(27)
	        			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 754, GroupLayout.PREFERRED_SIZE)
	        			.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
	        			.addGroup(gl_p1.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(btnNewButton_2)
	        				.addComponent(btnNewButton_1)
	        				.addComponent(lblNewLabel))
	        			.addContainerGap())
	        );
	        panel_1.setLayout(new GridLayout(7,1));
	        p1.setLayout(gl_p1);
	    
	        p1.setLayout(gl_p1);
	        tp.add(p2);
	      
	        
	        
	        JPopupMenu popup1=new JPopupMenu();
			
			JMenuItem jmmmm=new JMenuItem("刷新");
			popup1.add(jmmmm);
			jmmmm.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					adminJf adf=new adminJf();
					adf.setVisible(true);
					dispose();
					
				}
			});
	        
	        
	        p1.addMouseListener(new MouseListener() {
				
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
				if(e.getButton()==MouseEvent.BUTTON3) {
					popup1.show(p1, e.getX(), e.getY());
				}
					
				}
			});
	       
p2.addMouseListener(new MouseListener() {
				
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
				if(e.getButton()==MouseEvent.BUTTON3) {
					popup1.show(p1, e.getX(), e.getY());
				}
					
				}
			});
	       
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	   //第二个面板     
//	      上
	        JPanel panel = new JPanel();
	        panel.setBackground(Color.WHITE);
//	        下
	        JPanel panel_3 = new JPanel();
	        panel_3.setBackground(Color.WHITE);
	        
	    	List<order_> listorder=orderdao.adminlookorder();
			recordCount2= listorder.size();
					
					if(recordCount2!=0) {
					if(recordCount2%countPerpage2==0) {
						pageCount2=recordCount2/countPerpage2;
					}else {
						pageCount2 =recordCount2/countPerpage2+1;
					}
					if(curentPageIndex2==pageCount2) {
					num2=list.size();
					}
					else {
						num2=curentPageIndex2*7;
					}
					}
					JLabel lblNewLabel_1 = new JLabel(curentPageIndex2+"/"+pageCount2);
					 for(int i=(curentPageIndex2-1)*7;i<num2;i++) {
							jp=new JPanel();
							jp.setSize(new Dimension(600, 70));
							jp.setLayout(null);
							order_=listorder.get(i);
							ProductsDao prodao=new ProductsDao();
							Products progoods=	prodao.findgoods(order_.getName());
							//图片
							JLabel jl=new JLabel();
							System.out.println(i);
							jl.setIcon(new ImageIcon("src\\images\\homepage\\img\\productSingle_small\\"+progoods.getId()+".jpg"));
							jl.setBounds(10, 0, 60, 60);
							//数量
							JLabel  jl2=new JLabel(order_.getNumber()+"");
							jl2.setFont(new Font("宋体",Font.PLAIN,25));
							jl2.setBounds(350, 0, 100, 30);
							//名称
							JLabel jl1=new JLabel(order_.getName());
							jl1.setBounds(90, 0, 250, 60);
							//订单状态
							//订单号  判断订单处理
							JLabel orderco=new JLabel(order_.getOrderCode());
							
							JButton  jl5=new JButton();
							jl5.setFont(new Font("宋体",Font.BOLD,20));
							jl5.setBounds(800, 0, 150, 40);
							if(order_.getStatus().equals("下单成功")) {
								jl5.setText("等待发货");
		
							}else {
								jl5.setText("等待签收");
								Buttonzhezhi.Button(jl5);
								jl5.setBorder(null);
							}
							jl5.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
													if(jl5.getText().equals("等待发货")) {
														 int res=JOptionPane.showConfirmDialog(null, "是否发货", "确认发货", JOptionPane.YES_NO_OPTION);
														                if(res==JOptionPane.YES_OPTION){ 
														                	  ProductsDao prodao=new ProductsDao();
																	             String s= orderco.getText();
																	             order_ updateord=new order_();
																	             System.out.println(s);
																	             for(order_  ordupdate:listorder) {
																	            	 if(s.equals(ordupdate.getOrderCode())) {
																	            		 jl5.setText("等待签收");
																							Buttonzhezhi.Button(jl5);
																							jl5.setBorder(null);
																							SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss " );
																					        Date d= new Date();
																					        String str = sdf.format(d);
																					       
																					        updateord.setStatus("等待签收");
																					        updateord.setDeliveryDate(str);
																					        updateord.setId(ordupdate.getId());
																					        updateord.setOrderCode(s);
																					        System.out.println(updateord.getId()+"   "+updateord.getDeliveryDate()+"   "+updateord.getStatus());
																					        orderdao.updateuserorder(updateord);
																					        return;
																	            	 }
																	             }
														                  }else{
														                     System.out.println("选择否后执行的代码");    //点击“否”后执行这个代码块
														                    return;
														                 } 
									            	
											            		 						            		 
											            	 
											             
									                }
								}
							});
							//金额
							
							JLabel jl4=new JLabel(order_.getMoney()+"");
							jl4.setFont(new Font("宋体",Font.PLAIN,25));
							jl4.setForeground(Color.RED);
							jl4.setBounds(450, 0, 150, 30);
							JLabel jl99=new JLabel(order_.getUid());
							jl99.setBounds(600, 0, 150, 30);
							jl99.setFont(new Font("宋体",Font.PLAIN,20));
							jp.add(jl);
							jp.add(jl1);
							jp.add(jl2);
							jp.add(jl99);
							
						
							jp.add(jl4);
							jp.add(jl5);
							panel_3.add(jp);
						
						
							jl.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									String s=jl1.getText();
									ProductsDao prodao=new ProductsDao();
									Products pro=prodao.findgoods(s);
									System.out.println(s);
//									watchShopping whtch=new watchShopping(user, pro);
//									whtch.setVisible(true);
									
									
								}
							});
							
						}
//	        上一页
	        JButton btnNewButton_3 = new JButton("\u4E0A\u4E00\u9875");
	        btnNewButton_3.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		curentPageIndex2--;
	        		if(curentPageIndex2<1) {
	        			JOptionPane.showMessageDialog(null, "没有上一页了");
	        			curentPageIndex2++;
	        		}else {
	        			panel_3.removeAll();
	        			lblNewLabel_1.setText(curentPageIndex2+"/"+pageCount2);
	        			 for(int i=(curentPageIndex2-1)*7;i<curentPageIndex2*7;i++) {
								jp=new JPanel();
								jp.setSize(new Dimension(600, 70));
								jp.setLayout(null);
								order_=listorder.get(i);
								ProductsDao prodao=new ProductsDao();
								Products progoods=	prodao.findgoods(order_.getName());
								//图片
								JLabel jl=new JLabel();
								jl.setIcon(new ImageIcon("src\\images\\homepage\\img\\productSingle_small\\"+progoods.getId()+".jpg"));
								jl.setBounds(10, 0, 60, 60);
								//数量
								JLabel  jl2=new JLabel(order_.getNumber()+"");
								jl2.setFont(new Font("宋体",Font.PLAIN,25));
								jl2.setBounds(350, 0, 100, 30);
								//名称
								JLabel jl1=new JLabel(order_.getName());
								jl1.setBounds(90, 0, 250, 60);
								//订单状态
								//订单号  判断订单处理
								JLabel orderco=new JLabel(order_.getOrderCode());
								
								JButton  jl5=new JButton();
								jl5.setFont(new Font("宋体",Font.BOLD,20));
								jl5.setBounds(800, 0, 150, 40);
								if(order_.getStatus().equals("下单成功")) {
									jl5.setText("等待发货");
			
								}else {
									jl5.setText("等待签收");
									Buttonzhezhi.Button(jl5);
									jl5.setBorder(null);
								}
								jl5.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
														if(jl5.getText().equals("等待发货")) {
															 int res=JOptionPane.showConfirmDialog(null, "是否发货", "确认发货", JOptionPane.YES_NO_OPTION);
															                if(res==JOptionPane.YES_OPTION){ 
															                	  ProductsDao prodao=new ProductsDao();
																		             String s= orderco.getText();
																		             order_ updateord=new order_();
																		             System.out.println(s);
																		             for(order_  ordupdate:listorder) {
																		            	 if(s.equals(ordupdate.getOrderCode())) {
																		            		 jl5.setText("等待签收");
																								Buttonzhezhi.Button(jl5);
																								jl5.setBorder(null);
																								SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss " );
																						        Date d= new Date();
																						        String str = sdf.format(d);
																						       
																						        updateord.setStatus("等待签收");
																						        updateord.setDeliveryDate(str);
																						        updateord.setId(ordupdate.getId());
																						        updateord.setOrderCode(s);
																						        System.out.println(updateord.getId()+"   "+updateord.getDeliveryDate()+"   "+updateord.getStatus());
																						        orderdao.updateuserorder(updateord);
																						        return;
																		            	 }
																		             }
															                  }else{
															                     System.out.println("选择否后执行的代码");    //点击“否”后执行这个代码块
															                    return;
															                 } 
										            	
												            		 						            		 
												            	 
												             
										                }
									}
								});
								//金额
								
								JLabel jl4=new JLabel(order_.getMoney()+"");
								jl4.setFont(new Font("宋体",Font.PLAIN,25));
								jl4.setForeground(Color.RED);
								jl4.setBounds(450, 0, 150, 30);
								JLabel jl99=new JLabel(order_.getUid());
								jl99.setBounds(600, 0, 150, 30);
								jl99.setFont(new Font("宋体",Font.PLAIN,20));
								
								jp.add(jl99);
								jp.add(jl);
								jp.add(jl1);
								jp.add(jl2);
								
							
								jp.add(jl4);
								jp.add(jl5);
								panel_3.add(jp);
							
							panel_3.updateUI();
								jl.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										String s=jl1.getText();
										ProductsDao prodao=new ProductsDao();
										Products pro=prodao.findgoods(s);
										System.out.println(s);
//										watchShopping whtch=new watchShopping(user, pro);
//										whtch.setVisible(true);
										
										
									}
								});
								
	        		}
	        		
	        		}
	        		
	        	}
	        });
	        btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 25));
	        
	        
	        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
	        //下一页
	        JButton btnNewButton_4 = new JButton("\u4E0B\u4E00\u9875");
	        
	        btnNewButton_4.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		curentPageIndex2++;
	        		if(curentPageIndex2>pageCount2) {
	        			JOptionPane.showMessageDialog(null, "没有下一页");
	        			curentPageIndex2--;
	        		}else  if(curentPageIndex2<pageCount2){
	        			panel_3.removeAll();
	        			lblNewLabel_1.setText(curentPageIndex2+"/"+pageCount2);
	        			 for(int i=(curentPageIndex2-1)*7;i<curentPageIndex2*7;i++) {
								jp=new JPanel();
								jp.setSize(new Dimension(600, 70));
								jp.setLayout(null);
								order_=listorder.get(i);
								ProductsDao prodao=new ProductsDao();
								Products progoods=	prodao.findgoods(order_.getName());
								//图片
								JLabel jl=new JLabel();
								jl.setIcon(new ImageIcon("src\\images\\homepage\\img\\productSingle_small\\"+progoods.getId()+".jpg"));
								jl.setBounds(10, 0, 60, 60);
								//数量
								JLabel  jl2=new JLabel(order_.getNumber()+"");
								jl2.setFont(new Font("宋体",Font.PLAIN,25));
								jl2.setBounds(350, 0, 100, 30);
								//名称
								JLabel jl1=new JLabel(order_.getName());
								jl1.setBounds(90, 0, 250, 60);
								//订单状态
								//订单号  判断订单处理
								JLabel orderco=new JLabel(order_.getOrderCode());
								
								JButton  jl5=new JButton();
								jl5.setFont(new Font("宋体",Font.BOLD,20));
								jl5.setBounds(800, 0, 150, 40);
								if(order_.getStatus().equals("下单成功")) {
									jl5.setText("等待发货");
			
								}else {
									jl5.setText("等待签收");
									Buttonzhezhi.Button(jl5);
									jl5.setBorder(null);
								}
								jl5.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
														if(jl5.getText().equals("等待发货")) {
															 int res=JOptionPane.showConfirmDialog(null, "是否发货", "确认发货", JOptionPane.YES_NO_OPTION);
															                if(res==JOptionPane.YES_OPTION){ 
															                	  ProductsDao prodao=new ProductsDao();
																		             String s= orderco.getText();
																		             order_ updateord=new order_();
																		             System.out.println(s);
																		             for(order_  ordupdate:listorder) {
																		            	 if(s.equals(ordupdate.getOrderCode())) {
																		            		 jl5.setText("等待签收");
																								Buttonzhezhi.Button(jl5);
																								jl5.setBorder(null);
																								SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss " );
																						        Date d= new Date();
																						        String str = sdf.format(d);
																						       
																						        updateord.setStatus("等待签收");
																						        updateord.setDeliveryDate(str);
																						        updateord.setId(ordupdate.getId());
																						        updateord.setOrderCode(s);
																						        System.out.println(updateord.getId()+"   "+updateord.getDeliveryDate()+"   "+updateord.getStatus());
																						        orderdao.updateuserorder(updateord);
																						        return;
																		            	 }
																		             }
															                  }else{
															                     System.out.println("选择否后执行的代码");    //点击“否”后执行这个代码块
															                    return;
															                 } 
										            	
												            		 						            		 
												            	 
												             
										                }
									}
								});
								//金额
								
								JLabel jl4=new JLabel(order_.getMoney()+"");
								jl4.setFont(new Font("宋体",Font.PLAIN,25));
								jl4.setForeground(Color.RED);
								jl4.setBounds(450, 0, 150, 30);
								JLabel jl99=new JLabel(order_.getUid());
								jl99.setBounds(600, 0, 150, 30);
								jl99.setFont(new Font("宋体",Font.PLAIN,20));
								
								jp.add(jl99);
								jp.add(jl);
								jp.add(jl1);
								jp.add(jl2);
								
							
								jp.add(jl4);
								jp.add(jl5);
								panel_3.add(jp);
								panel_3.updateUI();
							
								jl.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										String s=jl1.getText();
										ProductsDao prodao=new ProductsDao();
										Products pro=prodao.findgoods(s);
										System.out.println(s);
//										watchShopping whtch=new watchShopping(user, pro);
//										whtch.setVisible(true);
										
										
									}
								});
	        			 }
	        		}else {
	        			panel_3.removeAll();
	        			lblNewLabel_1.setText(curentPageIndex2+"/"+pageCount2);
	        			 for(int i=(curentPageIndex2-1)*7;i<recordCount2;i++) {
								jp=new JPanel();
								jp.setSize(new Dimension(600, 70));
								jp.setLayout(null);
								order_=listorder.get(i);
								ProductsDao prodao=new ProductsDao();
								Products progoods=	prodao.findgoods(order_.getName());
								//图片
								JLabel jl=new JLabel();
								jl.setIcon(new ImageIcon("src\\images\\homepage\\img\\productSingle_small\\"+progoods.getId()+".jpg"));
								jl.setBounds(10, 0, 60, 60);
								//数量
								JLabel  jl2=new JLabel(order_.getNumber()+"");
								jl2.setFont(new Font("宋体",Font.PLAIN,25));
								jl2.setBounds(350, 0, 100, 30);
								//名称
								JLabel jl1=new JLabel(order_.getName());
								jl1.setBounds(90, 0, 250, 60);
								//订单状态
								//订单号  判断订单处理
								JLabel orderco=new JLabel(order_.getOrderCode());
								
								JButton  jl5=new JButton();
								jl5.setFont(new Font("宋体",Font.BOLD,20));
								jl5.setBounds(800, 0, 150, 40);
								if(order_.getStatus().equals("下单成功")) {
									jl5.setText("等待发货");
			
								}else {
									jl5.setText("等待签收");
									Buttonzhezhi.Button(jl5);
									jl5.setBorder(null);
								}
								jl5.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
														if(jl5.getText().equals("等待发货")) {
															 int res=JOptionPane.showConfirmDialog(null, "是否发货", "确认发货", JOptionPane.YES_NO_OPTION);
															                if(res==JOptionPane.YES_OPTION){ 
															                	  ProductsDao prodao=new ProductsDao();
																		             String s= orderco.getText();
																		             order_ updateord=new order_();
																		             System.out.println(s);
																		             for(order_  ordupdate:listorder) {
																		            	 if(s.equals(ordupdate.getOrderCode())) {
																		            		 jl5.setText("等待签收");
																								Buttonzhezhi.Button(jl5);
																								jl5.setBorder(null);
																								SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss " );
																						        Date d= new Date();
																						        String str = sdf.format(d);
																						       
																						        updateord.setStatus("等待签收");
																						        updateord.setDeliveryDate(str);
																						        updateord.setId(ordupdate.getId());
																						        updateord.setOrderCode(s);
																						        System.out.println(updateord.getId()+"   "+updateord.getDeliveryDate()+"   "+updateord.getStatus());
																						        orderdao.updateuserorder(updateord);
																						        return;
																		            	 }
																		             }
															                  }else{
															                     System.out.println("选择否后执行的代码");    //点击“否”后执行这个代码块
															                    return;
															                 } 
										            	
												            		 						            		 
												            	 
												             
										                }
									}
								});
								//金额
								
								JLabel jl4=new JLabel(order_.getMoney()+"");
								jl4.setFont(new Font("宋体",Font.PLAIN,25));
								jl4.setForeground(Color.RED);
								jl4.setBounds(450, 0, 150, 30);
								JLabel jl99=new JLabel(order_.getUid());
								jl99.setBounds(600, 0, 150, 30);
								jl99.setFont(new Font("宋体",Font.PLAIN,20));
								
								jp.add(jl99);
								jp.add(jl);
								jp.add(jl1);
								jp.add(jl2);
								
							
								jp.add(jl4);
								jp.add(jl5);
								panel_3.add(jp);
								panel_3.updateUI();
							
								jl.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										String s=jl1.getText();
										ProductsDao prodao=new ProductsDao();
										Products pro=prodao.findgoods(s);
										System.out.println(s);
//										watchShopping whtch=new watchShopping(user, pro);
//										whtch.setVisible(true);
										
										
									}
								});
								
	        		}
	        		}
	        		
	        		
	        	}
	        });
	        btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 20));
	        
	        
	        
	        
	        GroupLayout gl_p2 = new GroupLayout(p2);
	        gl_p2.setHorizontalGroup(
	        	gl_p2.createParallelGroup(Alignment.LEADING)
	        		.addComponent(panel, GroupLayout.DEFAULT_SIZE, 977, Short.MAX_VALUE)
	        		.addGroup(gl_p2.createSequentialGroup()
	        			.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
	        			.addContainerGap())
	        		.addGroup(gl_p2.createSequentialGroup()
	        			.addGap(365)
	        			.addComponent(btnNewButton_3)
	        			.addGap(23)
	        			.addComponent(lblNewLabel_1)
	        			.addGap(18)
	        			.addComponent(btnNewButton_4)
	        			.addContainerGap(343, Short.MAX_VALUE))
	        );
	        gl_p2.setVerticalGroup(
	        	gl_p2.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_p2.createSequentialGroup()
	        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 746, GroupLayout.PREFERRED_SIZE)
	        			.addGap(18)
	        			.addGroup(gl_p2.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(btnNewButton_4)
	        				.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(btnNewButton_3))
	        			.addContainerGap(24, Short.MAX_VALUE))
	        );
	        panel_3.setLayout(new GridLayout(7,1));
	        
	        JLabel label = new JLabel("\u5546\u54C1\u540D\u79F0");
	        label.setFont(new Font("宋体", Font.PLAIN, 18));
	        
	        JLabel label_1 = new JLabel("\u6570\u91CF");
	        label_1.setFont(new Font("宋体", Font.PLAIN, 18));
	        
	        JLabel label_2 = new JLabel("\u91D1\u989D");
	        label_2.setFont(new Font("宋体", Font.PLAIN, 18));
	        
	        JLabel label_3 = new JLabel("\u64CD\u4F5C");
	        label_3.setFont(new Font("宋体", Font.PLAIN, 18));
	        
	        JLabel lblid = new JLabel("\u7528\u6237id");
	        lblid.setFont(new Font("宋体", Font.PLAIN, 18));
	        GroupLayout gl_panel = new GroupLayout(panel);
	        gl_panel.setHorizontalGroup(
	        	gl_panel.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_panel.createSequentialGroup()
	        			.addGap(112)
	        			.addComponent(label)
	        			.addGap(161)
	        			.addComponent(label_1)
	        			.addGap(63)
	        			.addComponent(label_2)
	        			.addGap(89)
	        			.addComponent(lblid)
	        			.addPreferredGap(ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
	        			.addComponent(label_3)
	        			.addGap(69))
	        );
	        gl_panel.setVerticalGroup(
	        	gl_panel.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_panel.createSequentialGroup()
	        			.addGap(40)
	        			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(label_3)
	        				.addComponent(label)
	        				.addComponent(label_1)
	        				.addComponent(label_2)
	        				.addComponent(lblid))
	        			.addContainerGap(22, Short.MAX_VALUE))
	        );
	        panel.setLayout(gl_panel);
	        p2.setLayout(gl_p2);
	  
	        // 设置tab的标题
	        tp.setTitleAt(0, "商品管理");
	        tp.setTitleAt(1, "订单管理");
	       
	      
	        this.setContentPane(tp);
	  
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	        setVisible(true);
	
	}
}
