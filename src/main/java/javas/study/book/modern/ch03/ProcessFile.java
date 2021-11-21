package javas.study.book.modern.ch03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcessFile {

    public String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }

    public void test() {
        try {
            String result = processFile(br -> br.readLine() + br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
