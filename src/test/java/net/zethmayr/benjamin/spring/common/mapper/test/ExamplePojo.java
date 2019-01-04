package net.zethmayr.benjamin.spring.common.mapper.test;


public class ExamplePojo {
    protected Integer id;
    protected String name;
    protected String primaryCatchphrase;

    public Integer getId() {
        return id;
    }

    public ExamplePojo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ExamplePojo setName(String name) {
        this.name = name;
        return this;
    }

    public String getPrimaryCatchphrase() {
        return primaryCatchphrase;
    }

    public ExamplePojo setPrimaryCatchphrase(String primaryCatchphrase) {
        this.primaryCatchphrase = primaryCatchphrase;
        return this;
    }
}
