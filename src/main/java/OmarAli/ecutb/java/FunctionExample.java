package OmarAli.ecutb.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Hello world!
 *
 */
public class FunctionExample
{
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("ABC123", "Volvo", "S60", LocalDate.parse("2010-10-10")));
        cars.add(new Car("BBB123", "BMW", "530", LocalDate.parse("2007-12-10")));
        cars.add(new Car("DEF129", "Volvo", "740", LocalDate.parse("1993-02-11")));
        cars.add(new Car("XYZ123", "SAAB", "9-3", LocalDate.parse("2013-02-01")));
        cars.add(new Car("HaXxor", "Tesla", "model 3", LocalDate.parse("2019-10-10")));
        cars.add(new Car("SSD567", "Kia", "CEED", LocalDate.parse("2017-03-07")));
        cars.add(new Car("API003", "Volvo", "V70", LocalDate.parse("2012-05-30")));

            Predicate<Car> carPredicate = bil -> bil.getBrand().equalsIgnoreCase("Volvo");
            Function<Car, String> stringFunction = bil -> bil.toString();

            List<String> volvo = filterAndApply(cars, carPredicate, stringFunction);
            volvo.forEach(car -> System.out.println(car));
    }
    public static List<String> filterAndApply(List<Car> cars, Predicate<Car> filter, Function<Car, String> converter){
        List<String> strings = new ArrayList<>();
        for (Car car : cars){
            if (filter.test(car)){
                strings.add(converter.apply(car));
            }
        }
        return strings;
    }

    public static <T,R> List<R> filterAndApplyGeneric(List<T> list, Predicate<T> filter, Function<T,R> converter){
        List<R> strings = new ArrayList<>();
        for (T t: list){
            if (filter.test(t)){
                strings.add(converter.apply(t));
            }
        }
        return strings;
    }
}
class Car {
    private String regNumber, brand, model;
    private LocalDate regDate;

    public Car(String regNumber, String brand, String model, LocalDate regDate) {
        this.regNumber = regNumber;
        this.brand = brand;
        this.model = model;
        this.regDate = regDate;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(regNumber, car.regNumber) &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model) &&
                Objects.equals(regDate, car.regDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber, brand, model, regDate);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("regNumber='").append(regNumber).append('\'');
        sb.append("brand='").append(brand).append('\'');
        sb.append("model='").append(model).append('\'');
        sb.append("regDate='").append(regDate).append('\'');
        sb.append('}');
        return sb.toString();

    }
}