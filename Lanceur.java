package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Pattern;


/**
 * 
 * @author Bob M.
 * 
 * Ecrire une procédure nommée CalculerDureeVol() qui affiche 
 * la durée de vol en heure et minute connaissant l’heure de départ 
 * et l’heure d’arrivée.
 * Utilisation de méthodes statiques.
 */


public class Lanceur {

	// Déclaration des constantes qui seront utilisés tout au long 
	final private static int MINUTES_EN_HEURE = 60;
	final private static int HEURE_JOUR = 24;
	final private static int HEURE = 1;


	public static void main(String[] listeArguments) throws ParseException {

		// Numéro d'algorithme
		String numAlgo;

		final String LIST_ALGOS = "\n--> Algorithmes 81, 82, 83";
		final String TEXTE_SAISIE = "Numéro d'algorithme (return pour quitter) : ";

		System.out.println(LIST_ALGOS);

		numAlgo = saisirValeur(TEXTE_SAISIE);

		// TANT QUE return n'a pas été entré
		while (!numAlgo.isEmpty()) {

			try {
				switch(Integer.valueOf(numAlgo)) {		   
				case 81:
					// Algorithme 8.1
					System.out.println("\n--> Algorithme 8.1");
					Lanceur.CalculerDureeVol_v1();
					break;
				case 82:
					// Algorithme 8.2
					System.out.println("\n--> Algorithme 8.2");
					Lanceur.CalculerDureeVol_v2();
					break;
				case 83:
					// Algorithme 8.3
					System.out.println("\n--> Algorithme 8.3");
					Lanceur.CalculerDureeVol_v3();
					break;	   
				default:
					System.out.println("\n--> Ne jouez pas au malin avec Bob M. !!!");
					break;
				} // FIN
			}
			// Exception levée par la méthode Integer.valueOf()
			// dans le cas où l'utilisateur ne saisit pas un nombre
			catch (NumberFormatException ex) {		
				System.out.println("\nSaisie incorrecte");			
			}

			System.out.println(LIST_ALGOS);

			numAlgo = saisirValeur(TEXTE_SAISIE);

		} // FIN TANT QUE

		System.out.println("\n--> FIN DU PROGRAMME !!!");
	}

	// Algorithme 8.1
	// On considère que le départ et l’arrivée ont lieu le même jour.
	// Avec conversions en minutes
	public static void CalculerDureeVol_v1() {

		// appel de méthode avertissement
		avertissement();

		//bloc try... catch pour gérer l'exception de chiffre non valide entrée(
		try {

			//appel des méthodes pour récupérer les données afin de les utiliser dans le bloc de code 
			int iHeure_depart_v1 = heure_depart();
			int iMinutes_depart_v1 = minutes_depart();
			int iHeure_arrivee_v1 = heure_arrivee();
			int iMinutes_arrivee_v1 = minutes_arrivee();

			//appel de la fonction qui donne la date en fonction des heures entrées
			String jour = date(iHeure_depart_v1, iHeure_arrivee_v1);

			if (iHeure_depart_v1 < iHeure_arrivee_v1) {

				//bloc de code principal 		
				int iTotal_depart_v1 = (iHeure_depart_v1 * MINUTES_EN_HEURE + iMinutes_depart_v1);
				int iTotal_arrivee_v2 = ( iHeure_arrivee_v1  * MINUTES_EN_HEURE + iMinutes_arrivee_v1);
				int iDuree_heure = ((iTotal_arrivee_v2 - iTotal_depart_v1)/MINUTES_EN_HEURE);
				int iDuree_minute = ((iTotal_arrivee_v2 - iTotal_depart_v1)%MINUTES_EN_HEURE);
				System.out.println("La duree du vol est de " + iDuree_heure + " heures , " + iDuree_minute + " minutes");
				System.out.println("Vous arriverez le " + jour );
			}else{
				System.out.println("En allant à 88mph à bord d'une deLorean, vous y arriverez peut etre Doc");

			}

			// une exception est levé si l'utilisateur ne rentre pas de chiffres 		
		}catch(NumberFormatException e) {
			System.out.println( "\n -----Vous avez choisi de quitter le programme 81-----");
		}
	}


	// Algorithme 8.2
	// idem à l’algorithme 8.1 mais sans faire les conversions en minutes.

