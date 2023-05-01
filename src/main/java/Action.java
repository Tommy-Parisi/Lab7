public abstract class Action {
    protected Game game;
    protected int fromRow;
    protected int fromCol;
    protected int toRow;
    protected int toCol;

    public Action(int fromRow, int fromCol, int toRow, int toCol, Game game) {
        this.fromRow = fromRow;
        this.fromCol = fromCol;
        this.toRow = toRow;
        this.toCol = toCol;
        this.game = game;
    }

    public abstract void performAction();
}