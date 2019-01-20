package com.lalit.library.subscriptionservice.rest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lalit.library.subscriptionservice.model.Subscription;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SubscriptionResponse {

    String subscriptionId;
    String userId;
    String bookId;
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd-MM-yyyy'T'HH:mm:ss")
    Date issueDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd-MM-yyyy'T'HH:mm:ss")
    Date dueDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd-MM-yyyy'T'HH:mm:ss")
    Date returnDate;
    String status;

    public SubscriptionResponse() {
    }

    public SubscriptionResponse(Subscription subscription) {
        this.subscriptionId = subscription.getSubscriptionId();
        this.userId = subscription.getUserId();
        this.bookId = subscription.getBookId();
        this.returnDate = subscription.getReturnDate();
        this.issueDate = subscription.getIssueDate();
        this.dueDate = subscription.getDueDate();
        this.status = subscription.getStatus().getStatus();
    }
}
