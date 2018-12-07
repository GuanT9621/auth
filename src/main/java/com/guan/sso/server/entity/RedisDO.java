package com.guan.sso.server.entity;

import java.io.Serializable;

public class RedisDO implements Serializable {

    private long uid;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "RedisDO{" +
                "uid=" + uid +
                '}';
    }
}
