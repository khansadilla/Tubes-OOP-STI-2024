package com.pvz.Interface;

import com.pvz.Point;
import com.pvz.ExceptionHandling.IllegalTypeException;

public interface Factory<T> {
    public T create(long timeCreated, String type) throws IllegalTypeException;
}
