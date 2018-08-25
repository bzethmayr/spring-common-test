package net.zethmayr.benjamin.spring.common.repository.test;

import net.zethmayr.benjamin.spring.common.mapper.base.ClassFieldMapper;
import net.zethmayr.benjamin.spring.common.repository.base.MapperRepository;
import net.zethmayr.benjamin.spring.common.repository.base.Repository;
import net.zethmayr.benjamin.spring.common.repository.base.EnumRepository;

import java.util.stream.Collectors;

import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.text.StringContainsInOrder.stringContainsInOrder;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

public final class RepositoryAssertions {
    private RepositoryAssertions() {}

    public static <T,X,P> void assertDelegatesSelectAndInsert(final Repository<T, X> underTest, final MapperRepository<P, X> delegate) {
        final String select = underTest.select();
        verify(delegate).select();
        assertThat(select, stringContainsInOrder(
                delegate.mapper.fields().stream()
                        .map(ClassFieldMapper::fieldName)
                        .collect(Collectors.toList())
        ));
        final String insert = underTest.insert();
        verify(delegate).insert();
        assertThat(insert, stringContainsInOrder(
                delegate.mapper.fields().stream()
                        .filter((f) -> f != delegate.idMapper)
                        .map(ClassFieldMapper::fieldName)
                        .collect(Collectors.toList())
        ));
    }
}
