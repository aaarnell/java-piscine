package edu.classes;

import java.util.StringJoiner;

public class Car {
    private String      brandName;
    private String      modelName;
    private Integer     enginePower;

    public Car() {
        this.brandName = "Default brand name";
        this.modelName = "Default model name";
        this.enginePower = 0;
    }

    public Car(String brandName, String modelName, Integer enginePower) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.enginePower = enginePower;
    }

    public Integer growEnginePower(Integer value) {
        this.enginePower += value;
        return enginePower;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
                .add("brandName='" + brandName + "'")
                .add("modelName='" + modelName + "'")
                .add("enginePower=" + enginePower)
                .toString();
    }
}