	public static void CalculerDureeVol_v2() {		

		// appel de méthode avertissement
		avertissement();

		//bloc try... catch pour gérer l'exception de chiffre non valide entrée(
		try {
			int iHeure_depart_v2 = heure_depart();
			int iMinutes_depart_v2 = minutes_depart();
			int iHeure_arrivee_v2 = heure_arrivee();
			int iMinutes_arrivee_v2 = minutes_arrivee();

			String jour = date(iHeure_depart_v2, iHeure_arrivee_v2);

			//appel de la fonction qui vérifie que les chiffres entrés sont conforme et vérification de la condition true 

			if (iHeure_depart_v2 < iHeure_arrivee_v2) {

				//bloc de code principal 
				if (iMinutes_arrivee_v2 > iMinutes_depart_v2 ) {
					int iDuree_heure_v2 = (iHeure_arrivee_v2 - iHeure_depart_v2);
					int iDuree_minute_v2 = (iMinutes_arrivee_v2 - iMinutes_depart_v2);
					System.out.println("La duree du vol est de " + iDuree_heure_v2 + " heures , " + iDuree_minute_v2 + " minutes");
					System.out.println("Vous arriverez le " + jour );
				}else {
					int iDuree_heure_v2 = (iHeure_arrivee_v2 - iHeure_depart_v2 - HEURE);
					int iDuree_minute_v2 = (iMinutes_arrivee_v2 + MINUTES_EN_HEURE - iMinutes_depart_v2);
					System.out.println("La duree du vol est de " + iDuree_heure_v2 + " heures , " + iDuree_minute_v2 + " minutes");
					System.out.println("Vous arriverez le " + jour );
				}
			}else{
				System.out.println("En allant à 88mph à bord d'une deLorean, vous y arriverez peut etre Doc");
			}

		}catch(NumberFormatException e) {
			System.out.println( "\n -----Vous avez choisi de quitter le programme 82-----");
		}
	}


	// Algorithme 8.3 
	// On suppose que la durée de vol est inférieure à 24 heures 
	// mais que l’arrivée peut avoir lieu le lendemain.
	public static void CalculerDureeVol_v3() {

		//bloc try... catch pour gérer l'exception de chiffre non valide entrée(
		try {

			int iHeure_depart_v3 = heure_depart();
			int iMinutes_depart_v3 = minutes_depart();
			int iHeure_arrivee_v3 = heure_arrivee();
			int iMinutes_arrivee_v3 = minutes_arrivee();

			String jour = date(iHeure_depart_v3, iHeure_arrivee_v3);

			//appel de la fonction qui vérifie que les chiffres entrés sont conforme et vérification de la condition true 


			if(iHeure_arrivee_v3 > iHeure_depart_v3) {
				// calcul heure départ < arrivée et minutes départ < minutes arrivée
				if(iMinutes_arrivee_v3 > iMinutes_depart_v3) {
					int iDuree_heure = (iHeure_arrivee_v3 - iHeure_depart_v3);
					int iDuree_minute = (iMinutes_arrivee_v3 - iMinutes_depart_v3);
					System.out.println("La duree du vol est de " + iDuree_heure + " heures , " + iDuree_minute + " minutes");
					System.out.println("Vous arriverez le " + jour );
					
				}else{
					// calcul heure départ < arrivee et minutes départ > minutes arrivée
					int iDuree_heure = (iHeure_arrivee_v3 - iHeure_depart_v3 - HEURE);
					int iDuree_minute = (iMinutes_arrivee_v3 + MINUTES_EN_HEURE - iMinutes_depart_v3)%MINUTES_EN_HEURE;
					if(iDuree_minute != 0) {
						System.out.println("La duree du vol est de " + iDuree_heure + " heures , " + iDuree_minute + " minutes");
						System.out.println("Vous arriverez le " + jour );
					// calcul heure départ < arrivee et minutes départ = minutes arrivée
					}else if(iDuree_minute == 0) {
						int iDuree_heure_zero = iDuree_heure + HEURE;
						System.out.println("La duree du vol est de " + iDuree_heure_zero + " heures");
						System.out.println("Vous arriverez le " + jour );
						
					}
				}
			}else{
				if(iHeure_arrivee_v3 < iHeure_depart_v3){
					if(iMinutes_arrivee_v3 > iMinutes_depart_v3) {
						// calcul de l'arrivé si les heures depart est supérieur au heures d'arrivée avec une journée en plus
						// avec les minutes arrivee > minutes de départ
						int iDuree_heure = iHeure_arrivee_v3 - iHeure_depart_v3 + HEURE_JOUR;
						int iDuree_minute = iMinutes_arrivee_v3 - iMinutes_depart_v3;
						System.out.println("La duree du vol est de " + iDuree_heure + " heures , " + iDuree_minute + " minutes");
						System.out.println("Vous arriverez le " + jour );

					}else{
						//heure depart < heure arrivée, meme minutes
						int iDuree_heure = iHeure_arrivee_v3 - iHeure_depart_v3 + HEURE_JOUR - HEURE;
						int iDuree_minute = iMinutes_arrivee_v3 + MINUTES_EN_HEURE - iMinutes_depart_v3;

						// cas où les minutes valent 60
						if (iDuree_minute == MINUTES_EN_HEURE) {
							int iTotal = iDuree_heure + HEURE;
							System.out.println("La duree du vol est de " + iTotal+" heures" );
							System.out.println("Vous arriverez le " + jour );
						}else{
							System.out.println("La duree du vol est de " + iDuree_heure + " heures , " + iDuree_minute + " minutes");
							System.out.println("Vous arriverez le " + jour );
						}	
					}
				}else{
					//meme heure de départ, minutes arrivée supérieur à heure de départ
					if(iMinutes_arrivee_v3 > iMinutes_depart_v3) {
						int iDuree_heure = 0;
						int iDuree_minute = iMinutes_arrivee_v3 - iMinutes_depart_v3;
						System.out.println("La duree du vol est de " + iDuree_heure + " heures , " + iDuree_minute + " minutes");
						System.out.println("Vous arriverez le " + jour );
					}else{
						//meme heure de départ, minutes arrivée < minutes départ
						int iDuree_minute = (iMinutes_arrivee_v3 + MINUTES_EN_HEURE - iMinutes_depart_v3)%MINUTES_EN_HEURE;
						int iDuree_heure = iHeure_arrivee_v3 - iHeure_depart_v3 + (HEURE_JOUR - HEURE);
						if(iDuree_minute == 0) {
							iDuree_heure = iDuree_heure + HEURE;
							System.out.println("La duree du vol est de " + iDuree_heure + " heures , " + iDuree_minute + " minutes");
							System.out.println("Vous arriverez le " + jour );
						}else{
							System.out.println("La duree du vol est de " + iDuree_heure + " heures , " + iDuree_minute + " minutes");
							System.out.println("Vous arriverez le " + jour );
						}
					}
				}
			}

		}catch(NumberFormatException e) {
			System.out.println( "\n -----Vous avez choisi de quitter le programme 83-----");
		}
	}

