package oopsdesign;

public class VisitorDesignPattern {
	
	public static void main(String[] args) {
		
		ItemElement[] items = new ItemElement[] {new Book(10,"1234"),new Fruit(20,5,"Apple")};
		int price = 0;
		ShoppingCartVisitor visititem = new ShoppingCartVisitorImpl();
		for(ItemElement item: items) {
			price = price+ item.accept(visititem);
		}
		System.out.println("price: "+price);
	}
}


interface ItemElement 
{ 
    public int accept(ShoppingCartVisitor visitor); 
} 
  
class Book implements ItemElement 
{ 
    private int price; 
    private String isbnNumber; 
   
    public Book(int cost, String isbn) 
    { 
        this.price=cost; 
        this.isbnNumber=isbn; 
    } 
   
    public int getPrice()  
    { 
        return price; 
    } 
   
    public String getIsbnNumber()  
    { 
        return isbnNumber; 
    } 
   
    @Override
    public int accept(ShoppingCartVisitor visitor)  
    { 
        return visitor.visit(this); 
    } 
   
} 
  
class Fruit implements ItemElement  
{ 
    private int pricePerKg; 
    private int weight; 
    private String name; 
   
    public Fruit(int priceKg, int wt, String nm) 
    { 
        this.pricePerKg=priceKg; 
        this.weight=wt; 
        this.name = nm; 
    } 
   
    public int getPricePerKg()  
    { 
        return pricePerKg; 
    } 
   
    public int getWeight()  
    { 
        return weight; 
    } 
   
    public String getName() 
    { 
        return this.name; 
    } 
   
    @Override
    public int accept(ShoppingCartVisitor visitor)  
    { 
        return visitor.visit(this); 
    } 
   
} 
  
interface ShoppingCartVisitor  
{ 
   
    int visit(Book book); 
    int visit(Fruit fruit); 
} 
  
class ShoppingCartVisitorImpl implements ShoppingCartVisitor 
{ 
   
    @Override
    public int visit(Book book) 
    { 
        int cost=0; 
        //apply 5$ discount if book price is greater than 50 
        if(book.getPrice() > 50) 
        { 
            cost = book.getPrice()-5; 
        } 
        else 
            cost = book.getPrice(); 
              
        System.out.println("Book ISBN::"+book.getIsbnNumber() + " cost ="+cost); 
        return cost; 
    } 
   
    @Override
    public int visit(Fruit fruit)  
    { 
        int cost = fruit.getPricePerKg()*fruit.getWeight(); 
        System.out.println(fruit.getName() + " cost = "+cost); 
        return cost; 
    } 
   
} 
  
class ShoppingCartClient  
{ 
   
    public static void main(String[] args)  
    { 
        ItemElement[] items = new ItemElement[]{new Book(20, "1234"), 
                              new Book(100, "5678"), new Fruit(10, 2, "Banana"), 
                              new Fruit(5, 5, "Apple")}; 
   
        int total = calculatePrice(items); 
        System.out.println("Total Cost = "+total); 
    } 
   
    private static int calculatePrice(ItemElement[] items)  
    { 
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl(); 
        int sum=0; 
        for(ItemElement item : items) 
        { 
            sum = sum + item.accept(visitor); 
        } 
        return sum; 
    } 
   
} 