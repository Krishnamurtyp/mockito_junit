package com.knf.dev.mockito.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

 
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

 
import org.springframework.test.context.junit4.SpringRunner;

import com.knf.dev.mockito.entity.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByName_thenReturnUser() {
        // given
        String name = "sibin";
        User user = new User();
        user.setName(name);
        entityManager.persist(user);
        entityManager.flush();

        // when
        User found = userRepository.findByName(user.getName());

        // then
        Assert.assertNotNull(found);
        Assert.assertEquals(found.getName(), name);

    }

}
