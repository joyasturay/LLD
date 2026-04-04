package GoggleDocs;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

interface DocumentElements {
    public String render();
}

class TextElement implements DocumentElements {

    private String text;

    TextElement(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return this.text;
    }
}

class ImageElement implements DocumentElements {
   private String path;

    ImageElement(String path) {
        this.path = path;
    }

    @Override
    public String render() {
        return "[Image: " + path + "]";
    }
}

class GoggleDocumentEditor {
    private List<DocumentElements> list = new ArrayList<>();

    public void addElement(DocumentElements element) {
        list.add(element);
   }

    public String render() {
        StringBuilder sb = new StringBuilder();
        for (DocumentElements d : list) {
            sb.append(d.render()).append("/n");
        }
        return sb.toString();
    }
}
public class SOLIDGoogleDoc {
    public static void main(String[] args) {
        
    }
}
