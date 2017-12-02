package leetcode

object P111 {
  case class TreeNode(value: Int, left: TreeNode = null, right: TreeNode = null)

  object Solution {
    def minDepth(root: TreeNode): Int = {
      if (root == null) 0
      else if (root.left == null && root.right == null) 1
      else if (root.left == null) 1 + minDepth(root.right)
      else if (root.right == null) 1 + minDepth(root.left)
      else 1 + math.min(minDepth(root.left), minDepth(root.right))
    }
  }
}
