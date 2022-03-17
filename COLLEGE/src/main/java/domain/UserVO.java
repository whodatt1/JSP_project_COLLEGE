package domain;

public class UserVO {
	private String email;
	private String pwd;
	private String userName;
	private String regAt;
	private String lastLogin;
	private int grade;
	private String major;
	
	public UserVO() {}
	
	// 로그인용 생성자
	public UserVO(String email, String pwd) {
		this.email = email;
		this.pwd = pwd;
	}

	// 유저 등록용 생성자
	public UserVO(String email, String pwd, String userName, int grade, String major) {
		this.email = email;
		this.pwd = pwd;
		this.userName = userName;
		this.grade = grade;
		this.major = major;
	}
	
	// 유저 수정용 생성자
	public UserVO(String email, String pwd, String userName, String major) {
		this.email = email;
		this.pwd = pwd;
		this.userName = userName;
		this.major = major;
	}
	
	// 유저 직급 수정용 생성자
	public UserVO(String email, int grade) {
		this.email = email;
		this.grade = grade;
	}

	// 유저 리스트용 생성자
	public UserVO(String email, String userName, String regAt, String lastLogin, int grade, String major) {
		this.email = email;
		this.userName = userName;
		this.regAt = regAt;
		this.lastLogin = lastLogin;
		this.grade = grade;
		this.major = major;
	}
	

	// 유저 디테일용 생성자
	public UserVO(String email, String pwd, String userName, String regAt, String lastLogin, int grade, String major) {
		this.email = email;
		this.pwd = pwd;
		this.userName = userName;
		this.regAt = regAt;
		this.lastLogin = lastLogin;
		this.grade = grade;
		this.major = major;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRegAt() {
		return regAt;
	}

	public void setRegAt(String regAt) {
		this.regAt = regAt;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "UserVO [email=" + email + ", pwd=" + pwd + ", userName=" + userName + ", regAt=" + regAt
				+ ", lastLogin=" + lastLogin + ", grade=" + grade + ", major=" + major + "]";
	}
}
