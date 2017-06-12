package com.dverbivskyi;

import com.google.common.collect.ImmutableList;

import java.util.Collections;
import java.util.List;

public class Root {

    private int age;
    private List<Long> childrenIds;

    protected Root(Builder builder) {
        age = builder.age;
        childrenIds = builder.childrenIds;
    }

    public int getAge() {
        return age;
    }

    public List<Long> getChildrenIds() {
        return childrenIds;
    }

    public static class Builder<T extends Builder> {
        private int age;
        private List<Long> childrenIds;

        public Root build() {
            return new Root(this);
        }

        public T age(int age) {
            this.age = age;
            return (T) this;
        }

        public T childrenIds(List<Long> childrenIds) {
            this.childrenIds = (childrenIds == null) ?
                    Collections.<Long>emptyList() :
                    ImmutableList.copyOf(childrenIds);
            return (T) this;
        }
    }


}
