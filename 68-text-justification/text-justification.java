class Solution {
    public List<String> fullJustify(String[] words, int mw) {
        List<String> res = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        int len = 0;

        for (String word : words) {

            len += word.length() + 1;

            if (len > mw + 1) {

                int lenToAcc = len - word.length() - 2;
                int extra = mw - lenToAcc;

                String toAdd = build(sb, extra, mw);
                res.add(toAdd);

                sb = new StringBuilder();

                sb.append(word).append(" ");

                len = word.length() + 1;

            } else {
                sb.append(word).append(" ");
            }
        }

        String last = sb.toString().trim();

        StringBuilder temp = new StringBuilder(last);

        while (temp.length() < mw) {
            temp.append(" ");
        }

        res.add(temp.toString());

        return res;
    }

    private String build(StringBuilder sb, int extra, int wb) {

        String[] str = sb.toString().trim().split(" ");

        int x = str.length;

        if (x == 1) {

            StringBuilder single = new StringBuilder(str[0]);

            while (single.length() < wb) {
                single.append(" ");
            }

            return single.toString();
        }

        int gaps = x - 1;

        int totalSpaces = extra + gaps;

        int part = totalSpaces / gaps;

        int rem = totalSpaces % gaps;

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < x; i++) {

            res.append(str[i]);

            if (i == x - 1) break;

            for (int j = 0; j < part; j++) {
                res.append(" ");
            }

            if (rem > 0) {
                res.append(" ");
                rem--;
            }
        }

        return res.toString();
    }
}