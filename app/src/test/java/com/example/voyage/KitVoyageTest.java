package com.example.voyage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KitVoyageTest {
    
    @Test
    public void testConstructorKitVoyageTwoParameters(){
            KitVoyage monKitVoyage = new KitVoyage("Lyon", "Paris");
            assertEquals("Lyon", monKitVoyage.getDepart());
            assertEquals("Paris", monKitVoyage.getDestination());
    }
    
    @Test
    public void testMethodPrixWithDifferentsOptionVoyage() {
            KitVoyage monKitVoyage = new KitVoyage("Paris", "Lyon");
            OptionVoyage monOptionVoyage = new OptionVoyage("Saut en parachute", 250.00);
            Transport monTransport = new Transport("Trajet en TGV", 20, false);
            Sejour monSejour = new Sejour("Hotel de ville", 0, 3, 60);
            
            monKitVoyage.ajouterOption(monOptionVoyage);
            monKitVoyage.ajouterOption(monTransport);
            monKitVoyage.ajouterOption(monSejour);
            assertEquals(650.00, monKitVoyage.prix(), 1e-2);
    }

    @Test
    public void testMethodAnnulerShouldHaveNoOptionVoyageInCollection(){
        KitVoyage monKitVoyage = new KitVoyage("Paris", "Lyon");
        OptionVoyage monOptionVoyage = new OptionVoyage("Saut en parachute", 250.00);
        Transport monTransport = new Transport("Trajet en TGV", 20, false);
        Sejour monSejour = new Sejour("Hotel de ville", 0, 3, 60);
        monKitVoyage.ajouterOption(monOptionVoyage);
        monKitVoyage.ajouterOption(monTransport);
        monKitVoyage.ajouterOption(monSejour);

        monKitVoyage.annuler();
        assertEquals(0, monKitVoyage.getNbOptions());
    }
}
