package com.ibm.cbn.itademo.networking;

public class DriveServer {
	public static void main(String[] args){
	AggregationServer server = new AggregationServer(4444);
	new Thread(server).start();

	try {
	    Thread.sleep(60 * 1000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	System.out.println("Stopping Server");
	server.stop();
	}
}