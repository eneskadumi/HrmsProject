package kadumi.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="job_postings")
public class JobPosting {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="posting_id")
	private int postingId;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="open_position_number")
	private int openPositionNumber;
	
	@Column(name="application_deadline")
	private LocalDate deadline;
	
	@Column(name="is_active")
	private boolean isActive;

	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	
	@ManyToOne()
	@JoinColumn(name="title_id")
	private JobTitle jobTitle;
	
	
	public JobPosting() {
		
	}
	
	public JobPosting(int postingId, String jobDescription, double minSalary, double maxSalary,
			int openPositionNumber, LocalDate deadline, boolean isActive) {
		super();
		this.postingId = postingId;
		this.jobDescription = jobDescription;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.openPositionNumber = openPositionNumber;
		this.deadline = deadline;
		this.isActive = isActive;
	}

	public int getJobPostingId() {
		return postingId;
	}

	public void setJobPostingId(int postingId) {
		this.postingId = postingId;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}

	public double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}

	public int getOpenPositionNumber() {
		return openPositionNumber;
	}

	public void setOpenPositionNumber(int openPositionNumber) {
		this.openPositionNumber = openPositionNumber;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
