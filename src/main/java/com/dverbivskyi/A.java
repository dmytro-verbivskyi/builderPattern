package com.dverbivskyi;

import com.google.common.collect.ImmutableList;

import java.util.Collections;
import java.util.List;

public class A {

    private List<Long> aLongs;

    protected A(Builder builder) {
        aLongs = builder.aLongs;
    }

    public List<Long> getALongs() {
        return aLongs;
    }

    public static class Builder<T extends Builder> {
        private List<Long> aLongs;

        public A build() {
            return new A(this);
        }

        public T aLongs(List<Long> aLongs) {
            this.aLongs = (aLongs == null) ?
                    Collections.<Long>emptyList() :
                    ImmutableList.copyOf(aLongs);
            return (T) this;
        }
    }


}
