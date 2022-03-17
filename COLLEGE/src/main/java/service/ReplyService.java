package service;

import java.util.List;

import domain.ReplyVO;

public interface ReplyService {
	public int register(ReplyVO rpvo);
	public List<ReplyVO> getList(long cno);
	public int modify(ReplyVO rpvo);
	public int remove(long rpno);
}
