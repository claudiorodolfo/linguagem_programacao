public abstract sealed class Forma permits Retangulo, Circulo {

    public abstract double area();

    public abstract double perimetro();

    public abstract String nome();

    @Override
    public String toString() {
        return nome() + " área=" + area() + " perímetro=" + perimetro();
    }
}
