package com.jdk.day01;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author xh.d
 * @since 2018/8/13 16:29
 */
public class PropertyDescriptorTest {

    public static void main(String[] args) {
        Upo upo = new Upo();
        try {
            PropertyDescriptor pd = new PropertyDescriptor("name",upo.getClass());
            if (pd!=null){
                Method method = pd.getWriteMethod();
                Object values[] = {"dxh"};
                method.invoke(upo, values);
                Method readMethod = pd.getReadMethod();
                System.out.println(readMethod.invoke(upo));
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    static class Upo{
        private String name;
        private String pwd;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }
    }
}
