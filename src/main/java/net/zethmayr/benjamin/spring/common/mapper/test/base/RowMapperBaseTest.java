package net.zethmayr.benjamin.spring.common.mapper.test.base;

import net.zethmayr.benjamin.spring.common.mapper.base.ClassFieldMapper;
import net.zethmayr.benjamin.spring.common.mapper.base.InvertibleRowMapper;
import net.zethmayr.benjamin.spring.common.mapper.base.Mapper;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

/**
 * Base class for any {@link InvertibleRowMapper} subclass test.
 * @param <T> The mapper type
 * @param <C> The row type
 */
public abstract class RowMapperBaseTest<T extends InvertibleRowMapper<C>, C> {
    protected final T underTest;

    protected RowMapperBaseTest(final T underTest) {
        this.underTest = underTest;
    }

    @Test
    public void canConstructInsert() {
        final String table = underTest.table();
        assertThat(table, not(isEmptyOrNullString()));
        final String insert = underTest.insert();
        assertInsertContainsTableAndAllFields(insert, table);
        System.out.println(insert);
    }

    protected void assertInsertContainsTableAndAllFields(final String insert, final String table) {
        assertThat(insert, not(isEmptyOrNullString()));
        assertThat(insert, containsString(table));
        for (ClassFieldMapper field : underTest.fields()) {
            if (!field.getColumnType().isIndexColumn()) {
                assertThat(insert, containsString(field.fieldName()));
            }
        }
    }

    @Test
    public void allFieldsAreSpecified() {
        for (ClassFieldMapper field : underTest.fields()) {
            assertThat(field.fieldName(), not(isEmptyOrNullString()));
            assertThat(field.sqlType(), not(isEmptyOrNullString()));
        }
    }

    @Test
    public void allMapperCastsAreLegal() {
        for (ClassFieldMapper raw : underTest.fields()) {
            assertThat(raw, instanceOf(Mapper.class));
            Mapper stillRawIGuess = Mapper.class.cast(raw);
        }
    }
}