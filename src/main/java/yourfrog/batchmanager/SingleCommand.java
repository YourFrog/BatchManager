package yourfrog.batchmanager;

/**
 * @author YourFrog
 */
public class SingleCommand 
{
    private String name;
    
    private String command;

    public void setName(String name) {
        this.name = name;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
