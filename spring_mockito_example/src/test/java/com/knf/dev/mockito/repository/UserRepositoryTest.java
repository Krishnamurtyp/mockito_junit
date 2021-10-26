package com.knf.dev.mockito.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import com.knf.dev.mockito.entity.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository userRepository;

	@Before
	public void setUp() {
		String name = "sibin";
		User user = new User();
		user.setName(name);
		entityManager.persist(user);
	}

	@After
	public void clear() {
		entityManager.clear();

	}

	@Test
	public void whenFindByName_thenReturnUser() {
		User found = userRepository.findByName("sibin");
		Assert.assertNotNull(found);
		Assert.assertEquals(found.getName(), "sibin");

	}

}