package com.example.titleapi.DTOModels;


public class RoleModelDTO {
    private long ID;
    private String name;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleModelDTO(long ID, String name) {
        this.ID = ID;
        this.name = name;
    }
}
