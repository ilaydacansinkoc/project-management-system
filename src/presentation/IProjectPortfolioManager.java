package presentation;

import domain.Project;

public interface IProjectPortfolioManager {
	
	public void start();
	
	public Project addProject();
	
	public Project removeProject(Project project);
	
	public Project updateProject(Project project);
	
	public String calculateHours(); //Calculating project, activity, and task duration by hours
	
	public String showResourcesAll();  //Finding number of distinct employees and consultants assigned to a project, activity, and task
	
	public String getMainMenu();

}
