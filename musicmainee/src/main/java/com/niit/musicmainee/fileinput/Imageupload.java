package com.niit.musicmainee.fileinput;

import java.io.*;
import org.springframework.web.multipart.MultipartFile;

public class Imageupload 
{

	public static void upload(String path, MultipartFile file,String fileName) {
		if(!file.isEmpty()){
			InputStream inputStream = null;
			OutputStream outputStream = null; 
			if(file.getSize()>0)
			{
			try 
			{
				inputStream=file.getInputStream();
				outputStream=new FileOutputStream(path+fileName);
			System.out.print("4");
			int readBytes = 0;
			System.out.print("5");
			byte[] buffer = new byte[1024];
			System.out.print("6");
			while((readBytes = inputStream.read(buffer, 0, 1024))!=-1) {

				outputStream.write(buffer, 0, readBytes);
			  }
			}
		 catch (IOException e) 
			{
			e.printStackTrace();
		}
		finally
		{
			try {
				outputStream.close();
				inputStream.close();
				
				
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	  }
		}
	}
}
