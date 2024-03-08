package com.ipi.jva350.model;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntrepriseTest {
    
    @Test
    public void TestEstDansPlageTrue(){
        // Given :
        LocalDate d = LocalDate.of(2022, 12, 20);
        LocalDate debut = LocalDate.of(2022, 10, 10);
        LocalDate fin = LocalDate.of(2023, 02, 15);
        // When : 
        boolean res = Entreprise.estDansPlage(d, debut, fin);
        // Then :
        Assertions.assertEquals(true, res, "le 20 décembre 2022 est compris entre le 10 octobre 2022 et le 15 février 2023");
    }

    @Test
    public void TestEstDansPlageFalse(){
        // Given :
        LocalDate d = LocalDate.of(2022, 05, 8);
        LocalDate debut = LocalDate.of(2022, 06, 12);
        LocalDate fin = LocalDate.of(2022, 10, 20);
        // When : 
        boolean res = Entreprise.estDansPlage(d, debut, fin);
        // Then :
        Assertions.assertEquals(false, res, "le 8 mai 2022 n'est pas compris entre le 12 juin 2022 et le 20 décembre 2022");
    }

    @Test
    public void TestEstDansPlageEqualsFalse(){
        //Given
        LocalDate d = LocalDate.of(2022, 06, 01);
        LocalDate debut = LocalDate.of(2022, 01, 21);
        LocalDate fin = LocalDate.of(2022, 06, 01);
        // When :
        boolean res = Entreprise.estDansPlage(d, debut, fin);
        // Then :
        Assertions.assertEquals(false, res, "le 1er juin n'est pas compris entre le 21 janvier 2022 et le 1er juin 2022 exclus");
    }
}
