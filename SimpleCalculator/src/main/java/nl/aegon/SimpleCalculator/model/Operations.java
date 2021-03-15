package nl.aegon.SimpleCalculator.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name ="Calculations")
public class Operations {

	private BigDecimal operand1;
	private BigDecimal operand2;
	private long id;
	private BigDecimal result = null;
	private String operator;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name ="Operand1")
	public BigDecimal getOperand1() {
		return operand1;
	}
	public void setOperand1(BigDecimal operand1) {
		this.operand1 = operand1;
	}
	@Column(name ="Operand2")
	public BigDecimal getOperand2() {
		return operand2;
	}
	public void setOperand2(BigDecimal operand2) 
	{
		this.operand2 = operand2;
	}
	@Column(name ="Result")
	public BigDecimal getResult() {
		return result;
	}

	public void setResult(BigDecimal result) {
		this.result = result;
	}
	@Column(name ="Operator")
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
}
