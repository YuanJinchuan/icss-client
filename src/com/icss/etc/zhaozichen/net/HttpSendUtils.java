package com.icss.etc.zhaozichen.net;

import com.icss.etc.zhaozichen.Student;

import java.io.*;
import java.net.Socket;

/**
 * @title:
 * @fileName: ${fileName}
 * @description:
 * @copyright:
 * @company: 个人
 * @author: 原晋川
 * @date: 2020/12/26 11:29
 * @version: V1.0
 */
public class HttpSendUtils {

    private static HttpSendUtils sendUtils = null;

    private HttpSendUtils() {
    }

    private static HttpSendUtils getInstance() {
        if (sendUtils == null) {
            sendUtils = new HttpSendUtils();
        }
        return sendUtils;
    }

    public String send(String ip, int port, Object... objects) {
        Socket socket = null;
        String info = null;
        try {
            socket = new Socket(ip, port);
            socket.setSoTimeout(100000);
            // 向服务端程序发送数据
            // 2.获取该Socket的输出流，用来向服务器发送信息
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(new Student("1", "1", "1", "1", "1"));
            socket.shutdownOutput();

            // 3.获取输入流，取得服务器的信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            while ((info = br.readLine()) != null) {
                System.out.println("服务器端的信息：" + info);
            }
            socket.shutdownInput();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return info;
    }

    public static void main(String[] args) {
        String info = HttpSendUtils.getInstance().send("222.186.174.9", 42104);

    }
}
