package cn.net.inlink.exceptions;

/**
 * 自定登录异常，用于记录登录是出现的异常
 * @author Yz
 *
 */
public class LoginException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	//错误信息
	private String message;
	
	public LoginException(String message){
		
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
