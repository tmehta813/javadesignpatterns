package oopsdesign;


public class BuilderPattern {

	public String name;

	// address
	public String streetAddress, postalCode, city;

	// work
	public String companyName, position;
	public long anualIncome;
	
	
	public static void main(String[] args) {
		PersonBuilder builder = new PersonBuilder();
		BuilderPattern person = builder
		.withName("Tarun")
		.lives()
		  .at("South west")
		  .in("Delhi")
		  .withPostalCode("110064")
		.works()
		 .at("xyz")
		 .position("senior software engineer")
		 .annualIncome(1234567)
		 .build();
	
		System.out.println(person.toString());   
   
		
	}

}



class PersonBuilder {

	public BuilderPattern person = new BuilderPattern();

	PersonBuilder withName(String name) {
		person.name=name;
		return this;
	}

	AddressBuilder lives() {
		return new AddressBuilder(person);
	}
	
	WorkBuilder works() {
		return new WorkBuilder(person);
	}

	BuilderPattern build() {
		return person;
	}

}

class AddressBuilder extends PersonBuilder {


	public AddressBuilder(BuilderPattern person) {
		this.person = person;
	}

	public AddressBuilder at(String address) {
		person.streetAddress = address;
		return this;
	}

	public AddressBuilder withPostalCode(String postalCode) {
		person.postalCode = postalCode;
		return this;
	}

	public AddressBuilder in(String city) {
		person.city = city;
		return this;
	}


}

class WorkBuilder extends PersonBuilder{

	public WorkBuilder(BuilderPattern person) {
		this.person = person;
	}

	public WorkBuilder position(String position) {
		person.position = position;
		return this;
	}

	public WorkBuilder at(String companyName) {
		person.companyName = companyName;
		return this;
	}
	WorkBuilder annualIncome(long income) {
		person.anualIncome = income;
		return this;
	}

}
