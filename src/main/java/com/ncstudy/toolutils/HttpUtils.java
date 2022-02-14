package com.ncstudy.toolutils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
   *   自带的处理方式
 * @author KJS_352
 *
 */
public class HttpUtils {
	
	/**
	 * post
	 * @param url 路由 
	 * @param content 信息
	 */
	 public static void doPost(String url, String content) {
		 
		 	try {
				URL urls = new URL(url);
				HttpURLConnection conn = (HttpURLConnection) urls.openConnection();
				conn.setDoOutput(true);
				conn.setDoInput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("accept", "*/*");
				conn.setRequestProperty("connection", "Keep-Alive");
				conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
				conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
				conn.connect();
				
				if(content != null) {
					BufferedWriter write = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(),"UTF-8"));
					write.write(content);  //写入参数
					write.flush();
					write.close();
				}
				int code = conn.getResponseCode();//响应参数
				if( code == HttpURLConnection.HTTP_OK) {
					InputStream input = conn.getInputStream();
					InputStreamReader inputReader = new InputStreamReader(input,"utf-8");
					BufferedReader bufferReader = new BufferedReader(inputReader);
					//BufferedReader bufferReader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
					
					String str = null;
					StringBuffer buffer = new StringBuffer();
					while((str = bufferReader.readLine()) != null) {
						buffer.append(str);
					}
					bufferReader.close();
					inputReader.close();
					input.close();
					conn.disconnect();
					
					System.out.println(buffer.toString());
				}
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	 }
	 
	 /**
	  * GET
	  * @param url
	  */
	 public static void doGet(String url) {
		 
		 	try {
				URL urls = new URL(url);
				HttpURLConnection conn = (HttpURLConnection) urls.openConnection();
				conn.setDoOutput(true);
				conn.setDoInput(true);
				conn.setRequestMethod("GET");
				conn.connect();
				
				int code = conn.getResponseCode();//响应参数
				if( code == HttpURLConnection.HTTP_OK) {
					InputStream input = conn.getInputStream();
					InputStreamReader inputReader = new InputStreamReader(input,"utf-8");
					BufferedReader bufferReader = new BufferedReader(inputReader);
					//BufferedReader bufferReader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
					
					String str = null;
					StringBuffer buffer = new StringBuffer();
					while((str = bufferReader.readLine()) != null) {
						buffer.append(str);
					}
					bufferReader.close();
					inputReader.close();
					input.close();
					conn.disconnect();
					
					System.out.println(buffer.toString());
				}
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	 }
}
