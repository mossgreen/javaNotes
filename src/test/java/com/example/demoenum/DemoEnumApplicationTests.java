package com.example.demoenum;

import com.demoenum.Flower;
import com.demoenum.FlowerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoEnumApplicationTests {

	@Autowired
	FlowerRepository flowerRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canSave() {

		Flower flower = new Flower();
		flower.setId(1L);
		flower.setSeason(com.example.demoenum.Season.SPRING);

		final Flower save = flowerRepository.save(flower);

		Assert.assertTrue(save != null);

	}

}
