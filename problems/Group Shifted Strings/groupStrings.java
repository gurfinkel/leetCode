class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, Integer> codeToIdxMap = new HashMap<>();

        for (String string : strings) {
            String code = getCode(string);

            if (!codeToIdxMap.containsKey(code)) {
                codeToIdxMap.put(code, result.size());
                result.add(new ArrayList<>());
            }

            result.get(codeToIdxMap.get(code)).add(string);
        }

        return result;
    }

    private String getCode(String item) {
        StringBuilder sb = new StringBuilder();

        for (int idx = 1; item.length() > idx; ++idx) {
            sb.append('a' + (item.charAt(idx) - item.charAt(0) + 26) % 26);
        }

        return sb.toString();
    }
}
