package taller4
import scala.collection.parallel.immutable.ParVector;

object Types {
  type Matriz = Vector[Vector[Int]];
  type MatrizPar = ParVector[ParVector[Int]];
}