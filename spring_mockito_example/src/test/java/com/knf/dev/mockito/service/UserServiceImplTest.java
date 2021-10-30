package com.knf.dev.mockito.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.knf.dev.mockito.entity.User;
import com.knf.dev.mockito.repository.UserRepository;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

	@InjectMocks
	private UserServiceImpl userService;

	@Mock
	private UserRepository userRepository;

	@Before
	public void setUp() {
		User user = new User();
		user.setName("sibin");
		user.setId(1);
		Mockito.when(userRepository.findByName(user.getName())).thenReturn(user);
	}

	@Test
	public void whenValidName_thenEmployeeShouldBeFound() {
		String name = "sibin";
		User found = userService.getUserByName(name);

		Assert.assertEquals(found.getName(), name);
	}
}
