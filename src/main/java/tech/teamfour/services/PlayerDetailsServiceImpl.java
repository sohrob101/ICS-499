package tech.teamfour.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.teamfour.model.Player;
import tech.teamfour.repositories.PlayerRepository;

import java.util.Optional;

@Service
public class PlayerDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<Player> player = playerRepository.findByUserName(name);
        player.orElseThrow(() -> new UsernameNotFoundException(name + " not registered"));
        return player.map(PlayerDetailsImpl::new).get();
    }
}
