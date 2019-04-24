package utils.test;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtilsTest {

    @Test
    public void testCopyArray() throws Exception {
        byte[] srcBytes = {1, 2, 3, 4, 5, 6, 7, 8};
        byte[] desBytes = new byte[3];
        System.arraycopy(srcBytes, 0, desBytes, 0, 3);
        System.out.println(desBytes);
    }

    @Test
    public void testReflect() throws Exception {
        List<String> list = Lists.newArrayList("aa","cc");
        Type[] genericInterfaces = list.getClass().getGenericInterfaces();
        System.out.println();
    }

    @Test
    public void testSenWord() {
        long b = System.currentTimeMillis();
        List<SensitiveWord> list = Lists.newArrayList();
        List<String> userAddWords = Arrays.asList("大数据", "人工智能", "中华人民共和国", "中国人民解放军", "天天");
        String srcSen = "科大讯飞具有雄厚的大数据和人工智能技术，其中人工智能技术最为牛逼！今天天气真好！人工智能测试一下！中华人民共和国";
        String wsResult = "科大讯飞 具有 雄厚 的 大 数据 和 人工智 能 技术 ， 其中 人工 智能 技术 最为 牛逼 ！ 今天 天气 真好！ 人工 智能测试 一下 ！ 中华 人民 共和 国";
        Map<Integer, String> map = new HashMap<>();
        System.out.println("参数构建时间：" + (System.currentTimeMillis() - b) + "ms");
        for (String word : userAddWords) {
            String temp = srcSen;
            Integer pos = 0;
            int i = 0;
            while ((i = temp.indexOf(word)) != -1) {
                map.put(pos + i, word);
                temp = temp.substring(i + word.length());
                pos = pos + i + word.length();
            }
        }
        System.out.println("第一次for循环时间:" + (System.currentTimeMillis() - b));
        String[] wsArr = wsResult.split(" ");
        Integer pos = 0;
        for (int i = 0; i < wsArr.length; i++) {
            if (map.get(pos) != null && allIn(wsArr, i, map.get(pos))) {
                list.add(new SensitiveWord(map.get(pos), pos, pos + map.get(pos).length()));
            }
            pos += wsArr[i].length();
        }
        System.out.println("消耗的时间：" + (System.currentTimeMillis() - b) + "ms");
        list.stream().forEach(System.out::println);
    }

    private Boolean allIn(String[] wsArr, Integer index, String value) {
        Integer len = value.length();
        Integer tempLen = 0;
        while (true) {
            tempLen += wsArr[index++].length();
            if (tempLen > len) {
                return false;
            }
            //不应该只判断长度，应该判断长度和内容是否都相同
            if (tempLen == len) {
                return true;
            }
        }
    }

    class SensitiveWord {

        public SensitiveWord(String word, Integer beginPos, Integer endPos) {
            this.word = word;
            this.beginPos = beginPos;
            this.endPos = endPos;
        }

        private String word;

        private Integer beginPos;

        private Integer endPos;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public Integer getBeginPos() {
            return beginPos;
        }

        public void setBeginPos(Integer beginPos) {
            this.beginPos = beginPos;
        }

        public Integer getEndPos() {
            return endPos;
        }

        public void setEndPos(Integer endPos) {
            this.endPos = endPos;
        }
    }
}
