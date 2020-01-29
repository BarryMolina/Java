package StaticExample;


public class Countable {

    private static int instanceCount = 0;

    public Countable(){
        instanceCount++;
    }

    public int getInstanceCount() {
        return instanceCount;
    }
}
