import java.util.*;
import java.util.List;
import java.sql.Date;
import java.util.stream.Collectors;

class Car {
    int carid;
    String model;
    String company;
    Date rcDate;
    String carNumber;

    public Car(int carid, String model, String company, Date rcDate, String carNumber) {
        super();
        this.carid = carid;
        this.model = model;
        this.company = company;
        this.rcDate = rcDate;
        this.carNumber = carNumber;
    }

    @Override
    public String toString() {
        return "Car [carid=" + carid + ", model=" + model + ", company=" + company + ", rcDate=" + rcDate
                + ", carNumber=" + carNumber + "]";
    }
    public int getCarid() {
        return carid;
    }
    public void setCarid(int carid) {
        this.carid = carid;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public Date getRcDate() {
        return rcDate;
    }
    public void setRcDate(Date rcDate) {
        this.rcDate = rcDate;
    }
    public String getCarNumber() {
        return carNumber;
    }
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}


class Owner {
    int ownerid;
    String name;
    String gender;
    List<Car> cars;
    public Owner(int ownerid, String name, String gender, List<Car> cars) {
        super();
        this.ownerid = ownerid;
        this.name = name;
        this.gender = gender;
        this.cars = cars;
    }


    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public List<Car> getCars() {
        return cars;
    }
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    @Override
    public String toString() {
        return "Owner [ownerid=" + ownerid + ", name=" + name + ", gender=" + gender + ", cars=" + cars + "]";
    }
}

class CarRepository {
    static List<Car> cars = new ArrayList<>();
    static List<Owner> owners = new ArrayList<>();
    static {
        cars.add(new Car(101, "Thar", "Manhindra", Date.valueOf("2020-05-07"), "MH02AG4528"));
        cars.add(new Car(205, "Thar", "Manhindra", Date.valueOf("2018-09-07"), "MH16AG4520"));
        cars.add(new Car(456, "Dzire", "Maruti", Date.valueOf("2016-05-07"), "HR02AG4523"));
        cars.add(new Car(157, "Sonet", "KIA", Date.valueOf("2024-05-07"), "MH02AP4588"));
        cars.add(new Car(752, "Sierra", "Tata", Date.valueOf("2025-05-07"), "MH02AG4528"));
        cars.add(new Car(951, "Nexon", "Tata", Date.valueOf("2026-05-17"), "MH02AG4028"));
        cars.add(new Car(188, "Nexon", "Tata", Date.valueOf("2022-05-07"), "MH02AG1526"));
        cars.add(new Car(305, "Alto", "Maruti", Date.valueOf("2018-05-07"), "PB02AG4523"));
        cars.add(new Car(177, "Swift", "Maruti", Date.valueOf("2017-05-07"), "MH06AG4528"));
        cars.add(new Car(101, "Swift", "Manhindra", Date.valueOf("2015-05-07"), "HP02AG4528"));
        cars.add(new Car(166, "Nexon", "Tata", Date.valueOf("2021-05-07"), "HP02AG4500"));
        cars.add(new Car(167, "Nexon", "Tata", Date.valueOf("2021-05-07"), "HP02AG4501"));
        owners.add(new Owner(21, "Sumit", "male", List.of(cars.get(0), cars.get(1))));
        owners.add(new Owner(12, "vipin", "male", null));
        owners.add(new Owner(26, "Rajni", "female", List.of(cars.get(7), cars.get(6), cars.get(3))));
        owners.add(new Owner(35, "Amita", "female", List.of(cars.get(4), cars.get(8))));
        owners.add(new Owner(96, "Ram", "male", List.of(cars.get(9))));
        owners.add(new Owner(48, "Krishan", "male", List.of(cars.get(10))));
        owners.add(new Owner(22, "Deepak", "male", List.of(cars.get(11))));
        owners.add(new Owner(51, "Geeta", "female", null));
        owners.add(new Owner(63, "Sachin", "male", null));
    }


    public static List<Car> getCars() {
        return cars;
    }
    public static List<Owner> getOwners() {
        return owners;
    }
}

public class Question1 {
    public static void main(String[] args) {
        List<Owner> owners = CarRepository.getOwners();
        List<Car> cars = CarRepository.getCars();
        // Ans1. Owners with no cars
                List<String> ownerswithnocars= owners.stream()
                .filter(owner -> owner.getCars() == null || owner.getCars().isEmpty())
                .map(Owner::getName)
                .collect(Collectors.toList());

        System.out.println("1. Owners with no cars:");
        System.out.println(ownerswithnocars);

        // Ans2. Map of owner name and number of cars
        Map<String, Integer> ownercarcount = owners.stream()
                .collect(Collectors.toMap(
                        Owner::getName,
                        owner -> owner.getCars() == null ? 0 : owner.getCars().size()
                ));

        System.out.println("\n2. Owner and number of cars:");
        System.out.println(ownercarcount);

        //3.  Cars not owned by anyone
        Set<Car> ownedcars = CarRepository.getOwners()
                .stream()
                .filter(owner -> owner.getCars() != null)
                .flatMap(owner -> owner.getCars().stream())
                .collect(Collectors.toSet());

        List<Car> notownedCars = cars.stream()
                .filter(car -> !ownedcars.contains(car))
                .collect(Collectors.toList());

        System.out.println("\n3. Cars not owned by anyone:");
        notownedCars.forEach(System.out::println);
    }
}


// 1. Return the list of names of the owners currently having no cars
// 2. create a map of name of person and number of cars he/she owns
// 3. List cars not owned by any one