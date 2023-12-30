import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "D:\\JAVA PROJECTS\\lab6\\src\\words.txt";
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, Integer> map = new HashMap<>();

        while (scanner.hasNext()) {
            String s = scanner.next();
            if (!map.containsKey(s)) {
                map.put(s,1);
            }
            else {
                int count = map.get(s) + 1;
                map.put(s,count);
            }
        }

        scanner.close();

        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int first = o1.getValue();
                int second = o2.getValue();
                return -Integer.compare(first, second);
            }
        });

        for (int i = 0; i < 10; i++) {
            System.out.println(String.valueOf(i+1) + ") " + list.get(i));
        }
    }
}
