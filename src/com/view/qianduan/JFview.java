package com.view.qianduan;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class JFview extends JFrame{

public JFview() {
	setIconImage(new ImageIcon(JFview.class.getResource("/images/qianduan/logo.png")).getImage());
	setBackground(Color.GRAY);
	setSize(530,500);
	setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}


}
