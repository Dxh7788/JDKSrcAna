package com.jdk.asm;


import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author xh.d
 * @since 2018/8/20 15:00
 */
public class MyClassVisitor extends ClassVisitor {
    public MyClassVisitor() {
        super(Opcodes.ASM5);
    }

    public MyClassVisitor(ClassVisitor classVisitor) {
        super(Opcodes.ASM5, classVisitor);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        return new MyAnnotationVisitor();
    }
    class MyAnnotationVisitor extends AnnotationVisitor{
        public MyAnnotationVisitor() {
            super(Opcodes.ASM5);
        }

        public MyAnnotationVisitor(AnnotationVisitor annotationVisitor) {
            super(Opcodes.ASM5, annotationVisitor);
        }
    }
}
