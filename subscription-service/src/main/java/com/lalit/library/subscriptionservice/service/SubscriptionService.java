package com.lalit.library.subscriptionservice.service;

import com.lalit.library.subscriptionservice.rest.model.AddSubscriptionCommand;
import com.lalit.library.subscriptionservice.rest.model.SubscriptionResponse;
import com.lalit.library.subscriptionservice.rest.model.UpdateSubscriptionCommand;

import java.util.List;
import java.util.Map;

public interface SubscriptionService {
    String add(AddSubscriptionCommand addSubscriptionCommand);
    SubscriptionResponse getOne(String subscriptionId);
    List<SubscriptionResponse> get(String userId);
    SubscriptionResponse update(UpdateSubscriptionCommand updateSubscriptionCommand);

    List<SubscriptionResponse> get(Map<String, String> queryParams);
}
