package com.network.social.sn.controller.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record AuthCreateUser(@NotBlank String username, @NotBlank String email, @NotBlank String password,
    @Nullable String fullName, @Nullable String bio, @Valid AuthCreateRoleRequest roleRequest) {

}
