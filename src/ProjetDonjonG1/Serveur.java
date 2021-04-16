package ProjetDonjonG1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;


public class Serveur{
	  private Vector tabClients = new Vector(); // contiendra tous les flux de sortie vers les clients
	  private int nbClients=0; // nombre total de clients connectés

	  
	  public static void main(String[] args){
		
	    Serveur serveur = new Serveur(); 
	    try{
	      int port= 7584;
	     
	      ServerSocket ss = new ServerSocket(port); // ouverture d'un socket serveur sur port
	      System.out.println("En attente de connexion..");
	      while (true) { 
	    	  new Service(ss.accept(),serveur);// un client se connecte, un nouveau thread client est lancé
	      }
	    }
	      
	    catch (Exception e) { 
	    	e.printStackTrace();
	    	}
	  }
	 

	 

	  //** Methode : ajoute un nouveau client dans la liste **
	  synchronized public int addClient(PrintWriter out) throws Exception{
		  nbClients+=1;
		  tabClients.addElement(out); // on ajoute le nouveau flux de sortie au tableau
		  return tabClients.size()-1; // on retourne le numéro du client ajouté (size-1)
	  	}

	  
	
}