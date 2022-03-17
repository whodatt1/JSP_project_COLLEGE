package service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.UserVO;
import repository.UserDAO;
import repository.UserDAOImple;

public class UserServiceImple implements UserService {
	private static Logger log = LoggerFactory.getLogger(UserServiceImple.class);
	private UserDAO udao;
	
	public UserServiceImple() {
		udao = new UserDAOImple();
	}

	@Override
	public int register(UserVO uvo) {
		return udao.insert(uvo);
	}

	@Override
	public List<UserVO> getList() {
		return udao.selectList();
	}

	@Override
	public UserVO getDetail(String email) {
		return udao.selectOne(email);
	}

	@Override
	public int modify(UserVO uvo) {
		return udao.update(uvo);
	}
	@Override
	public int modify2(UserVO uvo) {
		return udao.update2(uvo);
	}

	@Override
	public int remove(String email) {
		return udao.delete(email);
	}

	@Override
	public UserVO login(UserVO uvo) {
		UserVO loginUvo = udao.selectOne(uvo);
		if (loginUvo != null) udao.update(loginUvo.getEmail());
		loginUvo.setLastLogin(LocalDateTime.now().toString());
		return udao.selectOne(uvo);
	}

	@Override
	public List<String> getEmailList() {
		return udao.selectEmailList();
	}

	@Override
	public String getMatchPwd(String email) {
		return udao.selectMatchPwd(email);
	}

}
