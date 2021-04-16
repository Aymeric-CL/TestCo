package ProjetDonjonG1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Serveur{
	private JoueurServeur[] lesJoueurs;
	private int numSuivant = 0;
	
	public Serveur(JoueurServeur[] lesJoueurs) {
		this.lesJoueurs = lesJoueurs;
	}

	public Serveur() {
		// TODO Auto-generated constructor stub
	}

	public void ajouterJoueur(Socket socket) {
		lesJoueurs[numSuivant] = new JoueurServeur();
		numSuivant++;
		if (numSuivant == 2) donnerFeuVert();
	}

	public void traiterMessage(String message) {
		System.out.println(message);
		Scanner scan = new Scanner(message);
		int type = scan.nextInt();
	}

	

	
	
	public void donnerFeuVert() {
		for (JoueurServeur j : lesJoueurs) j.envoyerNumero();
	}
	public void run() throws Exception {
		int port = 7584;
		ServerSocket ss= null;
		try {
			ss = new ServerSocket(port);
			int nbClients=1;
			Socket s ;
			while (true) {
				System.out.println("En attente de connexion..");
				s= ss.accept();
				++nbClients;
				Client player = new Client(s);
				System.out.println("Connexion réussi");
				player.start();
				
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}

	public static void main(String[] arg) throws Exception {
		int nbClients=1;
		while (nbClients<6) {
			System.out.println("Vous etes le joueur numero " + nbClients);
			new Serveur().run();
			nbClients+=1;
			
			
		}
			
		

		
	}
	
	
	
}
