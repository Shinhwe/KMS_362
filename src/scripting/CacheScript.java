package scripting;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CacheScript
{
  private static final HashMap<String, String> ScriptCacheMap = new HashMap<>();

  private static void DoCacheByPath (String Path)
  {
    Stream.of(new File(Path).listFiles()).forEach((file) ->
    {
      System.out.println("緩存腳本文件: " + file.getPath());
      if (file.isDirectory())
      {
        DoCacheByPath(file.getPath());
      }
      else if (file.getName().toLowerCase().endsWith(".js"))
      {
        try (Stream<String> stream = Files.lines(file.toPath(), StandardCharsets.UTF_8))
        {
          String lines = "load('nashorn:mozilla_compat.js');";
          lines = lines + stream.collect(Collectors.joining(System.lineSeparator()));
          ScriptCacheMap.put(file.getPath(), lines);
        }
        catch (Exception e)
        {
          System.out.println("緩存腳本文件失敗! 路徑=  " + file.getPath());
          e.printStackTrace();
        }
      }
    });
  }

  public static void CacheAllScript ()
  {
    String basePath = "scripts/";

    DoCacheByPath(basePath);
  }

  public static String getScriptByPath (String path)
  {
    if (ScriptCacheMap.containsKey(path))
    {
      return ScriptCacheMap.get(path);
    }
    return null;
  }

  public static void ReloadScriptCache ()
  {
    ScriptCacheMap.clear();
    CacheAllScript();
  }
}
