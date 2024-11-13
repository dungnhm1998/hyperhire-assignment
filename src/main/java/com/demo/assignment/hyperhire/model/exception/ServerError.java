package com.demo.assignment.hyperhire.model.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerError {

    public static final ServerError NOT_FOUND_USER = new ServerError(10400,"Invalid user name or password");
    public static final ServerError USER_EXISTED = new ServerError(10401,"Email already exists");
    public static final ServerError INTERNAL_SERVER_ERRROR = new ServerError(50500, "Oops !!! Something went wrong, please try again later!");

    @JsonProperty(value = "server_code")
    private int serverCode;

    @JsonProperty(value = "message")
    private String message;

}
