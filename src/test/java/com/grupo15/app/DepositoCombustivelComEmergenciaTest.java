package com.grupo15.app;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

// TESTES COM EMERGÊNCIA NACIONAL
public class DepositoCombustivelComEmergenciaTest {
  DepositoCombustivel dc = null;
  int qtdade;

  @BeforeEach
  void setUp() {
    dc = new DepositoCombustivel(0, 0, 0, 0);
    qtdade = 0;
  }

  // result[0] = aditivo
  // result[1] = gasolina
  // result[2] = alcool1
  // result[3] = alcool2

  @Test
  void faltaAditivo() {
    dc.recebeAlcool(2500);
    dc.recebeGasolina(10000);

    final int result[] = dc.encomendaCombustivel(1000, true);

    final int expected = -1;
    final int actual = result[0];

    assertEquals(expected, actual);
  }

  @Test
  void faltaGasolina() {
    dc.recebeAditivo(500);
    dc.recebeAlcool(2500);

    final int result[] = dc.encomendaCombustivel(1000, true);

    final int expected = -1;
    final int actual = result[1];

    assertEquals(expected, actual);
  }

  @Test
  void faltaAlcool() {
    dc.recebeAditivo(500);
    dc.recebeGasolina(10000);

    final int result[] = dc.encomendaCombustivel(1000, true);

    final int expected = -1;
    final int actual = result[2];

    assertEquals(expected, actual);
  }

  @Test
  void encomendaBemSucedida() {
    dc.recebeAditivo(50);
    dc.recebeGasolina(700);
    dc.recebeAlcool(250);

    final int result[] = dc.encomendaCombustivel(1000, true);

    final boolean hasAditivo = result[0] >= 0 ? true : false;

    final boolean hasGasolina = result[1] >= 0 ? true : false;

    final boolean hasAlcool = (result[2] + result[3]) >= 0 ? true : false;

    assertTrue((hasAditivo && hasGasolina && hasAlcool));
  }

  @Test
  void entradaInvalida() {
    final int result[] = dc.encomendaCombustivel(0, true);

    final int expected = -2;
    final int actual = result[0];

    assertEquals(expected, actual);
  }

  @Test
  void entradaNegativa() {
    final int result[] = dc.encomendaCombustivel(-25, true);

    final int expected = -2;
    final int actual = result[0];

    assertEquals(expected, actual);
  }
}