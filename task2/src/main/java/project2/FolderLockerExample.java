package project2;

import java.io.*;
import java.nio.channels.*;

public class FolderLockerExample {
        public static void main(String[] args) throws Exception {
                try {
                        RandomAccessFile file = new RandomAccessFile("E:/file.txt", "rw");
                        FileChannel fileChannel = file.getChannel();
                        FileLock fileLock = fileChannel.tryLock();
                        if (fileLock != null) {
                                System.out.println("Folder is locked");
                                accessFile();
                        }
                } catch (Exception e) {
                }
        }

        public static void accessFile() {
                try {
                        String line = "";
                        BufferedReader br = new BufferedReader(
                                        new FileReader("E:/file.txt"));
                        while ((line = br.readLine()) != null) {
                                System.out.println(line);
                        }
                } catch (Exception e) {
                        System.out.println(e);
                }
        }
}