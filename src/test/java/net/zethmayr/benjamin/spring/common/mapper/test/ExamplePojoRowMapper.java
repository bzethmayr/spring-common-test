package net.zethmayr.benjamin.spring.common.mapper.test;

import net.zethmayr.benjamin.spring.common.mapper.base.ColumnType;
import net.zethmayr.benjamin.spring.common.mapper.base.ComposedMapper;
import net.zethmayr.benjamin.spring.common.mapper.base.InvertibleRowMapperBase;
import net.zethmayr.benjamin.spring.common.mapper.base.Mapper;

import java.util.Arrays;

public class ExamplePojoRowMapper extends InvertibleRowMapperBase<ExamplePojo> {
    public static final Mapper<ExamplePojo, Integer, Integer> ID = ComposedMapper.simpleField(
            "id",
            ExamplePojo::getId,
            ColumnType.INTEGER_INDEX,
            ExamplePojo::setId
    );

    public static final Mapper<ExamplePojo, String, String> NAME = ComposedMapper.simpleField(
            "character_name",
            ExamplePojo::getName,
            ColumnType.SHORT_STRING,
            ExamplePojo::setName
    );

    public static final Mapper<ExamplePojo, String, String> CATCHPHRASE = ComposedMapper.simpleField(
            "catchphrase",
            ExamplePojo::getPrimaryCatchphrase,
            ColumnType.LONG_STRING,
            ExamplePojo::setPrimaryCatchphrase
    );

    public ExamplePojoRowMapper() {
        super(ExamplePojo.class, Arrays.asList(ID, NAME, CATCHPHRASE), "characters", ExamplePojo::new);
    }
}
