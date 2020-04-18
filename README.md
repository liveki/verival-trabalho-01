<h3>Testes baseados na especificação da problemática:<h3>
  Variáveis de entrada: <i>Composição</i> (5% de aditivo, 25% de álcool, 70% de gasolina);
 
<b>A gasolina só é vendida se: SE EMERGÊNCIA FOR <n>TRUE<n></b><br>
  retirando aditivo do tanque de aditivo(500L) o restante for >= 0 ;<br>
  retirando gasolina do tanque de gasolina(10000L) o restante for >= 0 ;<br>
  a fim de respeitar a regra de equilíbrio dos tanques, o álcool só é retirado se:<br>
  retirando 12.5% de álcool do T1 (1250L) o restante for >= 0;<br>
  retirando 12.5% de álcool do T2 (1250L) o restante for >= 0;<br>
 
<b>A gasolina só é vendida se: SE EMERGÊNCIA FOR <n>FALSE</n> DEVE-SE MANTER A RESERVA TÉCNICA DE 25% SOBRE CADA TANQUE</b><br>
  Retirando aditivo do tanque de aditivo(500L) o restante for >= 125;<br>
  Retirando gasolina do tanque de gasolina(10000L) o restante for >= 2500;<br>
  a fim de respeitar a regra de equilíbrio dos tanques, o álcool só é retirado se:<br>
  retirando 12.5% de álcool do T1 (1250L) o restante for >= 312,5;<br>
  retirando 12.5% de álcool do T2 (1250L) o restante for >= 312.5;<br>
