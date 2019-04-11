package com.view.home;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.model.shoppDao.order_Dao;
import com.model.shoppDao.viewer;
import com.view.qianduan.JFview;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Wtchview extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private order_Dao orddao=new order_Dao();
	private boolean bool=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Wtchview dialog = new Wtchview();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Wtchview() {
		setUndecorated(true);
		setSize(803, 400);
		setLocationRelativeTo(null);
		
		setIconImage(new ImageIcon(JFview.class.getResource("/images/qianduan/logo.png")).getImage()); 
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
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
			if(bool) {
				dispose();
			}
				
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
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		JPanel view = null ;
		viewer ver;
		List<viewer> list=orddao.findview();
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			view=new JPanel();
			view.setLayout(null);
			ver=list.get(i);
			JLabel jltime=new JLabel(ver.getCreateDate());
			jltime.setBounds(10, 10, 150, 40);
			JLabel jlview=new JLabel(ver.getContent());
			jlview.setFont(new Font("ËÎÌו", Font.BOLD, 15));
			jlview.setBounds(150, 0, 500, 80);
			JLabel jluser=new JLabel(ver.getUid()+"");
			jluser.setBounds(650, 60, 100, 30);
			System.out.println(ver.getUid());
			view.add(jltime);
		
			view.add(jlview);
			view.add(jluser);
			panel_1.add(view);
		}
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(14)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(new GridLayout(4,1));
		
		JLabel lblNewLabel = new JLabel("\u7D2F\u8BA1\u8BC4\u8BBA"+"("+list.size()+")");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 25));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(636, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPanel.setLayout(gl_contentPanel);
//		JScrollPane js=new JScrollPane(panel_1);
	}
}
