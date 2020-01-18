package OmarAli.ecutb.java;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<String> stringPredicate = string -> string.length() > 10;
        Predicate<String> isEmpty = String::isEmpty;
        BiPredicate<String, String> equals = (s1,s2) -> s1.equalsIgnoreCase(s2);
        BiPredicate<String, String> equals2 = String::equalsIgnoreCase;

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
