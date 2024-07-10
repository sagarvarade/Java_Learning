package designpatterns.Structural.Decorator;

public interface DataSource {
    void writeData(String data);

    String readData();
}