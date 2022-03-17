package domain;

public class SubjectVO {
	private long sno;
	private String title;
	private String id;
	private String writer;
	private String major;
	private String description;
	private String imageFile;
	private int classLimit;
	private int attends;
	private String startAt;
	private String endAt;
	private String regAt;
	private String modAt;
	
	public SubjectVO() {}
	
	
	public SubjectVO(long sno, int attends) {
		this.sno = sno;
		this.attends = attends;
	}



	// 강의 등록용 생성자
	public SubjectVO(String title, String id, String writer, String major, String description, String imageFile, int classLimit,
			String startAt, String endAt) {
		this.title = title;
		this.id = id;
		this.writer = writer;
		this.major = major;
		this.description = description;
		this.imageFile = imageFile;
		this.classLimit = classLimit;
		this.startAt = startAt;
		this.endAt = endAt;
	}
	
	// 강의 리스트용 생성자
	public SubjectVO(long sno, String title, String id, String writer, String major, String description, String imageFile, int classLimit, int attends,
			String startAt) {
		this.sno = sno;
		this.title = title;
		this.id = id;
		this.writer = writer;
		this.major = major;
		this.description = description;
		this.imageFile = imageFile;
		this.classLimit = classLimit;
		this.attends = attends;
		this.startAt = startAt;
	}
	
	// 강의 수정용 생성자
	public SubjectVO(long sno, String title, String major, String description, String imageFile, int classLimit,
			String startAt, String endAt) {
		this.sno = sno;
		this.title = title;
		this.major = major;
		this.description = description;
		this.imageFile = imageFile;
		this.classLimit = classLimit;
		this.startAt = startAt;
		this.endAt = endAt;
	}
	
	// 강의 디테일용 생성자
	public SubjectVO(long sno, String title, String id, String writer, String major, String description, String imageFile, int classLimit,
			int attends, String startAt, String endAt, String modAt) {
		this.sno = sno;
		this.title = title;
		this.id = id;
		this.writer = writer;
		this.major = major;
		this.description = description;
		this.imageFile = imageFile;
		this.classLimit = classLimit;
		this.attends = attends;
		this.startAt = startAt;
		this.endAt = endAt;
		this.modAt = modAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getSno() {
		return sno;
	}

	public void setSno(long sno) {
		this.sno = sno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public int getClassLimit() {
		return classLimit;
	}

	public void setClassLimit(int classLimit) {
		this.classLimit = classLimit;
	}

	public int getAttends() {
		return attends;
	}

	public void setAttends(int attends) {
		this.attends = attends;
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

	public String getRegAt() {
		return regAt;
	}

	public void setRegAt(String regAt) {
		this.regAt = regAt;
	}

	public String getModAt() {
		return modAt;
	}

	public void setModAt(String modAt) {
		this.modAt = modAt;
	}

	@Override
	public String toString() {
		return "SubjectVO [sno=" + sno + ", title=" + title + ", id=" + id + ", writer=" + writer + ", major=" + major
				+ ", description=" + description + ", imageFile=" + imageFile + ", classLimit=" + classLimit
				+ ", attends=" + attends + ", startAt=" + startAt + ", endAt=" + endAt + ", regAt=" + regAt + ", modAt="
				+ modAt + "]";
	}

	
}
