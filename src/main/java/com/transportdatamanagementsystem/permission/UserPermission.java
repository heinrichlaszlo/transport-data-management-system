package com.transportdatamanagementsystem.permission;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public enum UserPermission {

    NONE,

    READ_ONLY,
    MODIFY,
    ADD,
    DELETE
}
