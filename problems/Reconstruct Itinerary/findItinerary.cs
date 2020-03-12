public class Solution {
    public IList<string> FindItinerary(IList<IList<string>> tickets) {
        IList<string> ret = new List<string>();
        Dictionary<string, List<string>> ticket = new Dictionary<string, List<string>>();

        for(int i = 0 ; i < tickets.Count ; i++){
            string curAirport = tickets[i][0];
            string nextAirport = tickets[i][1];
            if(ticket.ContainsKey(curAirport)) ticket[curAirport].Add(nextAirport);
            else {
                ticket.Add(curAirport, new List<string>());
                ticket[curAirport].Add(nextAirport);
            }
        }

        foreach(var item in ticket){
             item.Value.Sort();
        }

        ret.Add("JFK");
        dfs(ticket, "JFK", tickets.Count, ret);
        return ret;
    }

    private bool dfs(Dictionary<string, List<string>> ticket, string start, int trips, IList<string> ret){
        if(trips == 0) return true;
        if(!ticket.ContainsKey(start)) return false;

        for(int i = 0 ; i < ticket[start].Count ; i++){

            string nextStop = ticket[start][0];
            ticket[start].RemoveAt(0);
            ret.Add(nextStop);
            if(dfs(ticket, nextStop, trips - 1, ret)) return true;
            ticket[start].Add(nextStop);
            ret.RemoveAt(ret.Count - 1);
        }

        return false;
    }
}
