//elab-source:MovieRatingScoreComparator.java

import java.util.Comparator;

public class MovieRatingScoreComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie o1, Movie o2) {
        if(o1.getRatingScore() == o2.getRatingScore()) return 0;
        return (o1.getRatingScore() > o2.getRatingScore() ? -1 : 1);
    }
}
