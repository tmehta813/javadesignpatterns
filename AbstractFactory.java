package oopsdesign;

public class AbstractFactory {
	
	
	
	public static void main(String[] args) {
		
		HotDrinkFactory factory = new CoffeeFactoryImp();
		factory.prepare(10).consume();
		factory = new TeaFactoryImp();
		factory.prepare(5).consume();
	}

}

interface HotDrink{
	void consume();
}
class Tea implements HotDrink{
	
	@Override
	public void consume() {
		System.out.println("preparing tea");
	}
}

class Coffee implements HotDrink{

	@Override
	public void consume() {
		System.out.println("preparing coffee");
	}
}

interface HotDrinkFactory{
	
	HotDrink prepare(int amount);
}


class CoffeeFactoryImp implements HotDrinkFactory {

	@Override
	public HotDrink prepare(int amount) {
		return new Coffee();
		
	}
}

class TeaFactoryImp implements HotDrinkFactory {

	@Override
	public HotDrink prepare(int amount) {
		return new Tea();
	}
}
