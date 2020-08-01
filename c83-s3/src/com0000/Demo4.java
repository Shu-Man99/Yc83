package com0000;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class Demo4 {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.hyycinfo.com");
		
		System.out.println(url.getProtocol()); //Э��
		System.out.println(url.getPort());//�˿�
		System.out.println(url.getPath());//��Դ·��
		System.out.println(url.getHost());//����
		System.out.println(url.getFile());//��Դ��
		System.out.println(url.getQuery());//����
		
		URLConnection conn = url.openConnection();
		System.out.println(conn.getLastModified());//Ŀ����Դ������޸�ʱ��
		System.out.println(conn.getContentLengthLong());//Ŀ����Դ�Ĵ�С
		System.out.println(conn.getContentType());//Ŀ����Դ������
		
		
		System.out.println("========");
		InputStream in = conn.getInputStream();
		
		byte[] buffer = new byte[1024];
		int count;
		while((count = in.read(buffer)) > 0) {
			System.out.println(new String(buffer,0,count));
		}
		in.close();
	}

}


