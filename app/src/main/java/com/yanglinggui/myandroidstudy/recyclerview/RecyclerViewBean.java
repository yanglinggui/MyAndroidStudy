package com.yanglinggui.myandroidstudy.recyclerview;

public class RecyclerViewBean {
    private int imageId;
    private String name;
    private int groupId;
    private boolean isFirest;
    private boolean isLast;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public boolean isFirest() {
        return isFirest;
    }

    public void setFirest(boolean firest) {
        isFirest = firest;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }
}
