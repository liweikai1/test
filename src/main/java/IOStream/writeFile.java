package IOStream;

import java.io.*;

/**
 * @Author: li wei kai
 * @Date: 2023/07/04/14:35
 * @Description:
 */
public class writeFile {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\test.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("liweikai");
        bufferedWriter.flush();

        FileOutputStream fos = new FileOutputStream(file,true);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("");
        bw.newLine();
        bw.flush();
        bw.close();
        osw.close();
        fos.close();
    }
}
