package cn.linyt.common.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @ClassName PinYinUtil
 * @Description TODO
 * @Author Mojo
 * @Date 2020/4/19 21:30
 * @Version 1.0
 **/
public class PinYinUtil {

    public static String getPinYin(String chinese){

        char[] spell = chinese.toCharArray();
        String pinYin ="";
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for(int i= 0; i < spell.length; i++){
            if(spell[i] > 128){
                try {
                    pinYin += PinyinHelper.toHanyuPinyinStringArray(spell[i], defaultFormat)[0].charAt(0);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinYin += spell[i];
            }
        }
        return pinYin;
    }
}
