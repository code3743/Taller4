package taller4
import common._
import scala.util.Random;
import scala.collection.parallel.immutable.ParVector;
import Types.Matriz;
import Types.MatrizPar;



class MultiplicacionMatriz {
  
  val utils = new MatrizUtils();
 

  def multMatriz(m1: Matriz, m2: Matriz): Matriz = {
    val l = m1.length;
    val m2t = utils.transpuesta(m2);
    Vector.tabulate(l, l)((i, j) => utils.prodPunto(m1(i), m2t(j)));
  }

  def multMatrizPar(m1: Matriz, m2: Matriz): Matriz = {
    val l = m1.length;
    val m2t = utils.transpuesta(m2);

    val v = Vector.tabulate(l, l) { (i, j) =>
      task {
        utils.prodPunto(m1(i), m2t(j));
      }
    }

    Vector.tabulate(l, l) { (i, j) =>
      v(i)(j).join();
    }
  }

   

  def multMatrizRecursiva(m1: Matriz, m2: Matriz): Matriz = {
    val n = m1.length;

    if (n == 1) {
      Vector(Vector(m1(0)(0) * m2(0)(0)));
    } else {
    
      val (a11, a12, a21, a22) = (
        utils.subMatriz(m1, 0, 0, n / 2),
        utils.subMatriz(m1, 0, n / 2, n / 2),
        utils.subMatriz(m1, n / 2, 0, n / 2),
        utils.subMatriz(m1, n / 2, n / 2, n / 2)
      );
      val (b11, b12, b21, b22) = (
        utils.subMatriz(m2, 0, 0, n / 2),
        utils.subMatriz(m2, 0, n / 2, n / 2),
        utils.subMatriz(m2, n / 2, 0, n / 2),
        utils.subMatriz(m2, n / 2, n / 2, n / 2)
      );

      val (p1, p2, p3, p4)= (
       multMatrizRecursiva(a11, b11),
       multMatrizRecursiva(a12, b12),
       multMatrizRecursiva(a21, b21),
       multMatrizRecursiva(a22, b22)
      );

      val( c11, c12, c21,c22) = (
        utils.sumMatriz(multMatrizRecursiva(a11, b11), multMatrizRecursiva(a12, b21)),
        utils.sumMatriz(multMatrizRecursiva(a11, b12), multMatrizRecursiva(a12, b22)),
        utils.sumMatriz(multMatrizRecursiva(a21, b11), multMatrizRecursiva(a22, b21)),
        utils.sumMatriz(multMatrizRecursiva(a21, b12), multMatrizRecursiva(a22, b22))
      );
      utils.combinarMatrices(c11, c12, c21, c22);
    }
  }

  def multMatrizRecursivaPar(m1: Matriz, m2: Matriz): Matriz = {
    val n = m1.length;

    if (n == 1) {
      Vector(Vector(m1(0)(0) * m2(0)(0)));
    } else {
      val (a11, a12, a21, a22) = (
        utils.subMatriz(m1, 0, 0, n / 2),
        utils.subMatriz(m1, 0, n / 2, n / 2),
        utils.subMatriz(m1, n / 2, 0, n / 2),
        utils.subMatriz(m1, n / 2, n / 2, n / 2)
      );
      val (b11, b12, b21, b22) = (
        utils.subMatriz(m2, 0, 0, n / 2),
        utils.subMatriz(m2, 0, n / 2, n / 2),
        utils.subMatriz(m2, n / 2, 0, n / 2),
        utils.subMatriz(m2, n / 2, n / 2, n / 2)
      );

     
      val (p1, p2, p3, p4)= parallel(
       multMatrizRecursivaPar(a11, b11),
       multMatrizRecursivaPar(a12, b12),
       multMatrizRecursivaPar(a21, b21),
       multMatrizRecursivaPar(a22, b22)
      );

      val( c11, c12, c21,c22) = parallel(
        utils.sumMatriz(multMatrizRecursivaPar(a11, b11), multMatrizRecursivaPar(a12, b21)),
        utils.sumMatriz(multMatrizRecursivaPar(a11, b12), multMatrizRecursivaPar(a12, b22)),
        utils.sumMatriz(multMatrizRecursivaPar(a21, b11), multMatrizRecursivaPar(a22, b21)),
        utils.sumMatriz(multMatrizRecursivaPar(a21, b12), multMatrizRecursivaPar(a22, b22))
      );
      utils.combinarMatrices(c11, c12, c21, c22);
    }
  }

