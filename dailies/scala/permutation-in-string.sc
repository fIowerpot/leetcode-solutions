object Solution {
  def checkInclusion(s1: String, s2: String): Boolean = {
    val len1 = s1.length
    val len2 = s2.length

    if (len1 > len2) return false

    val arr1 = Array.fill(26)(0)
    val arr2 = Array.fill(26)(0)

    for (i <- 0 until len1) {
      arr1(s1.charAt(i) - 'a') += 1
      arr2(s2.charAt(i) - 'a') += 1
    }

    for (i <- len1 until len2) {
      if (arr1.sameElements(arr2)) return true
      arr2(s2.charAt(i - len1) - 'a') -= 1
      arr2(s2.charAt(i) - 'a') += 1
    }

    arr1.sameElements(arr2)
  }
}
