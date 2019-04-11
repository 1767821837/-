package com.view.home;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import com.model.shoppDao.Products;
import com.model.shoppDao.ProductsDao;
import com.model.shoppDao.order_;
import com.model.shoppDao.order_Dao;
import com.model.userDao.User;
import com.model.userDao.userDao;
import com.view.qianduan.JFview;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class watchShopping extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final JPanel contentPanel2 = new JPanel();
	private final JTabbedPane jtp=new JTabbedPane();
	private order_ ords;
	private order_Dao orderdao=new order_Dao();
	private ProductsDao prodao=new ProductsDao();
	 SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss " );
	 private boolean bool=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			watchShopping dialog = new watchShopping(new User(),new Products());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public watchShopping(User user,Products pro1) {
		setIconImage(new ImageIcon(JFview.class.getResource("/images/qianduan/logo.png")).getImage()); 
		setSize( 841, 650);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		Products pro=prodao.findgoods(pro1.getName());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
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
//				if(bool) {
//				setVisible(false);
//			dispose();
//				
//			}
				}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				bool=true;
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		//原价
		JLabel photo=new JLabel();
		photo.setBounds(20, 40, 400, 400);
		photo.setIcon(new ImageIcon("src\\images\\homepage\\img\\productSingle\\"+pro.getId()+".jpg"));
		JLabel jlyj=new JLabel("原价:");
		jlyj.setBounds(500, 180, 70, 25);
		jlyj.setFont(new Font("宋体",Font.PLAIN, 18));
		
		JLabel jlyj1=new JLabel(pro.getOriginalprice()+"");
		jlyj1.setFont(new Font("宋体", Font.PLAIN,15));
		jlyj1.setBounds(570, 180, 100, 25);
		//现价
		JLabel jlxj=new JLabel("现价:");
		jlxj.setBounds(500, 230, 70, 20);
		jlxj.setFont(new Font("宋体",Font.PLAIN, 18));
		
		JLabel jlxj1=new JLabel(pro.getPromoteprice()+"");
		jlxj1.setFont(new Font("宋体", Font.BOLD,22));
		jlxj1.setBounds(580, 230, 100, 25);
		jlxj1.setForeground(Color.RED);
		//钱符号
		JLabel jlq=new JLabel("¥");
		jlq.setForeground(Color.RED);
		jlq.setBounds(550, 230, 50, 22);
		jlq.setFont(new Font("宋体",Font.PLAIN, 22));
		
//		销售量
		JLabel jlxsl=new JLabel("销售量:");
		jlxsl.setBounds(480, 280, 70, 20);
		jlxsl.setFont(new Font("宋体",Font.PLAIN, 18));	
		
		JLabel jlxs1=new JLabel("50");
		jlxs1.setFont(new Font("宋体", Font.PLAIN,15));
		jlxs1.setBounds(570, 280, 100, 25);
		jlxs1.setForeground(Color.RED);
