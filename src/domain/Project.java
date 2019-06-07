package domain;

import java.io.Serializable;
import java.util.*;

import dataAccess.Keyboard;

public class Project implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String projectName;
	private String projectDescription;
	private Calendar projectStartCalendar;
	private int projectHours;
	
	private List<Activity> activityList;
	
	public Project(String projectName, String projectDescription, Calendar projectStartCalendar) {
		
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectStartCalendar = projectStartCalendar;
		
		this.activityList = new ArrayList<Activity>();
		
		this.init();
		
		System.out.println(this.toString() + " in Project class"); ////////////////////////
	}
	
	public void init() {
		this.addActivity();
	}

	public List<Activity> getActivityList() {
		return activityList;
	}

	public void setActivityList(List<Activity> activityList) {
		this.activityList = activityList;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public Calendar getProjectStartCalendar() {
		return projectStartCalendar;
	}

	public void setProjectStartCalendar(Calendar projectStartCalendar) {
		this.projectStartCalendar = projectStartCalendar;
	}
	
	public int getProjectHours() {
		int sumOfHours = 0;
		
		for (Activity a : this.getActivityList())
			sumOfHours += a.getActivityHours();
		
		return sumOfHours;
	}
	
	public Activity addActivity() {
		
		//TODO belki while ile coklu activity alinir
		
		//Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter activity number: (in Project class)");
		int activityNumber = Integer.valueOf(Keyboard.get());
		
		
		System.out.println("Enter activity description: (in Project class)");
		String activityDescription = Keyboard.get();
		
		System.out.println("Enter start date of activity (DD/MM/YYYY): (in Project class)");
		String[] splittedCalendar = Keyboard.get().split("/");									
		Calendar activityStartCalendar = Calendar.getInstance();
		activityStartCalendar.set(Integer.valueOf(splittedCalendar[2]), Integer.valueOf(splittedCalendar[1]), Integer.valueOf(splittedCalendar[0]));

		
		System.out.println("Enter activity deliverable: (in Project class)");
		String activityDeliverable = Keyboard.get();
		
		
		Activity activity = new Activity(
				activityNumber,
				activityDescription,
				activityStartCalendar,
				activityDeliverable);
		
		//keyboard.close();
		
		this.getActivityList().add(activity);
		
		this.projectHours = this.getProjectHours();
		
		return activity;
		
	}
	
	public Activity removeActivity() {
		
		//TODO removeActivity
		
		
		
		this.projectHours = this.getProjectHours();
		
		return null;
	}

	@Override
	public String toString() {
		return "Project [projectName=" + projectName + ", projectDescription=" + projectDescription
				+ ", projectStartCalendar=" 
				+ projectStartCalendar.get(Calendar.DAY_OF_MONTH) + "/" + projectStartCalendar.get(Calendar.MONTH) + "/" + projectStartCalendar.get(Calendar.YEAR) 
				+ ", projectHours= " + this.getProjectHours() +
				", activityList=" + activityList + "]";
	}
	
}
