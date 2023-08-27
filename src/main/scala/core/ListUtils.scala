package core;

object ListUtils {
    implicit class ListOps[@specialized T](list: List[T])(implicit num: Numeric[T]) {
        def sumOfElements(): T = {
            return list.foldLeft(num.zero)((x, y) => num.plus(x, y))
        }
    }
}
