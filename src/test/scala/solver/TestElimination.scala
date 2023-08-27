package solver
import core.Matrix



class TestElimination extends munit.FunSuite {
    test("gaussian elimination") {
        val A: Matrix[Double] = new Matrix[Double](3,3)
        A.init(List[Double](1,2,3,4,5,6,7,8,9))
        val b: List[Double] = List[Double](1,2,3)
        val result : (Matrix[Double], Array[Double]) = Elimination().gaussian_elimination(A, b.toArray, false)
    
        /*
        [1, 2, 3]
        [0, -3, -6]
        [0, 0, 0] 

        = [1, -2, 0]

        */

        assertEquals(result(0).at(0,0), 1.0)
        assertEquals(result(0).at(0,1), 2.0)
        assertEquals(result(0).at(0,2), 3.0)
        assertEquals(result(0).at(1,0), 0.0)
        assertEquals(result(0).at(1,1), -3.0)
        assertEquals(result(0).at(1,2), -6.0)
        assertEquals(result(0).at(2,0), 0.0)
        assertEquals(result(0).at(2,1), 0.0)
        assertEquals(result(0).at(2,2), 0.0)
        assertEquals(result(1)(0), 1.0)
        assertEquals(result(1)(1), -2.0)
        assertEquals(result(1)(2), 0.0)


    }
  
}
