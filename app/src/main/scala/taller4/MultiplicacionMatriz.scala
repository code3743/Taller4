package taller4
import common._
import scala.util.Random;
import Types.Matriz;

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

      val c11 =
        utils.sumMatriz(multMatrizRecursiva(a11, b11), multMatrizRecursiva(a12, b21))
      val c12 =
        utils.sumMatriz(multMatrizRecursiva(a11, b12), multMatrizRecursiva(a12, b22))
      val c21 =
        utils.sumMatriz(multMatrizRecursiva(a21, b11), multMatrizRecursiva(a22, b21))
      val c22 =
        utils.sumMatriz(multMatrizRecursiva(a21, b12), multMatrizRecursiva(a22, b22))

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

      val (p1, p2) =
        parallel(multMatrizRecursiva(a11, b11), multMatrizRecursiva(a12, b21));
      val (p3, p4) =
        parallel(multMatrizRecursiva(a21, b11), multMatrizRecursiva(a22, b21));

      val c11 = utils.sumMatriz(p1, p2);
      val c12 =
        utils.sumMatriz(multMatrizRecursiva(a11, b12), multMatrizRecursiva(a12, b22));
      val c21 = utils.sumMatriz(p3, p4);
      val c22 =
        utils.sumMatriz(multMatrizRecursiva(a21, b12), multMatrizRecursiva(a22, b22));

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

        val p1 = task { multStrassen(utils.sumMatriz(a11, a22), utils.sumMatriz(b11, b22)) }.join()
        val p2 = task { multStrassen(utils.sumMatriz(a21, a22), b11) }.join()
        val p3 = task { multStrassen(a11, utils.restaMatriz(b12, b22)) }.join()
        val p4 = task { multStrassen(a22, utils.restaMatriz(b21, b11)) }.join()  
        val p5 = task { multStrassen(utils.sumMatriz(a11, a12), b22) }.join()
        val p6 = task { multStrassen(utils.restaMatriz(a21, a11), utils.sumMatriz(b11, b12)) }.join()
        val p7 = task { multStrassen(utils.restaMatriz(a12, a22), utils.sumMatriz(b21, b22)) }.join()  
        val c11 = task { utils.sumMatriz(utils.restaMatriz(utils.sumMatriz(p1, p4), p5), p7) }.join()
        val c12 = task { utils.sumMatriz(p3, p5) }.join()
        val c21 = task { utils.sumMatriz(p2, p4) }.join()
        val c22 = task { utils.sumMatriz(utils.sumMatriz(utils.restaMatriz(p1, p2), p3), p6) }.join()  
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

        val ((p1, p2), (p3, p4)) = parallel(
        parallel(task { multStrassen(utils.sumMatriz(a11, a22), utils.sumMatriz(b11, b22)) }, task { multStrassen(utils.sumMatriz(a21, a22), b11) }),
        parallel(task { multStrassen(a11, utils.restaMatriz(b12, b22)) }, task { multStrassen(a22, utils.restaMatriz(b21, b11)) })
        )
        val ((p5, p6), (p7, _)) = parallel(
        parallel(task { multStrassen(utils.sumMatriz(a11, a12), b22) }, task { multStrassen(utils.restaMatriz(a21, a11), utils.sumMatriz(b11, b12)) }),
        parallel(task { multStrassen(utils.restaMatriz(a12, a22), utils.sumMatriz(b21, b22)) }, task { })
        )
        val ((c11, c12), (c21, c22)) = parallel(
        parallel(task { utils.sumMatriz(utils.restaMatriz(utils.sumMatriz(p1.join(), p4.join()), p5.join()), p7.join()) }, task { utils.sumMatriz(p3.join(), p5.join()) }),
        parallel(task { utils.sumMatriz(p2.join(), p4.join()) }, task { utils.sumMatriz(utils.sumMatriz(utils.restaMatriz(p1.join(), p2.join()), p3.join()), p6.join()) })
        )
        utils.combinarMatrices(c11.join(), c12.join(), c21.join(), c22.join());
    }
    }

}
