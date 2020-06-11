package com.company.netprogram.user;

import java.io.Serializable;

public class UserMagger implements Serializable {
    private static final long serialVersionUID = -7328692836645473850L;
    private String ty;
    private User user;

    public String getTy() {
        return ty;
    }

    public void setTy(String ty) {
        this.ty = ty;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return "UserMagger{" +
                "ty='" + ty + '\'' +
                ", user=" + user +
                '}';
    }
}
