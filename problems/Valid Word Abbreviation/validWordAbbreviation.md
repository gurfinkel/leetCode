
A string can be  **abbreviated**  by replacing any number of  **non-adjacent**  substrings with their lengths. For example, a string such as  `"substitution"`  could be abbreviated as (but not limited to):

-   `"s10n"`  (`"s  ubstitutio  n"`)
-   `"sub4u4"`  (`"sub  stit  u  tion"`)
-   `"12"`  (`"substitution"`)
-   `"su3i1u2on"`  (`"su  bst  i  t  u  ti  on"`)
-   `"substitution"`  (no substrings replaced)

Note that  `"s55n"`  (`"s  ubsti  tutio  n"`) is not a valid abbreviation of  `"substitution"`  because the replaced substrings are adjacent.

Given a string  `s`  and an abbreviation  `abbr`, return  _whether the string matches with the given abbreviation_.

**Example 1:**

**Input:** word = "internationalization", abbr = "i12iz4n"
**Output:** true

**Example 2:**

**Input:** word = "apple", abbr = "a2e"
**Output:** false

**Constraints:**

-   `1 <= word.length, abbr.length <= 20`
-   `word`  consists of only lowercase English letters.
-   `abbr`  consists of lowercase English letters and digits.