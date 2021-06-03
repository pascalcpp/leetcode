package com.xpcf.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * @author XPCF
 * @version 1.0
 * @date 5/20/2021 1:46 AM
 */
public class Client {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket(InetAddress.getLocalHost(), 4396);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        TimeUnit.SECONDS.sleep(10);
        socket.shutdownOutput();
        System.out.println("client socket 关闭 output");

        int len = 0;
        byte[] buffer = new byte[1024];

        while ((len = inputStream.read(buffer)) != -1) {

        }

        socket.shutdownInput();
        System.out.println("client socket 关闭 input");
        socket.close();
        TimeUnit.SECONDS.sleep(60);
        System.out.println();
    }
}
