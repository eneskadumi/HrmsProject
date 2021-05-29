package kadumi.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="job_titles")
public class JobTitle {
	
	@Id
	@GeneratedValue
	
	
	@Column(name="title_id")
	private int id;
	
	@Column(name="title")
	private String title;

	
	
	@OneToMany(mappedBy="employer")
	private List<JobPosting> jobPostings;
	
	
	
	public JobTitle() {
		
	}
	
	public JobTitle(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
