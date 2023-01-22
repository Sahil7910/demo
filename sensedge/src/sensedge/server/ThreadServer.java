package sensedge.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 5442
 */
public class ThreadServer {
	/*
	 * public static void main(String[] args) throws IOException {
	 * 
	 * SimpleDateFormat Date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); String
	 * timeStamp = Date.format(new Date());
	 * 
	 * final int PORT = 9191; ServerSocket serverSocket = new ServerSocket(PORT);
	 * 
	 * System.out.println("Server started...");
	 * System.out.println("Wating for clients...");
	 * 
	 * 
	 * 
	 * 
	 * 
	 * while(true) { Socket clientSocket = serverSocket.accept();
	 * 
	 * Thread t =new Thread() {
	 * 
	 * public void run() {
	 * 
	 * try {
	 * 
	 * BufferedReader in = new BufferedReader(new
	 * InputStreamReader(clientSocket.getInputStream()));
	 * System.out.println("Client response: " + in.toString()); //BufferedWriter out
	 * = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
	 * PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
	 * 
	 * String line=in.readLine(); System.out.println("ID="+line);
	 * 
	 * 
	 * try {
	 * 
	 * Class.forName("com.mysql.cj.jdbc.Driver");
	 * 
	 * Connection con =
	 * DriverManager.getConnection("jdbc:mysql://localhost:3307/demo", "root",
	 * "admin");
	 * 
	 * System.out.println("Inserting records into the table..."); String sql =
	 * "insert into readerstr(CardID,DateTime) values(?,?)"; PreparedStatement
	 * preparedStmt = con.prepareStatement(sql); preparedStmt.setString(1, line );
	 * preparedStmt.setString(2,timeStamp);
	 * 
	 * preparedStmt.execute();
	 * 
	 * System.out.println("Inserted records into the table successfully...");
	 * con.close();
	 * 
	 * String SQLCHECK = "select * from user where CardID='" + line + "'"; Statement
	 * stm = con.createStatement(); ResultSet rs2 = stm.executeQuery(SQLCHECK);
	 * 
	 * if (rs2.next()) {
	 * 
	 * String ID=rs2.getString(2);
	 * 
	 * System.out.println("ID"+ID);
	 * 
	 * System.out.println("line"+line);
	 * 
	 * if(line.equals(ID)) { out.println(0); }else { out.println(1); } }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 *     
	 * } }; t.start(); }
	 * 
	 * 
	 * 
	 * 
	 * } }
	 */

	public static void main(String args[]) throws Exception {
		ServerSocket ss = new ServerSocket(0);
		//final Socket s1 = null;
	    Socket s2 = null;
		
		try {
			int port = 9090;
			
			System.out.println("Port:" + port);

			while (true) {
			 Socket s1 = new Socket();
				
				 Thread t =new Thread() {
		        		
	        		 public void run() {
	        			 
	        			 try {
	        				 BufferedReader in = new BufferedReader(new InputStreamReader(s1.getInputStream()));
	                         System.out.println(in.toString());
	                         //BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
	                         PrintWriter out = new PrintWriter(s1.getOutputStream(), true);
	                         
	                         String CardID=in.readLine();
	                         System.out.println("ID="+CardID);
	        			 }catch (Exception e) {
	        				 e.printStackTrace();						}   
	        		 }
			};
			t.start();

	
				s1.close();
			}
		} finally {
			if (ss != null)
				ss.close();
			if (s2 != null)
				s2.close();
		}

	}
}
