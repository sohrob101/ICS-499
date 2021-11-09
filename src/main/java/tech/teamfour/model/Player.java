package tech.teamfour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Proxy(lazy = false)
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long playerID;
    private String userName;
    private String password;
    private int bestScore;
    private boolean isActive;
    private String roles;
 
}