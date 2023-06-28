package com.fxf.designMode.iterator;

import java.util.Iterator;
import java.util.Stack;

/**
 * @Classname CompositeIterator
 * @Description TODO
 * @Version 1.0.0
 * @Date 2023/3/12 14:32
 * @Created by 饭小范
 */
public class CompositeIterator implements Iterator {

    Stack stack = new Stack();

    public CompositeIterator(Iterator iterator) {
//        this.stack = stack;
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {

        return false;
    }

    @Override
    public Object next() {
        if (hasNext()){
            Iterator iterator = (Iterator) stack.peek();
            Object next = iterator.next();
            if (next instanceof Integer){
                stack.push(next);
            }
        }
        return null;
    }
}
