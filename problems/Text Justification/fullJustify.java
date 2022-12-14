class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        // Current sum of total characters.
        int currSum = 0;
        List<String> currList = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (currSum + words[i].length() + currList.size() <= maxWidth) {
                currList.add(words[i]);
                currSum += words[i].length();
            } else {
                // Number of words in this line.
                int n = currList.size();
                int numSpace = maxWidth - currSum;
                StringBuffer sb = new StringBuffer();

                if (n != 1) {
                    // Basic number of spaces between words.
                    int a = numSpace / (n - 1);
                    // Number of slots which need extra one space.
                    int b = numSpace - a * (n - 1);

                    for (int j = 0; j < currList.size(); j++) {
                        sb.append(currList.get(j));

                        if(j < b) {
                            for(int k = 0; k < a + 1; k++) {
                                sb.append(" ");
                            }
                        } else if(j != currList.size() - 1) {
                            for(int k = 0; k < a; k++) {
                                sb.append(" ");
                            }
                        }
                    }
                } else {
                    sb.append(currList.get(0));
                    while(sb.length() < maxWidth) {
                        sb.append(" ");
                    }
                }

                res.add(sb.toString());
                currList = new ArrayList<>();
                currList.add(words[i]);
                currSum = words[i].length();
            }
        }

        // For last line.
        if(currList.size() != 0) {
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < currList.size(); i++) {
                sb.append(currList.get(i));
                if(i != currList.size() - 1)
                    sb.append(" ");
            }

            while(sb.length() < maxWidth) {
                sb.append(" ");
            }

            res.add(sb.toString());
        }
        return res;
    }
}
