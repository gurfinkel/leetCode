public class Solution {
    public string ValidIPAddress(string IP) {
        if (isIPv6(IP)) {
            return "IPv6";
        } else if (isIPv4(IP)) {
            return "IPv4";
        } else {
            return "Neither";
        }
    }

    private bool isIPv6(string s) {
        var store = s.Split(':');

        if (8 != store.Length) {
            return false;
        }

        foreach (var item in store) {
            if (0 == item.Length || 4 < item.Length) {
                return false;
            }

            foreach (var symbol in item) {
                if (!(char.IsDigit(symbol) ||
                   'a' <= char.ToLower(symbol) &&
                   'f' >= char.ToLower(symbol))) {
                    return false;
                }
            }
        }

        return true;
    }

    private bool isIPv4(string s) {
        var store = s.Split('.');

        if (4 != store.Length) {
            return false;
        }

        foreach (var item in store) {
            if (0 == item.Length || 3 < item.Length) {
                return false;
            }

            var num = 0;
            var counter = 0;

            foreach (var symbol in item) {
                if (!char.IsDigit(symbol) || (1 < item.Length && 0 == num && '0' == symbol)) {
                    return false;
                }

                num = 10 * num + (symbol - '0');
            }

            if (255 < num) {
                return false;
            }
        }

        return true;
    }
}
