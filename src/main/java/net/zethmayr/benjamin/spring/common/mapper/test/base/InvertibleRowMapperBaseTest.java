package net.zethmayr.benjamin.spring.common.mapper.test.base;

import net.zethmayr.benjamin.spring.common.mapper.base.ClassFieldMapper;
import net.zethmayr.benjamin.spring.common.mapper.base.InvertibleRowMapper;
import org.junit.Test;

import java.sql.ResultSet;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public abstract class InvertibleRowMapperBaseTest<T extends InvertibleRowMapper<C>, C> extends RowMapperBaseTest<T, C> {

    protected InvertibleRowMapperBaseTest(final T underTest) {
        super(underTest);
    }

    @Test
    public void canMapMinimalFromRs() throws Exception {
        final ResultSet rs = mock(ResultSet.class);
        final C mapped = underTest.mapRow(rs, 0);
        assertThat(mapped, not(nullValue()));
    }

    @Test
    public void canReadToRealObjects() {
        final String table = underTest.table();
        final String select = underTest.select();
        assertSelectContainsTableAndAllFields(select, table);
        System.out.println(select);
        assertEmptyReturnsSomething(underTest);
    }

    private void assertSelectContainsTableAndAllFields(final String select, final String table) {
        assertThat(select, not(isEmptyOrNullString()));
        assertThat(select, containsString(table));
        for (ClassFieldMapper field : underTest.fields()) {
            assertThat(select, containsString(field.fieldName()));
        }
    }

    public static void assertEmptyReturnsSomething(final InvertibleRowMapper underTest) {
        final Object first;
        assertThat(first = underTest.empty(), is(not(nullValue())));
        assertThat(first, is(instanceOf(underTest.rowClass())));
        assertThat(underTest.empty(), allOf(is(not(nullValue())), not(sameInstance(first))));
    }
}
