/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Multi;
import java.io.*;
import java.net.*;
import java.util.*;

// Client class
class Client {
	
	// driver code
	public static void main(String[] args)
	{
		// establish a connection by providing host and port
		// number
		try (Socket socket = new Socket("localhost", 1234)) {
                	// writing object to server
			
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        BufferedReader in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			// object of scanner class
			Scanner sc = new Scanner(System.in);
			String kod = null;

			while (!"exit".equalsIgnoreCase(kod)) {
		            
                            System.out.println("Baraa kod:");
                            kod = sc.next();
                            Baraa b = new Baraa(kod);
                            System.out.println("Baraa ner:");
                            b.name = sc.next();
                            System.out.println("Baraa une:");
                            b.une = sc.nextInt();
                            System.out.println("Baraa turul:");
                            b.turul = sc.next();

                            oos.writeObject(b);
                           
                            oos.flush();

				
			}
			
			// closing the scanner object
			sc.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
