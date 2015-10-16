package com.rovergames.example.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Configuration extends AbstractEntity {
    @Id
    @GeneratedValue(generator = "configuration-uuid")
    @GenericGenerator(name = "configuration-uuid", strategy = "uuid")
    @Column(length = 32)
    private String id;

    @Column(nullable = false, unique = true, length = 32)
    private String name;

    @Column(nullable = false, length = 50)
    private String hostname;

    @Column(nullable = false)
    private long port;

    private String commonProperty;

    @Column(nullable = false)
    private String username;

    protected Configuration() {
    }

    public Configuration(String name, String hostname, long port, String username) {
        this.name = name;
        this.hostname = hostname;
        this.port = port;
        this.username = username;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public long getPort() {
        return port;
    }

    public void setPort(long port) {
        this.port = port;
    }

    public String getCommonProperty() {
        return commonProperty;
    }

    public void setCommonProperty(String commonProperty) {
        this.commonProperty = commonProperty;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
