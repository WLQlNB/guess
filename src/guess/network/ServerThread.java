package guess.network;

import java.io.*;
import java.net.*;
import java.util.*;


public class ServerThread extends Thread{
	private Socket clientSocket=null;
	private HashMap<String, Socket> hashMap;
	
	public void setSocket(Socket clientSocket) {
		this.clientSocket=clientSocket;
	}
	
	public void setHashMap(HashMap<String, Socket> hashMap) {
		this.hashMap=hashMap;
	}
	
	public void run() {
		try {
			DataOutputStream output=null;
			DataInputStream buf=new DataInputStream(clientSocket.getInputStream());
			Boolean flag=true;
			while (flag) {
				System.out.println(clientSocket+"\n等待客户端发送消息....");
				String msg=buf.readUTF();
				System.out.println("接收内容>>>>"+msg);
				String[]txt=msg.split(":");
				String formId=txt[0];
				hashMap.put(formId, clientSocket);
				for (String key:hashMap.keySet()) {
					if(!formId.equals(key)) {
						Socket socket=hashMap.get(key);
						output=new DataOutputStream(socket.getOutputStream());
						output.writeUTF(msg);
					}				
				}
			}
			output.close();
			buf.close();
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
