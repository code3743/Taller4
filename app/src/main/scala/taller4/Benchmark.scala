package taller4;
import Types.Matriz;
import Types.MatrizPar;
import  scala.collection.parallel.immutable.ParVector;
import org.scalameter.measure
import org.scalameter.withWarmer
import org.scalameter.Warmer
import scala.util.Random
import org.scalameter.Quantity

class Benchmark {
    val utils = new MatrizUtils();
    
    def compararAlgoritmos(Funcion1:(Matriz,Matriz) => Matriz, Funcion2:(Matriz,Matriz) => Matriz)(m1: Matriz, m2: Matriz): (Double, Double, Double) = {
        val timeF1 = withWarmer(new Warmer.Default) measure {
            Funcion1(m1, m2);
        }
        val timeF2 = withWarmer(new Warmer.Default) measure {
            Funcion2(m1, m2);
        }

        val promedio = timeF1.value / timeF2.value;
        (timeF1.value, timeF2.value, promedio);

    }

    def compararAlgoritmosParD(Funcion1:(MatrizPar,MatrizPar) => MatrizPar, Funcion2:(MatrizPar,MatrizPar) => MatrizPar)(m1: MatrizPar, m2: MatrizPar): (Double, Double, Double) = {
        val timeF1 = withWarmer(new Warmer.Default) measure {
            Funcion1(m1, m2);
        }
        val timeF2 = withWarmer(new Warmer.Default) measure {
            Funcion2(m1, m2);
        }
        val promedio = timeF1.value / timeF2.value;
        (timeF1.value, timeF2.value, promedio);
    }


    def compararProdPunto(l:Int)(fn1:(Vector[Int], Vector[Int]) =>Int, fn2:(ParVector[Int], ParVector[Int]) =>Int):(Double, Double, Double)={
        val v1 = utils.vectorAlAzar(l, 2);
        val v2 = utils.vectorAlAzar(l, 2);
        val v1Par = ParVector(v1:_*);
        val v2Par = ParVector(v2:_*);
        val timeF1 = withWarmer(new Warmer.Default) measure {
            fn1(v1, v2);
        }
        val timeF2 = withWarmer(new Warmer.Default) measure {
            fn2(v1Par, v2Par);
        }
        val promedio = timeF1.value / timeF2.value;
        (timeF1.value, timeF2.value, promedio);
    }
}