//elab-source:FilterYear.java

public class FilterYear implements Filter {
    @Override
    public boolean filter(Book book, String keyword) {
        return book.getPublishedYear()>= Integer.parseInt(keyword);
    }
}
