package net.zethmayr.benjamin.spring.common.mapper.test;

public enum ExampleEnum {
    Grob(0), Gob(90), Glob(180), Grod(270);

    public final int facingAngle;

    public final int facingAngle() {
        return facingAngle;
    }

    ExampleEnum(final int facingAngle) {
        this.facingAngle = facingAngle;
    }
}
