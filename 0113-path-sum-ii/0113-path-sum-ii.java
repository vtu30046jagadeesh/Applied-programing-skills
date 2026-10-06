import java.util.*;
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return result;
    }
    private void dfs(TreeNode node, int remaining) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.left == null && node.right == null) {
            if (remaining == node.val) {
                result.add(new ArrayList<>(path));
            }
        } else {
            dfs(node.left, remaining - node.val);
            dfs(node.right, remaining - node.val);
        }
        path.remove(path.size() - 1);
    }
}