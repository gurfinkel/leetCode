
Given an encoded string, return its decoded string.

The encoding rule is:  `k[encoded_string]`, where the  _encoded_string_  inside the square brackets is being repeated exactly  _k_  times. Note that  _k_  is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers,  _k_. For example, there won't be input like  `3a`  or  `2[4]`.

**Examples:**

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".