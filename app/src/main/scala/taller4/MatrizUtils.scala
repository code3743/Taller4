package taller4
import  scala.util.Random;
import  Types.Matriz;
import  Types.MatrizPar;
import  scala.collection.parallel.immutable.ParVector;

class MatrizUtils {
  val random = new Random;
 
  def matrizAlAzar(long: Int, vals: Int): Matriz = {
    val v = Vector.fill(long, long) { random.nextInt(vals) };
    v;
  }

  def vectorAlAzar(long: Int, vals: Int): Vector[Int] = {
    val v = Vector.fill(long) { random.nextInt(vals) };
    v;
  }

  def prodPunto(v1: Vector[Int], v2: Vector[Int]): Int = {
    (v1 zip v2).map({ case (i, j) => i * j }).sum
  }

  def transpuesta(m: Matriz): Matriz = {
    val l = m.length;
    val v = Vector.tabulate(l, l)((i, j) => m(j)(i));
    v;
  }

  def subMatriz(m: Matriz, i: Int, j: Int, l: Int): Matriz = {
    Vector.tabulate(l, l) { (x, y) => m(i + x)(j + y) };
  }

  def sumMatriz(m1: Matriz, m2: Matriz): Matriz = {
    val l = m1.length;
    val v = Vector.tabulate(l, l) { (i, j) => m1(i)(j) + m2(i)(j) };
    v;
  }

  def restaMatriz(m1: Matriz, m2: Matriz): Matriz = {
    val l = m1.length;
    val v = Vector.tabulate(l, l) { (i, j) => m1(i)(j) - m2(i)(j) };
    v;
  }

  def combinarMatrices(
      c11: Matriz,
      c12: Matriz,
      c21: Matriz,
      c22: Matriz
  ): Matriz = {
    val l = c11.length;
    Vector.tabulate(2 * l, 2 * l) { (i, j) =>
      if (i < l) {
        if (j < l) c11(i)(j) else c12(i)(j - l);
      } else {
        if (j < l) c21(i - l)(j) else c22(i - l)(j - l);
      }
    }
  }


  // Pruebas con VectorPar y MatrizPar
   def matrizAlAzarParD(long: Int, vals: Int): MatrizPar = {
    val v = ParVector.fill(long, long) { random.nextInt(vals) };
    v;
  }

  def prodPuntoParD(v1:ParVector[Int], v2:ParVector[Int]): Int = {
    (v1 zip v2).map({ case (i, j) => i * j }).sum
  }

  def transpuestaParD(m: MatrizPar): MatrizPar = {
    val l = m.length;
    val v = ParVector.tabulate(l, l)((i, j) => m(j)(i));
    v;
  }
}
