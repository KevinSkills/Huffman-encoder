
public class TreeNode {
	String value = "";
	public static TreeNode treeTop;
	TreeNode left;
	TreeNode right;

	public TreeNode(String let) {
		this.value = let;
	}

	public TreeNode(String let, TreeNode l, TreeNode r) {
		this.value = let;
		this.right = r;
		this.left = l;
	}

}
