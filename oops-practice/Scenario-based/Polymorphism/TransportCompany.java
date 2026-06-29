class Vehicle {
    String vehicleName;

    Vehicle(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    double fuelCost(int km) {
        return 0;
    }
}

class Car extends Vehicle {
    Car(String name) {
        super(name);
    }

    double fuelCost(int km) {
        return km * 8;
    }
}

class Bus extends Vehicle {
    Bus(String name) {
        super(name);
    }

    double fuelCost(int km) {
        return km * 15;
    }
}

class Bike extends Vehicle {
    Bike(String name) {
        super(name);
    }

    double fuelCost(int km) {
        return km * 3;
    }
}

class ElectricCar extends Vehicle {
    ElectricCar(String name) {
        super(name);
    }

    double fuelCost(int km) {
        return km * 2;
    }
}

public class TransportCompany {
    public static void main(String[] args) {

        Vehicle[] vehicles = {
                new Car("Swift"),
                new Bus("Volvo Bus"),
                new Bike("Splendor"),
                new ElectricCar("Tata Nexon EV")
        };

        int km = 100;

        for (Vehicle v : vehicles) {

            if (v instanceof Car) {
                Car c = (Car) v;
                System.out.println(c.vehicleName + " Fuel Cost = " + c.fuelCost(km));
            } 
            else if (v instanceof Bus) {
                Bus b = (Bus) v;
                System.out.println(b.vehicleName + " Fuel Cost = " + b.fuelCost(km));
            } 
            else if (v instanceof Bike) {
                Bike bike = (Bike) v;
                System.out.println(bike.vehicleName + " Fuel Cost = " + bike.fuelCost(km));
            } 
            else {
                System.out.println(v.vehicleName + " Fuel Cost = " + v.fuelCost(km));
            }
        }
    }
}