object Solution {
  def convert(s: String, numRows: Int): String = {
    if(numRows > s.length || numRows <= 1) s
    else {
      val zigzag = new Array[Char](s.length)
      var count = 0
      val interval = 2 * numRows - 2
      for (i <- 0 until numRows) {
        val step = interval - 2 * i
        for (j <- i until s.length by interval) {
          zigzag(count) = s(j)
          count += 1
          if (step > 0 && step < interval && j + step < s.length) {
            zigzag(count) = s(j + step)
            count += 1
          }
        }
      }
      zigzag.mkString
    }
  }
}
