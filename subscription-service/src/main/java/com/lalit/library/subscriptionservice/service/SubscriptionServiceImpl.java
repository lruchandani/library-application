package com.lalit.library.subscriptionservice.service;

import com.lalit.library.subscriptionservice.model.Subscription;
import com.lalit.library.subscriptionservice.repository.SubscriptionRepository;
import com.lalit.library.subscriptionservice.rest.model.AddSubscriptionCommand;
import com.lalit.library.subscriptionservice.rest.model.SubscriptionResponse;
import com.lalit.library.subscriptionservice.rest.model.UpdateSubscriptionCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{

  @Autowired private SubscriptionRepository subscriptionRepository;

    @Override
    public String add(AddSubscriptionCommand addSubscriptionCommand) {
        Subscription subscription = new Subscription(addSubscriptionCommand);
        Subscription savedSubscription = subscriptionRepository.save(subscription);
        return savedSubscription.getSubscriptionId();
    }

    @Override
    public SubscriptionResponse getOne(String subscriptionId) {
        SubscriptionResponse subscriptionResponse = new SubscriptionResponse(subscriptionRepository.getOne(subscriptionId));
        return subscriptionResponse;
    }

    @Override
    public List<SubscriptionResponse> get(String userId) {
        List<Subscription> subscriptions = subscriptionRepository.findByUserId(userId);
        List<SubscriptionResponse> responses = subscriptions.stream().map(SubscriptionResponse::new).collect(Collectors.toList());
        return responses;
    }

    @Override
    public SubscriptionResponse update(UpdateSubscriptionCommand updateSubscriptionCommand) {
        return null;
    }

    @Override
    public List<SubscriptionResponse> get(Map<String, String> queryParams) {
        String userId = queryParams.get("userId");
        return get(userId);
    }
}
