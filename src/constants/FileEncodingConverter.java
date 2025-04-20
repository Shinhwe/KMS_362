package constants;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class FileEncodingConverter {

  public static void main(String[] args) {
    // 指定要处理的文件夹路径
    Path rootDir = Paths.get("./scripts");

    try {
      // 使用Files.walkFileTree遍历文件夹及其子文件夹
      Files.walkFileTree(rootDir, new SimpleFileVisitor<Path>() {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
          // 检查文件是否为.js文件
          if (file.toString().endsWith(".js")) {
            processJsFile(file);
          }
          return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
          System.err.println("访问文件失败: " + file + " - " + exc.getMessage());
          return FileVisitResult.CONTINUE;
        }
      });

      System.out.println("文件处理完成！");

    } catch (IOException e) {
      System.err.println("处理文件时发生错误: " + e.getMessage());
      e.printStackTrace();
    }
  }

  private static void processJsFile(Path file) {
    System.out.println("处理文件: " + file);

    try {
      // 尝试使用UTF-8读取文件
      String content = readFile(file, StandardCharsets.UTF_8);
      // 如果成功读取，使用UTF-8保存回文件
      Files.write(file, content.getBytes(StandardCharsets.UTF_8));
      System.out.println("  - 文件已使用UTF-8编码保存");

    } catch (MalformedInputException e) {
      // 如果UTF-8读取失败，尝试使用MS949读取
      try {
        System.out.println("  - UTF-8读取失败，尝试使用MS949读取");
        String content = readFile(file, Charset.forName("MS949"));
        // 使用UTF-8保存回文件
        Files.write(file, content.getBytes(StandardCharsets.UTF_8));
        System.out.println("  - 文件已从MS949转换为UTF-8编码保存");

      } catch (IOException ex) {
        System.err.println("  - 使用MS949读取文件失败: " + ex.getMessage());
      }

    } catch (IOException e) {
      System.err.println("  - 处理文件时发生错误: " + e.getMessage());
    }
  }

  private static String readFile(Path file, Charset charset) throws IOException {
    StringBuilder content = new StringBuilder();

    try (Stream<String> stream = Files.lines(file, charset)) {
      stream.forEach(line -> {
        content.append(line).append(System.lineSeparator());
      });
    }

    return content.toString();
  }
}