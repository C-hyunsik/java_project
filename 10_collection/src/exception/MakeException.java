package exception;

public class MakeException extends Exception{	//사용자가 만든 예외처리 클래스
	private String errorMsg;

	public MakeException() {
	}

	public MakeException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return errorMsg;
	}


}