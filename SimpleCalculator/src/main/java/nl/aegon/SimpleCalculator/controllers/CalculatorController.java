package nl.aegon.SimpleCalculator.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.aegon.SimpleCalculator.model.Operations;
import nl.aegon.SimpleCalculator.model.Result;
import nl.aegon.SimpleCalculator.repository.OpertaionsRepository;
import nl.aegon.SimpleCalculator.repository.impl.OperationsRepositoryImpl;
import nl.aegon.SimpleCalculator.util.Constants;

@RestController
@RequestMapping(Constants.CALCULATOR_PATH)
public class CalculatorController {
	
	@Autowired
	private OpertaionsRepository opertaionsRepository;
	@Autowired
	private OperationsRepositoryImpl ompl;
	
	private static final Logger logger = LogManager.getLogger(CalculatorController.class);
	@CrossOrigin
	@PostMapping("/add")
	public Result add(@RequestBody Operations  operation ) 
	{
        Result result = new Result();
        if(operation.getOperand1() !=null && operation.getOperand2()!=null) {
        	result.setResult(operation.getOperand1().add(operation.getOperand2()));
        	result.setError(Boolean.FALSE);
        	operation.setOperator("+");
        	operation.setResult(result.getResult());
            opertaionsRepository.save(operation);
        }else {
        	result.setError(Boolean.TRUE);
        	result.setMessage(Constants.ERROR_MESSAGE_OPERAND_NOT_VALID);
        	logger.error("one of the operand is invalid");
        }
        
		return result;
		
		
	}
	@CrossOrigin
	@PostMapping("/subtract")
	public Result subtract(@RequestBody Operations  operation ) 
	{
        Result result = new Result();
        if(operation.getOperand1() !=null && operation.getOperand2()!=null) {
        	result.setResult(operation.getOperand1().subtract(operation.getOperand2()));
        	result.setError(Boolean.FALSE);
        	operation.setOperator("-");
        	operation.setResult(result.getResult());
        	opertaionsRepository.save(operation);
        }else {
        	result.setError(Boolean.TRUE);
        	result.setMessage(Constants.ERROR_MESSAGE_OPERAND_NOT_VALID);
        	logger.error("one of the operand is invalid");
        }
		return result;
		
		
	}
	@CrossOrigin
	@PostMapping("/multiply")
	public Result multiply(@RequestBody Operations  operation ) 
	{
        Result result = new Result();
        if(operation.getOperand1() !=null && operation.getOperand2()!=null) {
        	result.setResult(operation.getOperand1().multiply(operation.getOperand2()));
        	result.setError(Boolean.FALSE);
        	operation.setOperator("*");
        	operation.setResult(result.getResult());
        	opertaionsRepository.save(operation);
        }else {
        	result.setError(Boolean.TRUE);
        	result.setMessage(Constants.ERROR_MESSAGE_OPERAND_NOT_VALID);
        	logger.error("one of the operand is invalid");
        }
		return result;
		
		
	}
	@CrossOrigin
	@PostMapping("/divide")
	public Result divide(@RequestBody Operations  operation ) 
	{
        Result result = new Result();
        if(operation.getOperand1() !=null && operation.getOperand2()!=null) {
        	result.setResult(operation.getOperand1().divide(operation.getOperand2()));
        	result.setError(Boolean.FALSE);
        	operation.setOperator("/");
        	operation.setResult(result.getResult());
        	opertaionsRepository.save(operation);
        }else {
        	result.setError(Boolean.TRUE);
        	result.setMessage(Constants.ERROR_MESSAGE_OPERAND_NOT_VALID);
        }
		return result;
		
		
	}
 @CrossOrigin
 @GetMapping("/history")
 public Result reterivehistory() 
 {
		/*
		 * Page<Operations> page = opertaionsRepository.findAll( PageRequest.of(0, 2,
		 * Sort.by(Sort.Direction.DESC, "id")));
		 * 
		 * return page.toList();
		 */
	 
	 Result result = new Result();
	 result.setHistory(ompl.getRecentHistory(2));
	 return result;
 }
 
}
