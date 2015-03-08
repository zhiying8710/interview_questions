package me.binge.questions;

import java.util.ArrayList;
import java.util.List;


/**
 * 翻转句子中单词的顺序。
 * @author Bingege
 *
 */
public class Q10 {


    public static void main(String[] args) {

        String s = "I am a student.";
        List<String> sl = new ArrayList<String>();
        char[] cs = s.toCharArray();
        String tmp = "";
        for (char c : cs) {
            if (c == ' ') {
                sl.add(tmp);
                sl.add(" ");
                tmp = "";
            } else {
                tmp += c;
            }
        }
        sl.add(tmp);
        int begin = 0;
        int end = sl.size() - 1;
        while (begin < end) {
            String t = sl.get(begin);
            sl.set(begin, sl.get(end));
            sl.set(end, t);

            begin ++;
            end --;
        }
        StringBuilder sb = new StringBuilder();
        for (String si : sl) {
            sb.append(si);
        }
        System.out.println(sb.toString());

    }

}
