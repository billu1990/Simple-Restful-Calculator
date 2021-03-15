package nl.aegon.SimpleCalculator.model;

import java.math.BigDecimal;
import java.util.List;

public class Result {

	private String message = "";
	
	private Boolean error = Boolean.FALSE;
	
	private BigDecimal result = null;
	
	private List<Operations> history ;
	
	public Result() {}
	
	public Result(String message, Boolean error, BigDecimal result) 
	{
		super();
		this.message = message;
		this.error = error;
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	public BigDecimal getResult() {
		return result;
	}

	public void setResult(BigDecimal result) {
		this.result = result;
	}

	public List<Operations> getHistory() {
		return history;
	}

	public void setHistory(List<Operations> history) {
		this.history = history;
	}

}
