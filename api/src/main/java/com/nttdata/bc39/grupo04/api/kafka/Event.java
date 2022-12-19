package com.nttdata.bc39.grupo04.api.kafka;

import lombok.Data;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Data
public abstract class Event<T> {
    private String key;
    private Date date;
    private T data;
    private EventType type;
    private String message;

    public Event(T data, EventType type, String message) {
        this.data = data;
        this.type = type;
        this.message = message;
        this.key = UUID.randomUUID().toString();
        this.date = Calendar.getInstance().getTime();
    }
}
