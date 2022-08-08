package info.drealm.jtrapkateditor17;

public enum EnumSingleton {

    INSTANCE("Initial class info"); 

    private String info;

    private EnumSingleton(String info) {
        this.info = info;
    }

    public EnumSingleton getInstance() {
        return INSTANCE;
    }

}
