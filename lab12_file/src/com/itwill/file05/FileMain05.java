package com.itwill.file05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.itwill.file04.Product;

public class FileMain05 {

	public static void main(String[] args) {
		// 파일에 쓸(write) 더미 데이터
		ArrayList<Product> list = new ArrayList<>();
		for (int i = 0; i < 1_000_000; i++) {
			list.add(new Product(i, "name_" + i, i));
		}
		System.out.println("size = " + list.size());

		// ArrayList를 저장하는 파일 이름
		String filename = "data/product_list.dat";

		// 1. Product 타입 객체 1,000,000개를 저장하는 ArrayList를 파일 쓰기
		// FOS, BOS, OOS을 이용

		try (FileOutputStream out = new FileOutputStream(filename);
				BufferedOutputStream bos = new BufferedOutputStream(out);
				ObjectOutputStream oos = new ObjectOutputStream(bos)) {
			
				oos.writeObject(list);
			


		} catch (Exception e) {
			e.printStackTrace();
		}

		// 2. 파일에서 객체를 읽어서 ArrayList<Product>로 변환하기
		// FIS, BIS, OIS을 이용

		try (FileInputStream in = new FileInputStream(filename);
				BufferedInputStream bis = new BufferedInputStream(in);
				ObjectInputStream ois = new ObjectInputStream(bis);) {
			
			
			ArrayList<Product> a = (ArrayList<Product>) ois.readObject();
			
			System.out.println(a.size());
			
			System.out.println(a.get(500));
			
			System.out.println(a.get(999999));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
