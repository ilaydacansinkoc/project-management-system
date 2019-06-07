package domain;

public class Employee extends Person {

	public Employee(int resourceId) {
		super(resourceId);
		
	}

	@Override
	public String toString() {
		return "Employee " + this.getResourceId() + " - " + this.getTaskList();
	}

}
