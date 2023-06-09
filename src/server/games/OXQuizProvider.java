package server.games;

import database.DatabaseConnection;
import server.Randomizer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OXQuizProvider
{
  public static OXQuiz[] getQuizList (int amount)
  {
    OXQuiz[] list = new OXQuiz[amount];
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try
    {
      int rowCount = 0;
      con = DatabaseConnection.getConnection();
      ps = con.prepareStatement("SELECT count(*) rowCount FROM OXQuiz", 1004, 1007);
      rs = ps.executeQuery();
      if (rs.next())
      {
        rowCount = rs.getInt("rowCount");
      }
      ps.close();
      rs.close();
      for (int a = 0; a < amount; a++)
      {
        int quizid = Randomizer.rand(0, rowCount);
        ps = con.prepareStatement("SELECT * FROM OXQuiz WHERE Id = ?");
        ps.setInt(1, quizid);
        rs = ps.executeQuery();
        if (rs.next())
        {
          String Question = rs.getString("Question");
          String Explaination = rs.getString("Explaination");
          if (Question.endsWith("= ") || Question.endsWith("= -"))
          {
            continue;
          }
          boolean isX = !rs.getString("Result").equals("O");
          OXQuiz quiz = new OXQuiz(Question, Explaination, isX);
          list[a] = quiz;
        }
        ps.close();
        rs.close();
        continue;
      }
      con.close();
    }
    catch (SQLException ex)
    {
      ex.printStackTrace();
    }
    finally
    {
      try
      {
        if (con != null)
        {
          con.close();
        }
        if (ps != null)
        {
          ps.close();
        }
        if (rs != null)
        {
          rs.close();
        }
      }
      catch (SQLException se)
      {
        se.printStackTrace();
      }
    }
    return list;
  }

  public static List<OXQuiz> getQuizList2 (int amount)
  {
    List<OXQuiz> quizes = new ArrayList<>();
    Collections.addAll(quizes, getQuizList(amount));
    return quizes;
  }
}
