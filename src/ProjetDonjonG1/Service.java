package ProjetDonjonG1;

import java.net.*;
import java.io.*;



class Service implements Runnable{
	private Thread t; // contiendra le thread du client
	private Socket s; // recevra le socket liant au client
	private PrintWriter out; // pour gestion du flux de sortie
	private BufferedReader in; // pour gestion du flux d'entrée
	private Serveur serveur; // pour utilisation des méthodes de la classe principale
	private int numClient=0; // contiendra le numéro de client géré par ce thread

	
	Service(Socket s, Serveur serveur) throws Exception  {// le param s est donnée dans BlablaServ par ss.accept()
		serveur=serveur; // passage de local en global (pour gestion dans les autres méthodes)
	    s=s; // passage de local en global
	    
	    try{
	    	out = new PrintWriter(s.getOutputStream());// fabrication d'une variable permettant l'utilisation du flux de sortie avec des string
	    	in = new BufferedReader(new InputStreamReader(s.getInputStream())); // fabrication d'une variable permettant l'utilisation du flux d'entrée avec des string
	    	numClient = serveur.addClient(out);// ajoute le flux de sortie dans la liste et récupération de son numéro
	    }
	    catch (IOException e){
	    	e.printStackTrace();
	    }

	    t = new Thread(this); 
	    t.start(); 
	}

	 
	public void run(){
		String message = ""; 

	    System.out.println("Un nouveau client s'est connecte, no "+numClient);
	    try{
	    	
	    	char charCur[] = new char[1]; // declaration d'un tableau de char d'1 element, _in.read() y stockera le char lu
	    	while(in.read(charCur, 0, 1)!=-1) { // attente en boucle des messages provenant du client (bloquant sur _in.read())
	    		// on regarde si on arrive a� la fin d'une chaine ...
	    		if (charCur[0] != '\u0000' && charCur[0] != '\n' && charCur[0] != '\r') {
	    			message += charCur[0]; // ... si non, on concatène le caractère dans le message
	    			}
	    		}
	    	}
	    catch (Exception e){ 
	    	e.printStackTrace();
	    }
	    finally  {// finally se produira le plus souvent lors de la deconnexion du client 
	    	try{
	    		// on indique a� la console la deconnexion du client
	    		System.out.println("Le client no "+numClient+" s'est deconnecte");
	    		s.close(); // fermeture du socket s'il ne l'a pas deja ete (a cause de l'exception levee plus haut)
	    	}
	    	catch (IOException e){ 
	    		e.printStackTrace();
	    	}
	    }
	  }
	}
