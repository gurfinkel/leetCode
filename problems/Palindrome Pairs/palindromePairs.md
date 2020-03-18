
Given a list of  **unique**  words, find all pairs of  **_distinct_**  indices  `(i, j)`  in the given list, so that the concatenation of the two words, i.e.  `words[i] + words[j]`  is a palindrome.

**Example 1:**

**Input:** ["abcd","dcba","lls","s","sssll"]
**Output:** [[0,1],[1,0],[3,2],[2,4]] 
**E****xplanation:** The palindromes are `["dcbaabcd","abcddcba","slls","llssssll"]`

**Example 2:**

**Input:** ["bat","tab","cat"]
**Output:** [[0,1],[1,0]] **E****xplanation:** The palindromes are `["battab","tabbat"]`