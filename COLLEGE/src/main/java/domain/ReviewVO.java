package domain;

public class ReviewVO {
	private long rvno;
	private long sno;
	private String title;
	private String id;
	private String writer;
	private int score;
	private String content;
	private String regAt;
	private String modAt;
	
	public ReviewVO() {}
	
	// 강의 리뷰 등록용 생성자
	public ReviewVO(long sno, String title, String id, String writer, int score, String content) {
		this.sno = sno;
		this.title = title;
		this.id = id;
		this.writer = writer;
		this.score = score;
		this.content = content;
	}

	// 강의 리뷰 리스트용 생성자
	public ReviewVO(long rvno, long sno, String title, String id, String writer, int score, String content, String modAt) {
		this.rvno = rvno;
		this.sno = sno;
		this.title = title;
		this.id = id;
		this.writer = writer;
		this.score = score;
		this.content = content;
		this.modAt = modAt;
	}
	
	// 강의 리뷰 수정용 생성자
	public ReviewVO(long rvno, String title, int score, String content) {
		this.rvno = rvno;
		this.title = title;
		this.score = score;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getRvno() {
		return rvno;
	}

	public void setRvno(long rvno) {
		this.rvno = rvno;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return "ReviewVO [rvno=" + rvno + ", sno=" + sno + ", title=" + title + ", id=" + id + ", writer=" + writer
				+ ", score=" + score + ", content=" + content + ", regAt=" + regAt + ", modAt=" + modAt + "]";
	}

	
}
