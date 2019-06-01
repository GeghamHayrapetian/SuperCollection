package com.aca.collection.SuperCollection;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class SuperCollection<T> implements Iterable<Object> {
    private int size = 100;
    private Object[] objects = new Object[size];

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    @Override
    public Iterator<Object> iterator() {
        return iterator;

    }

    private Iterator<Object> iterator = new Iterator<Object>() {
        final Object[] objects = new Object[1000];
        int i = 0;

        @Override
        public boolean hasNext() {
            return i < objects.length;
        }

        @Override
        public Object next() {
            Object object = objects[i];
            i += 1;
            return object;
        }
    };

    private boolean unique(Object obj) {
        boolean flag = false;
        for (Object o : objects) {
            if (!obj.equals(o)) {
                flag = true;
            }
        }
        return flag;
    }

    public void add(Object obj) {
        if(objects.length==0)
        {
            objects[0]=obj;
        }
        if ((objects.length < (int) (size / 1.5))) {
            if (unique(obj)) objects[objects.length - 1] = obj;
            else if (unique(obj) == false) {
                System.out.println("Object arent unique");
            } else {
                int length = objects.length;
                Object[] newObject = new Object[size * 2];
                setObjects(newObject);
                objects[length - 1] = obj;
                size *= 2;

            }
        }

    }

    public void add(int index, Object obj) {
        if (index < size && index > objects.length) {
            if (unique(obj)) objects[index] = obj;
            else System.out.println("Object arent unique");

        }
        if (index < size && index < objects.length) {
            if (unique(obj)) {
                Object[] newObjects = new Object[size];
                for (int i = 0; i < size; ++i) {
                    newObjects[i] = objects[i];
                    if (i == index) {
                        newObjects[index] = obj;
                        ++i;
                    }
                }
                setObjects(newObjects);
            }

        }
        if (index > size) {
            Object[] newObject = new Object[size * 2];
            setObjects(newObject);
            objects[index] = obj;
            size *= 2;

        }

    }

    public Object get(int index) {
        return objects[index];
    }

    public void remove(int index) {
        for (int i = index; i < objects.length; ++i)
            objects[i] = objects[i + 1];
    }

    public void remove(Object obj) {

        for (int i = 0; i < objects.length; ++i) {
            if (objects[i] == obj)
                remove(i);
            break;
        }
    }
    public boolean contains(Object obj)
    {
        boolean flag =false;
        for (int i = 0; i < objects.length; ++i) {
            if (objects[i] == obj)
                flag =true;
            break;
        }
        return flag;
    }
    public String toString ()
    {

        StringBuilder string =new StringBuilder();
        string.append('(');
        for (Object o:objects
             ) {
            string.append(o);
            string.append(',');
        }
        string.append(')');
        {

        }
        System.out.println(string);
        return string.toString();
    }


}





