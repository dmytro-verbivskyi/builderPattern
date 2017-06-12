package com.dverbivskyi;

import com.google.common.collect.ImmutableList;

import java.util.Collections;
import java.util.List;

/**
 * Created by dverbivskyi on 2017-06-12.
 */
public class C extends B {

    private List<Long> cLongs;

    private C(Builder builder) {
        super(builder);
    }

    public List<Long> getCLongs() {
        return cLongs;
    }

}
