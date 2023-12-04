package taller4

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner
import scala.collection.parallel.immutable.ParVector


@RunWith(classOf[JUnitRunner])
class TestMatrizUtils extends AnyFunSuite{

    val utils = new MatrizUtils();
    
    test("Test matrizAlAzar"){
        val m = utils.matrizAlAzar(2, 2);
        assert(m.length == 2);
        assert(m(0).length == 2);
    }


    test("Test vectorAlAzar"){
        val v = utils.vectorAlAzar(2, 2);
        assert(v.length == 2);
    }
   
    test("Test prodPunto"){
        val v1 = Vector(1,2,3);
        val v2 = Vector(1,2,3);
        assert(utils.prodPunto(v1,v2) == 14);
    }

    test("Test prodPuntoParD"){
        val v1 = ParVector(1,2,3);
        val v2 = ParVector(1,2,3);
        assert(utils.prodPuntoParD(v1,v2) == 14);
    }

    test("Test transpuesta"){
        val m = Vector(Vector(1,2,3),Vector(4,5,6),Vector(7,8,9));
        val t = utils.transpuesta(m);
        assert(t == Vector(Vector(1,4,7),Vector(2,5,8),Vector(3,6,9)));
    }

    test("Test subMatriz"){
        val m = Vector(Vector(1,2,3,4),Vector(5,6,7,8),Vector(9,10,11,12),Vector(13,14,15,16));
        val s = utils.subMatriz(m,1,1,2);
        assert(s == Vector(Vector(6,7),Vector(10,11)));
    }

    test("Test sumMatriz"){
        val m1 = Vector(Vector(1,2,3),Vector(4,5,6),Vector(7,8,9));
        val m2 = Vector(Vector(1,2,3),Vector(4,5,6),Vector(7,8,9));
        val s = utils.sumMatriz(m1,m2);
        assert(s == Vector(Vector(2,4,6),Vector(8,10,12),Vector(14,16,18)));
    }

    test("Test restaMatriz"){
        val m1 = Vector(Vector(1,2,3),Vector(4,5,6),Vector(7,8,9));
        val m2 = Vector(Vector(1,2,3),Vector(4,5,6),Vector(7,8,9));
        val s = utils.restaMatriz(m1,m2);
        assert(s == Vector(Vector(0,0,0),Vector(0,0,0),Vector(0,0,0)));
    }

    test("Test combinarMatrices"){
        val m1 = Vector(Vector(1,2),Vector(3,4));
        val m2 = Vector(Vector(5,6),Vector(7,8));
        val m3 = Vector(Vector(9,10),Vector(11,12));
        val m4 = Vector(Vector(13,14),Vector(15,16));
        val s = utils.combinarMatrices(m1,m2,m3,m4);
        assert(s == Vector(Vector(1,2,5,6),Vector(3,4,7,8),Vector(9,10,13,14),Vector(11,12,15,16)));
    }
}
