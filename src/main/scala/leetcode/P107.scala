package leetcode

object P107 {
  def main(args: Array[String]): Unit = {
    val root: TreeNode = null
    val res = Solution.levelOrderBottom(root)
    println(res)
  }

  case class TreeNode(value: Int, left: TreeNode = null, right: TreeNode = null)

  object Solution {
    type Level = List[TreeNode]

    def levelOrderBottom(root: TreeNode): List[List[Int]] = {
      if (root == null) List()
      else {
        val levels = getAllLevels(List(root)).reverse.filter(_.nonEmpty)
        levels.map(_.map(_.value))
      }
    }

    def getAllLevels(level: Level): List[Level] = {
      if (level.isEmpty) List()
      else level :: getAllLevels(nextLevel(level))
    }

    def nextLevel(level: Level): Level = {
      if (level.isEmpty) List()
      else level.flatMap(node => List(node.left, node.right).filter(_ != null))
    }
  }

}
