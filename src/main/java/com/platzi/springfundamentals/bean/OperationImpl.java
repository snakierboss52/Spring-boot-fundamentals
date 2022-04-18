package com.platzi.springfundamentals.bean;

public class OperationImpl implements Operation{


    @Override
    public int sum(int number) {
        return number + 24;
    }
}
