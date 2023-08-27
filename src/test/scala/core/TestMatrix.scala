class TestMatrix extends munit.FunSuite {
    test("init matrix with working sizess") {
        val matrix: Matrix[Int] = new Matrix[Int](2,2)
        val (rows, cols) = matrix.getSize()
        assertEquals(rows, 2, "matrix should have 2 rows but had " + rows)
        assertEquals(cols, 2)
    }

    test("init matrix with values") {
        val matrix: Matrix[Int] = new Matrix[Int](2,2)
        matrix.init(1)
        assertEquals(matrix.at(0,0), 1)
        assertEquals(matrix.at(0,1), 1)
        assertEquals(matrix.at(1,0), 1)
        assertEquals(matrix.at(1,1), 1)
    }

    test("update matrix") {
        val matrix: Matrix[Int] = new Matrix[Int](2,2)
        matrix.init(1)
        matrix.update(0,0,2)
        assertEquals(matrix.at(0,0), 2)
    }

    test("matrix with negative size") {
        try {
            val matrix: Matrix[Int] = new Matrix[Int](-1,-1)
            fail("should have thrown exception")
        } catch {
            assertEquals(_, new IllegalArgumentException("rows and cols must be positive"))
        }
    }

    test("matrix from list") {
        val matrix: Matrix[Int] = new Matrix[Int](2,2)
        matrix.init(1 :: 2 :: 3 :: 4 :: Nil)
        assertEquals(matrix.at(0,0), 1)
        assertEquals(matrix.at(0,1), 2)
        assertEquals(matrix.at(1,0), 3)
        assertEquals(matrix.at(1,1), 4)
    }

    test("matrix add") {
        val matrix: Matrix[Int] = new Matrix[Int](2,2)
        matrix.init(1 :: 2 :: 3 :: 4 :: Nil)
        val matrix2: Matrix[Int] = new Matrix[Int](2,2)
        matrix2.init(1 :: 2 :: 3 :: 4 :: Nil)
        matrix.add(matrix2)
        assertEquals(matrix.at(0,0), 2)
        assertEquals(matrix.at(0,1), 4)
        assertEquals(matrix.at(1,0), 6)
        assertEquals(matrix.at(1,1), 8)
    }

    test("matrix sub") {
        val matrix: Matrix[Int] = new Matrix[Int](2,2)
        matrix.init(1 :: 2 :: 3 :: 4 :: Nil)
        val matrix2: Matrix[Int] = new Matrix[Int](2,2)
        matrix2.init(1 :: 2 :: 3 :: 4 :: Nil)
        matrix.sub(matrix2)
        assertEquals(matrix.at(0,0), 0)
        assertEquals(matrix.at(0,1), 0)
        assertEquals(matrix.at(1,0), 0)
        assertEquals(matrix.at(1,1), 0)
    }

    test("matrix scalar mul") {
        val matrix: Matrix[Int] = new Matrix[Int](2,2)
        matrix.init(1 :: 2 :: 3 :: 4 :: Nil)
        matrix.mul(2)
        assertEquals(matrix.at(0,0), 2)
        assertEquals(matrix.at(0,1), 4)
        assertEquals(matrix.at(1,0), 6)
        assertEquals(matrix.at(1,1), 8)
    }
}