  def multStrassen(m1: Matriz, m2: Matriz): Matriz = {
    val n = m1.length;

    if (n == 1) {
      Vector(Vector(m1(0)(0) * m2(0)(0)));
    } else {
      val (a11, a12, a21, a22) = (
        utils.subMatriz(m1, 0, 0, n / 2),
        utils.subMatriz(m1, 0, n / 2, n / 2),
        utils.subMatriz(m1, n / 2, 0, n / 2),
        utils.subMatriz(m1, n / 2, n / 2, n / 2)
      );
      val (b11, b12, b21, b22) = (
        utils.subMatriz(m2, 0, 0, n / 2),
        utils.subMatriz(m2, 0, n / 2, n / 2),
        utils.subMatriz(m2, n / 2, 0, n / 2),
        utils.subMatriz(m2, n / 2, n / 2, n / 2)
      );

        val (p1, p2, p3, p4) =(
          multStrassen(utils.sumMatriz(a11, a22), utils.sumMatriz(b11, b22)),
          multStrassen(utils.sumMatriz(a21, a22), b11),
          multStrassen(a11, utils.restaMatriz(b12, b22)),
          multStrassen(a22, utils.restaMatriz(b21, b11))
          );
        val (p5,p6,p7) = (
          multStrassen(utils.sumMatriz(a11, a12), b22),
          multStrassen(utils.restaMatriz(a21, a11), utils.sumMatriz(b11, b12)),
          multStrassen(utils.restaMatriz(a12, a22), utils.sumMatriz(b21, b22))
          );
  
        val (c11, c12, c21, c22) =( 
         utils.sumMatriz(utils.restaMatriz(utils.sumMatriz(p1, p4), p5), p7) ,
         utils.sumMatriz(p3, p5) ,
         utils.sumMatriz(p2, p4) ,
         utils.sumMatriz(utils.sumMatriz(utils.restaMatriz(p1, p2), p3), p6)
         );
        utils.combinarMatrices(c11, c12, c21, c22);
      }
  }

  def multStrassenPar(m1: Matriz, m2: Matriz): Matriz = {
       val n = m1.length;

    if (n == 1) {
      Vector(Vector(m1(0)(0) * m2(0)(0)));
    } else {
      val (a11, a12, a21, a22) = (
        utils.subMatriz(m1, 0, 0, n / 2),
        utils.subMatriz(m1, 0, n / 2, n / 2),
        utils.subMatriz(m1, n / 2, 0, n / 2),
        utils.subMatriz(m1, n / 2, n / 2, n / 2)
      );
      val (b11, b12, b21, b22) = (
        utils.subMatriz(m2, 0, 0, n / 2),
        utils.subMatriz(m2, 0, n / 2, n / 2),
        utils.subMatriz(m2, n / 2, 0, n / 2),
        utils.subMatriz(m2, n / 2, n / 2, n / 2)
      );

        val (p1, p2, p3, p4) = parallel(
          multStrassenPar(utils.sumMatriz(a11, a22), utils.sumMatriz(b11, b22)),
          multStrassenPar(utils.sumMatriz(a21, a22), b11),
          multStrassenPar(a11, utils.restaMatriz(b12, b22)),
          multStrassenPar(a22, utils.restaMatriz(b21, b11))
          );
        val (p5, p6) = parallel(
          multStrassenPar(utils.sumMatriz(a11, a12), b22),
          multStrassenPar(utils.restaMatriz(a21, a11), utils.sumMatriz(b11, b12))
        );

        val p7 = multStrassenPar(utils.restaMatriz(a12, a22), utils.sumMatriz(b21, b22));
  
        val (c11, c12, c21, c22) = parallel( 
         utils.sumMatriz(utils.restaMatriz(utils.sumMatriz(p1, p4), p5), p7) ,
         utils.sumMatriz(p3, p5) ,
         utils.sumMatriz(p2, p4) ,
         utils.sumMatriz(utils.sumMatriz(utils.restaMatriz(p1, p2), p3), p6)
         );
        utils.combinarMatrices(c11, c12, c21, c22);
    }
  }



    //Prueba de algortimo con ParVector y MatrizPar

    def multMatrizParD(m1: MatrizPar, m2: MatrizPar): MatrizPar = {
      val l = m1.length;
      val m2t = utils.transpuestaParD(m2);
      ParVector.tabulate(l, l)((i, j) => utils.prodPuntoParD(m1(i), m2t(j)));
    }

    def multMatrizParParD(m1: MatrizPar, m2: MatrizPar): MatrizPar = {
      val l = m1.length;
      val m2t = utils.transpuestaParD(m2);

      val v = ParVector.tabulate(l, l) { (i, j) =>
        task {
          utils.prodPuntoParD(m1(i), m2t(j));
        }
      }

      ParVector.tabulate(l, l) { (i, j) =>
        v(i)(j).join();
      }
    }

}
