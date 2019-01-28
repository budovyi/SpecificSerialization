public interface IFigures {
    public void draw();
    public void fill(String color);

    int getSize();
    public  String getColor();
    public String toXml(IFigures figure);
    public String toJson(IFigures figure);
}
