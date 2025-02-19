/**
  * Taller 4 - Programación Funcional
  * Autores: <Estudiantes>
  * Profesor: Carlos A Delgado
  */
package taller4

import org.scalameter.measure
import org.scalameter.withWarmer
import org.scalameter.Warmer
import  scala.collection.parallel.immutable.ParVector;

object Taller4{
 
  def main(args: Array[String]): Unit = {
    val benchmark = new Benchmark();
    val utils = new MatrizUtils();
    println(
      withWarmer(new Warmer.Default) measure {
        (1 to 100000000).toArray
      }
    );
    ///*1. Multiplicación de matrices de forma secuencial vs Multiplicación de matrices de forma concurrente*/
    // for {
    //   i <- 1 to 10
    //   m1 = utils.matrizAlAzar(math.pow(2, i).toInt, 2)
    //   m2 = utils.matrizAlAzar(math.pow(2, i).toInt, 2)
    // } yield {
    //     println(s"Multiplicando matrices de ${math.pow(2, i).toInt}x${math.pow(2, i).toInt}");
    //     val (t1, t2, aceleracion) = benchmark.compararAlgoritmos(
    //       new MultiplicacionMatriz().multMatrizRecursiva,
    //       new MultiplicacionMatriz().multMatrizRecursivaPar
    //     )(m1, m2);
    //     println(s"Tiempo secuencial: $t1");
    //     println(s"Tiempo paralelo: $t2");
    //     println(s"Aceleración: $aceleracion");
    //   }
    // ///*2. Producto punto de vectores de forma secuencial vs Producto punto de vectores de forma concurrente*/
    // // for{
    // //   i <- 1 to 10
    // // } yield {
    // //   println(s"Comparando prodPunto de vectores de tamaño ${math.pow(10, i).toInt}");
    // //   val (t1, t2, aceleracion) = benchmark.compararProdPunto(math.pow(10, i).toInt)(
    // //     utils.prodPunto,
    // //     utils.prodPuntoParD
    // //   );
    // //   println(s"Tiempo secuencial: $t1");
    // //   println(s"Tiempo paralelo: $t2");
    // //   println(s"Aceleración: $aceleracion");
    // // }
    
    // ///*3. Multiplicación de matrices de forma secuencial vs Multiplicación de matrices de forma concurrente utilizando ParVector */
    //  for {
    //     i <- 1 to 10
    //     m1 = utils.matrizAlAzarParD(math.pow(2, i).toInt, 2)
    //     m2 = utils.matrizAlAzarParD(math.pow(2, i).toInt, 2)
    //  } yield {
    //     println(s"Multiplicando matrices de ${math.pow(2, i).toInt}x${math.pow(2, i).toInt}");
    //     val (t1, t2, aceleracion) = benchmark.compararAlgoritmosParD(
    //       new MultiplicacionMatriz().multMatrizParD,
    //       new MultiplicacionMatriz().multMatrizParParD
    //     )(m1, m2);
    //     println(s"Tiempo secuencial: $t1");
    //     println(s"Tiempo paralelo: $t2");
    //     println(s"Aceleración: $aceleracion");
    // }
}

}