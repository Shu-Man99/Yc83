package day0726;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class D1 {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.hyycinfo.com");
		URLConnection conn = url.openConnection();
		
		int filesize = conn.getContentLength();
		int blocksize =2*1024*1024;
		int blocknums = filesize/blocksize;
		if(filesize%blocksize != 0 ) {
			blocknums++;
		}
		for(int i=0;i<blocknums;i++) {
			conn = url.openConnection();
			InputStream in = conn.getInputStream();
			FileOutputStream out = new FileOutputStream("");
			
			int beginBytes = i*blocksize;
			int endBytes = beginBytes + blocksize;
			if(endBytes > filesize) {
				endBytes = filesize;
			}
			in.skip(beginBytes);
			
			byte[] buffer = new byte[1024];
			int count;
			while((count = in.read(buffer)) > 0) {
				out.write(buffer,0,count);
			}
			in.close();
			out.close();
		}
		
		
		
	}

}
