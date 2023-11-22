

package org.hbrs.se1.ws23.uebung4.prototype.improvements.model;

import org.hbrs.se1.ws23.uebung4.prototype.mysolution.Model.Exception.PersistenceException;
import org.hbrs.se1.ws23.uebung4.prototype.mysolution.Model.PSStrategies.PersistenceStrategy;

import java.io.IOException;
import java.util.*;

/*
 * Klasse zum Management sowie zur Eingabe unnd Ausgabe von User-Stories.
 * Die Anwendung wird über dies Klasse auch gestartet (main-Methode hier vorhanden)
 *
 * erstellt von Julius P., H-BRS 2023, Version 1.0
 *
 * Strategie für die Wiederverwendung (Reuse):
 * - Anlegen der Klasse UserStory
 * - Anpassen des Generic in der List-Klasse (ALT: Member, NEU: UserStory)
 * - Anpassen der Methodennamen
 *
 * ToDo: Was ist ihre Strategie zur Wiederverwendung? (F1)
 *
 * Alternative 1:
 * Klasse UserStory implementiert Interface Member (UserStory implements Member)
 * Vorteil: Wiederverwendung von Member, ID verwenden; Strenge Implementierung gegen Interface
 * Nachteil: Viele Casts notwendig, um auf die anderen Methoden zuzugreifen
 *
 * Alternative 2:
 * Container mit Generic entwickeln (z.B. Container<E>))
 *
 * Entwurfsentscheidung: Die wichtigsten Zuständigkeiten (responsibilities) sind in einer Klasse, d.h. Container,
 * diese liegt in einem Package.
 * ToDo: Wie bewerten Sie diese Entscheidung? (F2, F6)
 * 
 */

public class Container {
	 
	// Interne ArrayList zur Abspeicherung der Objekte vom Type UserStory
	private List<UserStory> liste = null;
	
	// Statische Klassen-Variable, um die Referenz
	// auf das einzige Container-Objekt abzuspeichern
	// Diese Variante sei thread-safe, so hat Hr. P. es gehört... stimmt das?
	// Todo: Bewertung Thread-Safeness (F1)
	// Nachteil: ggf. geringer Speicherbedarf, da Singleton zu Programmstart schon erzeugt wird
	// Todo: Bewertung Speicherbedarf (F1)
	private static Container instance = new Container();
	
	// URL der Datei, in der die Objekte gespeichert werden 
	//final static String LOCATION = "allStories.ser";

	private PersistenceStrategy<UserStory> myPersistenceStrategy = null;
	/**
	 * Liefert ein Singleton zurück.
	 * @return
	 */
	public static Container getInstance() {
		return instance;
	}
	
	/**
	 * Vorschriftsmäßiges Ueberschreiben des Konstruktors (private) gemaess Singleton-Pattern (oder?)
	 * Nun auf private gesetzt! Vorher ohne Access Qualifier (--> dann package-private)
	 */
	Container(){
		liste = new ArrayList<UserStory>();
	}
	
