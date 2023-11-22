package org.hbrs.se1.ws23.uebung4.prototype.mysolution.Model.PSStrategies;

import org.hbrs.se1.ws23.uebung4.prototype.mysolution.Model.Exception.PersistenceException;

import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<E> implements PersistenceStrategy<E> {

    // URL of file, in which the objects are stored
    static String location = "objects.ser";
    private ObjectInputStream ois = null;
    private FileInputStream fis = null;
    private ObjectOutputStream oos;
    private FileOutputStream fos;

    //um zu bestimmen ob das input oder output ist,
    //dann wird ObjectInputStream oder ObjectOutputStream geöffnet
    private boolean isInput = true;

    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for opening the connection to a stream (here: Input- and Output-Stream)
     * In case of having problems while opening the streams, leave the code in methods load
     * and save.
     */
    public void openConnection() throws PersistenceException {
        try{
            if (isInput) {
                fis = new FileInputStream(location);
                ois = new ObjectInputStream(fis);
            } else {
                fos = new FileOutputStream(location);
                oos = new ObjectOutputStream(fos);
            }
        }
/*
        IOException is the base class for exceptions thrown
        while accessing information using streams, files and directories.
        The Base Class Library includes the following types,
        each of which is a derived class of IOException :
        DirectoryNotFoundException. EndOfStreamException. FileNotFoundException.
*/
        catch (IOException e){
            e.printStackTrace();
            throw new PersistenceException
                    (PersistenceException.ExceptionType.ConnectionNotAvailable, "Connection not possible.");
        }
    }

    @Override
    /**
     * Method for closing the connections to a stream
     */
    public void closeConnection() throws PersistenceException {
        try {
            if(isInput) {
                ois.close();
                fis.close();
            }
            else {
                oos.close();
                fos.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "No Connection open.");
        }
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<E> liste) throws PersistenceException {
        isInput = false; //wir wollen ausdrucken bzw.speichern in save()
        openConnection(); //initialisieren

        try {
            oos.writeObject(liste); //Members einfügen
        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "The Members can not be saved.");
        } finally {
            System.out.println( liste.size() + " UserStory wurden erfolgreich gespeichert!");
            closeConnection();
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<E> load() throws PersistenceException {
        isInput = true;
        openConnection();

        List<E> newListe =  null;

        //fis = new FileInputStream(location); //schon in openConnection() geladet

        // Tipp: Use a directory (ends with "/") to implement a negative test case ;-)

        // Reading and extracting the list (try .. catch ommitted here)
        try {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                newListe = (List) obj;
            }
            System.out.println("Es wurden " + newListe.size() + " UserStory erfolgreich reingeladen!");
        } catch (IOException e) {
            throw new PersistenceException
                    (PersistenceException.ExceptionType.ImplementationNotAvailable,
                            "LOG (für Admin): Datei konnte nicht gefunden werden!");
        } catch (ClassNotFoundException e) {
            throw new PersistenceException
                    (PersistenceException.ExceptionType.ImplementationNotAvailable,
                            "LOG (für Admin): Liste konnte nicht extrahiert werden (ClassNotFound)!");
        }
        closeConnection();
        return newListe;
    }
}
