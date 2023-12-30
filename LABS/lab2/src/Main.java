public class Main {
    public static void main(String[] args) {
        // Создание объектов и вывод информации о них
        Audiobook audiobook = new Audiobook("The Great Gatsby", "F. Scott Fitzgerald", 1925, 360);
        audiobook.printInfo();
        Audiobook audiobook1 = new Audiobook("x", "x", 2007, 14);
        audiobook1.printInfo();

        Movie movie = new Movie("The Shawshank Redemption", "Stephen King", 1994, "Frank Darabont");
        movie.printInfo();

        Musical musical = new Musical("Les Misérables", "Victor Hugo", 1862, "Claude-Michel Schönberg", "123");
        musical.printInfo();

        System.out.println("-----------------");

        audiobook.setTitle("00000");
        musical.setTitle("00000");
        movie.setTitle("00000");

        audiobook.printInfo();
        musical.printInfo();
        movie.printInfo();

        System.out.println("-----------------");
        System.out.println(audiobook.getYear());
        System.out.println(musical.getAuthor());
        System.out.println(movie.getDirector());

    }
}

