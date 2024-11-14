package com.demo.assignment.hyperhire.model.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerError {

    public static final ServerError INTERNAL_SERVER_ERRROR = new ServerError(50500, "Oops !!! Something went wrong, please try again later!");
    public static final ServerError NOT_FOUND_USER = new ServerError(10400,"Invalid user name or password");
    public static final ServerError USER_EXISTED = new ServerError(10401,"Email already exists");
    public static final ServerError NOT_FOUND_ROOM = new ServerError(10402,"Cannot find room. Please try again");
    public static final ServerError NOT_FOUND_RESERVATION = new ServerError(10403,"Cannot find Reservation. Please try again");
    public static final ServerError OVERDUE_ALLOWED_CANCEL_DATE = new ServerError(10404,"Cannot cancel reservation due to overdue allowed date");

    @JsonProperty(value = "server_code")
    private int serverCode;

    @JsonProperty(value = "message")
    private String message;

}
