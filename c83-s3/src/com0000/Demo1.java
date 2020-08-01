package com0000;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class Demo1 {
   private int downNums=0;
	public static void main(String[] args) throws IOException,InterruptedException {
		new Demo1().download();
	}
 public void download() throws IOException,InterruptedException{
		URL url = new URL(
				"https://mirror.bit.edu.cn/apache/tomcat/tomcat-10/v10.0.0-M7/bin/apache-tomcat-10.0.0-M7-windows-x64.zip");

		String filename = "d:/apache-tomcat-10.0.0-M7-windows-x64.zip";
		long time = System.currentTimeMillis();

		URLConnection conn = url.openConnection();
		// 获取文件总大小
		int filesize = conn.getContentLength();
		// 每块的大小 (自定义 2M)
		int blocksize = 2 * 1024 * 1024;
		// 计算块数
		int blocknums = filesize / blocksize;
		if (filesize % blocksize != 0) {
			blocknums++;
		}
		System.out.println("开始下载");

		// 分块下载
		for (int i = 0; i < blocknums; i++) {
			downNums++;
			int index=i;
			new Thread() {
				public void run() {
					try {
						
			System.out.println("第" + (index + 1) + "块开始下载");
			/**在每次循环中 获取 一个连接对象*/
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			FileOutputStream out = new FileOutputStream(filename + index);
			// 开始的字节数
			int beginBytes = index * blocksize;
			// 结束的字节数
			int endBytes = beginBytes + blocksize;
			// 结束的字节数不能超过文件的大小
			if (endBytes > filesize) {
				endBytes = filesize;
			}
			// 跳过开始的字节数
			in.skip(beginBytes);
			/**
			 * 	请下载当前块内的字节数
			 * 	1. 计数
			 * 	2. 判断
			 */
			// 当前下载到的位置
			int position = beginBytes;
			byte[] buffer = new byte[1024];
			int count;
			while ((count = in.read(buffer)) > 0) {
				if (position + count > endBytes) {
					// 计算超出部分
					int a = position + count - endBytes;
					// 减去超出的部分
					count = count - a;
				}
				out.write(buffer, 0, count);
				// 更新下载位置( 向前推进 )
				position += count;
				// 如果下载位置已经到达该块结束位置
				if (position >= endBytes) {
					break;
				}
			}
			in.close();
			out.close();
			System.out.println("第" + (index + 1) + "块结束下载");
			synchronized (Demo1.this) {
				Demo1.this.downNums --;
				Demo1.this.notify();
			}
			}catch(IOException e) {
				e.printStackTrace();
		}
 }
}.start();
}
synchronized(this) {
	while(downNums>0) {
		wait();
	}
}
		// 合并文件
		marge(filename, blocknums);
		/**
		 * 请清空临时保存的小文件
		 */
		System.out.println("共花了" + (System.currentTimeMillis() - time) / 1000 + "秒");
		System.out.println("下载完成");
	}

	// 合并文件
	public static void marge(String path, int filenums) throws IOException {
		FileOutputStream fos = new FileOutputStream(path);
		for (int i = 0; i < filenums; i++) {
			FileInputStream fis = new FileInputStream(path + i);
			byte[] buffer = new byte[1024];
			int count;
			while ((count = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, count);
			}
			fis.close();
		}
		fos.close();
	}

}