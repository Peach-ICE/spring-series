import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {


    public static void main(String[] args) {
        try(Socket server = new Socket("localhost",8787)) {
            Scanner scan = new Scanner(System.in);
            OutputStreamWriter outToServer = new OutputStreamWriter(server.getOutputStream());
            System.out.println("连接成功，请输出发送内容：");
            outToServer.write(scan.nextLine() + "\n");
            outToServer.flush();
            System.out.println("发送数据成功，等待服务端回应");
            BufferedReader read = new BufferedReader(new InputStreamReader(server.getInputStream()));
            System.out.println(read.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
