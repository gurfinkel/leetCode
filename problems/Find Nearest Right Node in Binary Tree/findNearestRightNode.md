
Given the  `root`  of a binary tree and a node  `u`  in the tree, return  _the  **nearest**  node on the  **same level**  that is to the  **right**  of_  `u`_, or return_  `null`  _if_ `u`  _is the rightmost node in its level_.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/09/24/p3.png)

**Input:** root = [1,2,3,null,4,5,6], u = 4
**Output:** 5
**Explanation:** The nearest node on the same level to the right of node 4 is node 5.

**Example 2:**

**![](https://assets.leetcode.com/uploads/2020/09/23/p2.png)**

**Input:** root = [3,null,4,2], u = 2
**Output:** null
**Explanation:** There are no nodes to the right of 2.

**Example 3:**

**Input:** root = [1], u = 1
**Output:** null

**Example 4:**

**Input:** root = [3,4,2,null,null,null,1], u = 4
**Output:** 2

**Constraints:**

-   The number of nodes in the tree is in the range  `[1, 10^5]`.
-   `1 <= Node.val <= 10^5`
-   All values in the tree are  **distinct**.
-   `u`  is a node in the binary tree rooted at  `root`.