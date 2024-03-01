package ua.alikhanov.hw.hw021.builder;

public class Computer {
    private final String processor;
    private final int ram;
    private final int storage;

    private Computer(String processor, int ram, int storage) {
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
    }

    public String getProcessor() {
        return processor;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public static class Builder {
        private String processor;
        private int ram;
        private int storage;

        public Builder() {}

        public Builder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public Builder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(processor, ram, storage);
        }
    }
}
