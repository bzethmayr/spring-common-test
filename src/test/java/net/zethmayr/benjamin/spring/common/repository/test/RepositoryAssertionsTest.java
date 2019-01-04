package net.zethmayr.benjamin.spring.common.repository.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertThat;

/**
 * Yeesh - what was the CUT even for? For making sure I was doing something wrong?
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryAssertionsTest {

    @Autowired
    private ExampleRepository underTest;

    @Test
    public void wires() {
        assertThat(underTest, isA(ExampleRepository.class));
    }
}
