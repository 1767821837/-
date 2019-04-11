package com.view.home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import com.model.shoppDao.Products;
import com.model.shoppDao.ProductsDao;
import com.model.shoppDao.order_;
import com.model.shoppDao.order_Dao;
import com.model.userDao.User;
import com.util.Buttonzhezhi;
import com.view.qianduan.JFview;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class myorder extends JFrame {

	private JPanel contentPane;
	private  int curentPageIndex=1;        //当前页码                    
	private  int countPerpage=5;        //每页显示条数  
	private  int pageCount;           //总页数  
	private  int recordCount;           //总记录条数  
	private int num;
	private order_Dao orderdao=new order_Dao();
	private order_ ord;
	private JPanel jp ;
private boolean bool=false;
	/**-9
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myorder frame = new myorder(new User());
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
	public myorder(User user) {
		
		setIconImage(new ImageIcon(JFview.class.getResource("/images/qianduan/logo.png")).getImage()); 
		List<order_> list=orderdao.finduserorder(user);
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
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 818, 722);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u4FE1\u606F");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("\u6570\u91CF");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel("\u91D1\u989D");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label = new JLabel("\u8BA2\u5355\u72B6\u6001");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		JLabel label_1 = new JLabel(curentPageIndex+"/"+pageCount);
		label_1.setText(curentPageIndex+"/"+pageCount);
	
		
		JPanel panel_1 = new JPanel();
		
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
			//数量
			JLabel  jl2=new JLabel(ord.getNumber()+"");
			jl2.setFont(new Font("宋体",Font.PLAIN,25));
			jl2.setBounds(400, 0, 100, 30);
			//名称
			JLabel jl1=new JLabel(ord.getName());
			jl1.setBounds(90, 0, 250, 60);
			//订单状态
			
			JLabel jl3=new JLabel();
			if(ord.getStatus().equals("下单成功")) {
				jl3.setText("等待发货");
			
				jl3.setForeground(Color.ORANGE);
			}
			else if(ord.getStatus().equals("等待签收")){
				jl3.setText("等待收货");
				jl3.setForeground(Color.RED);
			}
			jl3.setFont(new Font("宋体",Font.PLAIN,25));
			jl3.setBounds(630, 0, 150, 30);
			jl3.setOpaque(false);
			//金额
			
			JLabel jl4=new JLabel(ord.getMoney()+"");
			jl4.setFont(new Font("宋体",Font.PLAIN,25));
			jl4.setForeground(Color.RED);
			jl4.setBounds(530, 0, 150, 30);
			jp.add(jl);
			jp.add(jl1);
			jp.add(jl2);
			
			jp.add(jl3);
			jp.add(jl4);
			panel_1.add(jp);
		
		
			jl.addMouseListener(new MouseAdapter() {
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
					label_1.setText(curentPageIndex+"/"+pageCount);
					for(int i=(curentPageIndex-1)*5;i<curentPageIndex*5;i++) {
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
						//数量
						JLabel  jl2=new JLabel(ord.getNumber()+"");
						jl2.setFont(new Font("宋体",Font.PLAIN,25));
						jl2.setBounds(400, 0, 100, 30);
						//名称
						JLabel jl1=new JLabel(ord.getName());
						jl1.setBounds(90, 0, 250, 60);
						//订单状态
						
						JButton jl3=new JButton();
						Buttonzhezhi.Button(jl3);
						if(ord.getStatus().equals("下单成功")) {
							jl3.setText("等待发货");
						
							jl3.setForeground(Color.ORANGE);
						}
						else if(ord.getStatus().equals("等待签收")){
							jl3.setText("等待收货");
							jl3.setForeground(Color.RED);
						
						}
						jl3.setFont(new Font("宋体",Font.BOLD,25));
						jl3.setBounds(630, 0, 150, 30);
						jl3.setOpaque(false);
						//金额
						
						JLabel jl4=new JLabel(ord.getMoney()+"");
						jl4.setFont(new Font("宋体",Font.PLAIN,25));
						jl4.setForeground(Color.RED);
						jl4.setBounds(530, 0, 150, 30);
						jp.add(jl);
						jp.add(jl1);
						jp.add(jl2);
						
						jp.add(jl3);
						jp.add(jl4);
						panel_1.add(jp);
						panel_1.updateUI();
					
						jl.addMouseListener(new MouseAdapter() {
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
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		//下一页
		JButton btnNewButton_1 = new JButton("\u4E0B\u4E00\u9875");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				curentPageIndex++;
				if(curentPageIndex<pageCount) {
					panel_1.removeAll();
					label_1.setText(curentPageIndex+"/"+pageCount);
					
				for(int i=(curentPageIndex-1)*5;i<curentPageIndex*5;i++) {
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
					//数量
					JLabel  jl2=new JLabel(ord.getNumber()+"");
					jl2.setFont(new Font("宋体",Font.PLAIN,25));
					jl2.setBounds(400, 0, 100, 30);
					//名称
					JLabel jl1=new JLabel(ord.getName());
					jl1.setBounds(90, 0, 250, 60);
					//订单状态
					
					JLabel jl3=new JLabel();
					if(ord.getStatus().equals("下单成功")) {
						jl3.setText("等待发货");
					
						jl3.setForeground(Color.ORANGE);
					}
					else if(ord.getStatus().equals("等待签收")){
						jl3.setText("等待收货");
						jl3.setForeground(Color.RED);
					}
					jl3.setFont(new Font("宋体",Font.PLAIN,25));
					jl3.setBounds(630, 0, 150, 30);
					jl3.setOpaque(false);
					//金额
					
					JLabel jl4=new JLabel(ord.getMoney()+"");
					jl4.setFont(new Font("宋体",Font.PLAIN,25));
					jl4.setForeground(Color.RED);
					jl4.setBounds(530, 0, 150, 30);
					jp.add(jl);
					jp.add(jl1);
					jp.add(jl2);
					
					jp.add(jl3);
					jp.add(jl4);
					panel_1.add(jp);
					panel_1.updateUI();
				
					jl.addMouseListener(new MouseAdapter() {
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
					
				}}
				else if(curentPageIndex==pageCount) {
					panel_1.removeAll();
					label_1.setText(curentPageIndex+"/"+pageCount);
					for(int i=(curentPageIndex-1)*5;i<list.size();i++) {
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
						//数量
						JLabel  jl2=new JLabel(ord.getNumber()+"");
						jl2.setFont(new Font("宋体",Font.PLAIN,25));
						jl2.setBounds(400, 0, 100, 30);
						//名称
						JLabel jl1=new JLabel(ord.getName());
						jl1.setBounds(90, 0, 250, 60);
						//订单状态
						
						JLabel jl3=new JLabel();
						if(ord.getStatus().equals("下单成功")) {
							jl3.setText("等待发货");
						
							jl3.setForeground(Color.ORANGE);
						}
						else if(ord.getStatus().equals("等待签收")){
							jl3.setText("等待收货");
							jl3.setForeground(Color.RED);
						}
						jl3.setFont(new Font("宋体",Font.PLAIN,25));
						jl3.setBounds(630, 0, 150, 30);
						jl3.setOpaque(false);
						//金额
						
						JLabel jl4=new JLabel(ord.getMoney()+"");
						jl4.setFont(new Font("宋体",Font.PLAIN,25));
						jl4.setForeground(Color.RED);
						jl4.setBounds(530, 0, 150, 30);
						jp.add(jl);
						jp.add(jl1);
						jp.add(jl2);
						
						jp.add(jl3);
						jp.add(jl4);
						panel_1.add(jp);
					panel_1.updateUI();
					
						jl.addMouseListener(new MouseAdapter() {
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
				}else {
					JOptionPane.showMessageDialog(null, "没有下一页了");
					curentPageIndex--;
				}
				
				
				
				
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(212, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(109)
					.addComponent(lblNewLabel_1)
					.addGap(111)
					.addComponent(lblNewLabel_2)
					.addGap(97)
					.addComponent(label)
					.addGap(45))
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(240)
					.addComponent(btnNewButton)
					.addGap(45)
					.addComponent(label_1)
					.addGap(39)
					.addComponent(btnNewButton_1)
					.addContainerGap(232, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel))
					.addGap(43)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		panel_1.setLayout(new GridLayout(5,1));
		contentPane.setLayout(gl_contentPane);
	}
}
