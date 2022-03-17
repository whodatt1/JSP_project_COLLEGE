package domain;

public class ReplyVO {
	private long rpno;
	private long cno;
	private String id;
	private String replier;
	private String content;
	private String regAt;
	private String modAt;
	
	public ReplyVO() {}
	
	// 커뮤니티 댓글 등록용 생성자
	public ReplyVO(long cno, String id, String replier, String content) {
		this.cno = cno;
		this.id = id;
		this.replier = replier;
		this.content = content;
	}
	
	// 커뮤니티 댓글 리스트용 생성자
	public ReplyVO(long rpno, long cno, String id, String replier, String content, String modAt) {
		this.rpno = rpno;
		this.cno = cno;
		this.id = id;
		this.replier = replier;
		this.content = content;
		this.modAt = modAt;
	}
	
	// 커뮤니티 댓글 수정용 생성자
	public ReplyVO(long rpno, String content) {
		this.rpno = rpno;
		this.content = content;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getRpno() {
		return rpno;
	}

	public void setRpno(long rpno) {
		this.rpno = rpno;
	}

	public long getCno() {
		return cno;
	}

	public void setCno(long cno) {
		this.cno = cno;
	}

	public String getReplier() {
		return replier;
	}

	public void setReplier(String replier) {
		this.replier = replier;
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
		return "ReplyVO [rpno=" + rpno + ", cno=" + cno + ", id=" + id + ", replier=" + replier + ", content=" + content
				+ ", regAt=" + regAt + ", modAt=" + modAt + "]";
	}
	
}
