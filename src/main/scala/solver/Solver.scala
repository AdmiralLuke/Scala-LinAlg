package solver

import core.Matrix

class Solver() {
    def cholesky_solver(L: Matrix[Double], b: Array[Double]): Array[Double] = {
        val (n, m): (Int, Int) = L.getSize()
        if (n != m) throw new IllegalArgumentException("matrix must be square")
        
        val y: Array[Double] = Substitution().forward_sub(L, b)
        val x: Array[Double] = Substitution().backward_sub(L.transpose(), y)
        return x
    } 
}