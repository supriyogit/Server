package com.ibm.cbn.itademo.networking;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;

public class WorkerRunnable implements Runnable{

    protected Socket clientSocket = null;
    protected String serverText   = null;

    public WorkerRunnable(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }
    
    public void run() {
        try {
        	ObjectInputStream serverInputStream = new ObjectInputStream(
        			clientSocket.getInputStream());
        	
            ObjectOutputStream serverOutputStream = new ObjectOutputStream(
            		clientSocket.getOutputStream());
            Report anchorReport = (Report) serverInputStream.readObject();
            if(anchorReport != null)
            	System.out.println("Bearing = " + anchorReport.bearing);
            else
            	System.out.println("Unable to retrieve anchor report");
            
            System.out.println("Closing anchor connection");
            
            serverInputStream.close();
            serverOutputStream.close();
        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}