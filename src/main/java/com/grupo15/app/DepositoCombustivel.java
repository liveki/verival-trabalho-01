package com.grupo15.app;

public class DepositoCombustivel {
  public static final int MAX_ADITIVO = 500;
  public static final int MAX_ALCOOL = 2500;
  public static final int MAX_GASOLINA = 10000;

  private int tGasolina;
  private int tAditivo;
  private int tAlcool1;
  private int tAlcool2;

  public DepositoCombustivel(int tGasolina, int tAditivo, int tAlcool1, int tAlcool2) {
    this.tGasolina = tGasolina;
    this.tAditivo = tAditivo;
    this.tAlcool1 = tAlcool1;
    this.tAlcool2 = tAlcool2;
  }

  public int gettGasolina() {
    // TODO
    return tGasolina;
  }

  public int gettAditivo() {
    // TODO
    return tAditivo;
  }

  public int gettAlcool1() {
    // TODO
    return tAlcool1;
  }

  public int gettAlcool2() {
    // TODO
    return tAlcool2;
  }

  public int recebeAditivo(int qtdade) {
    // TODO
    return 0;
  }

  public int recebeGasolina(int qtdade) {
    // TODO
    return 0;
  }

  public int recebeAlcool(int qtdade) {
    // TODO
    return 0;
  }

  public int[] encomendaCombustivel(int qtdade, boolean emerg) {
    // TODO
    return null;
  }

  @Override
  public String toString() {
    return "DepComb [tAditivo=" + tAditivo + ", tAlcool1=" + tAlcool1 + ", tAlcool2=" + tAlcool2 + ", tGasolina="
        + tGasolina + "]";
  }

}