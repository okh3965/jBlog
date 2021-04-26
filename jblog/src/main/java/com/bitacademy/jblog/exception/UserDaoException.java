package com.bitacademy.jblog.exception;

import com.bitacademy.jblog.vo.UserVo;

public class UserDaoException extends RuntimeException {
	// field
	// 예외가 발생했을 때의 상황을 저장할 변수 
	private UserVo userVo = null;
	
	// constrcutors
	public UserDaoException() {
		
	}
	
	public UserDaoException(String message) {
		super(message);
		
	}
	
	public UserDaoException(String message, UserVo memberVo) {
		super(message);
		this.userVo = memberVo;
	}

	public UserVo getMemberVo() {
		return userVo;
	}

	public void setMemberVo(UserVo userVo) {
		this.userVo = userVo;
	}
}
