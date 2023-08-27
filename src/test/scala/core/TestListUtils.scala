package core;
import core.ListUtils.ListOps

class TestListUtils extends munit.FunSuite {
    test("sum of elements") {
        val list: List[Int] = 1 :: 2 :: 3 :: Nil
        assertEquals(list.sumOfElements(), 6)
    }
}
