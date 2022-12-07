class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> duplicates = new HashMap<>();
        HashSet<String> store = new HashSet<>();
        HashMap<String, List<String>> nameToTransactions = new HashMap<>();

        for (String transaction : transactions) {
            String[] items = transaction.split(",");

            duplicates.put(transaction, 1 + duplicates.getOrDefault(transaction, 0));

            if (1000 < Integer.parseInt(items[2])) {
                store.add(transaction);
            }

            if (nameToTransactions.containsKey(items[0])) {
                List<String> list = nameToTransactions.get(items[0]);

                for (int idx = 0; list.size() > idx; ++idx) {
                    String[] sameNameTransaction = list.get(idx).split(",");

                    if (!items[3].equals(sameNameTransaction[3]) && 60 >= Math.abs(Integer.parseInt(items[1]) - Integer.parseInt(sameNameTransaction[1]))) {
                        store.add(transaction);
                        store.add(list.get(idx));
                    }
                }
            } else {
                nameToTransactions.put(items[0], new ArrayList<>());
            }

            nameToTransactions.get(items[0]).add(transaction);
        }

        for (String transaction : store) {
            for (int idx = 0; duplicates.get(transaction) > idx; ++idx) {
                result.add(transaction);
            }
        }

        return result;
    }
}
