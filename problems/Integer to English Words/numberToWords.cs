public class Solution {
    public string NumberToWords(int num) {
        if (0 == num) {
            return "Zero";
        }

        List<string> result = new List<string>();
        int billions = num / 1000000000;
        num -= billions * 1000000000;
        int millions = num / 1000000;
        num -= millions * 1000000;
        int thousands = num / 1000;
        num -= thousands * 1000;

        if (0 < billions) {
            result.Add(stringFromTreeDigits(billions));
            result.Add("Billion");
        }

        if (0 < millions) {
            result.Add(stringFromTreeDigits(millions));
            result.Add("Million");
        }

        if (0 < thousands) {
            result.Add(stringFromTreeDigits(thousands));
            result.Add("Thousand");
        }

        if (0 < num) {
            result.Add(stringFromTreeDigits(num));
        }

        return string.Join(" ", result);
    }

    private string stringFromTreeDigits(int num) {
        List<string> result = new List<string>();
        int hundreds = num / 100;

        num -= hundreds * 100;

        if (0 < hundreds) {
            result.Add(getDigit(hundreds));
            result.Add("Hundred");
        }

        if (0 < num) {
            if (20 <= num) {
                result.Add(getTens(num / 10));
                if (0 != num % 10) {
                    result.Add(getDigit(num % 10));
                }
            } else if (10 <= num && 20 > num) {
                result.Add(getExtras(num));
            } else {
                result.Add(getDigit(num));
            }
        }

        return string.Join(" ", result);
    }

    private string getDigit(int num) {
        var digits = new Dictionary<int, string>{{1, "One"}, {2, "Two"}, {3, "Three"}, {4, "Four"}, {5, "Five"}, {6, "Six"}, {7, "Seven"}, {8, "Eight"}, {9, "Nine"}};

        return digits[num];
    }

    private string getExtras(int num) {
        var extras = new Dictionary<int, string>{{10,"Ten"},{11,"Eleven"},{12,"Twelve"},{13,"Thirteen"},{14,"Fourteen"},{15,"Fifteen"},{16,"Sixteen"},{17,"Seventeen"},{18,"Eighteen"},{19,"Nineteen"}};

        return extras[num];
    }

    private string getTens(int num) {
        var tens = new Dictionary<int, string>{{2,"Twenty"},{3,"Thirty"},{4,"Forty"},{5,"Fifty"},{6,"Sixty"},{7,"Seventy"},{8,"Eighty"},{9,"Ninety"}};

        return tens[num];
    }
}
