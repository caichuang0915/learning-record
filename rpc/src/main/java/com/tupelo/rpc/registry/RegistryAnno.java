package com.tupelo.rpc.registry;

import java.lang.annotation.*;

/**
 * @Author: caichuang
 * @Date: 2023/5/11 17:46
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RegistryAnno {

	Class<?> interfaceClass() default void.class;
}
