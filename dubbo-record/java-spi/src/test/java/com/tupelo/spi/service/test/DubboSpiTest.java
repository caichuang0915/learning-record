package com.tupelo.spi.service.test;

import com.tupelo.spi.service.DubboRobot;
import com.tupelo.spi.service.DubboTest;
import com.tupelo.spi.service.Robot;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @description
 * @author: ts
 * @create:2021-05-26 14:29
 */
public class DubboSpiTest {


    @Test
    public void testSayHello() {

        ExtensionLoader<DubboRobot> extensionLoader = ExtensionLoader.getExtensionLoader(DubboRobot.class);
        DubboRobot dubboARobot = extensionLoader.getExtension("DubboBRobot");
        dubboARobot.sayHello();

//
//        ExtensionLoader<DubboTest> testExtensionLoader = ExtensionLoader.getExtensionLoader(DubboTest.class);
//        DubboTest aTest = testExtensionLoader.getExtension("DubboATest");
//        aTest.doTest();


    }
}
