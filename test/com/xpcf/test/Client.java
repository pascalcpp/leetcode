package com.xpcf.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author XPCF
 * @version 1.0
 * @date 5/20/2021 1:46 AM
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 4396);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello world".getBytes());


//        socket.shutdownOutput();
        outputStream.close();
        socket.close();
    }
}
