import java.util.ArrayList;
import java.util.Scanner;

public class Building {

    private ArrayList<Elevator> elevatorList = new ArrayList<Elevator>();
    private final int floorsNumber;
    private int passengerCurrentFloor;
    Scanner sc = new Scanner(System.in);

    public Building(int floorsNumber){
        this.floorsNumber = floorsNumber;
        this.elevatorList.add(new Elevator());
        this.elevatorList.add(new Elevator());
    }

    public void buildingWorking(){
        int passengerChoice;
        System.out.println("Enter 1 to call an elevator, or 2 to quit:");
        passengerChoice = Integer.parseInt(sc.nextLine());

        switch(passengerChoice){
            case 1 :
                interuptor();
                buildingWorking();
                break;

            case 2:
                System.exit(1);
            break;

            default:
                System.out.println("Vous n'avez pas fais un des choix proposé retour au menu");
                buildingWorking();
        }

    }

    public void interuptor(){

        do {
            System.out.println("Please enter the floor you are currently in, in this building of "+floorsNumber+" floors");
            passengerCurrentFloor = Integer.parseInt(sc.nextLine());
        }while(passengerCurrentFloor<0 || passengerCurrentFloor>this.floorsNumber);

        goToPassengerFloor();

    }

    public void passengerFloorChoice(int elevatorNumber){
        int floorWantedByPassenger;
        do {
            System.out.println("Please enter the floor you want to go");
            floorWantedByPassenger = Integer.parseInt(sc.nextLine());
        }while(floorWantedByPassenger<0 || floorWantedByPassenger>this.floorsNumber);

        if(floorWantedByPassenger<passengerCurrentFloor){
            goDown(elevatorNumber, floorWantedByPassenger);
        }
        else if(floorWantedByPassenger>passengerCurrentFloor){
            goUp(elevatorNumber, floorWantedByPassenger);
        }

        else{
            System.out.println("You are currently in this floor");
            passengerFloorChoice(elevatorNumber);
        }
    }

    public void goToPassengerFloor(){
        int rangeElevator1ToPassenger = Math.abs(this.elevatorList.get(0).getCurrentFloor()-this.passengerCurrentFloor);
        int rangeElevator2ToPassenger = Math.abs(this.elevatorList.get(1).getCurrentFloor()-this.passengerCurrentFloor);

        if(rangeElevator1ToPassenger>rangeElevator2ToPassenger){
            this.elevatorList.get(1).goToFloor(passengerCurrentFloor);
            passengerFloorChoice(1);
        }
        else if(rangeElevator1ToPassenger<rangeElevator2ToPassenger){
            this.elevatorList.get(0).goToFloor(passengerCurrentFloor);
            passengerFloorChoice(0);
        }

        else{
            this.elevatorList.get(0).goToFloor(passengerCurrentFloor);
            passengerFloorChoice(0);
        }
    }

    public void goUp(int elevatorNumber, int floorWanted){
        this.elevatorList.get(elevatorNumber).goToFloor(floorWanted);
    }

    public void goDown(int elevatorNumber, int floorWanted){
        this.elevatorList.get(elevatorNumber).goToFloor(floorWanted);
    }
    public static void main(String[] args){
        Building building1 = new Building(5);
        building1.buildingWorking();
    }
}

