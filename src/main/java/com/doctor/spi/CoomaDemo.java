package com.doctor.spi;

import com.alibaba.cooma.ExtensionLoader;
import com.doctor.spi.service.Car;

/**
 * Cooma SPI Demo
 * 
 * @author sdcuike
 *
 *         Created on 2016年7月25日 下午10:11:49
 * 
 * @see https://github.com/alibaba/cooma/wiki
 */
public class CoomaDemo {

    public static void main(String[] args) {
        // ExtensionLoader维护扩展点实现实例的 单例，即getExtension方法对于同一个扩展点实现名返回的实例是同一个。
        // 是不是和spring容器中by name获取容器中的bean实例差不多。
        // 这个使用方式可以通过扩展点实现名获得 单个接口的指定实现。

        ExtensionLoader<Car> extensionLoader = ExtensionLoader.getExtensionLoader(Car.class);
        Car racingCar = extensionLoader.getExtension("racingCar");
        racingCar.run();

        Car sportCar = extensionLoader.getExtension("sportCar");
        sportCar.run();
    }

}
