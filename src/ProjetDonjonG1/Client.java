package ProjetDonjonG1;


import java.net.Socket;
import java.util.Scanner;

import ProjetDonjonG1.Grille;
import ProjetDonjonG1.Objectif;
import ProjetDonjonG1.Personnage;



public class Client  extends Joueur implements Runnable {

	
	public Client() {}

	public Client(Socket socket)  throws Exception{	
		super(socket);
	}
	
	public void traiterMessage(String message , Grille g1 , Grille g2) throws ExceptionGrille, ExceptionPersonnage, ExceptionPiege, ExceptionObjet, ExceptionPotion, ExceptionInventaire {
	
		String perso = " Votre personnage";
		Personnage p1 = new  Personnage (perso);
		
		if(message.equals("C") || message.equals("c") ) {
			System.out.print("renter le prenom de votre personnage (il faut au moins 2 lettres ) : ");
			Scanner sc = new Scanner(System.in); 
			String p = sc.next();
			
			System.out.println("Votre personnage a ete cree est place dans le donjon");
			System.out.println(" ");
			System.out.println("Le but du jeu et de reussir a tombe sur la bonne case pour cela vous allez devoir effectuer 4 deplacements et le personnage ce deplacera dans le donjon ");
			System.out.println("Attention dans ce donjon il y a des pieges qui vous fera perdre de la vie");
			System.out.println("mais rassurez vous il y a aussi des potions que vous pouvez rammasser et utiliser.");
			System.out.println(" ");
			System.out.println("Vous pouvez commencer a jouer");
			System.out.println(" ");
			System.out.println("Bonne chance! ");
			System.out.println(" ");
			
		}
		if (message.equals("H")|| message.equals("h")){
			int l1 = g1.cherchePersoLigne();
			int c1 = g1.cherchePersoColonne();
			g2.testCase(l1, c1, g1, p1 );
			g1.deplacementH("XXX",p1);
			System.out.println(" ");		
			System.out.println(" ");
			g1.afficher();
		}
		if (message.equals("B") || message.equals("b")){
			int l1 = g1.cherchePersoLigne();
			int c1 = g1.cherchePersoColonne();
			g1.deplacementB("XXX",p1);
			g2.testCase(l1, c1,g1,p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
			
		}
		if(message.equals("D")|| message.equals("d")) {
			int l1 = g1.cherchePersoLigne();
			int c1 = g1.cherchePersoColonne();
			g1.deplacementD("XXX",p1);
			g2.testCase(l1, c1,g1,p1);	
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(message.equals("G") || message.equals("g")){
			int l1 = g1.cherchePersoLigne();
			int c1 = g1.cherchePersoColonne();
		g1.deplacementG("XXX",p1);
			g2.testCase(l1, c1,g1,p1);	
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();		
		}
		if(message.equals("R")|| message.equals("r")){
			int l1 = g1.cherchePersoLigne();
			int c1 = g1.cherchePersoColonne();
			g2.testCaseRamasserPotion(l1, c1, p1);
			g2.modifieCase(l1, c1, "R");
			int Xaleatoire = 1+(int) (Math.random()*((10-1)+1));
			int Yaleatoire = 1+(int) (Math.random()*((10-1)+1));
				if (g2.accederCaseGrille(Xaleatoire, Yaleatoire).equals("???")) {
						g2.apparaitrePotion(Xaleatoire, Yaleatoire);
				}
		}
		if(message.equals("U")|| message.equals("u")) {
			g2.testUtiliseP(p1);
		}
			
	}
	

	

	public void run() {
		while(true)
			try {
				Grille g1= new Grille ( "g1");
				Grille g2 = new Grille ("g2");
				String message = in.readLine();
				traiterMessage(message, g1, g2);
			}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public static void main(String[] arg) throws Exception {
		
		Socket  socket = new Socket("127.0.0.1", 7584);
		Client joueur = new Client (socket);
	
	
	}
	public void start() throws Exception {
		
	Grille g1= new Grille ( "g1");
	Grille g2 = new Grille ("g2");
	String perso = " Votre personnage";
	Personnage p1 = new  Personnage (perso);
	Objectif objectif = new Objectif();
	Socket  socket = new Socket("127.0.0.1", 7584);
	Client joueur = new Client (socket);

	
	System.out.println("pour cree votre personnage taper: C ");
	Scanner sc = new Scanner(System.in); 
	String message1 = sc.next();
	joueur.traiterMessage(message1 , g1, g2);
	g2.initialisationGrille(g1, g2);
	g1.afficher();
	g2.afficher();
	System.out.println("Taper OK quand vous ete pres a commencer ");

	String message2 = sc.next();
	if(message2.equals("OK")|| message2.equals("ok") ) {
		
		while(p1.getVie()> 0 && objectif.obectifAAtteindre(g1.chercheperso(), g2.chercheOb()) ){
			System.out.println(g2.chercheOb());
			
			System.out.println("        Veuilliez saisir vos 4 prochain deplacements  : ");
			System.out.println(" ");
			System.out.println("     - H pour aller en HAUT ");
			System.out.println("     - B pour aller en BAS ");
			System.out.println("     - D pour aller a  DROITE ");
			System.out.println("     - G pour aller a  GAUCHE ");
			System.out.println("     - R pour ramasser un objet ");
			System.out.println("     - U pour utiliser un objet ");
			System.out.println(" ");
			System.out.println(" ");
			System.out.print(" Premier mouvement : ");
			String move1 = sc.next();
			System.out.print(" Deuxieme mouvement : ");
			String move2 = sc.next();
			System.out.print(" Troisieme mouvement : ");
			String move3 =sc.next();
			System.out.print(" Quatrieme mouvement : ");
			String move4 = sc.next();
			g1.testDeplacement(move1, move2, move3,move4 );
			joueur.traiterMessage(move1, g1, g2);
			joueur.traiterMessage(move2, g1, g2);
			joueur.traiterMessage(move3, g1, g2);
			joueur.traiterMessage(move4, g1, g2);
		}
		
	}else {
		System.out.println(" veuiller ressaisir OK");
		 message2 = sc.next();
	}
	}
}

	






	
	


	


	