package Object_Class;

import java.util.Objects;

public class Usuarios {

    private int id;
    private String name = "Juan";
    private String pass = "123";

    public Usuarios(){
        id=1;
    }

    public Usuarios(int id, String name, String pass) {
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuarios usuarios = (Usuarios) o;
        return id == usuarios.id && Objects.equals(name, usuarios.name) && Objects.equals(pass, usuarios.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pass);
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
