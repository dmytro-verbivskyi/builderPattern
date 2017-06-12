package com.dverbivskyi;

import com.google.common.collect.ImmutableList;

import java.util.Collections;
import java.util.List;

/**
 * Created by dverbivskyi on 2017-06-12.
 */
public class Trunk extends Root {

    private List<Long> trunkIds;

    private Trunk(Builder builder) {
        super(builder);
        trunkIds = builder.trunkIds;
    }

    public List<Long> getTrunkIds() {
        return trunkIds;
    }

    public static class Builder extends Root.Builder<Builder> {
        private List<Long> trunkIds;

        public Trunk build() {
            return new Trunk(this);
        }

        public Builder trunkIds(List<Long> trunkIds) {
            this.trunkIds = (trunkIds == null) ?
                    Collections.<Long>emptyList() :
                    ImmutableList.copyOf(trunkIds);
            return this;
        }
    }

}
