/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaproject;

import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Server c
class Server {

	public static void main(String[] args) throws SQLException {

		ServerSocket server = null;
		try {
			server = new ServerSocket(1234);
			server.setReuseAddress(true);
			System.out.println("started");
			while (true) {
				Socket client = server.accept();
				System.out.println("New client connected" + client.getInetAddress().getHostAddress());
				ClientHandler clientSock = new ClientHandler(client);
				new Thread(clientSock).start();
			}
		}
                catch (IOException e) {
		} finally {
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
				}
			}
		}
                
                //SignUpForm-d duudaj burtgelin utguuda shidne.
                //Enend SignUp() classin object uusgej database ru
                //higed amjilttai bol true return hine
                public DoSignUp(){
                    
                }
                
                //LogInForm-d oruulsan 2 utgiig iishe shidej endes LogIn()
                //ru yavuulj database tei haritsulad biylvel true butsaana
                public DoLogIn(){
                    
                }
	}

	private static class ClientHandler implements Runnable {

		private final Socket clientSocket;

		public ClientHandler(Socket socket) {
			this.clientSocket = socket;
		}

		@Override
		public void run() {
			PrintWriter out = null;
			ObjectInputStream ois = null;

			try {
				out = new PrintWriter(clientSocket.getOutputStream(), true);
				ois = new ObjectInputStream(clientSocket.getInputStream());
				while (((Object) ois.readObject()) != null) {

				}
			} catch (IOException e) {
			} catch (ClassNotFoundException ex) {
				Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				try {
					if (out != null) {
						out.close();
					}
					if (ois != null) {
						ois.close();
						clientSocket.close();
					}
				} catch (IOException e) {
				}
			}
		}
	}
}
