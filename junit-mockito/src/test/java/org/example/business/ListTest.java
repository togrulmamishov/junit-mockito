package org.example.business;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class ListTest {

    @Test
    public void mockListSizeMethod_ReturnMultipleValues() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);

        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    public void mockListGet() {
        List listMock = mock(List.class);
        //ArgumentMatcher
        when(listMock.get(anyInt())).thenReturn("Togrul");

        assertEquals("Togrul", listMock.get(0));
        assertEquals("Togrul", listMock.get(1));
    }

    @Test
    public void mockListGet_usingBDD() {
        //Given
        List listMock = mock(List.class);
        given(listMock.get(anyInt())).willReturn("Togrul");

        assertThat(listMock.get(5), is("Togrul"));

    }

    @Test(expected = RuntimeException.class)
    public void mockList_willThrowRuntimeException() {
        List listMock = mock(List.class);
        //ArgumentMatcher
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Some exception"));
        listMock.get(0);

    }
}
