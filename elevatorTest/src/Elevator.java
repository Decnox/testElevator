import java.util.concurrent.TimeUnit;

public class Elevator {
    private int currentFloor;


    public Elevator(){
        this.currentFloor=0;

    }

    public void goToFloor(int floor){

        for (int i=Math.abs(currentFloor-floor); i>0 ; i--){
            if(floor>this.currentFloor){
                this.currentFloor+=1;
            }
            else if(floor<this.currentFloor){
                this.currentFloor-=1;
            }

            System.out.println(this.currentFloor);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
}
