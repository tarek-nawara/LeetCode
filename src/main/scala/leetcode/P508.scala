package leetcode

import scala.collection.mutable

object P508 {
  def main(args: Array[String]): Unit = {
    val root = TreeNode(1)
    val res = Solution.findFrequentTreeSum(root)
    println(res.toList)
  }

  case class TreeNode(value: Int, left: TreeNode = null, right: TreeNode = null)

  object Solution {
    def findFrequentTreeSum(root: TreeNode): Array[Int] = {
      if (root == null) return Array()
      implicit val occur = new mutable.HashMap[Long, Int]().withDefaultValue(0)
      buildOccur(root)
      val maxOccur = occur.maxBy(_._2)._2
      occur.filter(_._2 == maxOccur).keys.map(_.asInstanceOf[Int]).toArray
    }

    def buildOccur(root: TreeNode)(implicit occur: mutable.Map[Long, Int]): Long = {
      if (root == null) 0
      else {
        val left = buildOccur(root.left)
        val right = buildOccur(root.right)
        val total = left + right + root.value
        occur(total) += 1
        total
      }
    }
  }

}
