package ShoppingMall.VO;

public class CustomerVO {

	private String id;
	private String password;
	private String name;
	private String gender;
	private String tel;
	private String address;
	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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
	
	@Override
	public String toString() {
		return "아이디: " + id + "\n패스워드: " + password + "\n이름: " + name + "\n성별: " + gender + "\n전화번호: " + tel + "\n주소: " + address + "\n이메일: " + email;
	}

}
