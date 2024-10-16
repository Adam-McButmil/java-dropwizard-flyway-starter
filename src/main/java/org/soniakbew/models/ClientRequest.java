package org.soniakbew.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientRequest {
    private int clientId;
    private String name;

    @JsonCreator
    public ClientRequest(
            final @JsonProperty("clientId") int clientId,
            final @JsonProperty("name") String name

    ) {
        this.clientId = clientId;
        this.name = name;
    }
}
