package leetcode

object P104 {

  case class TreeNode(value: Int, left: TreeNode = null, right: TreeNode = null)
  object Solution {
    def maxDepth(root: TreeNode): Int = {
      if (root == null) 0
      else 1 + math.max(maxDepth(root.left), maxDepth(root.right))
    }
  }
}
