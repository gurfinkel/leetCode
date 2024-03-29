class SmallestInfiniteSet {

    public SmallestInfiniteSet() {
        isPresent = new HashSet<>();
        addedIntegers = new PriorityQueue<>();
        currentInteger = 1;
    }

    public int popSmallest() {
        int answer;
        // If there are numbers in the min-heap,
        // top element is lowest among all the available numbers.
        if (!addedIntegers.isEmpty()) {
            answer = addedIntegers.poll();
            isPresent.remove(answer);
        }
        // Otherwise, the smallest number of large positive set
        // denoted by 'currentInteger' is the answer.
        else {
            answer = currentInteger;
            currentInteger += 1;
        }
        return answer;
    }

    public void addBack(int num) {
        if (currentInteger <= num || isPresent.contains(num)) {
            return;
        }
        // We push 'num' in the min-heap if it isn't already present.
        addedIntegers.add(num);
        isPresent.add(num);
    }

    private HashSet<Integer> isPresent;
    private PriorityQueue<Integer> addedIntegers;
    private Integer currentInteger;
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
