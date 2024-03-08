package com.ipi.jva350.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.cglib.core.Local;

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

    @ParameterizedTest(name = "jour {0} est ferie : {1}")
    @CsvSource({
            "'2024-05-08', true",
            "'2024-03-01', false",
            "'2024-02-29', false",
            "'2024-04-01', true"

    })
    public void TestEstJourFerie(String jour, Boolean res){
        //Given, When, Then
        LocalDate test = LocalDate.parse(jour);
        Assertions.assertEquals(res, Entreprise.estJourFerie(test));
    }


    @ParameterizedTest
    @CsvSource({
            "'2023-04-01', '2022-06-01'",
            "'2023-09-01', '2023-06-01'"
    })
    public void TestGetPremierJourAnneeDeConges(String d, String premierJour){
        //Given, When, Then
        LocalDate test = LocalDate.parse(d);
        LocalDate attendu = LocalDate.parse(premierJour);
        Assertions.assertEquals(Entreprise.getPremierJourAnneeDeConges(test), attendu);
    }
}
