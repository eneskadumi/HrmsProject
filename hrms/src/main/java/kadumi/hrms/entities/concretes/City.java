package kadumi.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="cities")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","jobPostings"})
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="city_id")
	private int cityId;
	@Column(name="city_name")
	private String cityName;
	
	
	@OneToMany(mappedBy="city")
	private List<JobPosting> jobPostings;
	
	
	public City() {
		
	}
	
	public City(int cityId, String cityName) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
