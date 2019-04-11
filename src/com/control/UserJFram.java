package com.control;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

import com.view.qianduan.Login;

public class UserJFram {
public static void main(String[] args) {
	JFrame.setDefaultLookAndFeelDecorated(true);
	JDialog.setDefaultLookAndFeelDecorated(true);
	try {
		
		UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
	} catch (Exception e) {
	
		e.printStackTrace();
	}
	Login login=new Login();
	login.setVisible(true);
}
}

