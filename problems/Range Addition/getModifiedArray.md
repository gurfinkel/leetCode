
You are given an integer  `length`  and an array  `updates`  where  `updates[i] = [startIdxi, endIdxi, inci]`.

You have an array  `arr`  of length  `length`  with all zeros, and you have some operation to apply on  `arr`. In the  `ith`  operation, you should increment all the elements  `arr[startIdxi], arr[startIdxi  + 1], ..., arr[endIdxi]`  by  `inci`.

Return  `arr`  _after applying all the_  `updates`.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/03/27/rangeadd-grid.jpg)

**Input:** length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
**Output:** [-2,0,3,5,3]

**Example 2:**

**Input:** length = 10, updates = [[2,4,6],[5,6,8],[1,9,-4]]
**Output:** [0,-4,2,2,2,4,4,-4,-4,-4]

**Constraints:**

-   `1 <= length <= 10^5`
-   `0 <= updates.length <= 10^4`
-   `0 <= startIdxi  <= endIdxi  < length`
-   `-1000 <= inci  <= 1000`