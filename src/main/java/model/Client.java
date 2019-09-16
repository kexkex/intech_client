package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Client {

    private String uid;
    private String name;
    private Set<Content> contents = new HashSet<>();

    public Client(){
    }

    public Client(String name, String uid){
        this.name = name;
        this.uid = uid;
        System.out.println(this.uid);
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Content> getContents() {
        return contents;
    }

    public void setContents(Set<Content> contents) {
        this.contents = contents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return uid == client.uid &&
                Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, name);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + uid +
                ", name='" + name + '\'' +
                '}';
    }
}
