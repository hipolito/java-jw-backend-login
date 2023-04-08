package com.dasgher.backend.login.model;

public record User(
        String id,
        String username,
        String password,
        String firstName,
        String lastName,
        String token) {
}
