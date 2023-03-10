package sensedge.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class GreetServer {

	//  private static final Logger LOG = Logger.getLogger(GreetServer.class);

	    private ServerSocket serverSocket;

	    public void start(int port) {
	        try {
	            serverSocket = new ServerSocket(port);
	           
               while (true)
	                new EchoClientHandler(serverSocket.accept()).start();

	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            stop();
	        }

	    }

	    public void stop() {
	        try {

	            serverSocket.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }

	    private static class EchoClientHandler extends Thread {
	        private Socket clientSocket;
	        private PrintWriter out;
	        private BufferedReader in;

	        public EchoClientHandler(Socket socket) {
	            this.clientSocket = socket;
	        }

	        public void run() {
	            try {
	                out = new PrintWriter(clientSocket.getOutputStream(), true);
	                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	                String inputLine;
	                while ((inputLine = in.readLine()) != null) {
	                    if (".".equals(inputLine)) {
	                        out.println("bye");
	                        break;
	                    }
	                    out.println(inputLine);
	                }

	                in.close();
	                out.close();
	                clientSocket.close();

	            } catch (IOException e) {
	              //  LOG.debug(e.getMessage());
	            }
	        }
	    }

	    public static void main(String[] args) {
	        GreetServer server = new GreetServer();
	        server.start(5555);
	    }

	}

