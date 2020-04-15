public class Solution {
    public IList<IList<string>> AccountsMerge(IList<IList<string>> accounts) {
        var result = new Dictionary<int, IList<string>>();
        var dsu = new Dsu(10001);
        var emailToName = new Dictionary<string, string>();
        var emailToId = new Dictionary<string, int>();
        var id = 0;

        foreach (var account in accounts) {
            var name = account[0];

            for (var i = 1; account.Count > i; ++i) {
                var email = account[i];

                if (!emailToName.ContainsKey(email)) {
                    emailToName.Add(email, name);
                }

                if (!emailToId.ContainsKey(email)) {
                    emailToId.Add(email, id++);
                }

                dsu.union(emailToId[account[1]], emailToId[email]);
            }
        }

        foreach (var email in emailToName.Keys) {
            var idx = dsu.find(emailToId[email]);

            if (result.ContainsKey(idx)) {
                result[idx].Add(email);
            } else {
                result.Add(idx, new List<string> { email });
            }
        }

        foreach (var idx in result.Keys) {
            ((List<string>)result[idx]).Sort(
                (x, y) => string.CompareOrdinal(x, y)
            );
            result[idx].Insert(0, emailToName[result[idx][0]]);
        }

        return result.Values.ToList();
    }

    private class Dsu {
        private readonly int[] _parents;
        private readonly int[] _ranks;

        public Dsu(int n) {
            _parents = new int[n];
            _ranks = new int[n];

            for (var i = 0; n > i; ++i) {
                _parents[i] = i;
            }
        }

        public int find(int x) {
            if (x != _parents[x]) {
                x = find(_parents[x]);
            }

            return _parents[x];
        }

        public bool union(int x, int y) {
            var px = find(x);
            var py = find(y);

            if (px == py) {
                return false;
            }

            if (_ranks[px] > _ranks[py]) {
                _parents[py] = px;
                ++_ranks[px];
            } else {
                _parents[px] = py;
                ++_ranks[py];
            }

            return true;
        }
    }
}
