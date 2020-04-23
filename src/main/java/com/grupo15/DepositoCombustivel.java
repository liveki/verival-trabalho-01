package com.grupo15;

public class DepositoCombustivel {
  public static final int MAX_ADITIVO = 500;
  public static final int MAX_ALCOOL = 2500;
  public static final int MAX_GASOLINA = 10000;

  private int tGasolina;
  private int tAditivo;
  private int tAlcool1;
  private int tAlcool2;

  public DepositoCombustivel(int tGasolina, int tAditivo, int tAlcool1, int tAlcool2) {
    // inicializa as variáveis com 0(zero) caso sejam negativas.
    tGasolina = tGasolina < 0 ? 0 : tGasolina;
    tAditivo = tAditivo < 0 ? 0 : tAditivo;
    tAlcool1 = tAlcool1 < 0 ? 0 : tAlcool1;
    tAlcool2 = tAlcool2 < 0 ? 0 : tAlcool2;

    // verifica se os valores passados não são superior aos limites de cada tanque.
    this.tGasolina = tGasolina > MAX_GASOLINA ? MAX_GASOLINA : tGasolina;
    this.tAditivo = tAditivo > MAX_ADITIVO ? MAX_ADITIVO : tAditivo;
    this.tAlcool1 = tAlcool1 > MAX_ALCOOL / 2 ? MAX_ALCOOL / 2 : tAlcool1;
    this.tAlcool2 = tAlcool2 > MAX_ALCOOL / 2 ? MAX_ALCOOL / 2 : tAlcool2;
  }

  public int gettGasolina() {
    return tGasolina;
  }

  public int gettAditivo() {
    return tAditivo;
  }

  public int gettAlcool1() {
    return tAlcool1;
  }

  public int gettAlcool2() {
    return tAlcool2;
  }

  public int recebeAditivo(int qtdade) {
    if (qtdade < 0) {
      return -1;
    }
    tAditivo = tAditivo + qtdade > MAX_ADITIVO ? MAX_ADITIVO : tAditivo + qtdade;
    return tAditivo;
  }

  public int recebeGasolina(int qtdade) {
    if (qtdade < 0) {
      return -1;
    }

    tGasolina = tGasolina + qtdade > MAX_GASOLINA ? MAX_GASOLINA : tGasolina + qtdade;

    return tAditivo;
  }

  public int recebeAlcool(int qtdade) {
    if (qtdade < 0) {
      return -1;
    }

    int totalAlcool = tAlcool1 + tAlcool2 + qtdade > MAX_ALCOOL ? MAX_ALCOOL : tAlcool1 + tAlcool2 + qtdade;
    tAlcool1 = tAlcool2 = totalAlcool / 2;

    return tAlcool1;
  }

  public int[] encomendaCombustivel(int qtdade, boolean emerg) {
    int[] result = { -2, 0, 0, 0 };

    if (qtdade <= 0)
      return result;

    result[0] = 0;

    int qtAditivo = (int) (qtdade * 0.05);
    int qtGasolina = (int) (qtdade * 0.7);
    int qtAlcool = (int) (qtdade * 0.25);

    if (!canRemoveAditivo(qtAditivo, emerg)) {
      result[0] = -1;
      return result;
    }

    if (!canRemoveGas(qtGasolina, emerg)) {
      result[1] = -1;

      return result;
    }

    if (!canRemoveAlcool(qtAlcool, emerg)) {
      result[2] = -1;

      return result;
    }

    tGasolina -= qtGasolina;
    tAditivo -= qtAditivo;
    tAlcool1 -= qtAlcool / 2;
    tAlcool2 -= qtAlcool / 2;

    result = new int[] { tAditivo, tGasolina, tAlcool1, tAlcool2 };

    return result;
  }

  private boolean canRemoveGas(int ammountToRemove, boolean isEmergency) {
    if (isEmergency) {
      return tGasolina - ammountToRemove >= 0 ? true : false;
    } else {
      return tGasolina - ammountToRemove >= (MAX_GASOLINA * 0.25) ? true : false;
    }
  }

  private boolean canRemoveAditivo(int ammountToRemove, boolean isEmergency) {
    if (isEmergency) {
      return tAditivo - ammountToRemove >= 0 ? true : false;
    } else {
      return tAditivo - ammountToRemove >= (MAX_ADITIVO * 0.25) ? true : false;
    }
  }

  private boolean canRemoveAlcool(int ammountToRemove, boolean isEmergency) {
    if (isEmergency) {
      return (tAlcool1 + tAlcool2) - ammountToRemove >= 0 ? true : false;
    } else {
      return (tAlcool1 + tAlcool2) - ammountToRemove >= (MAX_ALCOOL * 0.25) ? true : false;
    }
  }

  @Override
  public String toString() {
    return "DepComb [tAditivo=" + tAditivo + ", tAlcool1=" + tAlcool1 + ", tAlcool2=" + tAlcool2 + ", tGasolina="
        + tGasolina + "]";
  }
}
