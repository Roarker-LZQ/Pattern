package com.lzq.pattern.gof23pattern.behavioral.templatemethod.demo02;

public class PythonCourse extends AbstractCourse {
    private boolean needCheckHomework = true;

    public void setNeedCheckHomework(boolean needCheckHomework) {
        this.needCheckHomework = needCheckHomework;
    }

    @Override
    protected boolean needCheckHomework() {
        return this.needCheckHomework;
    }
    @Override
    protected void checkHomework() {
        System.out.println("检查Python作业");
    }
}
