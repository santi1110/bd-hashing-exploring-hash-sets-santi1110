package com.amazon.ata.hashingset.partsmanager;

import java.util.List;
import java.util.Objects;

public class    DevicePart {
    private String manufacturer;  //read - only (not setters) inmutable
    private String manufacturersPartNumber;
    private List<AmazonDevice> devicesUsedIn;

    public DevicePart(String manufacturer, String manufacturersPartNumber, List<AmazonDevice> devicesUsedIn) {
        this.manufacturer = manufacturer;
        this.manufacturersPartNumber = manufacturersPartNumber;
        this.devicesUsedIn = devicesUsedIn;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("in teh.equals() for Device Part");
        if (this == o) return true;
        if (!(o instanceof DevicePart)) return false;
        DevicePart that = (DevicePart) o;
        return Objects.equals(getManufacturer(), that.getManufacturer()) && Objects.equals(getManufacturersPartNumber(), that.getManufacturersPartNumber());
    }

    @Override
    public int hashCode() {
        System.out.println("in teh.hashCode() for Device Part");
        return Objects.hash(getManufacturer(), getManufacturersPartNumber());
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getManufacturersPartNumber() {
        return manufacturersPartNumber;
    }

    public List<AmazonDevice> getDevicesUsedIn() {
        return devicesUsedIn;
    }

    public void setDevicesUsedIn(List<AmazonDevice> devicesUsedIn) {
        this.devicesUsedIn = devicesUsedIn;
    }

    public void addDeviceUsedIn(AmazonDevice amazonDevice) {
        devicesUsedIn.add(amazonDevice);
    }

    public void removeDeviceUsedIn(AmazonDevice amazonDevice) {
        devicesUsedIn.remove(amazonDevice);
    }

    @Override
    public String toString() {
        return String.format("Device Part: {manufacturer: %s, manufacturersPartNumber: %s, devicesUsedIn: %s}",
                manufacturer, manufacturersPartNumber, devicesUsedIn);
    }
}
