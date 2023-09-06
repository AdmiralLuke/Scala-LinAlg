package solver

import core.Matrix

class TestSolver extends munit.FunSuite {

    test("cholesky solver") {
        val A: Matrix[Double] = new Matrix[Double](4,4)
        A.init(List[Double](9, 3, -6, 12, 3, 26, -7, -11, -6, -7, 9, 7, 12, -11, 7, 65))
        val b: Array[Double] = Array[Double](72, 34, 22, 326)

        val L: Matrix[Double] = Elimination().cholesky_elimination(A)
        val x: Array[Double] = Solver().cholesky_solver(L, b)

        assertEquals(x(0), 2.0)
        assertEquals(x(1), 4.0)
        assertEquals(x(2), 3.0)
        assertEquals(x(3), 5.0)
    }
  
}
