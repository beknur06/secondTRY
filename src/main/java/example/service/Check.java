package example.service;

import example.player.Players;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class Check {
    public Check() {
        this.players = new HashMap<>();
        players.put("admin", new Players("admin", "admin","admin","admin"));
    }
    private Map<String, Players> players;
    public boolean login(String username, String password){
        if (!players.containsKey(username)) {
            return false;
        } else {
            Players player = players.get(username);
            return player.getPassword().equals(password);
        }
    }
    public boolean register(String name, String surname, String username, String password){
        if (!players.containsKey(username)) {
            players.put(username, new Players(name, surname, username, password));
            return true;
        } else {
            return false;
        }

    }
}
