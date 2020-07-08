package com.ssafy.happyhouse.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.dto.HouseDeal;
import com.ssafy.happyhouse.dto.HouseInfo;
import com.ssafy.happyhouse.dto.HousePageBean;

@Repository
public class HouseDaoImpl implements HouseDao{
	
   @Autowired
   SqlSession sqlsession;

   private Map<String, HouseInfo> houseInfo;
   private Map<String, List<HouseDeal>> deals;
   private int size;
   private List<HouseDeal>search;
   private String[] searchType= {HouseDeal.APT_DEAL, HouseDeal.APT_RENT, HouseDeal.HOUSE_DEAL, HouseDeal.HOUSE_RENT};
   public HouseDaoImpl() {
   }
   /**
    * 아파트 정보와 아파트 거래 정보를  xml 파일에서 읽어온다.
    */
   @Override
   public void loadData() {
      // TODO Auto-generated method stub
      
   }
   
   /**
    * 검색 조건(key) 검색 단어(word)에 해당하는 아파트 거래 정보(HouseInfo)를  검색해서 반환.  
    * @param bean  검색 조건과 검색 단어가 있는 객체
    * @return 조회한 식품 목록
    */
   @Override
   public List<HouseDeal> searchAll(HousePageBean bean) throws SQLException {
	    List<HouseDeal> list = null;
		list = sqlsession.selectList("house.selectAll",bean);
		return list;
	}
   
   /**
    * 주택 거래 식별 식별 번호에 해당하는 아파트 거래 정보를 검색해서 반환한다.<br/>
    * 법정동+아파트명을 이용하여 HouseInfo에서 건축연도, 법정코드, 지번, 이미지 정보를 찾아서 HouseDeal에 setting한 정보를 반환한다. 
    * @param no   검색할 아파트 식별 번호
    * @return      아파트 식별 번호에 해당하는 아파트 거래 정보를 찾아서 리턴한다, 없으면 null이 리턴됨
    */
   @Override
	public HouseDeal search(int no)  {
	    HouseDeal result = sqlsession.selectOne("house.getTotalCount",no);
		return result;
	}
   /**
    * 게시글 총 갯수 확인
    */
   @Override
   public int getTotalCount(HousePageBean bean) throws SQLException {
	   int cnt = 0;
	   cnt = sqlsession.selectOne("house.select",bean);
	   return cnt;
   }
   
//   public List<HouseDeal> searchAll(HousePageBean  bean) throws SQLException{
//      Connection con = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        try {
//            con = DBUtil.getConnection();
//            StringBuilder sql = new StringBuilder(100);
//            sql.append("select * from housedeal where 1=1 ");
//            boolean[] type = bean.getSearchType();
//            sql.append("and type in (");
//            for (int i=0, size=type.length; i < size; i++) {
//                if(type[i]) {
//                    sql.append(i+1);
//                    boolean flag = false;
//                    for(int j=i+1; j<size; j++) {
//                       if(type[j]) {
//                          flag = true;
//                          break;
//                       }
//                    }
//                    if(flag) {
//                       sql.append(",");
//                    }
//                }
//            }
//            sql.append(") \n");
//            String dong = bean.getDong();
//            String aptName = bean.getAptname();
//            if(dong!=null) {
//                sql.append(" and dong like ? \n");
//            }else if(aptName != null) {
//                sql.append(" and AptName like ? \n");
//            }
//            
//            // 페이지 작업
//            sql.append(" limit ?, ? ");
//            
//            
//            stmt = con.prepareStatement(sql.toString());
//            System.out.println(sql.toString());
//            int idx = 0;
//            if(dong!=null) {
//                stmt.setString(++idx, "%"+dong+"%");
//            }else if(aptName != null) {
//                stmt.setString(++idx, "%"+aptName+"%");
//            }
//            stmt.setInt(++idx, (bean.getPageNo() - 1) * bean.getInterval() );
//            stmt.setInt(++idx, bean.getInterval());
//            
//            rs = stmt.executeQuery();
//            List<HouseDeal> dealList = new LinkedList<>();
//            while(rs.next()) {
//                HouseDeal  deal = new HouseDeal();
//                deal.setNo(rs.getInt("no"));
//                deal.setDong(rs.getString("dong"));
//                deal.setAptName(rs.getString("AptName"));
//                deal.setCode(rs.getString("code"));
//                deal.setDealAmount(rs.getString("dealAmount"));
//                deal.setBuildYear(rs.getInt("buildYear"));
//                deal.setDealYear(rs.getInt("dealYear"));
//                deal.setDealMonth(rs.getInt("dealMonth"));
//                deal.setDealDay(rs.getInt("dealDay"));
//                deal.setArea(rs.getDouble("area"));
//                deal.setFloor(rs.getInt("floor"));
//                deal.setJibun(rs.getString("jibun"));
//                deal.setType(rs.getString("type"));
//                deal.setRentMoney(rs.getString("rentMoney"));
//                dealList.add(deal);
//            }
//            return dealList;
//        } finally {
//            DBUtil.close(rs);
//            DBUtil.close(stmt);
//            DBUtil.close(con);
//        }
//   }
   
//   /**
//    * 주택 거래 식별 식별 번호에 해당하는 아파트 거래 정보를 검색해서 반환한다.<br/>
//    * 법정동+아파트명을 이용하여 HouseInfo에서 건축연도, 법정코드, 지번, 이미지 정보를 찾아서 HouseDeal에 setting한 정보를 반환한다. 
//    * @param no   검색할 아파트 식별 번호
//    * @return      아파트 식별 번호에 해당하는 아파트 거래 정보를 찾아서 리턴한다, 없으면 null이 리턴됨
//    */
//   public HouseDeal search(int no) throws SQLException {
//      Connection con = null;
//      PreparedStatement stmt = null;
//      ResultSet rs = null;
//      try {
//         con = DBUtil.getConnection();
//         String sql = "select * from housedeal where no = ?";
//         stmt = con.prepareStatement(sql);
//         stmt.setInt(1, no);
//         
//         rs = stmt.executeQuery();
//         if(rs.next()) {
//            HouseDeal deal = new HouseDeal();
//            deal.setNo(rs.getInt("no"));
//            deal.setDong(rs.getString("dong"));
//            deal.setAptName(rs.getString("aptName"));
//            deal.setCode(rs.getString("code"));
//            deal.setDealAmount(rs.getString("dealAmount"));
//            deal.setBuildYear(rs.getInt("buildYear"));
//            deal.setDealYear(rs.getInt("dealYear"));
//            deal.setDealMonth(rs.getInt("dealMonth"));
//            deal.setDealDay(rs.getInt("dealDay"));
//            deal.setArea(rs.getDouble("area"));
//            deal.setFloor(rs.getInt("floor"));
//            deal.setJibun(rs.getString("jibun"));
//            deal.setType(rs.getString("type"));
//            deal.setRentMoney(rs.getString("rentMoney"));
//            return deal;
//         }
//         return null;
//      } finally {
//         DBUtil.close(rs);
//         DBUtil.close(stmt);
//         DBUtil.close(con);
//      }
//   }
   

