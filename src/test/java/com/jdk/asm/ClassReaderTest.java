package com.jdk.asm;

import org.junit.Test;
import org.objectweb.asm.ClassReader;

import java.io.IOException;
import java.io.InputStream;

import static org.objectweb.asm.ClassReader.SKIP_DEBUG;

/**
 * @author xh.d
 * @since 2018/8/20 13:39
 */
public class ClassReaderTest {

    @Test
    public void testClassReader() throws IOException {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = cl.getResourceAsStream("com/jdk/ana/ByteAna.class");
        if (inputStream!=null) {
            ClassReader classReader = new ClassReader(inputStream);
            classReader.accept(new MyClassVisitor(),SKIP_DEBUG);
            String[] interfaces = classReader.getInterfaces();
            for (String ife:interfaces){
                System.out.println(ife);
            }
            String superName = classReader.getSuperName();
            System.out.println(superName);
        }
    }
}
