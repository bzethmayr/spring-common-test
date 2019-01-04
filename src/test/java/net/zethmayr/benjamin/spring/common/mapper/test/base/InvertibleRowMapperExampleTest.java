package net.zethmayr.benjamin.spring.common.mapper.test.base;

import net.zethmayr.benjamin.spring.common.mapper.base.InvertibleRowMapperBase;
import net.zethmayr.benjamin.spring.common.mapper.test.ExamplePojoRowMapper;

public class InvertibleRowMapperExampleTest extends InvertibleRowMapperBaseTest {
    public InvertibleRowMapperExampleTest() {
        super(new ExamplePojoRowMapper());
    }
}
