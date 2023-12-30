import java.util.*;

public class Goods {
    static LinkedHashMap<String,Integer> goods = new LinkedHashMap<>();
    public static void addGoods(String name, int sales) {
        goods.put(name, sales);
    }
    public static void printGoods() {
        System.out.println(goods);
    }
    public static int totalSales() {
        int sum = 0;
        Collection<Integer> values = goods.values();
        for (int number : values) {
            sum += number;
        }
        return sum;
    }
    public static String mostPopular() {
        if (!goods.isEmpty()) {
            List<Map.Entry<String,Integer>> list = new ArrayList<>(goods.entrySet());

            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    int first = o1.getValue();
                    int second = o2.getValue();
                    return -Integer.compare(first, second);
                }
            });
            return list.get(0).getKey();
        }
        return "Товаров нет";
    }
}
