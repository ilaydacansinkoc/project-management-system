package domain;

import java.util.*;

import dataAccess.Keyboard;

public class Activity {
	
	private int activityNumber;
	private String activityDescription;
	private Calendar activityStartCalendar;
	private String activityDeliverable;
	private int activityHours;
	
	
	private List<Task> taskList;
	
	public Activity(int activityNumber, String activityDescription, Calendar activityStartCalendar, String activityDeliverable){
		
		this.activityNumber = activityNumber;
		this.activityDescription = activityDescription;
		this.activityStartCalendar = activityStartCalendar;
		this.activityDeliverable = activityDeliverable;
		
		
		taskList = new ArrayList<Task>();
		
		this.init();
			
		System.out.println(this.toString() + " in Activity class"); ////////////////////////
	}
	
	public void init() {
		this.addTask();
	}
	
	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public int getActivityNumber() {
		return activityNumber;
	}

	public void setActivityNumber(int activityNumber) {
		this.activityNumber = activityNumber;
	}

	public String getActivityDescription() {
		return activityDescription;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	public Calendar getActivityStartCalendar() {
		return activityStartCalendar;
	}

	public void setActivityStartCalendar(Calendar activityStartCalendar) {
		this.activityStartCalendar = activityStartCalendar;
	}

	public String getActivityDeliverable() {
		return activityDeliverable;
	}

	public void setActivityDeliverable(String activityDeliverable) {
		this.activityDeliverable = activityDeliverable;
	}

	public int getActivityHours() {
		int sumOfHours = 0;
		
		for (Task t : this.getTaskList())
			sumOfHours += t.getTaskHours();
		
		return sumOfHours;
	}


	public Task addTask() {
		
		//TODO belki while ile coklu task alinir
		
		//Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter task number: (in Activity class)");
		int taskNumber = Integer.valueOf(Keyboard.get());
		
		
		System.out.println("Enter task description: (in Activity class)");
		String taskDescription = Keyboard.get();
		
		
		System.out.println("Enter start date of task (DD/MM/YYYY): (in Activity class)");
		String[] splittedCalendar = Keyboard.get().split("/");									
		Calendar taskStartCalendar = Calendar.getInstance();
		taskStartCalendar.set(Integer.valueOf(splittedCalendar[2]), Integer.valueOf(splittedCalendar[1]), Integer.valueOf(splittedCalendar[0]));

		
		System.out.println("Enter task hours: (in Activity class)");
		int taskHours = Integer.valueOf(Keyboard.get());
		
		
		Task task = new Task(taskNumber, taskDescription, taskStartCalendar, taskHours);
		
		//keyboard.close();
		
		this.getTaskList().add(task);
		
		this.activityHours = this.getActivityHours();
		
		return task;
		
	}
	
	public Task removeTask() {
		
		//TODO removeTask
		
		
		
		this.activityHours = this.getActivityHours();
		
		return null;
	}

	@Override
	public String toString() {
		return "Activity [activityNumber=" + activityNumber + ", activityDescription=" + activityDescription
				+ ", activityStartCalendar=" 
				+ activityStartCalendar.get(Calendar.DAY_OF_MONTH) + "/" + activityStartCalendar.get(Calendar.MONTH) + "/" + activityStartCalendar.get(Calendar.YEAR) 
				+ ", activityDeliverable=" + activityDeliverable
				+ ", activityHours=" + this.getActivityHours() + ", taskList=" + taskList + "]";
	}

}
