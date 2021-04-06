class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, Integer> store = new HashMap<>();

        for (String item : strs) {
            char[] letters = item.toCharArray();
            Arrays.sort(letters);
            String sortedLetters = new String(letters);

            if (store.containsKey(sortedLetters)) {
                result.get(store.get(sortedLetters)).add(item);
            } else {
                result.add(new ArrayList<>());
                store.put(sortedLetters, result.size() - 1);
                result.get(result.size() - 1).add(item);
            }
        }

        return result;
    }
}
