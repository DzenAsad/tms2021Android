package com.home;

public interface CheckLoading {
    default boolean checkPossibilityOfLoading(int cargo, int capacity) {
        if (cargo > capacity) {
            return false;
        } else {
            return true;
        }
    }
}
