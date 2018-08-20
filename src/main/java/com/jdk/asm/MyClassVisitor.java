package com.jdk.asm;


import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
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
    public MethodVisitor visitMethod(int access, String name, String returnValue, String signature, String[] exceptions) {
        MyMethodVisitor visitor = new MyMethodVisitor();
        visitor.visitMethodInsn(Opcodes.ASM5,this.getClass().getName(),name,returnValue,false);
        return super.visitMethod(access, name, returnValue, signature, exceptions);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        AnnotationVisitor visitor = new MyAnnotationVisitor();
        visitor.visit(descriptor,visible);
        return visitor;
    }

    class MyAnnotationVisitor extends AnnotationVisitor{
        public MyAnnotationVisitor() {
            super(Opcodes.ASM5);
        }

        public MyAnnotationVisitor(AnnotationVisitor annotationVisitor) {
            super(Opcodes.ASM5, annotationVisitor);
        }

        @Override
        public void visit(String name, Object value) {
            System.out.println(name);
        }
    }

    class MyMethodVisitor extends MethodVisitor{
        public MyMethodVisitor() {
            super(Opcodes.ASM5);
        }

        public MyMethodVisitor(MethodVisitor methodVisitor) {
            super(Opcodes.ASM5, methodVisitor);
        }

        @Override
        public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
            System.out.println(opcode);
            System.out.println(owner);
            System.out.println(name);
            System.out.println(descriptor);
            System.out.println(isInterface);
        }
    }
}
