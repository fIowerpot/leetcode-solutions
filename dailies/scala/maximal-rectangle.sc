object Solution {
  def previousSmaller(arr: Array[Int]): Array[Int] = {
    val n = arr.length
    val ans = Array.fill[Int](n)(-1)
    val s = scala.collection.mutable.Stack[Int]()

    for (i <- 0 until n) {
      while (s.nonEmpty && arr(s.top) >= arr(i)) {
        s.pop()
      }

      if (s.isEmpty) ans(i) = -1
      else ans(i) = s.top

      s.push(i)
    }

    ans
  }

  def nextSmaller(arr: Array[Int]): Array[Int] = {
    val n = arr.length
    val ans = Array.fill[Int](n)(n)
    val s = scala.collection.mutable.Stack[Int]()

    for (i <- n - 1 to 0 by -1) {
      while (s.nonEmpty && arr(s.top) >= arr(i)) {
        s.pop()
      }

      if (s.isEmpty) ans(i) = n
      else ans(i) = s.top

      s.push(i)
    }

    ans
  }

  def maximalRectangle(mat: Array[Array[Char]]): Int = {
    val n = mat.length
    val m = mat(0).length
    val arr = Array.fill[Int](m)(0)
    var max = Int.MinValue

    for (i <- 0 until n) {
      for (j <- 0 until m) {
        if (mat(i)(j) == '1') arr(j) = arr(j) + 1
        else arr(j) = 0
      }

      val prev = previousSmaller(arr)
      val next = nextSmaller(arr)

      for (j <- 0 until m) {
        val area = (next(j) - prev(j) - 1) * arr(j)
        max = max max area
      }
    }

    max
  }
}
