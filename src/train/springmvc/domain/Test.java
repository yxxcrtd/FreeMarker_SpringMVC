package train.springmvc.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
public class Test implements Serializable {

	private int testId;
	
	private String testName;
	
	private boolean testStatus;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Date testDate;
	
	public Test() {
		//
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public boolean getTestStatus() {
		return testStatus;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestStatus(boolean testStatus) {
		this.testStatus = testStatus;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

}
