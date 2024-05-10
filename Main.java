public class Main
{
    public static void main(String[] args) {
        World world = new World(
            10, 1, 
            10, 1, 
            2, 4
        );

        for (int i = 0; i < 500; i++)
            world.add(new Matematico());
        
        while (!world.isEnded()) {
            world.makeRound();
            System.out.println(world);
        }
    }
}