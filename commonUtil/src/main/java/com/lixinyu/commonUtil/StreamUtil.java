package com.lixinyu.commonUtil;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtil {
	public static void closeAll(AutoCloseable...autoCloseables) {
		if(autoCloseables!=null) {
			for (AutoCloseable autoCloseable : autoCloseables) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static String readFile(File file) {
		InputStream inputstram =null;
		String str="";
		try {
			inputstram = new FileInputStream(file);
			byte[] b=new byte[1024];
			while(inputstram.read(b)!=-1) {
				str+=new String(b);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(inputstram);
		}
		return str;
	}
	public static void writerTestFile(String content,File file) {
		String parent = file.getParent();
		File parentFile = new File(parent);
		if(!parentFile.exists()) {
			parentFile.mkdirs();
		}
		BufferedWriter writer=null;
		try {
			writer = new BufferedWriter(new FileWriter(file,true));
			writer.write(content+"\n");
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(writer);
		}
	}
	public static void main(String[] args) {
		writerTestFile("我是你爸爸", new  File("D:\\游戏\\aaa.txt"));
	}
}
