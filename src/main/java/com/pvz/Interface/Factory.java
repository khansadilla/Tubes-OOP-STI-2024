package com.pvz.Interface;

import com.pvz.ExceptionHandling.IllegalTypeException;

public interface Factory<T> {
    public T create(int timeCreated, String type) throws IllegalTypeException;
}
