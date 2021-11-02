package dev.xeo.srrtplanner.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "tasks")
public class Task {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotEmpty(message = "Task name field required")
	@Column(name = "task_name")
	private String taskName;

	@NotEmpty(message = "Task category field required")
	@Column(name = "category")
	private String category;

	@Min(value = 1)
	@Max(value = 5)
	@Column(name = "priority")
	private int priority;

	@NotEmpty(message = "Task description field required")
	@Column(name = "description")
	private String description;

	public Task() {

	}

	public Task(int id, String taskName, String category, int priority, String description) {
		this.id = id;
		this.taskName = taskName;
		this.category = category;
		this.priority = priority;
		this.description = description;
	}

	public Task(String taskName, String category, int priority, String description) {
		this.taskName = taskName;
		this.category = category;
		this.priority = priority;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Task{" +
				"id=" + id +
				", taskName='" + taskName + '\'' +
				", category='" + category + '\'' +
				", priority=" + priority +
				", description='" + description + '\'' +
				'}';
	}
}



