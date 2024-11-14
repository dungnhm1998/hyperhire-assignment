package com.demo.assignment.hyperhire.util;

import java.util.UUID;

public class CommonUtil {
    public static String generateUUIDString() {
        // Generate a UUID and remove hyphens
        return UUID.randomUUID().toString().replace("-", "");
    }
}
