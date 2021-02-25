package oopsdesign;

public class BridgePattern {
	
	public static void main(String[] args) {
		
		Gear gearManual = new ManualGear();
		Gear gearAutomatic = new AutoMaticGear();
		Vehicle vehicle = new Car(gearManual);
		Vehicle vehicleTruck = new Truck(gearAutomatic);
		vehicle.addGear();
		vehicleTruck.addGear();
		
	}
}


interface Gear {
	void handleGear();
}

class ManualGear implements Gear{

	@Override
	public void handleGear() {
		System.out.println("handle manyal gear");
	}
}


class AutoMaticGear implements Gear {

	@Override
	public void handleGear() {
		System.out.println("handle automatic gear");
	}
	
}


abstract class Vehicle{
	
	Gear gear;
	Vehicle(Gear  gear){
		this.gear = gear;
	}
   abstract void addGear();
}

class Car extends Vehicle{
	
	Car(Gear gear){
		super(gear);
	}

	@Override
	public void addGear() {
		gear.handleGear();
	}
}


class Truck extends Vehicle{

	Truck(Gear gear) {
		super(gear);
	}

	@Override
	public void addGear() {
		gear.handleGear();
	}
}
