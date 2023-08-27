package core;
import scala.reflect.ClassTag

class Matrix[@specialized T:ClassTag](val rows: Int, val cols: Int)(implicit num: Numeric[T]) {

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
     * alias for update
     */
    def set(row: Int, col: Int, value: T): Unit = update(row, col, value)

    /**
    * initializes all values in matrix to given value
    */
    def init(value: T): Unit = {
        for (i <- 0 until rows; j <- 0 until cols) matrix(i)(j) = value
    }

    def init(list: List[T]): Unit = {
        for (i <- 0 until rows; j <- 0 until cols) matrix(i)(j) = list(i*cols + j)
    }

    /**
    * returns size of matrix (rows, cols)
    */
    def getSize(): (Int, Int) = (rows,cols)


    //------------------------------------//
    //         Matrix Operations         //
    //-----------------------------------//

    /**
      * adds matrix other to this matrix (overriding this matrix)
      *
      * @param other matrix to add. must be same size as this matrix
      * @throws IllegalArgumentException if other is not same size as this matrix
      * @return this matrix with added other
      */
    def add(other: Matrix[T]): Matrix[T] = {
        if (rows != other.rows || cols != other.cols) throw new IllegalArgumentException("matrices must be same size")
        for (i <- 0 until rows; j <- 0 until cols) matrix(i)(j) = num.plus(matrix(i)(j), other.at(i,j))
        return this
    }

    /**
      * subtracts matrix other from this matrix (overriding this matrix)
      *
      * @param other matrix to subtract. must be same size as this matrix
      * @throws IllegalArgumentException if other is not same size as this matrix
      * @return this matrix with other subtracted
      */
    def sub(other: Matrix[T]): Matrix[T] = {
        if (rows != other.rows || cols != other.cols) throw new IllegalArgumentException("matrices must be same size")
        return this.add(other.cpy().mul(num.fromInt(-1)))
    }

    /**
      * multiplies this matrix by scalar (overriding this matrix)
      *
      * @param scalar scalar to multiply by
      * @return this matrix with scalar multiplied
      */
    def mul(scalar: T): Matrix[T] = {
        for (i <- 0 until rows; j <- 0 until cols) matrix(i)(j) = num.times(matrix(i)(j), scalar)
        return this
    }

    /**
      * multiplies this matrix by other matrix (not overriding this matrix)
      *
      * @param other matrix to multiply by. cols of this matrix must equal rows of other matrix
      * @return this matrix with other multiplied
      */
    def mul(other: Matrix[T]): Matrix[T] = {
        if (cols != other.rows) throw new IllegalArgumentException("cols of this matrix must equal rows of other matrix")
        val result: Matrix[T] = new Matrix[T](rows, other.cols)
        for (i <- 0 until rows; j <- 0 until other.cols) {
            var sum: T = num.zero
            for (k <- 0 until cols) sum = num.plus(sum, num.times(matrix(i)(k), other.at(k,j)))
            result.set(i,j,sum)
        }
        return result
    }

    def transpose(): Matrix[T] = {
        val result: Matrix[T] = new Matrix[T](cols, rows)
        for (i <- 0 until rows; j <- 0 until cols) result.set(j,i, matrix(i)(j))
        return result
    }

    def t(): Matrix[T] = transpose()

    override def equals(other: Any): Boolean = {
        val otherMatrix: Matrix[T] = other.asInstanceOf[Matrix[T]]
        if (rows != otherMatrix.rows || cols != otherMatrix.cols) return false
        for (i <- 0 until rows; j <- 0 until cols) {
            if (matrix(i)(j) != otherMatrix.at(i,j)) return false
        }
        return true
    }

    /**
      * returns copy of this matrix
      *
      * @return copy of this matrix
      */
    def cpy(): Matrix[T] = {
        val copy: Matrix[T] = new Matrix[T](rows, cols)
        for (i <- 0 until rows; j <- 0 until cols) copy.set(i,j, matrix(i)(j))
        return copy
    }

    def flatten(): List[T] = {
        var l: List[T] = List[T]()
        for (i <- 0 until rows; j <- 0 until cols) l = l ::: List[T](matrix(i)(j))
        return l
    }

    override def toString(): String = {
        var str: String = ""
        for (i <- 0 until rows) {
            for (j <- 0 until cols) {
                str += matrix(i)(j).toString() + " "
            }
            str += "\n"
        }
        return str
    }   
}