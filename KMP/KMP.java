package Test;

/**
 * 计算 KMP 长度
 * LPS 为辅助数组
 */
public class KMP {

    public void search() {
        String origin = "AAAAABAAABA";
        String pattern = "ABAA";
        int[] LPS = calLPS(pattern);
        int i = 0, j = 0;
        int originLength = origin.length(), patternLength = pattern.length();
        while (i < originLength) {
            if (origin.charAt(i) == pattern.charAt(j)) {
                i += 1;
                j += 1;
            }
            if (j == patternLength) {
                System.out.println("已经找到匹配在 " + (i - j));
                j = LPS[j - 1];
            }

            // 进行 shift 移位
            else if (i < originLength && origin.charAt(i) != pattern.charAt(j)) {
                if (j != 0)
                    j = LPS[j - 1];
                else
                    i += 1;
            }
        }

    }

    public int[] calLPS(String pattern) {
        int[] LPS = new int[pattern.length()];
        int length = pattern.length();
        if (length == 0)
            throw new IllegalArgumentException("必须提供合理的 pattern");
        LPS[0] = 0;
        int i = 1, index = 0;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(index)) {
                index += 1;
                LPS[i] = index;
                i += 1;
            } else {
                if (index != 0) {
                    index = LPS[index - 1];
                } else {
                    System.out.println(" i is " + i + " index is " + index);
                    LPS[i] = index;
                    i += 1;
                }
            }
        }
        return LPS;

    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        kmp.search();
    }
}
