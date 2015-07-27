package com.qq.client.tools;
/**
 * 这是一个管理客户端和服务器保持通讯的线程类
 * @author Administrator
 */
import java.net.*;
import java.util.HashMap;
import java.io.*;

public class ManageClientConServerThread {

		 private static HashMap hm = new HashMap<String, ClientConServerThread>();
		 //吧创建好的ClientConServerThread放入到hm中去
		 public static void addClientConServerThread(String qqid,ClientConServerThread ccst){
			 hm.put(qqid, ccst);
		 }
		 //可以通过qqId取得该线程
		 public  static ClientConServerThread getClientConServerThread(String qqId){
			return  (ClientConServerThread) hm.get(qqId);
		 }
		 
}
