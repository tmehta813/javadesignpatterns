package oopsdesign;

public class FacadePattern {
	
	public static void main(String[] args) {
		
		Kitchen kitchen = new KitchenImp();
		Waiter waiter = new WaiterImp();
		
		Facade facade = new FacadeImp(kitchen, waiter);
		facade.serveCustomer();
		
	}

}


interface Waiter{
	void writeOrder();
	void giveToKitchen();
	void serveOrder();
}

interface Kitchen{
	void prepareOrder();
	void callWaiter();
	void washDishes();
}


class WaiterImp implements Waiter {

	@Override
	public void writeOrder() {
		System.out.println("writing order");	
	}

	@Override
	public void giveToKitchen() {
		System.out.println("order give to kitchen");
	}

	@Override
	public void serveOrder() {
		System.out.println("serve order to customer");
		
	}
	
}



class KitchenImp implements Kitchen {

	@Override
	public void prepareOrder() {
		System.out.println("preparing order");		
	}

	@Override
	public void callWaiter() {
		System.out.println("calling waiter for serving");	
	}

	@Override
	public void washDishes() {
		System.out.println("washing dishes");
	}
	
}


interface Facade {
	void serveCustomer();
}


class FacadeImp implements Facade {
	
  Kitchen kitchen;
  Waiter waiter;
  
  public FacadeImp(Kitchen kitchen, Waiter waiter) {
	this.kitchen= kitchen;
	this.waiter =  waiter;
}

	@Override
	public void serveCustomer() {
		waiter.writeOrder();
		waiter.giveToKitchen();
		kitchen.prepareOrder();
		kitchen.callWaiter();
		waiter.serveOrder();
		kitchen.washDishes();
	}
	
}



