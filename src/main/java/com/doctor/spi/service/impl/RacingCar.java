package com.doctor.spi.service.impl;

import com.doctor.spi.service.Car;

/**
 * @author sdcuike
 *
 *         Created on 2016年7月24日 下午10:22:28
 * 
 *         Extension，扩展，即扩展点的实现
 */
public class RacingCar implements Car {

    @Override
    public void run() {
        System.out.println("RacingCar Running...");
    }

}
