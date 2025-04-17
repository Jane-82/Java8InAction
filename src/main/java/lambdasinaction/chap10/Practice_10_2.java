package lambdasinaction.chap10;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Practice_10_2 {

    public static void main(String ... args) {
        Insurance insurance = new Insurance("Company 1");
        Optional<Car> car = Optional.of(new Car(Optional.of(insurance)));
        Optional<Person> person = Optional.of(new Person(car, 20));


        String companyName = getCarInsuranceName(person, 18);
        System.out.println(companyName);
    }

    public static String getCarInsuranceName(Optional<Person> person, int minAge) {
        return person.filter(p -> p.getAge() >= minAge)
                     .flatMap(Person::getCar)
                     .flatMap(Car::getInsurance)
                     .map(Insurance::getName)
                     .orElse("Unknown");
    }

    static class Person {

        private Optional<Car> car;
        private int age;

        public Person(Optional<Car> car, int age) {
            this.car = car;
            this.age = age;
        }

        public Optional<Car> getCar() {
            return car;
        }

        public Integer getAge() {
            return age;
        }
    }

    static class Car {

        private Optional<Insurance> insurance;

        public Car(Optional<Insurance> insurance) {
            this.insurance = insurance;
        }

        public Optional<Insurance> getInsurance() {
            return insurance;
        }
    }

    static class Insurance {

        private String name;

        public Insurance() {}

        public Insurance(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
