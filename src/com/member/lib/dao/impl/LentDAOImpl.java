package com.member.lib.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.common.Connector;
import com.member.lib.dao.LentDAO;

public class LentDAOImpl implements LentDAO {

   @Override
   public int insertLent(Map<String, Object> lent) {
      Connection con = null;
      PreparedStatement ps = null;
      int result = 0;
      try {
    	 con = Connector.open();
         String sql = "inset into lent(l_num, l_lentdate, l_recdate, m_num, b_num) ";
         sql += " values(seq_lent_l_num.nextval, sysdate, null, ?,?)";
         ps = con.prepareStatement(sql);
         ps.setInt(1, (int)lent.get("m_num"));
         ps.setInt(2, (int)lent.get("b_num"));
         result = ps.executeUpdate();
         con.commit();
         return result;
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if (ps != null) {
            try {
               ps.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         if (con != null) {
            try {
               con.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      }
      return 0;
   }

   @Override
   public int updateLent(Map<String, Object> lent) {
      Connection con = null;
      PreparedStatement ps = null;
      int result = 0;
      try {
         con = Connector.open();
         String sql = "update lent set ";
         sql += "l_recdate = sysdate where l_num = ?";
         ps = con.prepareStatement(sql);
         ps.setInt(1, (int)lent.get("l_num"));
         result = ps.executeUpdate();
         con.commit();
         return result;
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if (ps != null) {
            try {
               ps.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         if (con != null) {
            try {
               con.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      }
      return 0;
   }

   @Override
   public int deleteLent(int lNum) {
      Connection conn = null;
      PreparedStatement ps = null;
      int result = 0;
      try {
         conn = Connector.open();
         String sql = "delete from lent where l_num = ? ";
         ps = conn.prepareStatement(sql);
         ps.setInt(1, lNum);
         result = ps.executeUpdate();
         conn.commit();
         return result;
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if (ps != null) {
            try {
               ps.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         if (conn != null) {
            try {
               conn.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      }
      return 0;
   }

   @Override
   public List<Map<String, Object>> selectLent(Map<String, Object> lent) {
      List<Map<String, Object>> mList = new ArrayList<>();
      Connection conn = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      try {
         conn = Connector.open();
         String sql = "select l_num, l_lentdate, l_recdate, m_num, b_num from lent ";
         ps = conn.prepareStatement(sql);
         rs = ps.executeQuery();
         while (rs.next()) {
            Map<String, Object> map = new HashMap<>();
            map.put("l_num", (int) rs.getObject("l_num"));
            map.put("l_lentdate", rs.getObject("l_lentdate").toString());
            map.put("l_recdate", rs.getObject("l_recdate").toString());
            map.put("m_num", rs.getObject("m_num").toString());
            map.put("b_num", rs.getObject("b_num").toString());
            mList.add(map);
         }
         return mList;
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if (rs != null) {
            try {
               rs.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         if (ps != null) {
            try {
               ps.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         if (conn != null) {
            try {
               conn.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      }
      return null;
   }

   @Override
   public Map<String, Object> selectLent(int lNum) {
      Map<String, Object> map = new HashMap<>();
      Connection conn = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      try {
         conn = Connector.open();
         String sql = "select l_num, l_lentdate, l_recdate, m_num, b_num from lent where l_num = ? ";
         ps = conn.prepareStatement(sql);
         ps.setInt(1, lNum);
         rs = ps.executeQuery();
         if (rs.next()) {
            map.put("l_num", (int) rs.getObject("l_num"));
            map.put("l_lentdate", rs.getObject("l_lentdate").toString());
            map.put("l_recdate", rs.getObject("l_recdate").toString());
            map.put("m_num", rs.getObject("m_num").toString());
            map.put("b_num", rs.getObject("b_num").toString());
         }
         return map;
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if (rs != null) {
            try {
               rs.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         if (ps != null) {
            try {
               ps.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         if (conn != null) {
            try {
               conn.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      }
      return null;
   }

}