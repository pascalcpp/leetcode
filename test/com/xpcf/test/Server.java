package com.xpcf.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * @author XPCF
 * @version 1.0
 * @date 5/20/2021 1:46 AM
 */
public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(4396);
        Socket socket = serverSocket.accept();
        System.out.println("client 成功连接 server");
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();


        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = inputStream.read(buffer)) != -1) {

        }
        socket.shutdownInput();
        System.out.println("server socket 关闭 input");

        TimeUnit.SECONDS.sleep(10);
        socket.shutdownOutput();
        System.out.println("server socket 关闭 output");

        TimeUnit.SECONDS.sleep(3000);
    }
}
