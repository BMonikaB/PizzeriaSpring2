package com.example.kurs.domain;

public enum OrderStatus {

    NEW,
    IN_PROGRESS,
    COMPLETE;

    public static OrderStatus changeOrderStatus(OrderStatus orderStatus){
        if(orderStatus ==NEW)
            return IN_PROGRESS;

        else if(orderStatus==IN_PROGRESS)
            return COMPLETE;

        else throw new IllegalArgumentException("Nie ma takiej możliwości");
        }


}
