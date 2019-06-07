package domain;

public class Consultant extends Person {

	public Consultant(int resourceId) {
		super(resourceId);
		
	}

	@Override
	public String toString() {
		return "Consultant " + this.getResourceId() + " - " + this.getTaskList();
	}
	
	

}
