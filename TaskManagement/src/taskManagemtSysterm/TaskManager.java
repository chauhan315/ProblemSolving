package taskManagemtSysterm;


import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

	static int id = 0;

	public static void main(String[] args) {
		ArrayList<Task> list = new ArrayList<Task>();
//		TaskManager tm = new TaskManager();
//		Task task = new Task();

		menuOptions(list);
	}

	public static void menuOptions(ArrayList<Task> list) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Select the option:");
			System.out.println("1: Show all the task");
			System.out.println("2: Add a task");
			System.out.println("3: Delete a task");
			System.out.println("4: Update a task");
			System.out.println("5: View task by priority");
			System.out.println("6: to exit the menu");

			int option = sc.nextInt();

			switch (option) {
			case 1:
				showAll(list);
				break;

			case 2:
				addTask(list);
				break;

			case 3:
				deleteTask(list);
				break;

			case 4:
				updateTaskById(list);
				break;

			case 5:
				priorityView(list);
				break;

			case 6:
				sc.close();
				break;

			default:
				sc.close();
				throw new IllegalArgumentException("Unexpected value: Give a numwerical value from 1-5" + option);

			}
		}
	}

	private static void priorityView(ArrayList<Task> list) {
		ArrayList<Task> high = new ArrayList<Task>();
		ArrayList<Task> mid = new ArrayList<Task>();
		ArrayList<Task> low = new ArrayList<Task>();

		for (Task task : list) {
			String priorityOfTask = task.getPriority();

			if (priorityOfTask.equals("high")) {
				high.add(task);
			} else if (priorityOfTask.equals("mid")) {
				mid.add(task);
			} else {
				low.add(task);
			}
		}

		System.out.println("1: To view all by priority, 2: High, 3: mid, 4: low");

		Scanner sc = new Scanner(System.in);
		int priorityOp = sc.nextInt();

		if (priorityOp == 1) {
			System.out.println("High Priority");
			System.out.println(high);
			
			System.out.println("Mid Priority");
			System.out.println(mid);
			
			System.out.println("Low Priority");
			System.out.println(low);
			
		} else if (priorityOp == 2) {
			System.out.println(high);
		} else if (priorityOp == 3) {
			System.out.println(mid);
		} else {
			System.out.println(low);
		}

	}

	private static void updateTaskById(ArrayList<Task> list) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Id of the task to be updated");
		int Id = sc.nextInt();

		Task tasktoUpdate = null;

		for (Task tsk : list) {
			if (tsk.getId() == Id) {
				tasktoUpdate = tsk;
			}
		}

		if (tasktoUpdate == null) {
			System.out.println("Task with ID " + id + " not found.");
			return;
		}

		System.out.println("What to update: 1-title, 2-description, 3-priority");
		int upOpt = sc.nextInt();

		switch (upOpt) {
		case 1:
			System.out.println("Enter new title: ");
			String newTitle = sc.next();
			tasktoUpdate.setTitle(newTitle);
			list.removeIf(task -> task.getId() == id);
			list.add(tasktoUpdate);
			break;

		case 2:
			System.out.println("Enter new description: ");
			String newDescription = sc.next();
			tasktoUpdate.setTitle(newDescription);
			list.removeIf(task -> task.getId() == id);
			list.add(tasktoUpdate);
			break;

		case 3:
			System.out.println("Enter new pririty: ");
			String newPriority = sc.next();
			tasktoUpdate.setTitle(newPriority);
			list.removeIf(task -> task.getId() == id);
			list.add(tasktoUpdate);
			break;

		default:
			System.out.println("Enter correct value");
		}

	}

	private static void deleteTask(ArrayList<Task> list) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter task id to be deleted");
		int Id = sc.nextInt();

		try {
			list.remove(Id - 1);
			System.out.println("Task deleted succesfully");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Task with this id not available");
		}

	}

	private static void addTask(ArrayList<Task> list) {
		Scanner sc = new Scanner(System.in);

		++id;
		System.out.println("Enter title, description, priority.");

		String title = sc.nextLine();

		String description = sc.nextLine();

		String priority = sc.nextLine();

		list.add(new Task(id, title, description, priority));

	}

	private static void showAll(ArrayList<Task> list) {
		for (Task task : list) {
			System.out.println(task);
		}
	}

}
