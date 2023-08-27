class Matrix[T](val rows: Int, val cols: Int) {
    val rows: Int = rows
    val cols: Int = cols
    val matrix: Array[Array[T]] = Array.ofDim[Double](rows, cols)

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
        for (i <- 0 until rows; j <- 0 unitl cols) matrix(i)(j) = value
    }

    /**
    * returns size of matrix (rows, cols)
    */
    def getSize(): (Int, Int) = (rows,cols)

}