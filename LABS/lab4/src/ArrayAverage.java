public class ArrayAverage {
    public static void main(String[] args) {

        String[] arr = {"1", "2", "3", "4", "5"};
        int sum = 0;

        try {
            for (int i = 0; i < arr.length; i++) {
                sum += Integer.parseInt(arr[i]);
            }
            System.out.println((double) sum / arr.length);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Выход за пределы массива " + e.getMessage());
        }
        catch (NumberFormatException e) {
            System.err.println("Элемент массива не число "+ e.getMessage());
        }
        finally {
            System.out.println("Завершение операции");
        }
    }
}
