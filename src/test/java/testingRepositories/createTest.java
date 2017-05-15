package testingRepositories;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.ProductRepository;

public class createTest {
	
	//setup
	private Product item = new Product();
	private long maiorId;

	@Test
	public void testcreateWithNewProduct() {
		
		//test
		long actual = ProductRepository.getInstance().create(item);
		maiorId = ProductRepository.getInstance().getMaiorId();
		
		//result
		Assert.assertEquals(maiorId, actual);
	}
	
	@After
	public void aftertestcreateWithNewProduct() {
		ProductRepository.getInstance().remove(maiorId);
	}

}
