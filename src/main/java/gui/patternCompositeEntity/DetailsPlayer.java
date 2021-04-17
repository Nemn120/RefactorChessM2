package gui.patternCompositeEntity;

public class DetailsPlayer {

    Player player = new Player();

    public void setDataOfPlayers(String playerName, int numDeadsPieces) {
        String data = "Jugador: " + playerName + "\n" + "Número de piezas muertas: " + numDeadsPieces + "\n" +
                "Número de piezas disponibles: " + (16 - numDeadsPieces);
        player.setData(data);
    }

    public String getDataOfPlayer() {
        return player.getData();
    }

}
