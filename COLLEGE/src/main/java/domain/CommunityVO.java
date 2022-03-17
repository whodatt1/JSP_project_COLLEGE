package domain;

public class CommunityVO {
	private long cno;
	private String id;
	private String writer;
	private String title;
	private String content;
	private String regAt;
	private String modAt;
	private int readCount;
	private String imageFile;
	
	public CommunityVO() {}
	
	// 커뮤니티 글 등록용 생성자
	public CommunityVO(String writer, String id, String title, String content, String imageFile) {
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.imageFile = imageFile;
	}
	
	// 커뮤니티 글 리스트용 생성자
	public CommunityVO(long cno, String id, String writer, String title, String modAt, int readCount, String imageFile) {
		this.cno = cno;
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.modAt = modAt;
		this.readCount = readCount;
		this.imageFile = imageFile;
	}
	
	// 커뮤니티 글 디테일용 생성자
	public CommunityVO(long cno, String id, String writer, String title, String content, String modAt, int readCount, String imageFile) {
		this.cno = cno;
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.modAt = modAt;
		this.readCount = readCount;
		this.imageFile = imageFile;
	}
	
	// 커뮤니티 글 수정용 생성자
	public CommunityVO(long cno, String title, String content, String imageFile) {
		this.cno = cno;
		this.title = title;
		this.content = content;
		this.imageFile = imageFile;
	}
	
	// 커뮤니티 조회수용 생성자
	public CommunityVO(long cno, int readCount) {
		this.cno = cno;
		this.readCount = readCount;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getCno() {
		return cno;
	}

	public void setCno(long cno) {
		this.cno = cno;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	@Override
	public String toString() {
		return "CommunityVO [cno=" + cno + ", id=" + id + ", writer=" + writer + ", title=" + title + ", content="
				+ content + ", regAt=" + regAt + ", modAt=" + modAt + ", readCount=" + readCount + ", imageFile="
				+ imageFile + "]";
	}

}
