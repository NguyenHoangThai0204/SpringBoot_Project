package iuh.modal;

import java.time.LocalDate;

@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "user")
public class User {
	@jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	@jakarta.persistence.Id
	@jakarta.persistence.Column(name = "id")
	private int id;
	@jakarta.persistence.Column(name = "username")
	private String username;
	@jakarta.persistence.Column(name = "password")
	private String password;
	@jakarta.persistence.Column(name = "full_name")
	private String fullName;
	@jakarta.persistence.Column(name = "birthday")
	private LocalDate birthday;
	@jakarta.persistence.Column(name ="sex")
	private String sex;
	@jakarta.persistence.Column(name = "address")
	private String address;
	@jakarta.persistence.Column(name = "email")
	private String email;
	@jakarta.persistence.Column(name = "phone")
	private String phone;
	@jakarta.persistence.Column(name = "role")
	private Boolean role;
	
	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", fullName=" + fullName
				+ ", birthday=" + birthday + ", sex=" + sex + ", address=" + address + ", email=" + email + ", phone="
				+ phone + ", role=" + role + "]";
	}

	public User(String username, String password, String fullName, LocalDate birthday, String sex, String address,
			String email, String phone, Boolean role) {
		super();
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.role = role;
	}

	public User(String username, String password, String fullName, LocalDate birthday, String sex, String address,
			String email, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getRole() {
		return role;
	}

	public void setRole(Boolean role) {
		this.role = role;
	}
	
	
	
}
