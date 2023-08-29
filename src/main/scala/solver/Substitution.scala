package solver
import core.Matrix
import scala.reflect.ClassTag

class Substitution {
  
    def backward_sub(A: Matrix[Double], b: Array[Double]) : Array[Double] = {
        val (n, m): (Int, Int) = A.getSize()
        if (n != m) throw new IllegalArgumentException("matrix must be square")

        var x: Array[Double] = new Array[Double](n)

        for (k <- 0 until n) {
            var sum: Double = 0.0
            for (i <- 0 until k - 1) {
                sum = sum + (x(i) * A.at(k, i)) 
            }
            val x_k: Double = (b(k) - sum) / A.at(k, k)  
            x(k) = x_k
        }
        return x;
    }
}
