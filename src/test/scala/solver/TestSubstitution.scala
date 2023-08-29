package solver
import core.Matrix;

class TestSubstitution extends munit.FunSuite {
    test("backward substitution") {
        val matrix: Matrix[Double] = Matrix[Double](2, 2)
        matrix.init(1.0 :: 2.0 :: 3.0 :: 5.0 :: Nil)
        val b: Array[Double] = Array(1, 3)
        val res = Elimination().gaussian_elimination(matrix, b, false)
        val x: Array[Double] = Substitution().backward_sub(res(0), res(1))
        assertEquals(x(0), 1.0)
        assertEquals(x(1), 0.0)
    }

    test("backward substitution II") {
        val matrix: Matrix[Double] = Matrix[Double](3, 3)
        matrix.init(2.0 :: 2.0 :: 3.0 :: 1.0 :: 2.0 :: 2.0 :: 1.0 :: 1.0 :: 4.0 :: Nil)
        val b: Array[Double] = Array(75, 50, 50)
        val res = Elimination().gaussian_elimination(matrix, b, false)
        val x: Array[Double] = Substitution().backward_sub(res(0), res(1))
        assertEquals(x.toList, Array[Double](20,10,5).toList)
    }

    test("forward substitution") {
        val matrix: Matrix[Double] = Matrix[Double](2, 2)
        matrix.init(1.0 :: 0.0 :: 2.0 :: 3.0 :: Nil)
        val b: Array[Double] = Array(4, 8)
        val x: Array[Double] = Substitution().forward_sub(matrix, b)
        assertEquals(x(0), 4.0)
        assertEquals(x(1), 0.0)
    }  
}

/*

1 0  4
2 3  8

2*4 + 3x = 8
0


*/
