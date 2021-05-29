package kadumi.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employers")
public class Employer extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employer_id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_address")
	private String webAddress;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="is_activated")
	private boolean isActivated;

	
	
	
	@OneToMany(mappedBy="employer")
	private List<JobPosting> jobPostings;
	
	
	
	
	public Employer() {
		
	}
	
	public Employer(int id, String companyName, String webAddress, String phoneNumber, boolean isActivated) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.webAddress = webAddress;
		this.phoneNumber = phoneNumber;
		this.isActivated = isActivated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isActivated() {
		return isActivated; 
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}
	
	
	

}
