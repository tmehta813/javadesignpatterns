package oopsdesign;

public class IteratorPattern {

	public static void main(String[] args) {
		
		Iterator iterate = new NameRepository().getIterator();
		while(iterate.hasNext()) {
			System.out.println(iterate.next()+"");
		}
		
	}
}


interface Iterator {
	boolean hasNext();
	Object next();
}

interface Container {
	Iterator getIterator();
}


 class NameRepository implements Container {
	
	int index = 0;
	String name[] = {"name1","name2","name3","name4"};

	
	class NameIterator implements Iterator{

		@Override
		public boolean hasNext() {
			if(index<name.length) return true;
			return false;
		}

		@Override
		public Object next() {
			return name[index++];
		}
		
	}
	

	@Override
	public Iterator getIterator() {
		// TODO Auto-generated method stub
		return new NameIterator();
	}

	
}