package algorithm.leetcode;

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 限制：0 <= 节点个数 <= 5000
 *
 * @author marcus
 * @date 2020-12-23
 */
public class BuildTree {

	// 递归法
	public static TreeNode solution1(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
			return null;
		}
		// 前序遍历第一个结果为根节点
		TreeNode node = new TreeNode(preorder[0]);
		buildChild(node, preorder, 1, inorder, 0, inorder.length - 1);
		return node;
	}

	public static void buildChild(TreeNode node, int[] preorder, int preorderStartIndex, int[] inorder, int inorderStartIndex, int inorderEndIndex) {
		for (int i = inorderStartIndex; i <= inorderEndIndex; i++) {
			// 当找到当前树的根节点的时候, 其左边的为坐子树节点，其右边为右子树节点
			if (inorder[i] == node.val) {
				// 判断左子树节点个数大于0，则递归处理左子树
				int leftNum = i - inorderStartIndex;
				if (leftNum > 0) {
					// 找到左子树的根节点，左子树根节点为根节点后的第一个节点即preorderStartIndex
					node.left = new TreeNode(preorder[preorderStartIndex]);
					// 左子树节点个数大于1则左子树还有节点需要处理
					if (leftNum > 1) {
						buildChild(node.left, preorder, preorderStartIndex + 1, inorder, inorderStartIndex, i - 1);
					}
				}
				// 判断右子树节点个数大于0，则递归处理右子树
				int rightNum = inorderEndIndex - i;
				if (rightNum > 0) {
					// 找到右子树的根节点，右子树根节点为根节点+所有左子树后的第一个节点
					node.right = new TreeNode(preorder[preorderStartIndex + leftNum]);
					if(rightNum > 1) {
						buildChild(node.right, preorder, preorderStartIndex + leftNum + 1, inorder, i + 1, inorderEndIndex);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] preorder = new int[]{3, 9, 20, 15, 7};
		int[] inorder = new int[]{9, 3, 15, 20, 7};
		TreeNode node = solution1(preorder, inorder);
		System.out.println(node);
	}
}
