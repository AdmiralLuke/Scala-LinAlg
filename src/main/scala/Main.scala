import core.Matrix
@main def hello: Unit = {
  val matrix: Matrix[Int] = new Matrix[Int](3,3)
  matrix.init(1 :: 2 :: 3 :: 4 :: 5 :: 6 :: 7 :: 8 :: 9 :: Nil)
  println(matrix)
}


