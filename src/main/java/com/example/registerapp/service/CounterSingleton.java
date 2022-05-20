package com.example.registerapp.service;

public class CounterSingleton {

    private static CounterSingleton instance = new CounterSingleton();

    public int counter = 1;

    private CounterSingleton() {}

    public static CounterSingleton getInstance() {
        return instance;
    }

    public void increment()
    {
        this.counter++;
    }
}
