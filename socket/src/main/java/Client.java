import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8888)) {
            System.out.println("等待客户端连接");
            Socket socket = server.accept();
            System.out.println("客户端已连接，ip：" + socket.getInetAddress().getHostAddress());
//            InputStream in = socket.getInputStream();
//            int num = in.read();
//            while(num != -1){
//                System.out.print((char)num);
//                num = in.read();
//            }

//            System.out.println("数据接收完成");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            outputStreamWriter.write("HTTP/1.1 200 Accepted\r\n");
            outputStreamWriter.write("\r\n");
            outputStreamWriter.write("lbwnb!");
            outputStreamWriter.flush();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
