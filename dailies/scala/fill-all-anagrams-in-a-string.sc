import scala.collection.mutable.ArrayBuffer

object Solution {
  def findAnagrams(s: String, p: String): List[Int] = {
    val hash_p = new Array[Int](26)
    val hash_s = new Array[Int](26)
    val result = ArrayBuffer[Int]()
    if (p.length > s.length) {
      return result.toList
    }
    for (i <- 0 until p.length) {
      hash_p(p(i) - 'a') += 1
      hash_s(s(i) - 'a') += 1
    }
    var count = 0
    for (i <- 0 until 26) {
      if (hash_p(i) == hash_s(i)) {
        count += 1
      }
    }
    var i = 0
    var j = p.length
    while (j < s.length) {
      if (count == 26) {
        result += i
      }
      hash_s(s(i) - 'a') -= 1
      if (hash_p(s(i) - 'a') == hash_s(s(i) - 'a')) {
        count += 1
      } else if (hash_p(s(i) - 'a') == hash_s(s(i) - 'a') + 1) {
        count -= 1
      }
      hash_s(s(j) - 'a') += 1
      if (hash_p(s(j) - 'a') == hash_s(s(j) - 'a')) {
        count += 1
      } else if (hash_p(s(j) - 'a') == hash_s(s(j) - 'a') - 1) {
        count -= 1
      }
      i += 1
      j += 1
    }
    if (count == 26) {
      result += i
    }
    result.toList
  }
}
