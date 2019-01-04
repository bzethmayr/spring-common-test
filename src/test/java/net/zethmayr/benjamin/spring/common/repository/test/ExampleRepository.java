package net.zethmayr.benjamin.spring.common.repository.test;

import net.zethmayr.benjamin.spring.common.mapper.test.ExamplePojo;
import net.zethmayr.benjamin.spring.common.mapper.test.ExamplePojoRowMapper;
import net.zethmayr.benjamin.spring.common.repository.base.MapperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ExampleRepository extends MapperRepository<ExamplePojo, Integer> {
    public ExampleRepository(final @Autowired JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, new ExamplePojoRowMapper(), ExamplePojoRowMapper.ID);
    }
}
