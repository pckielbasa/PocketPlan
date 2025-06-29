package com.pkielbasa.pocketplan.application.util;

import org.springframework.data.domain.Sort;

public class SortUtils {

    private SortUtils() {}

    public static Sort buildSort(String sortBy, String direction) {
        if (sortBy == null || sortBy.isEmpty()) {
            return Sort.unsorted();
        }

        Sort.Direction dir = Sort.Direction.ASC;
        if (direction != null) {
            dir = Sort.Direction.fromString(direction);
        }

        return Sort.by(dir, sortBy);
    }
}
