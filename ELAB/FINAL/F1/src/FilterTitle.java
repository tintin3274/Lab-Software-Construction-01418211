//elab-source:FilterTitle.java

public class FilterTitle implements Filter {
    @Override
    public boolean filter(Book book, String keyword) {
        return book.getTitle().contains(keyword);
    }
}
