package com.example.lock;

class ProductRemovalWorker implements Runnable {
    private final String name;
    private final LockedWarehouse warehouse;

    public ProductRemovalWorker(String name, LockedWarehouse warehouse) {
        this.name = name;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        for (int i =   0; i <   5; i++) {
            warehouse.remove(Product.BOOK, name);
        }
    }
}