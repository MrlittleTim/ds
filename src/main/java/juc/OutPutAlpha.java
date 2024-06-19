package juc;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author tim
 * @date 2024/6/4
 */

public class OutPutAlpha {

    static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
    public static void main(String[] args) {
        int length = ALPHA.length();
        int count = 200;
        List<String> list = new ArrayList<>(length * count);
        for (int i = 0; i < length; i++) {
            char ch = ALPHA.charAt(i);
            for (int j = 0; j < count; j++) {
                list.add(String.valueOf(ch));
            }
        }
        Collections.shuffle(list);

        File dir = new File("tmp");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        for (int i = 0; i < 26; i++) {
            try (PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(
                            Files.newOutputStream(new File(dir, (i + 1) + ".txt").toPath())))) {
                String collect = String.join("\n", list.subList(i * count, (i + 1) * count));
                out.print(collect);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
