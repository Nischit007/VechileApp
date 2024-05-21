package VechileApp;

import java.util.Scanner;

class Vechile {
    String name;
    int speed;
    int direction;
}

class Car extends Vechile {
    int wheel;
    String type;
    int noOfDoor;
    int noOfGears;
    int currGear;
    boolean manual;

    void changeGear(int currGear) {
        this.currGear = currGear;
        System.out.println("Gear changed to: " + currGear);
    }

    void changeSpeed(int speed, int direction) {
        this.speed = speed;
        this.direction = direction;
        System.out.println("Speed changed to: " + speed + " Direction: " + direction);
    }
}

class Suv extends Car {
    void accelerate(int rate, int direction) {
        this.speed = rate;
        this.direction = direction;
        System.out.println("SUV accelerated to speed: " + rate + " in direction: " + direction);
    }
}

class HatchBack extends Car {
    void accelerate(int rate, int direction) {
        this.speed = rate;
        this.direction = direction;
        System.out.println("HatchBack accelerated to speed: " + rate + " in direction: " + direction);
    }
}

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Suv mySuv = new Suv();
        HatchBack myHatchBack = new HatchBack();
        Car myCar = mySuv; // Start with an SUV for this example

        while (true) {
            System.out.println("Choose an action: 1. Change Gear 2. Change Speed 3. Accelerate 4. Switch Vehicle 5. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter new gear:");
                    int newGear = scanner.nextInt();
                    myCar.changeGear(newGear);
                    break;
                case 2:
                    System.out.println("Enter new speed and direction:");
                    int newSpeed = scanner.nextInt();
                    int newDirection = scanner.nextInt();
                    myCar.changeSpeed(newSpeed, newDirection);
                    break;
                case 3:
                    System.out.println("Enter acceleration rate and direction:");
                    int rate = scanner.nextInt();
                    int direction = scanner.nextInt();
                    if (myCar instanceof Suv) {
                        ((Suv) myCar).accelerate(rate, direction);
                    } else if (myCar instanceof HatchBack) {
                        ((HatchBack) myCar).accelerate(rate, direction);
                    }
                    break;
                case 4:
                    System.out.println("Switch to: 1. SUV 2. HatchBack");
                    int vehicleChoice = scanner.nextInt();
                    if (vehicleChoice == 1) {
                        myCar = mySuv;
                        System.out.println("Switched to SUV");
                    } else if (vehicleChoice == 2) {
                        myCar = myHatchBack;
                        System.out.println("Switched to HatchBack");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
