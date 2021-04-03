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
 * Ecrire une proc�dure nomm�e CalculerDureeVol() qui affiche 
 * la dur�e de vol en heure et minute connaissant l�heure de d�part 
 * et l�heure d�arriv�e.
 * Utilisation de m�thodes statiques.
 */


public class Lanceur {

	// D�claration des constantes qui seront utilis�s tout au long 
	final private static int MINUTES_EN_HEURE = 60;
	final private static int HEURE_JOUR = 24;
	final private static int HEURE = 1;


	public static void main(String[] listeArguments) throws ParseException {

		// Num�ro d'algorithme
		String numAlgo;

		final String LIST_ALGOS = "\n--> Algorithmes 81, 82, 83";
		final String TEXTE_SAISIE = "Num�ro d'algorithme (return pour quitter) : ";

		System.out.println(LIST_ALGOS);

		numAlgo = saisirValeur(TEXTE_SAISIE);

		// TANT QUE return n'a pas �t� entr�
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
			// Exception lev�e par la m�thode Integer.valueOf()
			// dans le cas o� l'utilisateur ne saisit pas un nombre
			catch (NumberFormatException ex) {		
				System.out.println("\nSaisie incorrecte");			
			}

			System.out.println(LIST_ALGOS);

			numAlgo = saisirValeur(TEXTE_SAISIE);

		} // FIN TANT QUE

