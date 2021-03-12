class Solution {
    public String numberToWords(int num) {
        if (0 == num) {
            return "Zero";
        }

        List<String> result = new ArrayList<>();
        int billions = num / 1000000000;
        num -= billions * 1000000000;
        int millions = num / 1000000;
        num -= millions * 1000000;
        int thousands = num / 1000;
        num -= thousands * 1000;

        if (0 < billions) {
            result.add(getStringFromThreeDigits(billions));
            result.add("Billion");
        }

        if (0 < millions) {
            result.add(getStringFromThreeDigits(millions));
            result.add("Million");
        }

        if (0 < thousands) {
            result.add(getStringFromThreeDigits(thousands));
            result.add("Thousand");
        }

        if (0 < num) {
            result.add(getStringFromThreeDigits(num));
        }

        return String.join(" ", result);
    }

    private String getStringFromThreeDigits(int num) {
        List<String> result = new ArrayList<>();
        int hundreds = num / 100;

        num -= hundreds * 100;

        if (0 < hundreds) {
            result.add(getStringFromOneDigit(hundreds));
            result.add("Hundred");
        }

        if (0 < num) {
            if (20 <= num) {
                int tens = num / 10;

                num -= tens * 10;
                result.add(getTens(tens));

                if (0 < num) {
                    result.add(getStringFromOneDigit(num));
                }
            } else if (10 <= num && 20 > num) {
                result.add(getExtras(num));
            } else {
                result.add(getStringFromOneDigit(num));
            }
        }

        return String.join(" ", result);
    }

    private String getStringFromOneDigit(int num) {
        switch (num) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            default:
                return "Error";
        }
    }

    private String getTens(int num) {
        switch (num) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
            default:
                return "Error";
        }
    }

    private String getExtras(int num) {
        switch (num) {
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
            default:
                return "Error";
        }
    }
}
