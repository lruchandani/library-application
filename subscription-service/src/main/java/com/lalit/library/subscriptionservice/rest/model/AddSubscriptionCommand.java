package com.lalit.library.subscriptionservice.rest.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddSubscriptionCommand {
    String userId;
    String bookId;
}
