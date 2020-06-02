public class Solution {
    public IList<string> InvalidTransactions(string[] transactions) {
        var store = new Dictionary<string, List<string>>();
        var result = new HashSet<string>();

        foreach (var item in transactions) {
            var transaction = item.Split(',');

            if (1000 < int.Parse(transaction[2])) {
                result.Add(item);
            }

            if (store.ContainsKey(transaction[0])) {
                var list = store[transaction[0]];

                for (var i = 0; list.Count > i; ++i) {
                    var sameNameTransaction = list[i].Split(',');

                    if (sameNameTransaction[3] != transaction[3] &&
                       60 >= Math.Abs(int.Parse(sameNameTransaction[1]) - int.Parse(transaction[1]))) {
                        result.Add(list[i]);
                        result.Add(item);
                    }
                }

                store[transaction[0]].Add(item);
            } else {
                store.Add(transaction[0], new List<string> {item});
            }
        }

        return result.ToList();
    }
}