		System.out.println("\n--> FIN DU PROGRAMME !!!");
	}

	// Algorithme 8.1
	// On consid�re que le d�part et l�arriv�e ont lieu le m�me jour.
	// Avec conversions en minutes
	public static void CalculerDureeVol_v1() {

		// appel de m�thode avertissement
		avertissement();

		//bloc try... catch pour g�rer l'exception de chiffre non valide entr�e(
		try {

			//appel des m�thodes pour r�cup�rer les donn�es afin de les utiliser dans le bloc de code 
			int iHeure_depart_v1 = heure_depart();
			int iMinutes_depart_v1 = minutes_depart();
			int iHeure_arrivee_v1 = heure_arrivee();
			int iMinutes_arrivee_v1 = minutes_arrivee();

			//appel de la fonction qui donne la date en fonction des heures entr�es
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
				System.out.println("En allant � 88mph � bord d'une deLorean, vous y arriverez peut etre Doc");

			}

			// une exception est lev� si l'utilisateur ne rentre pas de chiffres 		
		}catch(NumberFormatException e) {
			System.out.println( "\n -----Vous avez choisi de quitter le programme 81-----");
		}
	}


	// Algorithme 8.2
	// idem � l�algorithme 8.1 mais sans faire les conversions en minutes.

	public static void CalculerDureeVol_v2() {		

		// appel de m�thode avertissement
		avertissement();

		//bloc try... catch pour g�rer l'exception de chiffre non valide entr�e(
		try {
			int iHeure_depart_v2 = heure_depart();
			int iMinutes_depart_v2 = minutes_depart();
			int iHeure_arrivee_v2 = heure_arrivee();
			int iMinutes_arrivee_v2 = minutes_arrivee();

			String jour = date(iHeure_depart_v2, iHeure_arrivee_v2);

			//appel de la fonction qui v�rifie que les chiffres entr�s sont conforme et v�rification de la condition true 

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
				System.out.println("En allant � 88mph � bord d'une deLorean, vous y arriverez peut etre Doc");
			}

		}catch(NumberFormatException e) {
			System.out.println( "\n -----Vous avez choisi de quitter le programme 82-----");
		}
	}


	// Algorithme 8.3 
	// On suppose que la dur�e de vol est inf�rieure � 24 heures 
	// mais que l�arriv�e peut avoir lieu le lendemain.
	public static void CalculerDureeVol_v3() {

		//bloc try... catch pour g�rer l'exception de chiffre non valide entr�e(
		try {

			int iHeure_depart_v3 = heure_depart();
			int iMinutes_depart_v3 = minutes_depart();
			int iHeure_arrivee_v3 = heure_arrivee();
			int iMinutes_arrivee_v3 = minutes_arrivee();

			String jour = date(iHeure_depart_v3, iHeure_arrivee_v3);

			//appel de la fonction qui v�rifie que les chiffres entr�s sont conforme et v�rification de la condition true 


			if(iHeure_arrivee_v3 > iHeure_depart_v3) {
				// calcul heure d�part < arriv�e et minutes d�part < minutes arriv�e
				if(iMinutes_arrivee_v3 > iMinutes_depart_v3) {
					int iDuree_heure = (iHeure_arrivee_v3 - iHeure_depart_v3);
					int iDuree_minute = (iMinutes_arrivee_v3 - iMinutes_depart_v3);
					System.out.println("La duree du vol est de " + iDuree_heure + " heures , " + iDuree_minute + " minutes");
					System.out.println("Vous arriverez le " + jour );
					
				}else{
					// calcul heure d�part < arrivee et minutes d�part > minutes arriv�e
					int iDuree_heure = (iHeure_arrivee_v3 - iHeure_depart_v3 - HEURE);
					int iDuree_minute = (iMinutes_arrivee_v3 + MINUTES_EN_HEURE - iMinutes_depart_v3)%MINUTES_EN_HEURE;
					if(iDuree_minute != 0) {
						System.out.println("La duree du vol est de " + iDuree_heure + " heures , " + iDuree_minute + " minutes");
						System.out.println("Vous arriverez le " + jour );
					// calcul heure d�part < arrivee et minutes d�part = minutes arriv�e
					}else if(iDuree_minute == 0) {
						int iDuree_heure_zero = iDuree_heure + HEURE;
						System.out.println("La duree du vol est de " + iDuree_heure_zero + " heures");
						System.out.println("Vous arriverez le " + jour );
						
					}
				}
			}else{
				if(iHeure_arrivee_v3 < iHeure_depart_v3){
					if(iMinutes_arrivee_v3 > iMinutes_depart_v3) {
						// calcul de l'arriv� si les heures depart est sup�rieur au heures d'arriv�e avec une journ�e en plus
						// avec les minutes arrivee > minutes de d�part
						int iDuree_heure = iHeure_arrivee_v3 - iHeure_depart_v3 + HEURE_JOUR;
						int iDuree_minute = iMinutes_arrivee_v3 - iMinutes_depart_v3;
						System.out.println("La duree du vol est de " + iDuree_heure + " heures , " + iDuree_minute + " minutes");
						System.out.println("Vous arriverez le " + jour );

					}else{
						//heure depart < heure arriv�e, meme minutes
						int iDuree_heure = iHeure_arrivee_v3 - iHeure_depart_v3 + HEURE_JOUR - HEURE;
						int iDuree_minute = iMinutes_arrivee_v3 + MINUTES_EN_HEURE - iMinutes_depart_v3;

						// cas o� les minutes valent 60
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
					//meme heure de d�part, minutes arriv�e sup�rieur � heure de d�part
					if(iMinutes_arrivee_v3 > iMinutes_depart_v3) {
						int iDuree_heure = 0;
						int iDuree_minute = iMinutes_arrivee_v3 - iMinutes_depart_v3;
						System.out.println("La duree du vol est de " + iDuree_heure + " heures , " + iDuree_minute + " minutes");
						System.out.println("Vous arriverez le " + jour );
					}else{
						//meme heure de d�part, minutes arriv�e < minutes d�part
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

	// m�thode permettant de r�cup�rer l'heure de d�part et de v�rifier si c'est la bonne heure qui est entr�
	public static Integer heure_depart() {

		//Utilisation de la classe saisirValeur pour notre scanner 
		//Transformer le r�sultat en Integer et le renvoyer 
		Integer iHeure_depart;
		String hScanner_h_depart = saisirValeur("Veuillez entrer une heure de depart compris entre 0 et 23");
		iHeure_depart = Integer.parseInt(hScanner_h_depart);

		// boucle while ou on v�rifie que l'heure entr� est correcte et on boucle le cas contraire 
		while(!heures_conforme(iHeure_depart)) {
			hScanner_h_depart = saisirValeur("Veuillez entrer une heure de depart compris entre 0 et 23");
			iHeure_depart = Integer.parseInt(hScanner_h_depart);
		}
		return iHeure_depart;
	}

	// m�thode permettant de r�cup�rer les minutes de d�part (m�me structure de m�thode que pour l'heure de d�part)
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

	// m�thode permettant de r�cup�rer l'heure d'arriv�e (m�me structure de m�thode que pour l'heure de d�part)
	public static  Integer heure_arrivee() {
		//Utilisation de la classe saisirValeur pour notre scanner 
		//Transformer le r�sultat en Integer et le renvoyer 
		Integer iHeure_arrivee;
		String hScanner_h_arrivee = saisirValeur("Veuillez entrer une heure d'arriv�e compris entre 0 et 23");
		iHeure_arrivee = Integer.parseInt(hScanner_h_arrivee);
		while(!heures_conforme(iHeure_arrivee)) {
			hScanner_h_arrivee = saisirValeur("Veuillez entrer une heure d'arriv�e compris entre 0 et 23");
			iHeure_arrivee = Integer.parseInt(hScanner_h_arrivee);
		}
		return iHeure_arrivee;
	}


	// m�thode permettant de r�cup�rer les minutes d'arriv�e (m�me structure de m�thode que pour l'heure de d�part)
	public static Integer minutes_arrivee() {

		Integer iMinutes_arrivee;
		String hScanner_m_arrivee  = saisirValeur("Veuillez entrer les minutes d'arriv�e compris entre 0 et 59");
		iMinutes_arrivee = Integer.parseInt(hScanner_m_arrivee);
		while(!minutes_conforme(iMinutes_arrivee)) {
			hScanner_m_arrivee  = saisirValeur("Veuillez entrer les minutes d'arriv�e compris entre 0 et 59");
			iMinutes_arrivee = Integer.parseInt(hScanner_m_arrivee);
		}
		return iMinutes_arrivee;	
	}	

	// M�thode pour la v�rification du bon format de l'heure retournant un bool�en
	public static boolean heures_conforme(int p_heure) {

		if (0 > p_heure || p_heure > 23){
			System.out.println("vous avez entr� une mauvaise heure");
			return false;
		}else{
			return true;
		}
	}

	// M�thode pour la v�rification du bon format des minutes retournant un bool�en
	public static boolean minutes_conforme(int p_minutes) {

		if (0 > p_minutes || p_minutes > 59) {
			System.out.println("vous avez entr� une mauvaise minute");
			return false;
		}else{
			return true;
		}
	}


	// M�thode qui r�cup�re les dates de voyages, et retourne la bonne date d'arriv�e
	//     /\ cependant, je ne suis pas arriv� � borner les dates  /\

	// La m�tode renvoi un String afin de retourner la date sans modification si on ne voyage une journ�e
	public static String date(int p_heure_depart, int p_heure_arrivee) {

		// On utilise une regex pour borner et un replace pour avoir un bon format de date 
		String sBon_format = "([0-9]{2})/([0-9]{2})/([0-9]{4})";
		String hScanner;

		// On saisie la date de l'utilisateur et on remplace les carat�res susceptible d'etre utilis� par ceux que l'on veut utiliser
		hScanner = saisirValeur("veuillez entrer la date de d�part sous la forme dd/MM/yyyy");
		String sReplace = hScanner.replaceAll("[ -  --]", "/");

		// boucle while pour boucler si la date n'est pas au bon format
		while(!hScanner.matches(sBon_format)){ 
			System.out.println("Veuillez entr� une date dans le bon format");
			hScanner = saisirValeur("veuillez entrer la date de d�part sous la forme dd/MM/yyyy");

		}

		// Cas ou ou voyage sur plusiseurs jours
		if (p_heure_depart > p_heure_arrivee || p_heure_arrivee == p_heure_depart) {

			// on instancie la classe Calendar pour pouvoir ajouter une journ�e
			Calendar cDate = Calendar.getInstance();

			// on instancie la classe DateFormatter
			SimpleDateFormat hDTF = new SimpleDateFormat("dd/MM/yyyy");

			// bloc try catch ou on set la date de d�part ainsi que le parsing du String au format date
			try {
				cDate.setTime(hDTF.parse(hScanner));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// on ajourte une journ�e
			cDate.add(Calendar.DATE, 1);

			// on reformate en String pour le retourner
			String sDate_final = hDTF.format(cDate.getTime());
			return sDate_final;
		}else {
			return hScanner;
		}
	}

	// M�thode avertissant l'utilisateur pour qu'il utilise la bonne m�thode
	public static void avertissement() {
		// message avertissement
		System.out.println("Attention, ce cas ne permet de traiter que les cas ou les vols ont lieu dans la m�me journ�e");
		System.out.println("pour ceux sur plusieurs jours, choississez la section 83");
		System.out.println("Appuyez sur n'importe quel touche (hors num�rique) pour sortir");

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

		// Cr�ation d'un objet Scanner permettant la saisie au clavier
		Scanner sc = new Scanner(System.in);

		// Affichage du texte
		System.out.print("\n" + p_texte);

		// Attendre la saisie et stocker la valeur dans valeurEntree
		String valeurEntree = sc.nextLine();

		// Fermeture du Scanner pose probl�me si on 
		// d�sire en utiliser un autre
		//if (sc != null)
		//	sc.close();

		// Retourner la valeur sous forme d'une String
		return valeurEntree;
	}
}