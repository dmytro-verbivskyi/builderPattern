package com.dverbivskyi;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by dverbivskyi on 2017-06-12.
 */
public class BLevelTest {

    @Test
    public void bEntityFullCreate() throws Exception {
        B b = new B.Builder()
                .aLongs(Arrays.asList(4L, 6L))
                .bLongs(Arrays.asList(45L, 67L))
                .build();
        assertThat(b).isNotNull();
        assertThat(b.getALongs()).containsExactly(4L, 6L);
        assertThat(b.getBLongs()).containsExactly(45L, 67L);
    }
}
