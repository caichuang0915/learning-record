package com.tupelo.spi.service.test;

import com.tupelo.spi.service.Robot;
import org.junit.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @description
 * @author: ts
 * @create:2021-05-26 14:29
 */
public class JavaSpiTest {

    @Test
    public void testSayHello() {

        ServiceLoader<Robot> load = ServiceLoader.load(Robot.class);
        Iterator<Robot> iterator = load.iterator();
        while (iterator.hasNext()){
            Robot robot = iterator.next();
            robot.sayHello();
        }


    }
}
