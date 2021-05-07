package com.lzq.pattern.gof23pattern.behavioral.templatemethod.demo02;

public abstract class AbstractCourse {
    public final void createCourse() {
        //1.发布预习资料
        postPreResources();
        //2.制作课件PPT
        createPPT();
        //3.在线直播
        liveVideo();
        //4.上传课后资料
        postResources();
        //5.布置作业
        postHomeWork();
        //6.通过钩子方法决定是否检查作业
        if (needCheckHomework()) {
            checkHomework();
        }

    }

    protected abstract void checkHomework();
    //钩子方法
    protected boolean needCheckHomework() {
        return false;
    }

    protected void postHomeWork() {
        System.out.println("布置作业");
    }

    protected void postResources() {
        System.out.println("上传课后资料");
    }

    protected void liveVideo() {
        System.out.println("在线直播");
    }

    protected void createPPT() {
        System.out.println("制作课件");
    }

    protected void postPreResources() {
        System.out.println("发布预习资料");
    }


}
