package control;

import boundary.Management;

public abstract class AbstractManagement implements Management {
    protected String name;

    public AbstractManagement(String name) {
        this.name = name;
    }

    public abstract void performDuties();
}
