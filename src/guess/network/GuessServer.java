package guess.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class GuessServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server=null;
		HashMap<String, Socket>hashMap=new HashMap<>();
		server=new ServerSocket(8080);
		System.out.println("服务器运行，等待客户端连接");
		Boolean flag=true;
		while (flag) {
			Socket clientSocket=server.accept();
			hashMap.put(clientSocket.getPort()+"",clientSocket);
			ServerThread ts=new ServerThread();
			ts.setSocket(clientSocket);
			ts.setHashMap(hashMap);
			ts.start();
		}
		server.close();
	}
}
