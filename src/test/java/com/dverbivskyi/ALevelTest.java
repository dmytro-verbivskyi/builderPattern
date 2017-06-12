package com.dverbivskyi;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ALevelTest {

    @Test
    public void rootCanBeCreatedViaBuilder() throws Exception {
        A a = new A.Builder().build();
        assertThat(a).isNotNull();
    }

    @Test
    public void builderCanBeReusedSeveralTimes() throws Exception {
        A.Builder builder = new A.Builder();
        A a1 = builder.build();
        A a2 = builder.build();
        assertThat(a1).isNotEqualTo(a2);
    }

    @Test
    public void defensiveOfReferenceTypeFromInputSide() throws Exception {
        A.Builder builder = new A.Builder();

        List<Long> inputSide = new ArrayList<Long>();
        inputSide.add(1234L);

        A a = builder.aLongs(inputSide).build();
        Assertions.assertThat(a.getALongs()).containsExactly(1234L);

        inputSide.set(0, -1L);
        Assertions.assertThat(a.getALongs()).containsExactly(1234L);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void defensiveOfReferenceTypeFromRecipientSide() throws Exception {
        A a = new A.Builder().aLongs(Collections.singletonList(1234L)).build();
        Assertions.assertThat(a.getALongs()).containsExactly(1234L);

        a.getALongs().add(-1L);
    }

    @Test
    public void fullCreateOfRoot() throws Exception {
        A a = new A.Builder().aLongs(null).build();

        Assertions.assertThat(a.getALongs()).isEmpty();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setNullToListToModifyItLater() throws Exception {
        A a = new A.Builder().aLongs(null).build();

        Assertions.assertThat(a.getALongs()).isEmpty();

        a.getALongs().add(12L);
    }
}
