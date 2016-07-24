package com.doctor.spi;

import java.util.ServiceLoader;

import com.doctor.spi.service.Car;

/**
 * @author sdcuike
 *
 *         Created on 2016年7月24日 下午10:20:45
 */
public class SPIDemo {

    public static void main(String[] args) {
        ServiceLoader<Car> serviceLoader = ServiceLoader.load(Car.class);

        serviceLoader.forEach(SPIDemo::runCar);
    }

    static void runCar(Car car) {
        System.out.println(car);
        car.run();
    }
}
