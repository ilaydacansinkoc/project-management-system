package domain;

import java.util.ArrayList;
import java.util.List;

import presentation.ProjectPortfolioManager;

public class Resource {
	
	private int resourceId;
	private List<Task> taskList;
	
	
	public Resource(int resourceId) {
		this.setResourceId(resourceId);
		setTaskList(new ArrayList<Task>());
		addToPortfolio();
	}

	public boolean isThereInPortfolio() {
		
		boolean isThere = false;
		
		for (Resource r : ProjectPortfolioManager.getListOfResources())
			if(r.resourceId == this.resourceId)
				isThere = true;
		
		return isThere;
		
	}
	
	private void addToPortfolio() {
		
		if(!isThereInPortfolio())
			ProjectPortfolioManager.getListOfResources().add(this);
		else
			System.out.println(this.toString() + " is there already");
			
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		if (resourceId > 0)
			this.resourceId = resourceId;
		else
			System.out.println("Resource ID must be bigger than 0 !");
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public void add(Task task) {
		
		if(isThereInPortfolio()) {
			for (Resource r : ProjectPortfolioManager.getListOfResources()) {
				if(r.getResourceId() == this.resourceId)
					r.getTaskList().add(task);
			}
		}
			
	}

}
