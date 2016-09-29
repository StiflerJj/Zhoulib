package com.zhou.zhoulib.gateway;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by dkdh on 2016/4/11.
 */
public class SetAP {
    private static  final String TAG = "SetAP";
    private static  final String HOST = "10.5.5.1";
    private static  final int PORT = 8989;
    private StringBuffer sb = new StringBuffer();

    public SetAP(String wifi_name, String wifi_password){

        sb.append("$APSET:");
        sb.append(wifi_name);
        sb.append(":");
        sb.append(wifi_password);
        sb.append(":0");
        sb.append("\r\n");
        SocketClient client = new SocketClient(HOST, PORT, sb.toString());
        client.start();
        Log.e(TAG, sb.toString());
    }

    public class SocketClient extends Thread{
        Socket socket;
        PrintWriter writer;
        String host;
        int port;
        String data;
        public  SocketClient(String host, int port, String data){
            this.host = host;
            this.port = port;
            this.data = data;
        }
        @Override
        public void run() {
            try{
                socket = new Socket();
                socket.connect(new InetSocketAddress(host, port), 0);
                if(socket.isConnected()){
                    writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
                    writer.print(data);
                    writer.flush();
                }
                Log.e(TAG, data);
                writer.close();
                socket.close();
            }catch(UnknownHostException e){
                Log.e(TAG, e.toString());
            }catch (IOException ex){
                Log.e(TAG, ex.toString());
            }catch (Exception ex2){
                Log.e(TAG, ex2.toString());
            }

        }
    }
}
