package com.unitTesting;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootUnitTestingApplicationTests {

	private Calculator cal=new Calculator();
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testSum()
	{
		int expectedResult=20;
		int actualResult=cal.doSum(3, 12,5);
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	void getProduct()
	{
		int expected=40;
		int actual=cal.doProduct(10, 4);
	    assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	public void comparetwono()
	{
		//boolean expected=true;		
		boolean actual=cal.comparetwono(4, 4);
		assertThat(actual).isTrue();
	}
	
}
