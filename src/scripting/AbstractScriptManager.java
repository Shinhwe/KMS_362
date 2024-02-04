package scripting;

import client.MapleClient;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractScriptManager
{
  private static final ScriptEngineManager sem = new ScriptEngineManager();


  protected Invocable getInvocable (String path, MapleClient c)
  {
    return getInvocable(path, c, false);
  }

  protected Invocable getInvocable (String path, MapleClient c, boolean npc)
  {
    path = "scripts/" + path;
    ScriptEngine engine = null;
    if (c != null)
    {
      engine = c.getScriptEngine(path);
    }
    if (engine == null)
    {
      File scriptFile = new File(path);
      if (!scriptFile.exists())
      {
        return null;
      }
      engine = sem.getEngineByName("nashorn");
      if (c != null)
      {
        c.setScriptEngine(path, engine);
      }

      String cachedScript = CacheScript.getScriptByPath(path);

      if (cachedScript != null)
      {
        try
        {
          engine.eval(cachedScript);
        }
        catch (ScriptException e)
        {
          e.printStackTrace();
          return null;
        }
      }
      else
      {
        try (Stream<String> stream = Files.lines(scriptFile.toPath(), StandardCharsets.UTF_8))
        {
          String lines = "load('nashorn:mozilla_compat.js');";
          lines = lines + stream.collect(Collectors.joining(System.lineSeparator()));
          engine.eval(lines);
        }
        catch (ScriptException | java.io.IOException e)
        {
          e.printStackTrace();
          return null;
        }
      }
    }
    return (Invocable) engine;
  }
}
