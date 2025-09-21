package com.pratik.fooddelivery.food_delivery_app.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferDetailsController {

    @RequestMapping(value = "/getOffer/{restaurant}", method = RequestMethod.GET)
    public int getOfferDetails(@PathVariable String restaurant) {
        return switch (restaurant) {
            case "Juicy Galaxy" -> 10;
            case "Behrooz Biryani" -> 15;
            default -> throw new IllegalStateException("restaurant no food" + restaurant);
        };
    }
}
