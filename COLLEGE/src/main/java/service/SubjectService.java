package service;

import java.util.List;

import domain.SubjectVO;

public interface SubjectService {
	public int register(SubjectVO svo);
	public List<SubjectVO> getList();
	public SubjectVO getDetail(long sno);
	public int modify(SubjectVO svo);
	public int remove(long sno);
	public int pAttends(SubjectVO svo);
	public int mAttends(SubjectVO svo);
	public List<SubjectVO> getList(long sno);
}
