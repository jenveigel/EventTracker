package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Activity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name="difficulty_level")
	private String level;
		//change to ENUM
	
	@Column(name="duration_in_hrs")
	private double duration;
	
	private String day;
		//change to ENUM

	
	//gets and sets
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getId() {
		return id;
	}

	
	//toString
	@Override
	public String toString() {
		return "Activity [id=" + id + ", name=" + name + ", level=" + level + ", duration=" + duration + ", day=" + day
				+ "]";
	}
	
	
	
}
