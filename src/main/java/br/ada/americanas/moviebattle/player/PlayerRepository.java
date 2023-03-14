package br.ada.americanas.moviebattle.player;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    public List<Player> findAllByOrderByScoreDesc();
}
