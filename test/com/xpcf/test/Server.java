package com.xpcf.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author XPCF
 * @version 1.0
 * @date 5/20/2021 1:46 AM
 */
public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);
        byte[] buffer = "asdasdasd".getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length, InetAddress.getByName("www.baidu.com"), 80);
        socket.send(packet);
        socket.close();
    }
}
