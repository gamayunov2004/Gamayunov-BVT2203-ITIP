// Абстрактный класс Книга
abstract class Book {
    private String title;
    private String author;
    private int year;

    // Конструктор по умолчанию
    public Book() {
        this.title = "";
        this.author = "";
        this.year = 0;
    }

    // Конструктор с параметрами
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Геттеры и сеттеры
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    // Абстрактный метод, описывающий поведение объекта
    public abstract void printInfo();
}