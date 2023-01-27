package com.project.CustomerService;


import com.project.CustomerService.Domain.Customer;
import com.project.CustomerService.Service.impl.CustomerServiceimp;
import com.project.CustomerService.adapter.AddressDto;
import com.project.CustomerService.adapter.ContactDto;
import com.project.CustomerService.adapter.CustomerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerServiceApplicationTests {

	@LocalServerPort
	public int port;
	private String baseUrl="http://localhost";
      @Autowired
	private static RestTemplate restTemplate;
	@BeforeAll
	public static void  init(){
		restTemplate = new RestTemplate();
	}

	@BeforeEach
	public  void setUp(){
		baseUrl=baseUrl.concat(":").concat(port+"").concat("/customers");
	}

	@Test
	void addCustomerForTest() {
		CustomerDto customerDto=new CustomerDto(1,"Akiki",new AddressDto("Asmara","harnet","111"),new ContactDto("1234","abc@gmail.com"));
		restTemplate.postForObject(baseUrl,customerDto,Customer.class);
		CustomerDto responseCustomer=restTemplate.getForObject(baseUrl+"/1", CustomerDto.class);
		Assertions.assertEquals(customerDto.getCustomerNumber(),responseCustomer.getCustomerNumber());
		restTemplate.delete(baseUrl+"/1");



	}
//   @Test
//   public void getAll() {
//	   CustomerDto customerDto = new CustomerDto(1, "Akiki", new AddressDto("Asmara", "harnet", "111"), new ContactDto("1234", "abc@gmail.com"));
//	   CustomerDto customerDto2 = new CustomerDto(2, "Aman", new AddressDto("keren", "bela", "222"), new ContactDto("2342", "aman@gmail.com"));
//	   List<CustomerDto> customerDtos = new ArrayList<>();
//	   customerDtos.add(customerDto2);
//	   customerDtos.add(customerDto);
//	   restTemplate.postForObject(baseUrl, customerDto, Customer.class);
//	   restTemplate.postForObject(baseUrl, customerDto2, Customer.class);
//
//	   CustomerList responseCustomer = restTemplate.getForObject(baseUrl, CustomerList.class);
//	   List<CustomerDto> getCustomers = responseCustomer.getCustomerLists();
//	   Assertions.assertEquals(customerDtos, getCustomers);
//	   restTemplate.delete(baseUrl + "/1");
//	   restTemplate.delete(baseUrl + "/2");
//   }


//	@Test
//   public void getAll() {
//	   CustomerDto customerDto = new CustomerDto(1, "Akiki", new AddressDto("Asmara", "harnet", "111"), new ContactDto("1234", "abc@gmail.com"));
//	   CustomerDto customerDto2 = new CustomerDto(2, "Aman", new AddressDto("keren", "bela", "222"), new ContactDto("2342", "aman@gmail.com"));
//	   List<CustomerDto> customerDtos = new ArrayList<>();
//	   customerDtos.add(customerDto2);
//	   customerDtos.add(customerDto);
//	   restTemplate.postForObject(baseUrl, customerDto, Customer.class);
//	   restTemplate.postForObject(baseUrl, customerDto2, Customer.class);
//
//	   CustomerList responseCustomer = restTemplate.getForObject(baseUrl, CustomerList.class);
//	   List<CustomerDto> getCustomers = responseCustomer.getCustomerLists();
//	   Assertions.assertEquals(customerDtos, getCustomers);
//	   restTemplate.delete(baseUrl + "/1");
//	   restTemplate.delete(baseUrl + "/2");
//   }

	@Test
   public void updateCustomer() {
	   CustomerDto customerDto = new CustomerDto(1, "Akiki", new AddressDto("Asmara", "harnet", "111"), new ContactDto("1234", "abc@gmail.com"));
	   CustomerDto customerDto2 = new CustomerDto(1, "Aman", new AddressDto("keren", "bela", "222"), new ContactDto("2342", "aman@gmail.com"));

	   restTemplate.postForObject(baseUrl, customerDto, CustomerDto.class);
	   restTemplate.put(baseUrl+"/1", customerDto2, CustomerDto.class);

	   CustomerDto responseCustomer = restTemplate.getForObject(baseUrl+"/1", CustomerDto.class);
	   Assertions.assertEquals(customerDto2.getName(), responseCustomer.getName());
	   restTemplate.delete(baseUrl + "/1");
   }

}
