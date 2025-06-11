public class BlueQ2 {
    /**
     * Returns which has a higher range: a given linked list or a given tree.
     * The range of a data structure is the difference between its highest
     * value and its lowest value.
     * 
     * Returns "list" if the list has a higher range and "tree" if the tree has
     * a higher range. You can assume there will not be a tie, and neither head
     * nor root will be null.
     * 
     * Example:
     *   List:
     *      7 -> 8 -> -2 -> 9 -> 21
     *   Tree:
     *            12
     *          /    \
     *         6      18
     *        / \    /  
     *       4   8  16  
     *   Expected Answer: "list"
     * 
     * Explanation:
     *   The largest number in the list is 21 and -2 is the smallest.
     *   Thus the range of the list is 21 - -2 = 23
     *   The largest number in the tree is 18, and 4 is the smallest.
     *   Thus the range of the tree is 18 - 4 = 14
     *   23 is bigger than 14, so the list has the bigger range.
     *    
     * 
     * @param head the head of the list
     * @param root the root of the tree
     * @return "list" if the list has a bigger range, "tree" otherwise
     */
    public static String biggerRange(ListNode head, TreeNode root) {
        int listMin = head.data, listMax = head.data;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.data < listMin) listMin = curr.data;
            if (curr.data > listMax) listMax = curr.data;
            curr = curr.next;
        }
        int listRange = listMax - listMin; 
        int treeMin = treeMin(root);
        int treeMax = treeMax(root);
        int treeRange = treeMax - treeMin;

        return listRange > treeRange ? "list" : "tree";
    }

    private static int treeMin(TreeNode node) {
        if (node == null) return Integer.MAX_VALUE;
        int leftMin = treeMin(node.left);
        int rightMin = treeMin(node.right);
        int min = node.data;
        min = Math.min(min, leftMin);
        min = Math.min(min, rightMin);
        return min;
    }

    private static int treeMax(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;
        int leftMax = treeMax(node.left);
        int rightMax = treeMax(node.right);
        int max = node.data;
        max = Math.max(max, leftMax);
        max = Math.max(max, rightMax);
        return max;
    }
}



    

   



// int listMinimum = head.data;
// int listMaximum = head.data;

// ListNode curr = head.next;
// while (curr != null) {
//     if (curr.data < listMinimum) listMinimum = curr.data;
//     if (curr.data > listMaximum) listMaximum = curr.data;
//     curr = curr.next;
// }
// int listRange = listMaximum - listMinimum;

// int[] treeMinMax = biggerRange(root);
// int treeRange = treeMinMax[1] - treeMinMax[0];
// return listRange > treeRange ? "list" : "tree";
// }