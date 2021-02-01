import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class Data {
    public static Comparable max(Comparable a, Comparable b) {
        if (a.compareTo(b) > 0) {
            return a;
        }
        return b;
        //return a.compareTo(b) > 0 ? a : b;
    }

    public static Comparable max(Collection<Comparable> collection) {
        if (collection.isEmpty()) return null;
        Iterator<Comparable> iterator = collection.iterator();
        Comparable m = iterator.next();
        while (iterator.hasNext()) {
            m = max(m, iterator.next());
        }
        return m;
    }


//    public static Object max(Object a, Object b, Comparator c) {
//        if (c.compare(a, b) > 0) {
//            return a;
//        }
//        return b;
//        //return c.compare(a, b) > 0 ? a : b;
//    }
//
//    public static Object max(Collection collection, Comparator c) {
//        if (collection.isEmpty()) return null;
//        Iterator iterator = collection.iterator();
//        Object m = iterator.next();
//        while (iterator.hasNext()) {
//            m = max(m, iterator.next(), c);
//        }
//        return m;
//    }


    public static <T> T max(T a, T b, Comparator<T> c) {
        if (c.compare(a, b) > 0) {
            return a;
        }
        return b;
        //return c.compare(a, b) > 0 ? a : b;
    }

    public static <T> T max(Collection<T> collection, Comparator<T> c) {
        if (collection.isEmpty()) return null;
        Iterator<T> iterator = collection.iterator();
        T m = iterator.next();
        while (iterator.hasNext()) {
            m = max(m, iterator.next(), c);
        }
        return m;
    }

}
