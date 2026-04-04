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

interface Persistence {
    void save(String content);
}

class FileStorage implements Persistence {
    @Override
    public void save(String content) {
        System.out.println("Saving to file" + content);
    }
}

class GoggleDocs {
    private GoggleDocumentEditor googleDocEditor;
    private Persistence storage;

    public GoggleDocs(GoggleDocumentEditor doc, Persistence file) {
        this.googleDocEditor = doc;
        this.storage = storage;
    }

    public void addText(String text) {
        googleDocEditor.addElement(new TextElement(text));
    }

    public void addImage(String path) {
        googleDocEditor.addElement(new ImageElement(path));
    }
}
public class SOLIDGoogleDoc {
    public static void main(String[] args) {
        
    }
}
