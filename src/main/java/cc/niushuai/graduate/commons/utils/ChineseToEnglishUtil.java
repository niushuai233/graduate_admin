package cc.niushuai.graduate.commons.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class ChineseToEnglishUtil {

    /**
     * @param
     * @author niushuai
     * @Description 汉字转拼音
     * @date 2018-2-25 上午9:34:17
     */
    public static String getPingYin(String str) {
        // 首先替换所有空格
        str = str.replace(" ", "");
        char[] t1 = null;
        t1 = str.toCharArray();
        String[] t2 = new String[t1.length];
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();

        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
        String t4 = "";
        int t0 = t1.length;
        try {
            for (int i = 0; i < t0; i++) {
                if (Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
                    t4 = t4 + t2[0];
                } else {
                    t4 = t4 + t1[i];
                }
            }
            return t4;
        } catch (BadHanyuPinyinOutputFormatCombination e1) {
            e1.printStackTrace();
        }
        return t4;
    }

    /**
     * @param
     * @author niushuai
     * @Description 汉字转成拼音并返回首字母
     * @date 2018-2-25 上午9:34:38
     */
    public static String getPinYinHeadChar(String str) {
        str = str.replace(" ", "");
        String convert = "";
        String first = (String) str.subSequence(0, 1);
        for (int j = 0; j < first.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null)
                convert = convert + pinyinArray[0].charAt(0);
            else {
                convert = convert + word;
            }
        }
        return convert.toUpperCase();
    }


    public static void main(String[] args) {
        System.out.println(getPinYinHeadChar("中国 人"));
        System.out.println(getPingYin("中国 人"));
    }

}
