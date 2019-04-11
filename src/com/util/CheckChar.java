package com.util;

public class CheckChar {
public static boolean checkNum(String str) {
	boolean b = false;
	char[]ch=str.toCharArray();
	for (int i = 0; i < ch.length; i++) {
		char c = ch[i];
		if(!(c>='0'&&c<='9')) {
	
		return b;
	}
	}
return true;
}
public static boolean checkChars(String str) {
	boolean b = false;
	char[]ch=str.toCharArray();
	for (int i = 0; i < ch.length; i++) {
		char c = ch[i];
		if(c<=33||c>=126) {
			return b;
	
	}
		}
	return true;
}
public static boolean checkChinese(String str) {
	boolean b = false;
	char[]ch=str.toCharArray();
	for (int i = 0; i < ch.length; i++) {
		char c = ch[i];
		if(c<32) {
			return b;
	
	}
		}
	return true;
}
}
