package oopsdesign;

public class DecoratorDesignPattern {
	
	public static void main(String[] args) {
	
    BasePizza pizza = new MargrettaPizza();
    System.out.println("MargrettaPizza price: "+pizza.getPrice());
    BasePizza extraCheese = new ExtraCheeseWithPizza(pizza);
    System.out.println("MargrettaPizza extra cheese price: "+extraCheese.getPrice());
    BasePizza doubleCheese = new ExtraCheeseWithPizza(extraCheese);
    System.out.println("MargrettaPizza double cheese price: "+doubleCheese.getPrice());
	}
}



interface BasePizza {
	int getPrice();
}

class MargrettaPizza implements BasePizza{

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 60;
	}
	
}

class VegPizza implements BasePizza{

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 80;
	}
	
}

class VegLoadedPizza implements BasePizza{

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 100;
	}
}


class ExtraCheeseWithPizza implements BasePizza{
	
	BasePizza pizza;
	
	public ExtraCheeseWithPizza(BasePizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public int getPrice() {
		return pizza.getPrice() + 20;
	}
	
}

