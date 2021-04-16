package ProjetDonjonG1;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;



public class JoueurServeur extends Joueur implements Runnable  {
	
	
	



		void traiterMessage(String message) {
			int type;
			Scanner scan = new Scanner(message);

			type =scan.nextInt();

	
			
			
			}
		public void envoyerNumero() {
			out.println( numero);
		}
		
		public void run() {
			String message;

			try {
				message = in.readLine();
				traiterMessage(message);
				message = in.readLine();
				
			}
			catch(IOException exc) {

			}
		}


		
				
	}