	// méthode permettant de récupérer l'heure de départ et de vérifier si c'est la bonne heure qui est entré
	public static Integer heure_depart() {

		//Utilisation de la classe saisirValeur pour notre scanner 
		//Transformer le résultat en Integer et le renvoyer 
		Integer iHeure_depart;
		String hScanner_h_depart = saisirValeur("Veuillez entrer une heure de depart compris entre 0 et 23");
		iHeure_depart = Integer.parseInt(hScanner_h_depart);

		// boucle while ou on vérifie que l'heure entré est correcte et on boucle le cas contraire 
		while(!heures_conforme(iHeure_depart)) {
			hScanner_h_depart = saisirValeur("Veuillez entrer une heure de depart compris entre 0 et 23");
			iHeure_depart = Integer.parseInt(hScanner_h_depart);
		}
		return iHeure_depart;
	}

	// méthode permettant de récupérer les minutes de départ (même structure de méthode que pour l'heure de départ)
	public static Integer minutes_depart() {
		Integer iMinutes_depart;
		String hScanner_m_depart  = saisirValeur("Veuillez entrer les minutes de depart compris entre 0 et 59");
		iMinutes_depart = Integer.parseInt(hScanner_m_depart);
		while(!minutes_conforme(iMinutes_depart)) {
			hScanner_m_depart  = saisirValeur("Veuillez entrer les minutes de depart compris entre 0 et 59");
			iMinutes_depart = Integer.parseInt(hScanner_m_depart);
		}
		return iMinutes_depart;
	}

	// méthode permettant de récupérer l'heure d'arrivée (même structure de méthode que pour l'heure de départ)
	public static  Integer heure_arrivee() {
		//Utilisation de la classe saisirValeur pour notre scanner 
		//Transformer le résultat en Integer et le renvoyer 
		Integer iHeure_arrivee;
		String hScanner_h_arrivee = saisirValeur("Veuillez entrer une heure d'arrivée compris entre 0 et 23");
		iHeure_arrivee = Integer.parseInt(hScanner_h_arrivee);
		while(!heures_conforme(iHeure_arrivee)) {
			hScanner_h_arrivee = saisirValeur("Veuillez entrer une heure d'arrivée compris entre 0 et 23");
			iHeure_arrivee = Integer.parseInt(hScanner_h_arrivee);
		}
		return iHeure_arrivee;
	}


