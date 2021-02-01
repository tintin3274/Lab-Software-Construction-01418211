//elab-source: Book.java
// ไม่ต้องส่ง class นี้
import java.util.List;

public class Book {
    private List<String> authors;  // ผู้แต่ง
    private String title;          // ชื่อหนังสือ
    private int publishedYear;     // ปีที่ออกขาย

    public Book(List<String> authors, String title, int publishedYear) {
        this.authors = authors;
        this.title = title;
        this.publishedYear = publishedYear;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authors=" + authors +
                ", title='" + title + '\'' +
                ", publishedYear=" + publishedYear +
                '}';
    }
}