package ProjetDonjonG1;

import java.net.*;
import java.io.*;
import java.util.*;

//** Classe principale du serveur, gère les infos globales **
public class Serveur
{
  
  private int nbClients=0; // nombre total de clients connectés

  //** Methode : la première méthode exécutée, elle attend les connexions **
  public static void main(String []args)
  {
	  Serveur serveur = new Serveur(); // instance de la classe principale
    try{
      int port = 7584;
      System.out.println("en attente de connection...");
      ServerSocket ss = new ServerSocket(port); // ouverture d'un socket serveur sur port
      while (true) // attente en boucle de connexion (bloquant sur ss.accept)
      {
        new Service(ss.accept(),serveur); // un client se connecte, un nouveau thread client est lancé
        System.out.println("connection reussie ");
      }
    }
    catch (Exception e) { 
    	e.printStackTrace();
    }
  }

  

  
  //** Methode : ajoute un nouveau client dans la liste **
  synchronized public int addClient(PrintWriter out){
    return nbClients++;
   
  }

  
  
  
 // où j'ai trouver le code que j'ai legerement modifié : https://defaut.developpez.com/tutoriel/java/serveur/multithread/ 

}
	  