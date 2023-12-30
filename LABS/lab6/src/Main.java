import java.awt.geom.GeneralPath;
import java.util.LinkedHashMap;

public class Main  {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.pop());

        Goods.addGoods("Петрушка", 2000);
        Goods.addGoods("Картошка", 3200);
        Goods.addGoods("Редиска", 1300);
        Goods.printGoods();
        System.out.println(Goods.totalSales());
        System.out.println(Goods.mostPopular());

    }
}