	// méthode permettant de récupérer les minutes d'arrivée (même structure de méthode que pour l'heure de départ)
	public static Integer minutes_arrivee() {

		Integer iMinutes_arrivee;
		String hScanner_m_arrivee  = saisirValeur("Veuillez entrer les minutes d'arrivée compris entre 0 et 59");
		iMinutes_arrivee = Integer.parseInt(hScanner_m_arrivee);
		while(!minutes_conforme(iMinutes_arrivee)) {
			hScanner_m_arrivee  = saisirValeur("Veuillez entrer les minutes d'arrivée compris entre 0 et 59");
			iMinutes_arrivee = Integer.parseInt(hScanner_m_arrivee);
		}
		return iMinutes_arrivee;	
	}	

	// Méthode pour la vérification du bon format de l'heure retournant un booléen
	public static boolean heures_conforme(int p_heure) {

		if (0 > p_heure || p_heure > 23){
			System.out.println("vous avez entré une mauvaise heure");
			return false;
		}else{
			return true;
		}
	}

	// Méthode pour la vérification du bon format des minutes retournant un booléen
	public static boolean minutes_conforme(int p_minutes) {

		if (0 > p_minutes || p_minutes > 59) {
			System.out.println("vous avez entré une mauvaise minute");
			return false;
		}else{
			return true;
		}
	}


	// Méthode qui récupère les dates de voyages, et retourne la bonne date d'arrivée
	//     /\ cependant, je ne suis pas arrivé à borner les dates  /\

	// La métode renvoi un String afin de retourner la date sans modification si on ne voyage une journée
	public static String date(int p_heure_depart, int p_heure_arrivee) {

		// On utilise une regex pour borner et un replace pour avoir un bon format de date 
		String sBon_format = "([0-9]{2})/([0-9]{2})/([0-9]{4})";
		String hScanner;

		// On saisie la date de l'utilisateur et on remplace les caratères susceptible d'etre utilisé par ceux que l'on veut utiliser
		hScanner = saisirValeur("veuillez entrer la date de départ sous la forme dd/MM/yyyy");
		String sReplace = hScanner.replaceAll("[ -  --]", "/");

		// boucle while pour boucler si la date n'est pas au bon format
		while(!hScanner.matches(sBon_format)){ 
			System.out.println("Veuillez entré une date dans le bon format");
			hScanner = saisirValeur("veuillez entrer la date de départ sous la forme dd/MM/yyyy");

		}

		// Cas ou ou voyage sur plusiseurs jours
		if (p_heure_depart > p_heure_arrivee || p_heure_arrivee == p_heure_depart) {

			// on instancie la classe Calendar pour pouvoir ajouter une journée
			Calendar cDate = Calendar.getInstance();

			// on instancie la classe DateFormatter
			SimpleDateFormat hDTF = new SimpleDateFormat("dd/MM/yyyy");

			// bloc try catch ou on set la date de départ ainsi que le parsing du String au format date
			try {
				cDate.setTime(hDTF.parse(hScanner));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// on ajourte une journée
			cDate.add(Calendar.DATE, 1);

			// on reformate en String pour le retourner
			String sDate_final = hDTF.format(cDate.getTime());
			return sDate_final;
		}else {
			return hScanner;
		}
	}

	// Méthode avertissant l'utilisateur pour qu'il utilise la bonne méthode
	public static void avertissement() {
		// message avertissement
		System.out.println("Attention, ce cas ne permet de traiter que les cas ou les vols ont lieu dans la même journée");
		System.out.println("pour ceux sur plusieurs jours, choississez la section 83");
		System.out.println("Appuyez sur n'importe quel touche (hors numérique) pour sortir");

		// bloc qui met en pause le thread, le temps de lire le message d'erreur

		try
		{
			Thread.sleep(2000);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}


	// Retourner une valeur saisie
	@SuppressWarnings("resource")
	public static String saisirValeur(String p_texte) {	

		// Création d'un objet Scanner permettant la saisie au clavier
		Scanner sc = new Scanner(System.in);

		// Affichage du texte
		System.out.print("\n" + p_texte);

		// Attendre la saisie et stocker la valeur dans valeurEntree
		String valeurEntree = sc.nextLine();

		// Fermeture du Scanner pose problème si on 
		// désire en utiliser un autre
		//if (sc != null)
		//	sc.close();

		// Retourner la valeur sous forme d'une String
		return valeurEntree;
	}
}