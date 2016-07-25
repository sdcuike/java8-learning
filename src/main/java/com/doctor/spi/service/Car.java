package com.doctor.spi.service;

import com.alibaba.cooma.Extension;

/**
 * @author sdcuike
 *
 *         Created on 2016年7月24日 下午10:21:37
 * 
 *         Extension Point，扩展点，要扩展的接口。提倡面向接口的编程，这些接口定义就变成了扩展点。
 */

@Extension
public interface Car {
    void run();
}
