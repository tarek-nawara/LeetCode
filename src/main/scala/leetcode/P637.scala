package leetcode

import java.util

object P637 {
  def main(args: Array[String]): Unit = {
    val root = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))
    val res = Solution.averageOfLevels(root)
    println(util.Arrays.toString(res))
  }

  case class TreeNode(value: Int, left: TreeNode = null, right: TreeNode = null)

  object Solution {
    type Level = List[TreeNode]

    def averageOfLevels(root: TreeNode): Array[Double] = {
      val allLevels = getAllLevels(List(root))
      val avg = for {
        level <- allLevels
        values = level.map(_.value * 1.0)
        sum = values.sum
        count = values.size
        if count > 0
      } yield 1.0 * sum / count
      avg.toArray
    }

    def getAllLevels(level: Level): List[Level] = {
      if (level.isEmpty) List(level)
      else level :: getAllLevels(nextLevel(level))
    }

    def nextLevel(level: Level): Level = {
      if (level.isEmpty) List()
      else level.flatMap(node => List(node.left, node.right).filter(_ != null))
    }
  }

}
