package com;

/**
 * Created by zoujianglin
 * 2018/8/28 0028.
 */

/**
 * 该来保存了动态代理的配置关系，
 */
public class ProxyConfig {
    private static final long serialVersionUID = -8409359707199703185L;
    private boolean proxyTargetClass = false;
    private boolean optimize = false;
    boolean opaque = false;
    boolean exposeProxy = false;
    private boolean frozen = false;

    public ProxyConfig() {
    }

    public void setProxyTargetClass(boolean proxyTargetClass) {
        this.proxyTargetClass = proxyTargetClass;
    }

    public boolean isProxyTargetClass() {
        return this.proxyTargetClass;
    }

    public void setOptimize(boolean optimize) {
        this.optimize = optimize;
    }

    public boolean isOptimize() {
        return this.optimize;
    }

    public void setOpaque(boolean opaque) {
        this.opaque = opaque;
    }

    public boolean isOpaque() {
        return this.opaque;
    }

    public void setExposeProxy(boolean exposeProxy) {
        this.exposeProxy = exposeProxy;
    }

    public boolean isExposeProxy() {
        return this.exposeProxy;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public boolean isFrozen() {
        return this.frozen;
    }

    public void copyFrom(ProxyConfig other) {
        if (other == null) {
            throw new RuntimeException("other is null");
        }
        //  Assert.notNull(other, "Other ProxyConfig object must not be null");
        this.proxyTargetClass = other.proxyTargetClass;
        this.optimize = other.optimize;
        this.exposeProxy = other.exposeProxy;
        this.frozen = other.frozen;
        this.opaque = other.opaque;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("proxyTargetClass=").append(this.proxyTargetClass).append("; ");
        sb.append("optimize=").append(this.optimize).append("; ");
        sb.append("opaque=").append(this.opaque).append("; ");
        sb.append("exposeProxy=").append(this.exposeProxy).append("; ");
        sb.append("frozen=").append(this.frozen);
        return sb.toString();
    }


}
