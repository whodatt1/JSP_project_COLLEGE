package service;

import java.util.List;

import domain.UserVO;

public interface UserService {
	public int register(UserVO uvo);
	public List<UserVO> getList();
	public UserVO getDetail(String email);
	public int modify(UserVO uvo);
	public int modify2(UserVO uvo);
	public int remove(String email);
	public UserVO login(UserVO uvo);
	public List<String> getEmailList();
	public String getMatchPwd(String email);
}
