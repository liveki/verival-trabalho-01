package com.grupo15;

import javax.sound.sampled.SourceDataLine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//TESTES SEM EMERGÊNCIA NACIONAL
public class DepositoCombustivelSemEmergenciaTest {
  DepositoCombustivel dc = null;
  int qtdade;

  @BeforeEach
  void setUp() {
    dc = new DepositoCombustivel(2500, 125, 313, 313);
    qtdade = 0;
  }

  // result[0] = aditivo
  // result[1] = gasolina
  // result[2] = alcool1
  // result[3] = alcool2

  @Test
  void faltaAditivo() {
    dc.recebeAlcool(1000);
    dc.recebeGasolina(1000);

    final int result[] = dc.encomendaCombustivel(1000, false);

    final int expected = -1;
    final int actual = result[0];

    Assertions.assertEquals(expected, actual);
  }

  @Test
  void faltaGasolina() {
    dc.recebeAditivo(1000);
    dc.recebeAlcool(1000);

    final int result[] = dc.encomendaCombustivel(1000, false);

    final int expected = -1;
    final int actual = result[1];

    Assertions.assertEquals(expected, actual);
  }

  @Test
  void faltaAlcool() {
    dc.recebeAditivo(1000);
    dc.recebeGasolina(10000);

    final int result[] = dc.encomendaCombustivel(1000, false);

    final int expected = -1;
    final int actual = result[2];

    Assertions.assertEquals(expected, actual);
  }

  @Test
  void encomendaBemSucedida() {
    dc.recebeAditivo(50);
    dc.recebeGasolina(700);
    dc.recebeAlcool(250);

    final int result[] = dc.encomendaCombustivel(1000, false);

    final boolean hasAditivo = result[0] >= 125 ? true : false;

    final boolean hasGasolina = result[1] >= 2500 ? true : false;

    final boolean hasAlcool = (result[2] + result[3]) >= 326 ? true : false;

    Assertions.assertTrue((hasAditivo && hasGasolina && hasAlcool));
  }

  @Test
  void entradaInvalida() {
    final int result[] = dc.encomendaCombustivel(0, false);

    final int expected = -2;
    final int actual = result[0];

    Assertions.assertEquals(expected, actual);
  }

  @Test
  void entradaNegativa() {
    final int result[] = dc.encomendaCombustivel(-25, false);

    final int expected = -2;
    final int actual = result[0];

    Assertions.assertEquals(expected, actual);
  }
}