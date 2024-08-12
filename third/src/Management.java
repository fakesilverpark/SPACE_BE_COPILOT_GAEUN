import java.io.IOException;

public interface Management {
    void printElements(String elementName);
    void createElement(String elementName) throws IOException;
    void deleteElement(String elementName);
}