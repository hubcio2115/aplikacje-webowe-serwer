package org.example.server.domains.user;

public record ChangeUserDetailsRequest(String firstName, String lastName, String email) {}
