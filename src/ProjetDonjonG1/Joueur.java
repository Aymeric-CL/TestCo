package ProjetDonjonG1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;




public class Joueur implements Runnable {
	protected int numero;
	protected int nbPoints;
	protected BufferedReader in;
	protected PrintStream out;
	
	protected Joueur adversaire;
	protected boolean jouer;
	private JoueurServeur[] lesJoueurs;

	public Joueur() {}

	public Joueur(Socket socket) {
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream());
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		new Thread(this).start();
		adversaire = new Joueur();
	}

	public Joueur(Socket socket, int numero) {
		this(socket);
		this.numero = numero;
	}
	
	public void run() {}

	
		
	
	

}