   /**
    * 게시글 총 갯수 확인
    */
//   public int getTotalCount(HousePageBean bean) throws SQLException{
//      int cnt = 0;
//      Connection con = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        
//        try {
//            con = DBUtil.getConnection();
//            StringBuilder sql = new StringBuilder(100);
//            sql.append("select count(no) from housedeal where 1=1 ");
//            boolean[] type = bean.getSearchType();
//            sql.append("and type in (");
//            for (int i=0, size=type.length; i < size; i++) {
//                if(type[i]) {
//                    sql.append(i+1);
//                    boolean flag = false;
//                    for(int j=i+1; j<size; j++) {
//                       if(type[j]) {
//                          flag = true;
//                          break;
//                       }
//                    }
//                    if(flag) {
//                       sql.append(",");
//                    }
//                }
//            }
//            sql.append(") \n");
//            String dong = bean.getDong();
//            String aptName = bean.getAptname();
//            if(dong!=null) {
//                sql.append(" and dong like ? \n");
//            }else if(aptName != null) {
//                sql.append(" and AptName like ? \n");
//            }         
//            
//            stmt = con.prepareStatement(sql.toString());
//            System.out.println(sql.toString());
//            int idx = 0;
//            if(dong!=null) {
//                stmt.setString(++idx, "%"+dong+"%");
//            }else if(aptName != null) {
//                stmt.setString(++idx, "%"+aptName+"%");
//            }
//            
//            rs = stmt.executeQuery();
//            rs.next();
//            cnt = rs.getInt(1);
//        } finally {
//            DBUtil.close(rs);
//            DBUtil.close(stmt);
//            DBUtil.close(con);
//        }
//        return cnt;
//   }
   

public static void main(String[] args) {
      HouseDao dao = new HouseDaoImpl();
      
   }   
}




