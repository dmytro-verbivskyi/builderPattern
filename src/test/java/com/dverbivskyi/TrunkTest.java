package com.dverbivskyi;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by dverbivskyi on 2017-06-12.
 */
public class TrunkTest {

    @Test
    public void trunkFullCreate() throws Exception {
        Trunk trunk = new Trunk.Builder()
                .age(13)
                .childrenIds(Arrays.asList(4L, 6L))
                .trunkIds(Arrays.asList(45L, 67L))
                .build();
        assertThat(trunk).isNotNull();
        assertThat(trunk.getAge()).isEqualTo(13);
        assertThat(trunk.getChildrenIds()).containsExactly(4L, 6L);
        assertThat(trunk.getTrunkIds()).containsExactly(45L, 67L);
    }
}
