package com.alexstrive;

import java.util.LinkedList;
import java.util.List;

public abstract class Composite {
    private final String name;
    private final List<Composite> children;
    private Composite parent;

    public Composite(String name) {
        this.name = name;
        this.children = new LinkedList<>();
    }

    protected boolean add(Composite composite) {
        if (!isEligibleComposite(composite)) {
            return false;
        }

        children.add(composite);
        composite.parent = this;

        return true;
    }

    public boolean isEligibleComposite(Composite composite) {
        if (composite == null || composite == this) {
            return false;
        } else if (this.parent != null) {
            return this.parent.isEligibleComposite(composite);
        }

        return true;
    }

    public String getName() {
        return name;
    }

    public List<Composite> getChildren() {
        return children;
    }
}
