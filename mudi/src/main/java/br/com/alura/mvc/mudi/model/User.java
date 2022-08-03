package br.com.alura.mvc.mudi.model;

import javax.persistence.*;
import java.util.List;

@Entity()
@Table(name = "users")
public class User {
    @Id
    private String username;
    private String password;
    private Boolean enable;

    public String getUsername() {
        return username;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Pedido> pedidos;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