//	数量
		JLabel jlnum=new JLabel("运费:");
		jlnum.setBounds(500, 330, 70, 20);
		jlnum.setFont(new Font("宋体",Font.PLAIN, 18));
		
		JLabel jlnum1=new JLabel("免邮");
		jlnum1.setFont(new Font("宋体", Font.PLAIN,15));
		jlnum1.setBounds(550, 330, 100, 25);
		
		//库存
		JLabel jlkc=new JLabel("库存:");
		jlkc.setBounds(500, 380, 70, 20);
		jlkc.setFont(new Font("宋体",Font.PLAIN, 18));
		
		JLabel jlkc1=new JLabel(pro.getStock()+"");
		jlkc1.setFont(new Font("宋体", Font.PLAIN,15));
		jlkc1.setBounds(570, 380, 100, 25);
		
		JLabel lblNewLabel = new JLabel(pro.getName());
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 18));

		
		JLabel jlnu=new JLabel("数量:");
		jlnu.setBounds(500, 430, 70, 20);
		jlnu.setFont(new Font("宋体",Font.PLAIN, 18));
		
		JSpinner jsp=new JSpinner();
		jsp.setBounds(550, 430, 80, 30);jsp.setValue(1);
		//购物车
		JButton Jb=new JButton("加入购物车");
		Jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date=new Date();
				if((int)jsp.getValue()==0) {
					JOptionPane.showMessageDialog(null, "请选择数量");
				}
				else if((int)jsp.getValue()>pro.getStock()) {
					JOptionPane.showMessageDialog(null, "超过库存");
				}else {
					order_ ord=new order_();
					 
					 String ordercode=date.getTime()+"";
					
					 ord.setOrderCode(ordercode);
					 ord.setStatus("购物车");
					 ord.setName(pro.getName());
					 ord.setNumber((int)jsp.getValue());
					 ord.setPrice(pro.getPromoteprice());
					 ord.setMoney(ord.getPrice()*ord.getNumber());
					ord.setUid(user.getId()+"");

					orderdao.addorder(user, ord,pro);
				JOptionPane.showMessageDialog(null, "加入成功");
					dispose();
					
					
					
					
				}
				
			}
		});
		Jb.setFont(new Font("宋体",Font.BOLD, 22));
		Jb.setBounds(450, 480, 150, 40);
//		立即购买
		JButton jbmai=new JButton("立即购买");
		jbmai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date=new Date();
				if((int)jsp.getValue()==0) {
					JOptionPane.showMessageDialog(null, "请选择数量");
				}
				else if((int)jsp.getValue()>pro.getStock()) {
					JOptionPane.showMessageDialog(null, "超过库存");
				}else 
				{
					if(user.getAddress()!=null) {
					
						userDao userdao=new  userDao();
						
						

						order_ ord=new order_();
						
						 String payDate=sdf.format(date);
						 String ordercode=date.getTime()+"";
						 
						 ord.setOrderCode(ordercode);
						 ord.setCreateDate(payDate);
						 ord.setStatus("下单成功");
						ord.setUid(user.getId()+"");
						ord.setPayDate(payDate);
						 ord.setName(pro.getName());
						 ord.setNumber((int)jsp.getValue());
						 ord.setPrice(pro.getPromoteprice());
						 ord.setMoney(ord.getPrice()*ord.getNumber());
							Payinterface pay=new Payinterface(user,ord,pro);
							pay.setVisible(true);
				}
					
					else {
						JOptionPane.showMessageDialog(null, "请填写收货地址");
						dispose();
					}
						

					
				}
			}
		});
		jbmai.setFont(new Font("宋体",Font.BOLD, 22));
		jbmai.setBounds(620, 480, 150, 40);
		
		JLabel lblNewLabel_1 = new JLabel(pro.getSubtitle());
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton button = new JButton("评论");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Wtchview watc=new Wtchview();
				watc.setVisible(true);
			}
		});
	
		button.setBackground(Color.WHITE);
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		
		
		
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(452, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addComponent(button)
							.addGap(57))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(31)
					.addComponent(lblNewLabel)
					.addGap(30)
					.addComponent(lblNewLabel_1)
					.addGap(166)
					.addComponent(button)
					.addContainerGap(297, Short.MAX_VALUE))
		);
		contentPanel.add(jlyj);
		contentPanel.add(jlxj);
		contentPanel.add(jlyj1);
		contentPanel.add(jlxj1);
		contentPanel.add(jlxsl);
		contentPanel.add(jlnum);
		contentPanel.add(jlkc);
		contentPanel.add(jlq);
		contentPanel.add(jlxs1);
		contentPanel.add(jlkc1);
		contentPanel.add(jlnum1);
		contentPanel.add(jlnu);
		contentPanel.add(jsp);
		contentPanel.add(Jb);
		contentPanel.add(jbmai);
		contentPanel.add(photo);
		contentPanel.setLayout(gl_contentPanel);
	}
}
