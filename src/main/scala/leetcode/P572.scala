package leetcode

object P572 {
  def main(args: Array[String]): Unit = {
    val root = TreeNode(3, TreeNode(4, TreeNode(1), TreeNode(2)), TreeNode(5))
    val t = TreeNode(4, TreeNode(1), TreeNode(2))
    val res = Solution.isSubtree(root, t)
    println(res)
  }

  case class TreeNode(value: Int, left: TreeNode = null, right: TreeNode = null)
  object Solution {
    def isSubtree(s: TreeNode, t: TreeNode): Boolean = {
      if (s == null && t == null) true
      else if (s == null) false
      else areEqual(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t)
    }

    def areEqual(a: TreeNode, b: TreeNode): Boolean = {
      if (a == null && b == null) true
      else if (a == null) false
      else if (b == null) false
      else if (a.value != b.value) false
      else areEqual(a.left, b.left) && areEqual(a.right, b.right)
    }
  }
}
