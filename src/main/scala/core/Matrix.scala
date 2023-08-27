import scala.reflect.ClassTag

class Matrix[T:ClassTag](val rows: Int, val cols: Int) {
    if (rows < 0 || cols < 0) throw new IllegalArgumentException("rows and cols must be positive")

    val matrix: Array[Array[T]] = Array.ofDim[T](rows, cols)

    /**
    * returns value at given index
    */
    def at(row: Int, col: Int): T = matrix(row)(col)

    /**
    * udates value at given index
    */
    def update(row: Int, col: Int, value: T): Unit = matrix(row)(col) = value 

    /**
    * initializes all values in matrix to given value
    */
    def init(value: T): Unit = {
        for (i <- 0 until rows; j <- 0 until cols) matrix(i)(j) = value
    }

    /**
    * returns size of matrix (rows, cols)
    */
    def getSize(): (Int, Int) = (rows,cols)

}