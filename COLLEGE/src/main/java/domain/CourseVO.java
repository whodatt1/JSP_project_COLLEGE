package domain;

public class CourseVO {
	private long csno;
	private long sno;
	private String email;
	private String userName;
	private String courseName;
	private String professorId;
	private String professorName;
	private String courseMajor;
	private String startAt;
	private String endAt;
	
	public CourseVO() {}

	// 수강 등록용 생성자
	public CourseVO(long sno, String email, String userName, String courseName, String professorId, String professorName, String courseMajor, String startAt, String endAt) {
		this.sno = sno;
		this.email = email;
		this.userName = userName;
		this.courseName = courseName;
		this.professorId = professorId;
		this.professorName = professorName;
		this.courseMajor = courseMajor;
		this.startAt = startAt;
		this.endAt = endAt;
	}
	
	// 수강 디테일용 생성자
	public CourseVO(long sno, String email) {
		this.sno = sno;
		this.email = email;
	}

	// 수강 교수용 리스트 생성자
	public CourseVO(long csno, long sno, String email, String userName, String courseName, String startAt, String endAt) {
		this.csno = csno;
		this.sno = sno;
		this.email = email;
		this.userName = userName;
		this.courseName = courseName;
		this.startAt = startAt;
		this.endAt = endAt;
	}
	
	// 학생용 리스트 생성자
	public CourseVO(long csno, String email, String courseName, String professorId, String professorName, String courseMajor, String startAt, String endAt, long sno) {
		this.csno = csno;
		this.sno = sno;
		this.email = email;
		this.courseName = courseName;
		this.professorId = professorId;
		this.professorName = professorName;
		this.courseMajor = courseMajor;
		this.startAt = startAt;
		this.endAt = endAt;
	}
	
	
	public String getProfessorId() {
		return professorId;
	}

	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public String getCourseMajor() {
		return courseMajor;
	}

	public void setCourseMajor(String courseMajor) {
		this.courseMajor = courseMajor;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getCsno() {
		return csno;
	}

	public void setCsno(long csno) {
		this.csno = csno;
	}

	public long getSno() {
		return sno;
	}

	public void setSno(long sno) {
		this.sno = sno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getStartAt() {
		return startAt;
	}

	public void setStartAt(String startAt) {
		this.startAt = startAt;
	}

	public String getEndAt() {
		return endAt;
	}

	public void setEndAt(String endAt) {
		this.endAt = endAt;
	}

	@Override
	public String toString() {
		return "CourseVO [csno=" + csno + ", sno=" + sno + ", email=" + email + ", userName=" + userName
				+ ", courseName=" + courseName + ", professorId=" + professorId + ", professorName=" + professorName
				+ ", courseMajor=" + courseMajor + ", startAt=" + startAt + ", endAt=" + endAt + "]";
	}


	
}	
