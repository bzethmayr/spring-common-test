package net.zethmayr.benjamin.spring.common.mapper.test;

import net.zethmayr.benjamin.spring.common.mapper.base.ColumnType;
import net.zethmayr.benjamin.spring.common.mapper.base.ComposedMapper;
import net.zethmayr.benjamin.spring.common.mapper.base.EnumRowMapper;
import net.zethmayr.benjamin.spring.common.mapper.base.Mapper;

import java.util.Arrays;

import static net.zethmayr.benjamin.spring.common.mapper.test.ExampleEnum.Gob;

public class ExampleEnumRowMapper extends EnumRowMapper<ExampleEnum> {
    public static final Mapper<ExampleEnum, ExampleEnum, Integer> ID = ComposedMapper.enumId(
            ExampleEnum::ordinal,
            (i) -> ExampleEnum.values()[i]
    );

    public static final Mapper<ExampleEnum, String, String> NAME = ComposedMapper.enumSimple(
            "face_name",
            ExampleEnum::name,
            ColumnType.SHORT_STRING
    );

    public static final Mapper<ExampleEnum, Integer, Integer> ANGLE = ComposedMapper.enumSimple(
        "face_angle",
            ExampleEnum::facingAngle,
            ColumnType.INTEGER
    );

    public ExampleEnumRowMapper() {
        super(Gob, Arrays.asList(ID, NAME, ANGLE), "oh_my");
    }
}
