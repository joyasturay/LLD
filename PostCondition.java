class Car {
    protected int speed = 60;

    //Postcondition: Speed must reduce after brake.
   public  void brake() {
        this.speed -= 20;
    }

    public int getSpeed() {
        return speed;
    }
}

class HybridCar extends Car {
    private int charge = 30;

    //Postcondition: Brake should increase the charge and reduce speed.
    @Override
    public void brake() {
        speed -= 20;
        this.charge += 20;
        System.out.println("Hybrid braking. Speed: " + speed + ", Charge: " + charge);
    }

    public int getCharge() {
        return charge;
    }
}
public class PostCondition {
    public static void main(String[] args) {
        Car myVehicle = new HybridCar();
        
        // The user/client expects the speed to drop.
        // Even though HybridCar does extra things (charging), 
        // the core postcondition (slowing down) is still met.
        myVehicle.brake();
    }
}
