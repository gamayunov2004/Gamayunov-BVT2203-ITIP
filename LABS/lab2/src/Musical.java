// Дочерний класс Мюзикл
class Musical extends Movie {
    private String composer;

    // Конструктор по умолчанию
    public Musical() {
        super();
        this.composer = "";
    }

    // Конструктор с параметрами
    public Musical(String title, String author, int year, String director, String composer) {
        super(title, author, year, director);
        this.composer = composer;
    }

    // Геттер и сеттер для поля composer
    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }
    public void Function(int x) {
        System.out.println("Musical is great for fans of music");
    }
    public void Function(String str) {
        System.out.println("Musical is interesting to watch and listen");
    }

    // Переопределение метода printInfo
    @Override
    public void printInfo() {
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Year: " + getYear());
        System.out.println("Composer: " + composer);
        Function(1);
        Function("asdf");
    }
}