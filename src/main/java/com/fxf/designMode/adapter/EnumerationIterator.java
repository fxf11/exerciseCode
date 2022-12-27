package com.fxf.designMode.adapter;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * @Classname EnumerationIterator
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/12/23 17:33
 * @Created by 饭小范
 */
public class EnumerationIterator implements Iterator {

    Enumeration emuml;

    public EnumerationIterator(Enumeration emuml) {
        this.emuml = emuml;
    }

    @Override
    public boolean hasNext() {
        return emuml.hasMoreElements();
    }

    @Override
    public Object next() {
        return emuml.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
