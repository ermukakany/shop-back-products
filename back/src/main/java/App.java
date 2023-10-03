package io.product;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) {
        DataStore.getInstance().getProduct(1003);
    }
}
