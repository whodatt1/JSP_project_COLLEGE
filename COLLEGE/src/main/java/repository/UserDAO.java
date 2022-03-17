package repository;

import java.util.List;

import domain.UserVO;

public interface UserDAO {
	public int insert(UserVO uvo);
	public List<UserVO> selectList();
	public UserVO selectOne(String email);
	public int update(UserVO uvo);
	public int update2(UserVO uvo);
	public int delete(String email);
	public UserVO selectOne(UserVO uvo);
	public int update(String email);
	public List<String> selectEmailList();
	public String selectMatchPwd(String email);
}
