//elab-source:FilterAuthor.java

public class FilterAuthor implements Filter {
    @Override
    public boolean filter(Book book, String keyword) {
        for(String name : book.getAuthors()){
            if(name.contains(keyword)) return true;
        }
        return false;
    }
}
