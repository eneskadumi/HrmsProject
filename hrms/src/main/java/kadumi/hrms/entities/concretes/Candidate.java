package kadumi.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="candidates")
public class Candidate extends User{
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNo;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	
	public Candidate() {
		 
	}


	public Candidate(int id, String firstName, String lastName, String identityNo, Date birthDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.identityNo = identityNo;
		this.birthDate = birthDate;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getIdentityNo() {
		return identityNo;
	}


	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	


}
