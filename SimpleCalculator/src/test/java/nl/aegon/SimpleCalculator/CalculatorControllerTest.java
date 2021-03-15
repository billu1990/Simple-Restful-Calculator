package nl.aegon.SimpleCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import nl.aegon.SimpleCalculator.controllers.CalculatorController;
import nl.aegon.SimpleCalculator.util.Constants;

//@RunWith(SpringRunner.class)
@WebMvcTest(CalculatorController.class)

public class CalculatorControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	//this method tests the add operation of 5 + 3
	@Test
	public void addPositiveOperatorTest() throws Exception{

		String jsonBody = "{\"operand1\": 5, \"operand2\": 3}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/add").accept(
				MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		String expectedResult = "{\"message\":\"\",\"error\":false,\"result\":8}";

		assertEquals(HttpStatus.OK.value(), response.getStatus());

		assertEquals(expectedResult, response.getContentAsString());
	}
	
	@Test
	public void addNullValueOperatorTest() throws Exception{

		String jsonBody = "{\"operand1\": null, \"operand2\": 3}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/add").accept(
				MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		String expectedResult =  "{\"message\":\"Error: One of the operands is not valid\",\"error\":true,\"result\":null}";

		assertEquals(HttpStatus.OK.value(), response.getStatus());

		assertEquals(expectedResult, response.getContentAsString());
	}
	
	@Test
	public void divideOperatorTest() throws Exception{

		String jsonBody = "{\"operand1\": 10, \"operand2\": 2}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/divide").accept(
				MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		String expectedResult = "{\"message\":\"\",\"error\":false,\"result\":5}";;

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		assertEquals(expectedResult, response.getContentAsString());

	}
	
	@Test
	public void multiplyOperatorTest() throws Exception{

		String jsonBody = "{\"operand1\": 10, \"operand2\": 2}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/multiply").accept(
				MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		String expectedResult = "{\"message\":\"\",\"error\":false,\"result\":20}";;

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		assertEquals(expectedResult, response.getContentAsString());

	}
}
