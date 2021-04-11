package netcracker;

public class MagicImpl implements Magic{
    private int x;
    @Override
    public void setNumber(int x) {
        this.x = x;
    }

    @Override
    public int getNumber() {
        return x;
    }
    /*
      Переворачивает число
    */
    @Override
    public void doMagic() {
        x = Integer.parseInt(new StringBuilder(Integer.toString(x)).reverse().toString());
    }
}
