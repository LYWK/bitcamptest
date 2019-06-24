package com.bitcamp.web.common.lamda;



/**
 * IConsumer
 */
// @Component//타입정의 
@FunctionalInterface
public interface IConsumer {
    public abstract void accept(Object o);
        

}