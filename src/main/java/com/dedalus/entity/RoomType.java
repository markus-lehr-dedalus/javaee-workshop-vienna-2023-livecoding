package com.dedalus.entity;

import java.util.Arrays;

public enum RoomType {
    MEETING, RELAXATION;

    RoomType() {

    }

    public static RoomType fromString(String value) {
        if (value == null) {
            return null;
        }
        String finalValue = value.toLowerCase();
        return Arrays.stream(RoomType.values())
                .filter(r -> r.toString().equals(finalValue))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
