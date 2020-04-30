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


<h2>Evolução das classes alvo e driver</h3></br>
<ol>
  <li>Assim que os testes e o código foram montados, encontrou-se erros com null pointers. A um primeiro ponto de vista isso não fazia sentido, pois os valores eram do tipo <b>int</b> e em Java, esses valores não tem como ter um valor nulo. Logo descobriu-se que que o <b>@BeforeEach</b> não estava executando, corrigir esse problema foi rápido e resolveu a maioria dos erros.</li>
  <li>O erro seguinte foi resultado de falta de entendimento do valor retornado pelas classes, que foi resolvido ajeitando a forma que os testes coonstruiam o valor <b>expected</b>.</li>
  <li>Com esses erros resolvidos e com os testes em perfeito estado, encontrou-se erros no código da classe alvo. Os erros eram constantes sendo usados em locais errados (e.g. constante MAX_ADITIVO sendo usada no lugar MAX_GASOLINA).</li>
  <li>Em seguida, notou-se que o código para testar o <b>recebeAlcool</b> também havia dado problema, mas isso se deve ao fato de que o código devolve apenas o valor de um dos tanques, em vez do valor total de alcool. Consequentemente, o valor esperado foi mudado para metade do valor total de alcool e os testes voltaram a correr sem erros.</li>
</ol>