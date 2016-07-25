package com.doctor.spi.service.impl;

import com.doctor.spi.service.Car;

/**
 * 
 * @author sdcuike
 *
 *         Created on 2016年7月24日 下午10:23:11
 * 
 *         Extension，扩展，即扩展点的实现
 */
public class SportCar implements Car {

    @Override
    public void run() {
        System.out.println("SportCar Running...");
    }
}
