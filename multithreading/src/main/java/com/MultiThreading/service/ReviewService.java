package com.MultiThreading.service;

import com.MultiThreading.domain.Review;

import static com.MultiThreading.util.CommonUtil.delay;

public class ReviewService {

    public Review retrieveReviews(String productId) {
        delay(1000);
        return new Review(200, 4.5);
    }
}
