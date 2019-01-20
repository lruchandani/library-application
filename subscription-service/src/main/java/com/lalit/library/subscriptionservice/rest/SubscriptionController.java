package com.lalit.library.subscriptionservice.rest;

import com.lalit.library.subscriptionservice.model.Subscription;
import com.lalit.library.subscriptionservice.rest.model.AddSubscriptionCommand;
import com.lalit.library.subscriptionservice.rest.model.SubscriptionResponse;
import com.lalit.library.subscriptionservice.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class SubscriptionController {

    public static final String SUBSCRIPTIONS = "subscriptions";
    @Autowired private SubscriptionService subscriptionService;

    @PostMapping(SUBSCRIPTIONS)
    public ResponseEntity add(@RequestBody AddSubscriptionCommand addSubscriptionCommand) {
        Subscription subscription = new Subscription(addSubscriptionCommand);
        String subId = subscriptionService.add(addSubscriptionCommand);
        String location = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(SubscriptionController.class).add(addSubscriptionCommand)).withSelfRel().getHref() + "/" + subId;
        return  ResponseEntity.created(URI.create(location)).build();
    }

    @GetMapping(value = SUBSCRIPTIONS+ "/{subscriptionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity get(@PathVariable("subscriptionId") String subscriptionId) {
        SubscriptionResponse subscriptionResponse = subscriptionService.getOne(subscriptionId);
        return ResponseEntity.ok(subscriptionResponse);
    }

    @GetMapping(SUBSCRIPTIONS)
    public ResponseEntity get(@RequestParam Map<String,String> queryParams) {
        List<SubscriptionResponse> subscriptions  = subscriptionService.get(queryParams);
        return ResponseEntity.ok(subscriptions);
    }
}