	/**
<<<<<<<< HEAD:src/org/hbrs/se1/ws23/uebung4/prototype/Model/Container.java
	 * Start-Methoden zum Starten des Programms 
	 * (hier koennen ggf. weitere Initialisierungsarbeiten gemacht werden spaeter)
	 */

	
	/*
	 * Diese Methode realisiert eine Eingabe ueber einen Scanner
	 * Alle Exceptions werden an den aufrufenden Context (hier: main) weitergegeben (throws)
	 * Das entlastet den Entwickler zur Entwicklungszeit und den Endanwender zur Laufzeit
	 */
	public void startEingabe() throws ContainerException{
		String strInput = null;
		
		// Initialisierung des Eingabe-View
		// ToDo: Funktionsweise des Scanners erklären (F3)
		Scanner scanner = new Scanner( System.in );
		System.out.println("UserStory-Tool V1.0 by Julius P. (dedicated to all my friends)");

		while ( true ) {
			// Ausgabe eines Texts zur Begruessung

			System.out.print( "> "  );

			strInput = scanner.nextLine();
		
			// Extrahiert ein Array aus der Eingabe
			String[] strings = strInput.split(" ");

			// 	Falls 'help' eingegeben wurde, werden alle Befehle ausgedruckt
			if ( strings[0].equals("help") ) {
				System.out.println("Folgende Befehle stehen zur Verfuegung: help, dump, enter, store");
			}
			// Auswahl der bisher implementierten Befehle:

			else if ( strings[0].equals("dump") ) {
				startAusgabe();
			}
			// Auswahl der bisher implementierten Befehle:
			else if ( strings[0].equals("enter") ) {
				// Daten einlesen ...
				// this.addUserStory( new UserStory( data ) ) um das Objekt in die Liste einzufügen.
				System.out.println("Geben 'stop' beim Ende der Eingabe ein");
				Scanner input = new Scanner(System.in);
				while (input.hasNext()) {
					System.out.print("Enter the ID from the User Story: ");
					String s = scanner.nextLine();
					if (s.equalsIgnoreCase("stop")) {
						startEingabe();
					}
					try {
						int number = Integer.parseInt(s);
						UserStory userStory = new UserStory();
						int zahl = scanner.nextInt();
						userStory.setId(zahl);
						this.addUserStory( userStory );
					} catch (NumberFormatException e) {
						System.out.println("Falsche Eingabe!");
						break;
					}
				}
			}
			else if (  strings[0].equals("store")  ) {
				try {
					this.store();
				} catch (IOException | PersistenceException e) {
					e.printStackTrace();
					//  Delegation in den aufrufendem Context
					// (Anwendung Pattern "Chain Of Responsibility)
					throw new ContainerException("Fehler beim Abspeichern");
			    }
			}
			else if (  strings[0].equals("load")  ) {
				try {
					this.load();
				} catch (PersistenceException e) {
					e.printStackTrace();
					//  Delegation in den aufrufendem Context
					// (Anwendung Pattern "Chain Of Responsibility)
					throw new ContainerException("Fehler beim Aufladen");
				}
			}
			else if (  strings[0].equals("search")  ) {
				Scanner intInput = new Scanner(System.in);
				while (true) {
					System.out.print("Enter the ID from the User Story: ");
					int zahl = scanner.nextInt();
					UserStory userStory = new UserStory();
					userStory.setId(zahl);
					if (contains(userStory)){
						System.out.println("This User Story exist");
					} else {
						System.out.println("This User Story doesn't exist");
					}
				}
			}
			else if (  strings[0].equals("exit")  ) {
				System.out.println("Das Programm ist beendet.");
				break;
			}
			else {
				System.out.println("Falsche Eingabe!");
				startEingabe();
			}
			scanner.close();
		} // Ende der Schleife
	}
	/**
	 * Diese Methode realisiert die Ausgabe.
	 */
	public void startAusgabe() {

		// Hier möchte Herr P. die Liste mit einem eigenen Sortieralgorithmus sortieren und dann
		// ausgeben. Allerdings weiss der Student hier nicht weiter

		// [Sortierung ausgelassen]
		Collections.sort(this.liste);

		// Klassische Ausgabe ueber eine For-Each-Schleife
		for (UserStory story : liste) {
			System.out.println(story.toString());
		}

		liste.forEach(member -> System.out.println(member)); //@Override?
		// [Variante mit forEach-Methode / Streams (--> Kapitel 9, Lösung Übung Nr. 2)?
		//  Gerne auch mit Beachtung der neuen US1
		// (Filterung Projekt = "ein Wert (z.B. Coll@HBRS)" und Risiko >=5
		// Todo: Implementierung Filterung mit Lambda (F5)

	}
	/*
	 * Methode zum Speichern der Liste. Es wird die komplette Liste
	 * inklusive ihrer gespeicherten UserStory-Objekte gespeichert.
	 * 
	 */
	public void store() throws IOException, PersistenceException {
		myPersistenceStrategy.save(liste);
		/*ObjectOutputStream oos = null;
========
	public void store() throws ContainerException {
		ObjectOutputStream oos = null;
>>>>>>>> alda/main:src/org/hbrs/se1/ws23/uebung4/prototype/improvements/model/Container.java
		FileOutputStream fos = null;

		fos = new FileOutputStream( Container.LOCATION );
		oos = new ObjectOutputStream(fos);
			
		oos.writeObject( this.liste );
		System.out.println( this.size() + " UserStory wurden erfolgreich gespeichert!");*/
	}

	/*
	 * Methode zum Laden der Liste. Es wird die komplette Liste
	 * inklusive ihrer gespeicherten UserStory-Objekte geladen.
	 * 
	 */
	public void load() throws PersistenceException {
		myPersistenceStrategy.load();
	}

	/**
	 * Methode zum Hinzufügen eines Mitarbeiters unter Wahrung der Schlüsseleigenschaft
	 * @param userStory
	 * @throws ContainerException
	 */
	public void addUserStory ( UserStory  userStory ) throws ContainerException {
		if ( contains(userStory) == true ) {
			ContainerException ex = new ContainerException("ID bereits vorhanden!");
			throw ex;
		}
		liste.add(userStory);
	}
	public String deleteUserStory(Integer id){
		for (int i = 0; i < liste.size(); i++) {
			UserStory us =  new UserStory();
			us.setId(id);
			if (contains(us)) {
				liste.remove(i);
				return "" + id;
			}
		}
		throw new NoSuchElementException();
	}

	/**
	 * Prüft, ob eine UserStory bereits vorhanden ist
	 * @param userStory
	 * @return
	 */
	private boolean contains( UserStory userStory) {
		int ID = userStory.getId();
		for ( UserStory userStory1 : liste) {
			if ( userStory1.getId() == ID ) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Ermittlung der Anzahl von internen UserStory
	 * -Objekten
	 * @return
	 */
	public int size() {
		return liste.size();
	}

	/**
	 * Methode zur Rückgabe der aktuellen Liste mit Stories
	 * Findet aktuell keine Anwendung bei Hr. P.
	 * @return
	 */
	public List<UserStory> getCurrentList() {
		return this.liste;
	}

	/**
	 * Liefert eine bestimmte UserStory zurück
	 * @param id
	 * @return
	 */
	private UserStory getUserStory(int id) {
		for ( UserStory userStory : liste) {
			if (id == userStory.getId() ){
				return userStory;
			}
		}
		throw new NoSuchElementException();
	}
}
