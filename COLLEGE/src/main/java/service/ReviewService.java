package service;

import java.util.List;

import domain.ReviewVO;

public interface ReviewService {
	public int register(ReviewVO rvvo);
	public List<ReviewVO> getList(long sno);
	public int modify(ReviewVO rvvo);
	public int remove(long rvno);
}
