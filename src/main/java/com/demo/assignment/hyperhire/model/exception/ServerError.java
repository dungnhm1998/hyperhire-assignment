package com.demo.assignment.hyperhire.model.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerError {

    public static final ServerError INTERNAL_SERVER_ERRROR = new ServerError(505000, "Oops !!! Something went wrong, please try again later!");
    public static final ServerError NOT_FOUND_USER = new ServerError(104000,"Invalid user name or password");
    public static final ServerError USER_EXISTED = new ServerError(104001,"Email already exists");
    public static final ServerError NOT_FOUND_ROOM = new ServerError(104002,"Cannot find room. Please try again");
    public static final ServerError NOT_FOUND_RESERVATION = new ServerError(104003,"Cannot find Reservation. Please try again");
    public static final ServerError OVERDUE_ALLOWED_CANCEL_DATE = new ServerError(104004,"Cannot cancel reservation due to overdue allowed date");
    public static final ServerError PAYMENT_PROCESSING_ERROR = new ServerError(104005,"Cannot process payment. Please try again");
    public static final ServerError NOT_FOUND_PAYMENT = new ServerError(104006,"Cannot find Payment. Please try again");
    public static final ServerError CANNOT_DO_ACTION_ON_RESERVATION = new ServerError(104007,"Cannot confirm/cancel/pay reservation. Please contact support");
    public static final ServerError CANNOT_REFUND_PAYMENT = new ServerError(104008,"Cannot refund payment. Please contact support");
    public static final ServerError PAYMENT_REFUND_PROCESSING_ERROR = new ServerError(104009,"Cannot refund payment. Please try again");
    public static final ServerError INVALID_ACTION = new ServerError(104010,"Invalid action. Please try again");

    @JsonProperty(value = "server_code")
    private int serverCode;

    @JsonProperty(value = "message")
    private String message;

}
