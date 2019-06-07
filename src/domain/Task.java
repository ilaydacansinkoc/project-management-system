package domain;

import java.util.*;

import dataAccess.Keyboard;

public class Task {

	private int taskNumber;
	private String taskDescription;
	private Calendar taskStartCalendar;
	private int taskHours;
	private int taskResourceId;
	
	public Task(int taskNumber, String taskDescription, Calendar taskStartCalendar, int taskHours) {
		this.setTaskNumber(taskNumber);
		this.setTaskDescription(taskDescription);
		this.setTaskStartCalendar(taskStartCalendar);
		this.setTaskHours(taskHours);
		
		this.init();
		System.out.println(this.toString() + " in Task class"); ////////////////////////
	}
	
	public void init() {
		this.setTaskResourceId();
	}

	public int getTaskNumber() {
		return taskNumber;
	}

	public void setTaskNumber(int taskNumber) {
		this.taskNumber = taskNumber;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public Calendar getTaskStartCalendar() {
		return taskStartCalendar;
	}

	public void setTaskStartCalendar(Calendar taskStartCalendar) {
		this.taskStartCalendar = taskStartCalendar;
	}

	public int getTaskHours() {
		return taskHours;
	}

	public void setTaskHours(int taskHours) {
		this.taskHours = taskHours;
	}

	public int getTaskResourceId() {
		return taskResourceId;
	}

	public void setTaskResourceId() {
		
		//Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter resource type (in Task class):");
		String personType = Keyboard.get();
		
		
		System.out.println("Enter resource ID (in Task class):");
		int resourceId = Integer.valueOf(Keyboard.get());
		
		Resource resource = null;
		if ( resourceId > 0 ) {
			
			this.taskResourceId = resourceId;
			
			if (personType.substring(0, 1).toUpperCase().equals("E"))
				resource = new Employee(resourceId);
			else if (personType.substring(0, 1).toUpperCase().equals("C"))
				resource = new Consultant(resourceId);
			else
				System.out.println("Enter a valid person type (in Task class)");		
		}
		
		else
			System.out.println("Resource ID must be greater than 0 ! (in Task class)");
		
		
		resource.add(this);
		
		
		//keyboard.close();
	}

	@Override
	public String toString() {
		return "Task [taskNumber=" + taskNumber + ", taskDescription=" + taskDescription + ", taskStartCalendar="
				+ taskStartCalendar.get(Calendar.DAY_OF_MONTH) + "/" + taskStartCalendar.get(Calendar.MONTH) + "/" + taskStartCalendar.get(Calendar.YEAR)
				+ ", taskHours=" + taskHours + ", taskResourceId=" + taskResourceId + "]";
	}

	
}
