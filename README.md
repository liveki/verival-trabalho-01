<h3>Testes baseados na especificação da problemática:</h3>
  Variáveis de entrada: <i>Composição</i> (5% de aditivo, 25% de álcool, 70% de gasolina);
 
<b>A gasolina só é vendida se: SE EMERGÊNCIA FOR <n>TRUE<n></b><br>
  retirando aditivo do tanque de aditivo(500L) o restante for >= 0 ;<br>
  retirando gasolina do tanque de gasolina(10000L) o restante for >= 0 ;<br>
  a fim de respeitar a regra de equilíbrio dos tanques, o álcool só é retirado se:<br>
  retirando 12.5% de álcool do T1 (1250L) o restante for >= 0;<br>
  retirando 12.5% de álcool do T2 (1250L) o restante for >= 0;<br>
 
<b>A gasolina só é vendida se: SE EMERGÊNCIA FOR <n>FALSE</n> DEVE-SE MANTER A RESERVA TÉCNICA DE 25% SOBRE CADA TANQUE</b><br>
  Retirando aditivo do tanque de aditivo(500L) o restante for > 125;<br>
  Retirando gasolina do tanque de gasolina(10000L) o restante for > 2500;<br>
  a fim de respeitar a regra de equilíbrio dos tanques, o álcool só é retirado se:<br>
  retirando 12.5% de álcool do T1 (1250L) o restante for > 312,5;<br>
  retirando 12.5% de álcool do T2 (1250L) o restante for > 312.5;<br>

<h3>Testes sem valores limites: SE EMERGÊNCIA FOR TRUE</h3>

Variáveis de entrada: <b>{ tAditivo, tGasolina, tAlcool1, tAlcool2 } = qtdade;</b>

Classes de equivalência:<br>

| Classe |          Variável           |      Resultado       |
| :----: | :-------------------------: | :------------------: |
|   C1   |        tAditivo == 0        |    Falta aditivo     |
|   C2   |       tGasolina == 0        |    Falta gasolina    |
|   C3   | ( tAlcool1 + tAlcool2) == 0 |     Falta álcool     |
|   C4   |   todas as variáveis > 0    | Pode ser encomendado |
|   C5   |         qtdade <= 0         | Quantidade inválida  |

<h3>Testes com valores limites: SE EMERGÊNCIA FOR FALSE</h3>

Variáveis de entrada: <b>{ tAditivo, tGasolina, tAlcool1, tAlcool2 } = qtdade;</b>

Classes de equivalência:

| Classe |       Variável        | On-point | Off-point |       In-points       | Out-points  |
| :----: | :-------------------: | :------: | :-------: | :-------------------: | :---------: |
|   C1   |       tAditivo        |   125    |    126    |   126 >= ... <= 500   | ... <= 500  |
|   C2   |       tGasolina       |   2500   |   2501    | 2501 >= ... <= 10.000 | ... <= 2500 |
|   C3   | (tAlcool1 + tAlcool2) |   625    |    626    |    626 ... <= 2500    | ... <= 625  |
|   C4   |        qtdade         |    0     |     1     |   1 >= ... <= 13000   |  ... <= 0   |
