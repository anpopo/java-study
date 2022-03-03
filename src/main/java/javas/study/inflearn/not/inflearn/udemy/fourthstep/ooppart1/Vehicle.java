package javas.study.inflearn.not.inflearn.udemy.fourthstep.ooppart1;

public class Vehicle {
    private String name;
    private String size;
    private int currentVelocity;
    private int currentDirection;

    public Vehicle(String name, String size) {
        this.name = name;
        this.size = size;

        this.currentVelocity = 0;
        this.currentDirection = 0;
    }

    public void steer (int direction) {
        currentDirection += direction;
        System.out.println("Vehicle.steer : Steering at " + currentDirection + "degrees.");
    }

    public void move (int velocity, int direction) {
        this.currentVelocity = velocity;
        currentDirection = direction;
        System.out.println("Vehicle.move : Moving at " + currentVelocity + " in direction " + currentDirection + " degrees.");
    }

    public void stop () {
        currentVelocity = 0;
    }


    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }
}
