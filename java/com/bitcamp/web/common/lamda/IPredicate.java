package com.bitcamp.web.common.lamda;

/**
 * IPredicate
 */
@FunctionalInterface
public interface IPredicate {

      public abstract boolean test(Object o);
    
}