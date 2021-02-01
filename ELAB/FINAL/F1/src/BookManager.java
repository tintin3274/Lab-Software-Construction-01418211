import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> booksList = new ArrayList<>();

    public void addBook(Book book){
        booksList.add(book);
    }

    public List<Book> search(String keyword, Filter filter){
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : booksList){
            if(filter.filter(book, keyword)) result.add(book);
        }
        return result;
    }
}
