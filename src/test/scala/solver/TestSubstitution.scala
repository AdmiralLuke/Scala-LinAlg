package solver
import core.Matrix;

class TestSubstitution extends munit.FunSuite {
    test("backwards substitution") {
        val matrix: Matrix[Double] = Matrix[Double](2, 2)
        matrix.init(1.0 :: 2.0 :: 3.0 :: 5.0 :: Nil)
        val b: Array[Double] = Array(1, 3)
        val res = Elimination().gaussian_elimination(matrix, b, false)
        val x: Array[Double] = Substitution().backward_sub(res(0), res(1))
        assertEquals(x(0), 1.0)
        assertEquals(x(1), 0.0)
    }
  
}
