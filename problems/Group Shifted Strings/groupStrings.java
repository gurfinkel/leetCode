class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, Integer> store = new HashMap<>();

        for (String item : strings) {
            String code = getCode(item);

            if (store.containsKey(code)) {
                result.get(store.get(code)).add(item);
            } else {
                result.add(new ArrayList<>());
                store.put(code, result.size() - 1);
                result.get(result.size() - 1).add(item);
            }
        }

        return result;
    }

    String getCode(String str) {
        StringBuilder sb = new StringBuilder();

        for (int idx = 1; str.length() > idx; ++idx) {
            sb.append('a' + (str.charAt(idx) - str.charAt(0) + 26) % 26);
        }

        return sb.toString();
    }
}
