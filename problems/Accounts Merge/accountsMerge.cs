public class Solution {
    public IList<IList<string>> AccountsMerge(IList<IList<string>> accounts) {
        var emailToNameMap = new Dictionary<string, string>();
        var parentMap  = new Dictionary<string, string>();
        foreach(var account in accounts)
        {
            for(int i = 1; i < account.Count; i++)
            {
                if(!emailToNameMap.ContainsKey(account[i]))
                    emailToNameMap[account[i]] = account[0];

                string par1 = GetParent(parentMap, account[1]), par2 = GetParent(parentMap, account[i]);
                if(par1 != par2)
                    parentMap[par1] = par2;
            }
        }

        var resultMap = new Dictionary<string, HashSet<string>>();
        foreach(var email in parentMap.Keys.ToList())
        {
            var par = GetParent(parentMap, email);
            if(!resultMap.ContainsKey(par))
                resultMap[par] = new HashSet<string>();
            resultMap[par].Add(email);
        }

        var result = new List<IList<string>>();

        foreach(var kvp in resultMap)
        {
            var list = new List<string>();
            foreach(var elem in kvp.Value)
                list.Add(elem);
            list.Sort(string.CompareOrdinal);
            list.Insert(0, emailToNameMap[kvp.Key]);
            result.Add(list);
        }

        return result;
    }

    private string GetParent(Dictionary<string, string> parentMap, string str)
    {
        if(!parentMap.ContainsKey(str)) parentMap[str] = str;
        if(parentMap[str] != str)
            parentMap[str] = GetParent(parentMap, parentMap[str]);
        return parentMap[str];
    }
}
