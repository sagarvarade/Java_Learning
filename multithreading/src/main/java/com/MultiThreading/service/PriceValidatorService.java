package com.MultiThreading.service;


import com.MultiThreading.domain.checkout.CartItem;

import static com.MultiThreading.util.CommonUtil.delay;
import static com.MultiThreading.util.LoggerUtil.log;

public class PriceValidatorService {

    public boolean  isCartItemInvalid(CartItem cartItem){
        int cartId = cartItem.getItemId();
        log("isCartItemInvalid : " + cartItem);
        delay(500);
        if (cartId == 7 || cartId == 9 || cartId == 11) {
            return true;
        }
        return false;
    }
}
