import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) {

        String file1 = "D:\\JAVA PROJECTS\\laba4444\\src\\file1.txt";
        String file2 = "D:\\JAVA PROJECTS\\laba4444\\src\\file2.txt";

        try {
            fileCopy(file1, file2);
        }
        catch (IOException e) {
            System.err.println("Ошибка " + e.getMessage());
        }
        finally {
            System.out.println("Завершение операции");
        }
    }
    public static void fileCopy (String file1, String file2) throws IOException {
        try {
            FileReader reader = new FileReader(file1);
            FileWriter writer = new FileWriter(file2);
            int content;
            while ((content = reader.read()) != -1) {
                writer.write(content);
            }
            reader.close();
            writer.close();
            writer.write(content);
        }
        catch (FileNotFoundException e) {
            System.err.println("Ошибка при чтении файла");
        }
        catch (IOException x) {
            System.err.println("Ошибка при записи файла");
        }
    }
}
