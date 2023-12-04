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

    // for {
    //   i <- 1 to 10
    //   m1 = utils.matrizAlAzar(math.pow(2, i).toInt, 2)
    //   m2 = utils.matrizAlAzar(math.pow(2, i).toInt, 2)
    // } yield {
    //     println(s"Multiplicando matrices de ${math.pow(2, i).toInt}x${math.pow(2, i).toInt}");
    //     val (t1, t2, aceleracion) = benchmark.compararAlgoritmos(
    //       new MultiplicacionMatriz().multStrassen,
    //       new MultiplicacionMatriz().multStrassenPar
    //     )(m1, m2);
    //     println(s"Tiempo secuencial: $t1");
    //     println(s"Tiempo paralelo: $t2");
    //     println(s"Aceleración: $aceleracion");
    //   }
    //}

    //Prueba con ParVector
     for {
        i <- 1 to 10
        m1 = utils.matrizAlAzarParD(math.pow(2, i).toInt, 2)
        m2 = utils.matrizAlAzarParD(math.pow(2, i).toInt, 2)
     } yield {
        println(s"Multiplicando matrices de ${math.pow(2, i).toInt}x${math.pow(2, i).toInt}");
        val (t1, t2, aceleracion) = benchmark.compararAlgoritmosParD(
          new MultiplicacionMatriz().multMatrizParD,
          new MultiplicacionMatriz().multMatrizParParD
        )(m1, m2);
        println(s"Tiempo secuencial: $t1");
        println(s"Tiempo paralelo: $t2");
        println(s"Aceleración: $aceleracion");
    }
 }
}
