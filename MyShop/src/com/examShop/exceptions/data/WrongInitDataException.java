package com.examShop.exceptions.data;

import com.examShop.exceptions.MyShopException;

public class WrongInitDataException extends MyShopException {
    public WrongInitDataException() {
        super();
    }

    public WrongInitDataException(String message) {
        super(message);
    }
}
