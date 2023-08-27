package solver
import core.Matrix


class Elimination() {
  
    def gaussian_elimination(A: Matrix[Double], b: Array[Double], use_pivoting: Boolean = true): (Matrix[Double], Array[Double]) = {
        val (n, m): (Int, Int) = A.getSize()
        if (n != m) throw new IllegalArgumentException("matrix must be square")
        if (n != b.length) throw new IllegalArgumentException("matrix and vector must have same size")

        for (k <- 0 until n) {
            if (use_pivoting) {
                var max: Double = A.at(k,k)
                var max_index: Int = k
                for (i <- k+1 until n) {
                    if (A.at(i,k).compareTo(max) > 0) {
                        max = A.at(i,k)
                        max_index = i
                    }
                }
                if (max_index != k) {
                    for (j <- k until n) {
                        val temp: Double = A.at(k,j)
                        A.set(k,j, A.at(max_index,j))
                        A.set(max_index,j, temp)
                    }
                    val temp: Double = b(k)
                    b(k) = b(max_index)
                    b(max_index) = temp
                }
            }
            for (i <- k+1 until n) {
                val factor: Double = A.at(i,k) / (A.at(k,k))
                b(i) = b(i) - factor * b(k)
                for (j <- k until n) {
                    A.set(i,j, A.at(i,j) - factor * A.at(k,j))
                }
            }
        }

        return (A, b)
    }
}

