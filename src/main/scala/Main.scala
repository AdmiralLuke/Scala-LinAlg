import core.Matrix
import solver.Elimination
@main def hello: Unit = {
  val matrix: Matrix[Double] = new Matrix[Double](3,3)
  matrix.init(1.0 :: 2.0 :: 3.0 :: 4.0 :: 5.0 :: 6.0 :: 7.0 :: 6.0 :: 9.0 :: Nil)
  println(matrix)
  var b: Array[Double] = Array(2.0, 4.0, 7.0)
  val res = Elimination().gaussian_elimination(matrix, b)
  println(res(0))
}


