package com.doctor.spi;

/**
 * @author sdcuike
 *
 *         Created on 2016年7月26日 下午11:03:28
 * 
 *         自适应实例是一个代理。在调用扩展点接口上的方法时，才决定真正要调用的哪个扩展点。
 *         # “延迟”决策。
 * 
 *         在方法调用时，要调用的哪个扩展点的信息来自于调用时的方法参数，在方法参数加上@Adaptive注解来标识。
 * 
 *         如何从方法参数上提取到要“要调用的哪个扩展点”？@Adaptive注释有属性extractor，用于指定“提取要调用的哪个扩展点”的实现。缺省使用MapSourceExtractor，要求方法实现Map接口。
 */
public class CoomaAdaptiveInstanceDemo {

    public static void main(String[] args) {

    }

}
