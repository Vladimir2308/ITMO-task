package lecture7.task6LibriaryHash;

public class Book {
    String author, title;
    int pagesNum;

    Book(String author, String title, int pagesNun) {
        this.author = author;
        this.title = title;
        this.pagesNum = pagesNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (pagesNum != book.pagesNum) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        return title != null ? title.equals(book.title) : book.title == null;
    }

    @Override
    public int hashCode() {
        int result = Math.abs ((author+title).hashCode() );


        return result;
    }
}
