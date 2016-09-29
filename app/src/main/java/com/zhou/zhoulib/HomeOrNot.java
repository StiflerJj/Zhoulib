package com.zhou.zhoulib;

import android.os.StrictMode;
import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketTimeoutException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by z on 2016/2/1.
 * HomeOrNot homeornot = new HomeOrNot();
 String ipAddr = homeornot.DoText();
 if(ipAddr.isEmpty()){
 Toast.makeText(this.getApplicationContext(),"not at home", Toast.LENGTH_SHORT).show();
 }else {
 Toast.makeText(this.getApplicationContext(),"at home", Toast.LENGTH_SHORT).show();
 }
 */
public class HomeOrNot {
    private static final String DISCOVER_CEGATEWAY_REQUEST = "DISCOVER_CEGATEWAY_REQUEST";
    private static final String DISCOVER_CEGATEWAY_RESPONSE = "DISCOVER_CEGATEWAY_RESPONSE";
    private static final int SOCKET_TIME_OUT=3000;

    private String ipAddr;

    public String getIpAddr() {
        return ipAddr;
    }

    public String DoText() {
        ipAddr = "";
        // Find the server using UDP broadcast
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            //Open a random port to send the package
            DatagramSocket c  = new DatagramSocket();
            c.setBroadcast(true);
            c.setSoTimeout(SOCKET_TIME_OUT);

            byte[] sendData = DISCOVER_CEGATEWAY_REQUEST.getBytes();

            //Try the 255.255.255.255 first
            try {
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("255.255.255.255"), 8888);
                c.send(sendPacket);
                System.out.println(getClass().getName() + ">>> Request packet sent to: 255.255.255.255 (DEFAULT)");
            } catch (Exception e) {
                Logger.getLogger("-------------------------------------------------------------------------abc").log(Level.WARNING,null,e);
            }

            // Broadcast the message over all the network interfaces
            Enumeration interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) interfaces.nextElement();

                if (networkInterface.isLoopback() || !networkInterface.isUp()) {
                    continue; // Don't want to broadcast to the loopback interface
                }

                for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                    InetAddress broadcast = interfaceAddress.getBroadcast();
                    if (broadcast == null) {
                        continue;
                    }

                    // Send the broadcast package!
                    try {
                        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, broadcast, 8888);
                        c.send(sendPacket);
                    } catch (Exception e) {
                        Logger.getLogger("-------------------------------------------------------------------------bbbb").log(Level.WARNING,null,e);
                    }

                    System.out.println(getClass().getName() + ">>> Request packet sent to: " + broadcast.getHostAddress() + "; Interface: " + networkInterface.getDisplayName());
                }
            }

            System.out.println(getClass().getName() + ">>> Done looping over all network interfaces. Now waiting for a reply!");

            //Wait for a response

            byte[] recvBuf = new byte[15000];
            DatagramPacket receivePacket = new DatagramPacket(recvBuf, recvBuf.length);
            try{
                c.receive(receivePacket);
            }catch (SocketTimeoutException e){
                e.printStackTrace();

            }


            //We have a response
            //System.out.println(getClass().getName() + ">>> Broadcast response from server: " + receivePacket.getAddress().getHostAddress());

            //Check if the message is correct
            String message = new String(receivePacket.getData()).trim();
            if (message.equals(DISCOVER_CEGATEWAY_RESPONSE)) {
                //DO SOMETHING WITH THE SERVER'S IP (for example, store it in your controller)
                //Controller_Base.setServerIp(receivePacket.getAddress());

                ipAddr = receivePacket.getAddress().getHostAddress()+"";
            }

            //Close the port!
            c.close();
        } catch (IOException ex) {
            Logger.getLogger("-------------------------------------------------------------------------ccc").log(Level.WARNING,null,ex);
        }
        Log.e("HomeOrNot", "DoText IPAddress =" + ipAddr);
        return ipAddr;
    }
}
