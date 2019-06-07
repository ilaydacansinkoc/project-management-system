package presentation;

import java.util.*;
import dataAccess.FileOperations;
import dataAccess.Keyboard;
import domain.*;

public class ProjectPortfolioManager implements IProjectPortfolioManager {
	
	//Scanner scan;
	
	private List<Project> listOfProjects;
	private static List<Resource> listOfResources;
	
	public ProjectPortfolioManager() {
		
		listOfProjects = new ArrayList<Project>();
		
		//listOfProjects = FileOperations.readFile(); TODO
		
		listOfResources = new ArrayList<Resource>();
	}

	public void start() {
		
		
		while(true) {
			for (Project p : listOfProjects)
				System.out.println(p.toString());
			System.out.println(getMainMenu());
			
			//scan = new Scanner(System.in);
			System.out.println("Select operation (Enter q to exit):");
					
			String entry = Keyboard.get();
			
			Project project = null;
			
//			try {
				
				if(entry.equals("q")) {
					Keyboard.close();
					FileOperations.writeFile(listOfProjects);
					System.exit(0);
				}
			
			
				else if (Integer.valueOf(entry) == 1) {
					
					addProject();
					
				}
				
				else if (Integer.valueOf(entry) == 2) {
					
					removeProject(project);
					
				}
				
				else if (Integer.valueOf(entry) == 3) {
					
					//TODO
					updateProject(project);
					
				}
				
				else if (Integer.valueOf(entry) == 4)			
					System.out.println(calculateHours());

				
				else if (Integer.valueOf(entry) == 5)					
					System.out.println(showResourcesAll());
				
				else
					System.out.println("Enter a number which is between 1-5 ! (in PMS class)");
			
//			}
//			catch(Exception e) {
//				System.out.println("Enter a valid entry ! (in PMS class)");
//				continue;
//			}
			//scan.close();
			
		}	
	}

	@Override
	public Project addProject() {
		
		String projectName = "", projectDescription = "";
		System.out.println("Enter name of project: (in PMS class)");
		
		projectName = Keyboard.get();
		
		
		System.out.println("Enter description of project: (in PMS class)");
		
		projectDescription = Keyboard.get();
		
		
		System.out.println("Enter start date of project (DD/MM/YYYY):  (in PMS class)");
		String[] splittedCalendar = Keyboard.get().split("/");									
		Calendar projectStartCalendar = Calendar.getInstance();
		projectStartCalendar.set(Integer.valueOf(splittedCalendar[2]), Integer.valueOf(splittedCalendar[1]), Integer.valueOf(splittedCalendar[0]));
		
		Project project = new Project(projectName, projectDescription, projectStartCalendar);
		
		this.listOfProjects.add(project);
		
				
		return project;
		
	}

	@Override
	public Project removeProject(Project project) {
		System.out.println("Enter a name of project which you want to remove:");
		String willBeRemovedProjectName = Keyboard.get();
		Project removedProject = null;
		for (Project p : listOfProjects)
			if (p.getProjectName().equals(willBeRemovedProjectName)) {
				removedProject = p;
				this.listOfProjects.remove(p);
			}
		
		if (removedProject == null)
			System.out.println("There is no such a project !");
		return removedProject;
	}

	@Override
	public Project updateProject(Project project) {
		// TODO Look at PDF
		return null;
		
	}

	@Override
	public String calculateHours() {
			
		StringBuilder builder = new StringBuilder();
		
		for (Project p : listOfProjects) {
			builder.append("Project " + p.getProjectName() + " - " + p.getProjectHours() + " hours\n");
			for (Activity a : p.getActivityList()) {
				builder.append("    Activity " + a.getActivityNumber() + " - " + a.getActivityHours() + " hours\n");
				for (Task t : a.getTaskList()) {
					builder.append("        Task " + t.getTaskNumber() + " - " + t.getTaskHours() + " hours\n");
				}
			}
			
			System.out.println("---------------------------------\n");
		}
			
		return builder.toString();
		
		
	}

	
	public String function() {
		
		StringBuilder builder = new StringBuilder();
		
		for (Resource r : ProjectPortfolioManager.getListOfResources()) {
			builder.append(r.toString() + "\n");
		}
		
		return builder.toString();
		
	}

	
	public static List<Resource> getListOfResources() {
		return listOfResources;
	}
	
	
	@Override
	public String getMainMenu() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("\n------------------MENU------------------\n\n");
		builder.append("1) Add a project (DONE gibi)\n");
		builder.append("2) Find and remove a project (DONE)\n");
		builder.append("(yapilmadi) 3) Find and update a project\n");
		builder.append("4) Calculate project, activity, and task duration by hours (DONE)\n");
		builder.append("(yapilmadi) 5) Find number of distinct employees and consultants assigned to a project, activity, and task\n");
		
		return builder.toString();
	}

	@Override
	public String showResourcesAll() {
		//TODO showResourcesAll
		return "";
	}

}
