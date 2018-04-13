// default package
// Generated 2018. 4. 12 ���� 3:51:31 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EmpDetail generated by hbm2java
 */
@Entity
@Table(name = "emp_detail")
public class EmpDetail implements java.io.Serializable {

	private long pkid;
	private Integer empId;
	private String address1;
	private String address2;
	private String city;
	private String zip;
	private String country;

	public EmpDetail() {
	}

	public EmpDetail(long pkid) {
		this.pkid = pkid;
	}

	public EmpDetail(long pkid, Integer empId, String address1, String address2, String city, String zip,
			String country) {
		this.pkid = pkid;
		this.empId = empId;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}

	@Id

	@Column(name = "pkid", unique = true, nullable = false)
	public long getPkid() {
		return this.pkid;
	}

	public void setPkid(long pkid) {
		this.pkid = pkid;
	}

	@Column(name = "emp_id")
	public Integer getEmpId() {
		return this.empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	@Column(name = "address1", length = 50)
	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "address2", length = 50)
	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "city", length = 50)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "zip", length = 10)
	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "country", length = 20)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
