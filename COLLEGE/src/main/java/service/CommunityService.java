package service;

import java.util.List;

import domain.CommunityVO;

public interface CommunityService {
	public int register(CommunityVO cvo);
	public List<CommunityVO> getList();
	public CommunityVO getDetail(long cno);
	public int modify(CommunityVO cvo);
	public int remove(long cno);
}
