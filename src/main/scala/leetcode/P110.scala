package leetcode

object P110 {
  def main(args: Array[String]): Unit = {

  }

  case class TreeNode(value: Int, left: TreeNode = null, right: TreeNode = null)
  object Solution {
    def isBalanced(root: TreeNode): Boolean = {
      val (_, res) = isBalancedWithHeight(root)
      res
    }

    def isBalancedWithHeight(root: TreeNode): (Int, Boolean) = {
      if (root == null) (0, true)

      else {
        Int.MaxValue
        lazy val (leftHeight, isBalancedLeft) = isBalancedWithHeight(root.left)
        lazy val (rightHeight, isBalancedRight) = isBalancedWithHeight(root.right)
        if (!isBalancedLeft || !isBalancedRight) (0, false)
        else if (math.abs(leftHeight - rightHeight) > 1) (0, false)
        else (math.max(leftHeight, rightHeight) + 1, true)
      }
    }
  }
}
