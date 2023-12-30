// Дочерний класс Аудиокнига
class Audiobook extends Book {
    private int duration;
    private static int objectCount;
    // Конструктор по умолчанию
    public Audiobook() {
        super();
        this.duration = 0;
        objectCount++;
    }

    // Конструктор с параметрами
    public Audiobook(String title, String author, int year, int duration) {
        super(title, author, year);
        this.duration = duration;
        objectCount++;
    }


    // Геттер и сеттер для поля duration
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public int getObjectCount() {
        return objectCount;
    }

    // Переопределение метода printInfo
    @Override
    public void printInfo() {
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Year: " + getYear());
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Count " + objectCount);
        Activity(1);
        Activity("abc");
    }
    public void Activity(int x) {
        System.out.println("Audiobook let you read book faster");
    }
    public void Activity(String str) {
        System.out.println("Audiobook is easier to read");
    }
}