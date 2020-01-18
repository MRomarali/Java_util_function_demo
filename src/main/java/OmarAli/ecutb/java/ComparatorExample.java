package OmarAli.ecutb.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
    List<Car> cars = new ArrayList<>();
        cars.add(new Car("ABC123", "Volvo", "S60", LocalDate.parse("2010-10-10")));
        cars.add(new Car("BBB123", "BMW", "530", LocalDate.parse("2007-12-10")));
        cars.add(new Car("DEF129", "Volvo", "740", LocalDate.parse("1993-02-11")));
        cars.add(new Car("XYZ123", "SAAB", "9-3", LocalDate.parse("2013-02-01")));
        cars.add(new Car("HaXxor", "Tesla", "model 3", LocalDate.parse("2019-10-10")));
        cars.add(new Car("SSD567", "Kia", "CEED", LocalDate.parse("2017-03-07")));
        cars.add(new Car("API003", "Volvo", "V70", LocalDate.parse("2012-05-30")));
    Comparator<Car> comparator = (o1, o2) -> o1.getBrand().compareToIgnoreCase(o2.getBrand());
    Comparator<Car> comparator1 = (o1,o2) -> o1.getRegDate().compareTo(o2.getRegDate());
    Comparator<Car> carComparator = Comparator.comparing(Car::getBrand).thenComparing(Car::getRegDate);

    cars.sort(comparator.thenComparing(carComparator));

    cars.forEach(System.out::println);
    }
}