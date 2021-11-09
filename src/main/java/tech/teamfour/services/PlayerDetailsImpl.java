package tech.teamfour.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tech.teamfour.model.Player;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private boolean isActive;
    private List<GrantedAuthority> authorities;

    public PlayerDetailsImpl(Player player){
        this.username = player.getUserName();
        this.password = player.getPassword();
        this.isActive = player.isActive();
        this.authorities = Arrays.stream(player.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public PlayerDetailsImpl(){}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
