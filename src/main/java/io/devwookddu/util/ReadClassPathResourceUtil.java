package io.devwookddu.util;

import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;

public class ReadClassPathResourceUtil {

	public static String getStringFromFile(String fileName){
		InputStream is = null;
  	int n = -1;
  	byte[] b = new byte[2048];
  	StringBuffer sb = new StringBuffer();
  	try{
  		is = new ClassPathResource(fileName).getInputStream();
  		while( (n = is.read(b)) != -1 ){
  			sb.append(new String(b, 0, n));
  		}
  	}catch(Exception e){
  		e.printStackTrace();
  	}finally{
  		try{ if( is != null ) is.close(); }catch(Exception e){ }
  	}
		return sb.toString();
	}
	
}
