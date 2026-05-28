# Binary Tree Notes — Core Concepts + Important Problems

# 1. What is a Binary Tree?

A Binary Tree is a data structure where each node has at most:

* one left child
* one right child

Structure:

```text
        Root
       /    \
    Left    Right
```

Java Structure:

```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
```

---

# 2. Important Terminology

| Term          | Meaning                        |
| ------------- | ------------------------------ |
| Root          | Top node                       |
| Leaf Node     | Node with no children          |
| Height        | Longest path from node to leaf |
| Depth         | Distance from root             |
| Subtree       | Tree inside another tree       |
| Balanced Tree | Height difference ≤ 1          |

Balanced condition:

|h(left) - h(right)| ≤ 1

---

# 3. DFS Traversals

Traversal means visiting all nodes.

---

## A. Preorder Traversal

Order:

```text
Root -> Left -> Right
```

Code:

```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        preorder(root, result);

        return result;
    }

    private void preorder(TreeNode root, List<Integer> result) {

        if (root == null) return;

        result.add(root.val);

        preorder(root.left, result);

        preorder(root.right, result);
    }
}
```

Use Cases:

* Copy tree
* Serialization
* Expression trees

---

## B. Inorder Traversal

Order:

```text
Left -> Root -> Right
```

Code:

```java
class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        inorder(result, root);

        return result;
    }

    private void inorder(List<Integer> result, TreeNode root) {

        if (root == null) return;

        inorder(result, root.left);

        result.add(root.val);

        inorder(result, root.right);
    }
}
```

IMPORTANT:

* In BST, inorder traversal gives sorted order.

---

## C. Postorder Traversal

Order:

```text
Left -> Right -> Root
```

Code:

```java
class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        postorder(root, result);

        return result;
    }

    private void postorder(TreeNode root, List<Integer> result) {

        if (root == null) return;

        postorder(root.left, result);

        postorder(root.right, result);

        result.add(root.val);
    }
}
```

Use Cases:

* Delete tree
* Bottom-up calculations

---

# 4. Binary Tree Paths

Problem:
Return all root-to-leaf paths.

Example:

```text
1->2->5
1->3
```

Code:

```java
class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        if (root == null) return result;

        dfs(root, "", result);

        return result;
    }

    private void dfs(TreeNode root, String path, List<String> result) {

        if (root == null) return;

        // leaf node
        if (root.left == null && root.right == null) {

            result.add(path + root.val);

            return;
        }

        dfs(root.left, path + root.val + "->", result);

        dfs(root.right, path + root.val + "->", result);
    }
}
```

Pattern:

* DFS
* Path accumulation

---

# 5. Balanced Binary Tree

Definition:
For every node:

```text
|leftHeight - rightHeight| <= 1
```

Optimized O(n) Solution:

```java
class Solution {

    public boolean isBalanced(TreeNode root) {

        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode root) {

        if (root == null) return 0;

        int leftHeight = dfsHeight(root.left);

        if (leftHeight == -1) return -1;

        int rightHeight = dfsHeight(root.right);

        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) {

            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
```

IMPORTANT IDEA:

* Height calculation + balance checking together

This avoids:

```text
O(n²)
```

and becomes:

```text
O(n)
```

---

# 6. Invert Binary Tree

Definition:
Swap left and right child of every node.

Before:

```text
    4
   / \
  2   7
```

After:

```text
    4
   / \
  7   2
```

Code:

```java
class Solution {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) return root;

        TreeNode temp = root.left;

        root.left = root.right;

        root.right = temp;

        invertTree(root.left);

        invertTree(root.right);

        return root;
    }
}
```

Pattern:

* DFS
* Swap
* Recurse

---

# 7. Most Important Binary Tree Patterns

| Pattern            | Used In                   |
| ------------------ | ------------------------- |
| DFS recursion      | Almost every tree problem |
| Height calculation | Balanced tree, diameter   |
| Path tracking      | Root-to-leaf problems     |
| Divide and conquer | Tree DP                   |
| BFS / Queue        | Level order traversal     |
| Backtracking       | Path sum problems         |

---

# 8. Most Important Binary Tree Questions

# Beginner

| Problem                      |
| ---------------------------- |
| Maximum Depth of Binary Tree |
| Same Tree                    |
| Symmetric Tree               |
| Invert Binary Tree           |
| Balanced Binary Tree         |
| Binary Tree Paths            |

---

# Traversal Based

| Problem                         |
| ------------------------------- |
| Binary Tree Preorder Traversal  |
| Binary Tree Inorder Traversal   |
| Binary Tree Postorder Traversal |
| Level Order Traversal           |
| Zigzag Traversal                |

---

# Medium Level

| Problem                        |
| ------------------------------ |
| Diameter of Binary Tree        |
| Path Sum                       |
| Path Sum II                    |
| Lowest Common Ancestor         |
| Validate BST                   |
| Kth Smallest in BST            |
| Construct Tree from Traversals |

---

# Advanced

| Problem                               |
| ------------------------------------- |
| Binary Tree Maximum Path Sum          |
| Serialize and Deserialize Binary Tree |
| House Robber III                      |
| Flatten Binary Tree                   |
| Vertical Order Traversal              |

---

# 9. Important Tree Recursion Template

MOST IMPORTANT TEMPLATE:

```java
private void dfs(TreeNode root){

    if(root == null) return;

    // work

    dfs(root.left);

    dfs(root.right);
}
```

---

# 10. Time Complexities

| Operation           | Complexity           |
| ------------------- | -------------------- |
| DFS Traversal       | O(n)                 |
| BFS Traversal       | O(n)                 |
| Height Calculation  | O(n)                 |
| Balanced Tree Check | O(n) optimized       |
| Space Complexity    | O(h) recursion stack |

Where:

```text
h = height of tree
```

---

# 11. Interview Tips

1. Tree problems are mostly recursion problems.
2. Always identify:

   * base case
   * work at node
   * recursive calls
3. Dry run small trees manually.
4. Learn preorder, inorder, postorder deeply.
5. For optimization:

   * combine computations in one DFS.

---

# 12. Ultimate Goal

If you master:

* traversals
* height recursion
* path problems
* BST basics
* BFS

then 70–80% of interview tree questions become manageable.
