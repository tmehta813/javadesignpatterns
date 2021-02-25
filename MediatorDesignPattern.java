package oopsdesign;

import java.util.ArrayList;
import java.util.List;

public class MediatorDesignPattern {
	
	public static void main(String[] args) {
		
		ChatMediator mediator = new ChatMediatorImp();
		
		User user1 = new UserImp(mediator, "Tarun");
		User user2 = new UserImp(mediator, "Saachi");
		User user3 = new UserImp(mediator, "Anju");
		mediator.addUser(user1);mediator.addUser(user2);mediator.addUser(user3);
		user1.sendMessage("Hello");
		user2.sendMessage("Hi");
	}

}


interface ChatMediator {
	void sendMessage(User user,String msg);
	void addUser(User user);
}

class ChatMediatorImp implements ChatMediator {
	
	List<User> users=new ArrayList<User>();
	
	void addUsers(User user){
		users.add(user);
	}

	@Override
	public void sendMessage(User user,String msg) {
		
	 for(User user1: users) {
		 if(user1!=user) {
			 user1.receiveMessage(user,msg);
		 }
	 }
	}

	@Override
	public void addUser(User user) {
		users.add(user);
	}
	
}


abstract class User {
	
	ChatMediator mediator;
	protected String name;
	
	public User(ChatMediator med, String name){
		this.mediator=med;
		this.name=name;
	}
	
	abstract void sendMessage(String msg);
	abstract void receiveMessage(User user,String msg);
}


class UserImp extends User {

	public UserImp(ChatMediator med, String name) {
		super(med, name);
	}

	@Override
	void sendMessage(String message) {
		this.mediator.sendMessage(this,message);	
	}

	@Override
	void receiveMessage(User user, String msg) {
		System.out.println(user.name +": "+msg+" to "+this.name);
	}
	
}
