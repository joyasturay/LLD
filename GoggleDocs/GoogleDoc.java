package GoggleDocs;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

class DocumentEditor {
    private List<String> elements=new ArrayList<>();
   private String renderedDocument="";

  
   public  void addText(String text) {
        elements.add(text);
    }

   public  void addImage(String path) {
        elements.add(path);
    }

    public String renderDocument() {
        if (!renderedDocument.isEmpty()) {
            return renderedDocument;
        }
        StringBuilder sb = new StringBuilder();
        for (String e : elements) {
            if (e.length() > 4 && (e.endsWith(".jpg") || e.endsWith(".png"))) {
                sb.append("Image: ").append(e).append("\n");
            } else {
                sb.append(e).append("\n");
            }
        }
        renderedDocument = sb.toString();
        return renderedDocument;
    }
    public void saveToFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(renderDocument());
            System.out.println("Document successfully saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Unable to open file: " + e.getMessage());
        }
    }
}
public class GoogleDoc {
    public static void main(String[] args) {
        DocumentEditor editor = new DocumentEditor();
        editor.addText("Hello World");
        editor.addImage("logo.png");
        editor.addText("This is a document editor.");

        System.out.println("--- Console Output ---");
        System.out.println(editor.renderDocument());
        
        editor.saveToFile("document.txt");
    }
}
