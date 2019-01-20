package com.lalit.library.subscriptionservice.model;


import com.lalit.library.subscriptionservice.rest.model.AddSubscriptionCommand;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Entity(name = "SUBSCRIPTION")
@Getter
@Setter
public class Subscription {

    @Id
    @Column(name = "subscription_id")
    String subscriptionId;

    @Column(name = "user_id")
    String userId;

    @Column(name = "book_id")
    String bookId;

    @Column(name = "issue_date")
    Date   issueDate;

    @Column(name = "due_date")
    Date   dueDate;

    @Column(name = "return_date")
    Date   returnDate;

    @Column(name = "status")
    @Convert(converter = StatusConverter.class)
    Status status;

    public Subscription() {
        this.subscriptionId = UUID.randomUUID().toString();
    }

    public Subscription(AddSubscriptionCommand addSubscriptionCommand) {
        this();
        this.userId = addSubscriptionCommand.getUserId();
        this.bookId = addSubscriptionCommand.getBookId();
        this.issueDate = new Date();
        this.dueDate = Date.from(issueDate.toInstant().plus(7, ChronoUnit.DAYS));
        this.status = Status.PENDING;
    }
}
