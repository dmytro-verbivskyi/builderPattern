package com.dverbivskyi;

import com.google.common.collect.ImmutableList;

import java.util.Collections;
import java.util.List;

/**
 * Created by dverbivskyi on 2017-06-12.
 */
public class B extends A {

    private List<Long> bLongs;

    protected B(Builder builder) {
        super(builder);
        bLongs = builder.bLongs;
    }

    public List<Long> getBLongs() {
        return bLongs;
    }

    public static class Builder extends A.Builder<Builder>  {
        private List<Long> bLongs;

        public B build() {
            return new B(this);
        }

        public Builder bLongs(List<Long> bLongs) {
            this.bLongs = (bLongs == null) ?
                    Collections.<Long>emptyList() :
                    ImmutableList.copyOf(bLongs);
            return this;
        }
    }

}
