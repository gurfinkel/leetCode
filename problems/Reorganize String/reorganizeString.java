class Solution {
    public String reorganizeString(String s) {
        StringBuilder sb = new StringBuilder();
        int[] letterFrequencies = new int[26];
        PriorityQueue<Letter> maxHeap = new PriorityQueue<>((a, b) ->
            a.frequency == b.frequency ?
                       a.symbol - b.symbol : b.frequency - a.frequency);

        for (char letter : s.toCharArray()) {
            ++letterFrequencies[letter -'a'];
        }

        for (int idx = 0; 26 > idx; ++idx) {
            if (0 < letterFrequencies[idx]) {
                if (((s.length() + 1) >> 1) < letterFrequencies[idx]) {
                    return "";
                }

                maxHeap.add(new Letter(letterFrequencies[idx], (char) ('a' + idx)));
            }
        }

        while (2 <= maxHeap.size()) {
            Letter a = maxHeap.poll();
            Letter b = maxHeap.poll();

            if (0 == sb.length() || sb.charAt(sb.length() - 1) != a.symbol) {
                sb.append(a.symbol);
                sb.append(b.symbol);
            } else {
                sb.append(b.symbol);
                sb.append(a.symbol);
            }

            if (0 < --a.frequency) {
                maxHeap.add(a);
            }
            if (0 < --b.frequency) {
                maxHeap.add(b);
            }
        }

        if (0 < maxHeap.size()) {
            sb.append(maxHeap.poll().symbol);
        }

        return sb.toString();
    }

    class Letter {
        int frequency;
        char symbol;

        Letter(int ct, char ch) {
            frequency = ct;
            symbol = ch;
        }
    }
}
