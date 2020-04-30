package com.grupo15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecebeCombustivelTeste {
    DepositoCombustivel dc = null;

    @BeforeEach
    void setup() {
        dc = new DepositoCombustivel(0, 0, 0, 0);
    }

    @Test
    void adicionaValorNegativoAditivo() {
        final int actual = dc.recebeAditivo(-2);
        final int expected = -1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void adicionaValorNormalAditivo() {
        final int actual = dc.recebeAditivo(300);
        final int expected = 300;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void adicionaValorMaiorNormalAditivo() {
        final int actual = dc.recebeAditivo(501);
        final int expected = DepositoCombustivel.MAX_ADITIVO;
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    void adicionaValorNegativoGasolina() {
        final int actual = dc.recebeGasolina(-2);
        final int expected = -1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void adicionaValorNormalGasolina() {
        final int actual = dc.recebeGasolina(5000);
        final int expected = 5000;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void adicionaValorMaiorNormalGasolina() {
        final int actual = dc.recebeGasolina(20_000);
        final int expected = DepositoCombustivel.MAX_GASOLINA;
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    void adicionaValorNegativoAlcool() {
        final int actual = dc.recebeAlcool(-2);
        final int expected = -1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void adicionaValorNormalAlcool() {
        final int actual = dc.recebeAlcool(1000);
        final int expected = 500; // recebe valor de apenas um tanque
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void adicionaValorMaiorNormalAlcool() {
        final int actual = dc.recebeAlcool(10_000);
        final int expected = DepositoCombustivel.MAX_ALCOOL/2; // recebe valor de apenas um tanque
        Assertions.assertEquals(expected, actual);
    }

}