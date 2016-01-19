import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Author: Íõ¿¡³¬
 * Date: 2016-01-19 21:57
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        // szxcdhlaytgj 636 1
        // arefkiz 645 1
        // jmfdahkeffyjjsf 648 2
        // jmfdahkeffyjjsf 645 1
        // qekvaxypemktyurn 633 1
        // maahmq 646 1
        // jmfdahkeffyjjsf 636 1
        // szxcdhlaytgj 642 1
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data2.txt"));

        LinkedHashMap<String, Integer> lru = new LRU<String, Integer>();

        while (scanner.hasNext()) {
            String name = scanner.next();

            int i = name.lastIndexOf("\\");
            if (i != -1) {
                name = name.substring(i + 1);
                if (name.length() > 16) {
                    name = name.substring(name.length() - 16);
                }
            }
            name += " " + scanner.nextInt();

            if (lru.containsKey(name)) {
                lru.put(name, lru.get(name) + 1);
            } else {
                lru.put(name, 1);
            }
        }

        scanner.close();


        StringBuilder builder = new StringBuilder(128);
        for (Map.Entry<String, Integer> e : lru.entrySet()) {
            builder.append(e.getKey()).append(' ').append(e.getValue()).append('\n');
        }

        System.out.print(builder.substring(0, builder.length() - 1));
    }

    public static class LRU<K, V> extends LinkedHashMap<K, V> {
        private static final int MAX_ENTRIES = 8;

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > MAX_ENTRIES;
        }
    }
}
