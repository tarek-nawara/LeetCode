package leetcode

object P693 {
  object Solution {
    def hasAlternatingBits(n: Int): Boolean = {
      val bs = n.toBinaryString.toList
      checkAlternating(bs, bs.head == '1')
    }

    def checkAlternating(xs: List[Char], isOne: Boolean): Boolean = {
      if (xs.isEmpty) true
      else if (isOne) xs.head == '1' && checkAlternating(xs.tail, false)
      else xs.head == '0' && checkAlternating(xs.tail, true)
    }
  }
}
