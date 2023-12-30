// Дочерний класс Фильм
class Movie extends Book {
    private String director;

    // Конструктор по умолчанию
    public Movie() {
        super();
        this.director = "";
    }

    // Конструктор с параметрами
    public Movie(String title, String author, int year, String director) {
        super(title, author, year);
        this.director = director;
    }

    // Геттер и сеттер для поля director
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    public void Advantage(int x) {
        System.out.println("Movies are exciting");
    }
    public void Advantage(String str) {
        System.out.println("Movies are cool!!!");
    }

    // Переопределение метода printInfo
    @Override
    public void printInfo() {
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Year: " + getYear());
        System.out.println("Director: " + director);
        Advantage(1);
        Advantage("aaa");
    }
}