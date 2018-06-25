package com.meng.filepath.service;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.util.StringUtils;

import java.util.Map;

public interface FilePathService {

    void insertFilePathBydir(String filePath);

    void clearFileContentByPath(String filePath) throws Exception;

    /**
     * 获取字符串内的所有汉字的汉语拼音并大写每个字的首字母
     *
     * @param chinese
     * @return
     */
    default String spell(String chinese, Map map) {
        if (chinese == null) {
            return null;
        }
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);// 小写
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 不标声调
        format.setVCharType(HanyuPinyinVCharType.WITH_V);// u:的声母替换为v
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chinese.length(); i++) {

                String[] array = PinyinHelper.toHanyuPinyinStringArray(chinese.charAt(i), format);
                if (array == null || array.length == 0) {
                    if(! StringUtils.isEmpty(map.get(chinese.substring(i,i+1)))){
                        sb.append(map.get(chinese.substring(i,i+1)));
                        //continue;
                    }
                    continue;
                }
                String s = array[0];// 不管多音字,只取第一个
                char c = s.charAt(0);// 大写第一个字母
                //String pinyin = String.valueOf(c).toUpperCase().concat(s.substring(1));
                //sb.append(pinyin);
                //添加首写字母
                sb.append(c);
            }
            return sb.toString();
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return null;
    }

}
