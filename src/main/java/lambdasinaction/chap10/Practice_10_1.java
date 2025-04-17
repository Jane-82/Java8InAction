package lambdasinaction.chap10;

import java.util.Optional;

public class Practice_10_1 {

    public static void main(String ... args) {
        Insurance insurance = new Insurance();
        Optional<Car> car = Optional.of(new Car(Optional.of(insurance)));
        Optional<Person> person = Optional.of(new Person(car));

        Optional<Insurance> cheapestInsurance = nullSafeFindCheapestInsurance(person, car);
        String companyName = cheapestInsurance.map(Insurance::getName).orElse("Unknown");
        System.out.println(companyName);
    }

    public static Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }

    public static Insurance findCheapestInsurance(Person person, Car car) {
        // 不同保险公司提供保险查询，对比所有数据
        Insurance cheapestCompany = new Insurance("Company 1");
        return cheapestCompany;
    }

    static class Person {

        private Optional<Car> car;

        public Person(Optional<Car> car) {
            this.car = car;
        }

        public Optional<Car> getCar() {
            return car;
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
