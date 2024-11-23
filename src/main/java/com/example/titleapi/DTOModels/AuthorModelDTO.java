package com.example.titleapi.DTOModels;


public class AuthorModelDTO {
    private long ID;
    private int age;
    private String nickname;
    private long titleID;
    private long fioId;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getTitleID() {
        return titleID;
    }

    public void setTitleID(long titleID) {
        this.titleID = titleID;
    }

    public long getFioId() {
        return fioId;
    }

    public void setFioId(long fioId) {
        this.fioId = fioId;
    }

    public AuthorModelDTO(long ID, int age, String nickname, long titleID, long fioId) {
        this.ID = ID;
        this.age = age;
        this.nickname = nickname;
        this.titleID = titleID;
        this.fioId = fioId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
