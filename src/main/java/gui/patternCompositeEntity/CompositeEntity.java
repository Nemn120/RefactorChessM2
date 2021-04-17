package gui.patternCompositeEntity;

public class CompositeEntity {

    private DetailsPlayer detailsPlayer = new DetailsPlayer();

    public void setDataOfPlayers(String playerName, int numDeadsPieces) {
        detailsPlayer.setDataOfPlayers(playerName, numDeadsPieces);
    }

    public String getData() {
        return detailsPlayer.getDataOfPlayer();
    }

}
