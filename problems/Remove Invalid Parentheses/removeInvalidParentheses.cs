public class Solution {
    public IList<string> RemoveInvalidParentheses(string s) {
        helper(s,0,0,0,new List<char>());

        int max=-1;

        foreach(var val in ret)
            max=Math.Max(max, val.Length);

        IList<string> ans = new List<string>();

        foreach(var val in ret)
            if(val.Length==max&&!ans.Contains(val))
                ans.Add(val);

        return ans;
    }

    IList<string> ret=new List<string>();

    private void helper(string s, int pos,int l,int r,IList<char> cur) {
        if(pos==s.Length) {
            if(l==r) {
                ret.Add(new string(cur.ToArray()));
            }
            return;
        }
        if(r>l)
            return;
        char ch=s[pos];
        if(ch=='(') {
            cur.Add(ch);
            helper(s,pos+1,l+1,r,cur);
            cur.RemoveAt(cur.Count-1);
            helper(s,pos+1,l,r,cur);
        } else if(ch==')') {
            cur.Add(ch);
            helper(s,pos+1,l,r+1,cur);
            cur.RemoveAt(cur.Count-1);
            helper(s,pos+1,l,r,cur);
        } else {
            cur.Add(ch);
            helper(s,pos+1,l,r,cur);
            cur.RemoveAt(cur.Count-1);
        }
    }
}
