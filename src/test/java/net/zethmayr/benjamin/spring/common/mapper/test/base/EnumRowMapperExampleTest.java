package net.zethmayr.benjamin.spring.common.mapper.test.base;

import net.zethmayr.benjamin.spring.common.mapper.test.ExampleEnumRowMapper;
import org.junit.Test;

import static net.zethmayr.benjamin.spring.common.mapper.test.ExampleEnum.Grob;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class EnumRowMapperExampleTest extends EnumRowMapperBaseTest<ExampleEnumRowMapper> {

    public EnumRowMapperExampleTest() {
        super(new ExampleEnumRowMapper());
    }

    @Test
    @Override
    public void canMapFromId() {
        assertThat(underTest.idMapper().des(0), is(Grob));
    }
}
