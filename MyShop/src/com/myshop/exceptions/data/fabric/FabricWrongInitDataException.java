package com.myshop.exceptions.data.fabric;

import com.myshop.exceptions.data.WrongInitDataException;

public class FabricWrongInitDataException extends WrongInitDataException {
    public FabricWrongInitDataException() {
        super();
    }

    public FabricWrongInitDataException(String message) {
        super(message);
    }
}
