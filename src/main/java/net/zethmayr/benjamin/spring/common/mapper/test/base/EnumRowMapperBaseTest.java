package net.zethmayr.benjamin.spring.common.mapper.test.base;

import net.zethmayr.benjamin.spring.common.mapper.base.EnumRowMapper;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.sql.ResultSet;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Base class for tests for enum mappers.
 * @param <T> The mapper type
 */
public abstract class EnumRowMapperBaseTest<T extends EnumRowMapper> {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    protected T underTest;

    protected EnumRowMapperBaseTest(final T underTest) {
        this.underTest = underTest;
    }

    @Test
    public void cannotGetEmptyInstanceButYouCanUseTheEnum() {
        thrown.expect(UnsupportedOperationException.class);
        underTest.empty();
    }

    @Test
    public abstract void canMapFromId();

    @Test
    @SuppressWarnings("unchecked") // because a CCE would fail the test...
    public void canMapFromRs() throws Exception {
        final Object expected = underTest.idMapper().des(0);
        final ResultSet mockRs = mock(ResultSet.class);
        final Object mapped = underTest.mapRow(mockRs, 99);
        assertThat(mapped, is(sameInstance(expected)));
    }

}
