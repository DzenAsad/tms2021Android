package com.myshop.exceptions.data;

import com.myshop.exceptions.MyShopException;

public class WrongInitDataException extends MyShopException {
    public WrongInitDataException() {
        super();
    }

    public WrongInitDataException(String message) {
        super(message);
    }
}
