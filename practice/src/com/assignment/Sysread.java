package com.assignment;

import java.io.IOException;

public class Sysread {


	
	 public static void main(String[] args) throws IOException {
	    
		 
	        System.out.print("입력 : ");
	        int anum = System.in.read();
	        System.out.println("출력 : " + anum);
	
	        System.in.read();
	        System.in.read();
	        
	        System.out.print("입력 : ");
	        int num = System.in.read() - 48;
	        System.out.print("출력 : " + num);
	        
	        System.in.read();
	        System.in.read();
	      
	        System.out.print("\n입력 : ");
	        char char_ = (char) System.in.read();
	       
	        System.out.println("출력 : " + char_);
	 
	    }
	 
	}