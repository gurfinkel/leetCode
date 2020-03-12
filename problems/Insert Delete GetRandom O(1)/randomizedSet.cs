public class RandomizedSet {

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.set = new List<int>();
        this.map = new Dictionary<int, int>();
        this.random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public bool Insert(int val) {
        if (!this.map.ContainsKey(val))
        {
            this.map[val] = this.set.Count;
            this.set.Add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public bool Remove(int val) {
        int valIndex;
        if (this.map.TryGetValue(val, out valIndex))
        {
            //Cache current last element in set.
            int lastIndexInSet = this.set.Count - 1;
            int lastElement = this.set[lastIndexInSet];
            //Move val to be removed to last in set.
            this.map[val] = lastIndexInSet;
            this.set[lastIndexInSet] = val;
            //Move cached last element to where the val to be removed was before it was move to last.
            this.set[valIndex] = lastElement;
            this.map[lastElement] = valIndex;
            //Remove the last element from the set.
            this.set.RemoveAt(this.set.Count - 1);
            this.map.Remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int GetRandom() {
        return this.set[this.random.Next(this.set.Count)];
    }

    List<int> set;
    Dictionary<int, int> map;
    Random random;
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * bool param_1 = obj.Insert(val);
 * bool param_2 = obj.Remove(val);
 * int param_3 = obj.GetRandom();
 */
