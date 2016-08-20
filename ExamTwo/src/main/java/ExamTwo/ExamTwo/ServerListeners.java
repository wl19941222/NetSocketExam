package ExamTwo.ExamTwo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;




public class ServerListeners extends Thread {

	@Override
	public void run() {
		//1-65535
		try {
			ServerSocket serverSocket = new ServerSocket(34567);
			while (true) {
				//block阻塞
				Socket socket = serverSocket.accept();
				//建立连接
				JOptionPane.showMessageDialog(null, "有客户端连接到了本机的34567端口");
				
				ChatSocket cs = new ChatSocket(socket);
				cs.start();
				ChatManager.getChatManager().add(cs);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
