abstract class Individual
{
    private Integer coins;
    Integer getCoins() {
        return coins;
    }
    void setCoins(Integer coins) {
        this.coins = coins;
    }
    void addCoins(Integer coins) {
        this.coins += coins;
    }

    abstract Boolean colaborate();
    abstract void feedback(Boolean result);
    abstract Individual copy();
}