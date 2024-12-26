package com.dao;

import java.math.BigDecimal;
import java.sql.*;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.model.*;

public class UserDao extends BaseDao {//所有的数据库操作
		//注册
		public boolean addU(User U) {
			String sql = "insert into U values(?,?,?,?,?,?)";//User在sql中是关键字,要用[]括起来 这里干脆改成U
			try (Connection conn = dataSource.getConnection(); 
			  	PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setString(1, U.getU_id());
					pstmt.setString(2, null);
					pstmt.setString(3, U.getU_name());
					pstmt.setString(4, U.getU_phone());
					pstmt.setString(5, U.getU_city());
					pstmt.setString(6, U.getU_psw());
					pstmt.executeUpdate();
					return true;
				} catch (SQLException se) {
					se.printStackTrace();
					System.out.println("注册出现异常");
					return false;
				}
		}
			
		//登录验证
		public boolean Login(String U_id,String U_psw) {
			String sql = "SELECT * FROM U";
			try (Connection conn = dataSource.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery()) {
				while (rst.next()) {
					System.out.println(U_id+" "+U_psw);//测试
					System.out.println(rst.getString(1)+" "+rst.getString(6).trim());//测试
					if(U_id.equals(rst.getString(1)) && U_psw.equals(rst.getString(6).trim())) { System.out.println("找到匹配客户"); return true; }
				}
				System.out.println("没有匹配的客户");
			    return false;
			}catch(SQLException ex) {
			    ex.printStackTrace();
			    System.out.println("登录出现异常");
			    return false;
			}
		}
		
		//根据身份证号查找客户
		public User findU(String U_id) {
			String sql = "SELECT * FROM U WHERE U_id=?";
			User U=new User();
			try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, U_id);
				try (ResultSet rst = pstmt.executeQuery()) {
					if (rst.next()) {
						U = new User(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6));
					}	return U;
				}
			} catch (SQLException se) {
				se.printStackTrace();
			    System.out.println("查找客户出现异常");
				return null;
			}		
		}
		
		//修改登录密码
		public boolean pswU(User U) {
			String sql = "update U set U_psw=? where U_id=?";
			try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, U.getU_psw());
				pstmt.setString(2, U.getU_id());
				pstmt.executeUpdate();
				return true;
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println("登录密码修改出现异常");//测试
				return false;
			}
		}
		
		//修改账户密码
		public boolean pswA(Account A) {
			String sql = "update Account set A_psw=? where A_id=?";
			try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, A.getA_psw());
				pstmt.setString(2, A.getA_id());
				pstmt.executeUpdate();
				return true;
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println("账户密码修改出现异常");//测试
				return false;
			}
		}
		
		//添加账户
		public boolean addA(Account A) {
			String sql = "insert into Account values(?,?,?,?,?,?,?,?);";
			try (Connection conn = dataSource.getConnection(); 
			  	PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setString(1, A.getA_id());
					pstmt.setString(2, A.getB_name());
					pstmt.setBigDecimal(3, new BigDecimal(0) );
					pstmt.setInt(4, 0);
					pstmt.setString(5, A.getA_psw());
					pstmt.setString(6, A.getA_type());
		//使用BigDecimal(String val)构造方法时,若传入的字符串是一个非法的数值,如空串、含有字母，就会报错NumberFormatException
					if(A.getA_type().equals("储蓄账户")) {
						pstmt.setBigDecimal(7, new BigDecimal("0.027") );
						pstmt.setBigDecimal(8, null );
					}else {
						pstmt.setBigDecimal(7, null );//
						pstmt.setBigDecimal(8, new BigDecimal("100000") );
					}
					pstmt.executeUpdate();
					return true;
				} catch (SQLException se) {
					se.printStackTrace();
					System.out.println("添加账户出现异常");
					return false;
				}
		}
				//添加账户到客户
				public boolean addAtoU(String A_id, String U_id) {
					String sql = "insert into Have values(?,?);";
					try (Connection conn = dataSource.getConnection(); 
					  	PreparedStatement pstmt = conn.prepareStatement(sql)) {
							pstmt.setString(1, A_id);
							pstmt.setString(2, U_id);
							pstmt.executeUpdate();
							return true;
						} catch (SQLException se) {
							se.printStackTrace();
							System.out.println("添加账户到客户出现异常");
							return false;
						}
				}

		//根据客户ID查找账户IDs
		public ArrayList<String> findAs(String U_id) {
			String sql = "SELECT A_id FROM Have WHERE U_id=?";
			ArrayList<String> A_ids=new ArrayList<String>();
			try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, U_id);
				try (ResultSet rst = pstmt.executeQuery()) {
					while (rst.next()) {
						String A_id= new String(rst.getString(1));
						A_ids.add(A_id);
					}	
				    System.out.println("查到帐户ID");
					return A_ids;
				}
			} catch (SQLException se) {
				se.printStackTrace();
			    System.out.println("查找帐户ID出现异常");
				return null;
			}		
		}
		
		//根据账户号查找账户
		public Account findA(String A_id) {
			String sql = "SELECT * FROM Account WHERE A_id=?";
			Account A=new Account();
			try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, A_id);
				try (ResultSet rst = pstmt.executeQuery()) {
					if (rst.next()) {
						if(rst.getBigDecimal(7)==null) {//.compareTo(BigDecimal.ZERO)==0
							A = new Account(rst.getString(1),rst.getString(2),rst.getBigDecimal(3).toString(),rst.getString(5),rst.getString(6),null,rst.getBigDecimal(8).toString(),rst.getInt(4));	
						}else {
							A = new Account(rst.getString(1),rst.getString(2),rst.getBigDecimal(3).toString(),rst.getString(5),rst.getString(6),rst.getBigDecimal(7).toString(),null,rst.getInt(4));
						}
//						A = new Account(rst.getString(1),rst.getString(2),rst.getBigDecimal(3).toString(),rst.getString(5),rst.getString(6),rst.getBigDecimal(7).toString(),rst.getBigDecimal(8).toString(),rst.getInt(4));
					}	return A;
				}
			} catch (SQLException se) {
				se.printStackTrace();
			    System.out.println("查找账户出现异常");
				return null;
			}		
		}
		
		//根据支行名查找支行
		public Branch findB(String B_name) {
			String sql = "SELECT * FROM Branch WHERE B_name=?";
			Branch B=new Branch();
			try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, B_name);
				try (ResultSet rst = pstmt.executeQuery()) {
					if (rst.next()) {
						B = new Branch(rst.getString(1),rst.getString(2),rst.getBigDecimal(3).toString());
					}	return B;
				}
			} catch (SQLException se) {
				se.printStackTrace();
			    System.out.println("查找账户出现异常");
				return null;
			}		
		}
		
		//挂失账户
		public boolean loseA(String A_id) {
			String sql = "update Account set A_status=1 where A_id=?";
			try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, A_id);
				pstmt.executeUpdate();
				return true;
			}
			catch (SQLException se) {
				se.printStackTrace();
			    System.out.println("查找账户出现异常");
				return false;
			}		
		}
		
		//删除账户
		public boolean deleteA(String A_id) {
			String sql = "delete from Account WHERE A_id=?";
			try {
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, A_id);
				if (pstmt.executeUpdate() > 0) {
					return true;
				}
			} catch (SQLException se) {
				System.out.println("销户异常");//测试
				return false;
			}	
			System.out.println("销户失败");//测试
			return false;
		}
				//从客户中删除账户	触发器写了--trigger"删除账户" 
				public boolean deleteAfromU(String A_id, String U_id) {
					String sql = "delete from Have WHERE A_id=? and U_id=?;";
					try (Connection conn = dataSource.getConnection(); 
					  	PreparedStatement pstmt = conn.prepareStatement(sql)) {
							pstmt.setString(1, A_id);
							pstmt.setString(2, U_id);
							pstmt.executeUpdate();
							return true;
						} catch (SQLException se) {
							se.printStackTrace();
							System.out.println("从客户中删除账户出现异常");
							return false;
						}
				}
		
		//存款
		public boolean In1(In in) {
			String sql = "insert into In1 values(?,?,?,?);";//In在sql中是关键字,要用[]括起来
			try (Connection conn = dataSource.getConnection(); 
			  	PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setString(1, in.getU_id());
					pstmt.setString(2, in.getA_id());
					pstmt.setBigDecimal(3, new BigDecimal(in.getI_money()) );
					pstmt.setTimestamp(4, in.getI_time());				
					pstmt.executeUpdate();
					return true;
				} catch (SQLException se) {
					se.printStackTrace();
					System.out.println("存款记录出现异常");
					return false;
				}
		}			
		public boolean In2(In in) {
			String sql = "update Account set A_money=A_money+? where A_id=?;";
			try (Connection conn = dataSource.getConnection(); 
			  	PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setBigDecimal(1, new BigDecimal(in.getI_money()));
					pstmt.setString(2, in.getA_id());
					pstmt.executeUpdate();
					return true;
				} catch (SQLException se) {
					se.printStackTrace();
					System.out.println("存款出现异常");
					return false;
				}
		}		
		//查找指定客户的存款记录
		public ArrayList<In> findIns(String U_id) {
			String sql = "SELECT * FROM In1 WHERE U_id=? order by I_time desc";
			ArrayList<In> Ins=new ArrayList<In>();
			try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, U_id);
				try (ResultSet rst = pstmt.executeQuery()) {
					while (rst.next()) {
						String A_id= new String(rst.getString(2));
						String I_money= new String(rst.getBigDecimal(3).toString());
						Timestamp I_time = rst.getTimestamp(4);//new Timestamp(rst.getTimestamp(4));写成这样报错 ???
						In in=new In(U_id,A_id, I_money, I_time);
						Ins.add(in);
					}	
				    System.out.println("找到存款记录");
					return Ins;
				}
			} catch (SQLException se) {
				se.printStackTrace();
			    System.out.println("查找存款记录出现异常");
				return null;
			}		
		}

		
		//取款
		public boolean Out1(Out out) {
			String sql = "insert into Out1 values(?,?,?,?);";
			try (Connection conn = dataSource.getConnection(); 
			  	PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setString(1, out.getU_id());
					pstmt.setString(2, out.getA_id());
					pstmt.setBigDecimal(3, new BigDecimal(out.getO_money()) );
					pstmt.setTimestamp(4, out.getO_time());				
					pstmt.executeUpdate();
					return true;
				} catch (SQLException se) {
					se.printStackTrace();
					System.out.println("取款记录出现异常");
					return false;
				}
		}			
		public boolean Out2(Out out) {
			String sql = "update Account set A_money=A_money-? where A_id=?;";
			try (Connection conn = dataSource.getConnection(); 
			  	PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setBigDecimal(1, new BigDecimal(out.getO_money()));
					pstmt.setString(2, out.getA_id());
					pstmt.executeUpdate();
					return true;
				} catch (SQLException se) {
					se.printStackTrace();
					System.out.println("取款出现异常");
					return false;
				}
		}		
		//查找指定客户的取款记录
		public ArrayList<Out> findOuts(String U_id) {
			String sql = "SELECT * FROM Out1 WHERE U_id=? order by O_time desc";
			ArrayList<Out> Outs=new ArrayList<Out>();
			try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, U_id);
				try (ResultSet rst = pstmt.executeQuery()) {
					while (rst.next()) {
						String A_id= new String(rst.getString(2));
						String O_money= new String(rst.getBigDecimal(3).toString());
						Timestamp O_time = rst.getTimestamp(4);
						Out out=new Out(U_id,A_id, O_money, O_time);
						Outs.add(out);
					}	
				    System.out.println("找到取款记录");
					return Outs;
				}
			} catch (SQLException se) {
				se.printStackTrace();
			    System.out.println("查找取款记录出现异常");
				return null;
			}		
		}		
				
		//转账
		public boolean Transfer1(Transfer t) {
			String sql = "insert into Transfer1 values(?,?,?,?,?);";
			try (Connection conn = dataSource.getConnection(); 
			  	PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setString(1, t.getU_id());
					pstmt.setString(2, t.getA_id());
					pstmt.setString(3, t.getA_id1());
					pstmt.setBigDecimal(4, new BigDecimal(t.getT_money()) );
					pstmt.setTimestamp(5, t.getT_time());											
					pstmt.executeUpdate();
					return true;
				} catch (SQLException se) {
					se.printStackTrace();
					System.out.println("转账记录出现异常");
					return false;
				}
		}			
		public boolean Transfer2(Transfer t) {//金额:汇款账户- 收款账户+
			String sql = "update Account set A_money=A_money-? where A_id=?; update Account set A_money=A_money+? where A_id=?;";
			try (Connection conn = dataSource.getConnection(); 
			  	PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setBigDecimal(1, new BigDecimal(t.getT_money()));
					pstmt.setString(2, t.getA_id());
					pstmt.setBigDecimal(3, new BigDecimal(t.getT_money()));
					pstmt.setString(4, t.getA_id1());
					pstmt.executeUpdate();
					return true;
				} catch (SQLException se) {
					se.printStackTrace();
					System.out.println("转账出现异常");
					return false;
				}
		}		
		//查找指定客户的转账记录
		public ArrayList<Transfer> findTransfers(String U_id) {
			String sql = "SELECT * FROM Transfer1 WHERE U_id=? order by T_time desc";
			ArrayList<Transfer> Transfers=new ArrayList<Transfer>();
			try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, U_id);
				try (ResultSet rst = pstmt.executeQuery()) {
					while (rst.next()) {
						String A_id = new String(rst.getString(2));
						String A_id1= new String(rst.getString(3));
						String T_money= new String(rst.getBigDecimal(4).toString());
						Timestamp T_time = rst.getTimestamp(5);
						Transfer t=new Transfer(U_id, A_id, A_id1, T_money, T_time);
						Transfers.add(t);
					}	
				    System.out.println("找到转账记录");
					return Transfers;
				}
			} catch (SQLException se) {
				se.printStackTrace();
			    System.out.println("查找转账记录出现异常");
				return null;
			}		
		}	
		
		//贷款
		public int L_id() {	//生成贷款号
			String sql="select max(L_id) from L";
			try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					return rst.getInt(1);
				}	return 0;
				
			} catch (SQLException se) {
				se.printStackTrace();
			    System.out.println("生成贷款号出现异常");
				return 0;
			}
		}
		public String B_name(String B_city) { //根据B_city查找B_name
			String sql="select B_name from Branch where B_city=?";
			try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, B_city);
				try (ResultSet rst = pstmt.executeQuery()) {
					if (rst.next()) {
						return rst.getString(1);
					}	return null;
				}
			} catch (SQLException se) {
				se.printStackTrace();
			    System.out.println("查找支行名出现异常");
				return null;
			}
		}
		public boolean Loan1(Loan L) { //添加贷款记录
				String sql = "insert into L values(?,?,?,?,?,?,?,?);";
				try (Connection conn = dataSource.getConnection(); 
				  	PreparedStatement pstmt = conn.prepareStatement(sql)) {
						pstmt.setInt(1, L.getL_id());
						pstmt.setString(2, L.getU_id());
						pstmt.setString(3, L.getU_name());
						pstmt.setString(4, L.getA_id());
						pstmt.setBigDecimal(5, new BigDecimal(L.getL_money()) );
						pstmt.setDate(6, L.getL_date());
						pstmt.setString(7, L.getB_name());
						pstmt.setString(8, null);
						pstmt.executeUpdate();
						return true;
					} catch (SQLException se) {
						se.printStackTrace();
						System.out.println("贷款记录出现异常");
						return false;
					}
			}			
		public boolean Loan2(Loan L) { //入账
			String sql = "update Account set A_money=A_money+? where A_id=?;";
			try (Connection conn = dataSource.getConnection(); 
			  	PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setBigDecimal(1, new BigDecimal( L.getL_money()) );
					pstmt.setString(2, L.getA_id());
					pstmt.executeUpdate();
					return true;
				} catch (SQLException se) {
					se.printStackTrace();
					System.out.println("贷款出现异常");
					return false;
				}
		}		
				//查找指定客户的贷款记录
				public ArrayList<Loan> findLoans(String U_id) {
					String sql = "SELECT * FROM L WHERE U_id=? order by L_date desc";
					ArrayList<Loan> Loans=new ArrayList<Loan>();
					try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
						pstmt.setString(1, U_id);
						try (ResultSet rst = pstmt.executeQuery()) {
							while (rst.next()) {
								int L_id= rst.getInt(1);
								String U_name = new String(rst.getString(3));
								String A_id= new String(rst.getString(4));
								String L_money= new String(rst.getBigDecimal(5).toString());
								Date L_date = rst.getDate(6);
								String B_name = new String(rst.getString(7));
								Loan L=new Loan( L_id, U_id, U_name, A_id, L_money, B_name, L_date );
								Loans.add(L);
							}	
						    System.out.println("找到贷款记录");
							return Loans;
						}
					} catch (SQLException se) {
						se.printStackTrace();
					    System.out.println("查找贷款记录出现异常");
						return null;
					}		
				}
				//根据贷款号查找贷款详情
				public Loan findL(String L_id) {
					String sql = "SELECT * FROM L WHERE L_id=?";
					Loan L=new Loan();
					try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
						pstmt.setString(1, L_id);
						try (ResultSet rst = pstmt.executeQuery()) {
							if (rst.next()) {
								if(rst.getBigDecimal(5)==null) {
									L = new Loan(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),null,rst.getString(7),rst.getDate(6));	
								}else {
									L = new Loan(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getBigDecimal(5).toString(),rst.getString(7),rst.getDate(6));
								}
							}	return L;
						}
					} catch (SQLException se) {
						se.printStackTrace();
					    System.out.println("查找贷款详情出现异常");
						return null;
					}		
				}
				
		//还款
		public boolean Repay1(Repay r) {
			String sql = "insert into Repay1 values(?,?,?,?,?);";
			try (Connection conn = dataSource.getConnection(); 
			  	PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setString(1, r.getU_id());
					pstmt.setString(2, r.getA_id());
					pstmt.setString(3, r.getL_id());
					pstmt.setBigDecimal(4, new BigDecimal(r.getR_money()) );
					pstmt.setTimestamp(5, r.getR_time());	
					pstmt.executeUpdate();
					return true;
				} catch (SQLException se) {
					se.printStackTrace();
					System.out.println("还款记录出现异常");
					return false;
				}
		}			
		public boolean Repay2(Repay r) {
			String sql = "update Account set A_money=A_money-? where A_id=?; update L set L_money=L_money-? where L_id=?;";
			try (Connection conn = dataSource.getConnection(); 
			  	PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setBigDecimal(1, new BigDecimal(r.getR_money()));
					pstmt.setString(2, r.getA_id());
					pstmt.setBigDecimal(3, new BigDecimal(r.getR_money()));
					pstmt.setString(4, r.getL_id());
					pstmt.executeUpdate();
					return true;
				} catch (SQLException se) {
					se.printStackTrace();
					System.out.println("还款出现异常");
					return false;
				}
		}		
		//查找指定客户的还款记录
		public ArrayList<Repay> findRepays(String U_id) {
			String sql = "SELECT * FROM Repay1 WHERE U_id=? order by R_time desc";
			ArrayList<Repay> Repays=new ArrayList<Repay>();
			try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, U_id);
				try (ResultSet rst = pstmt.executeQuery()) {
					while (rst.next()) {
						String A_id= new String(rst.getString(2));
						String L_id= new String(rst.getString(3));
						String R_money= new String(rst.getBigDecimal(4).toString());
						Timestamp R_time = rst.getTimestamp(5);
						Repay r=new Repay(U_id,A_id, L_id, R_money, R_time);
						Repays.add(r);
					}	
				    System.out.println("找到还款记录");
					return Repays;
				}
			} catch (SQLException se) {
				se.printStackTrace();
			    System.out.println("查找还款记录出现异常");
				return null;
			}		
		}		
				
		
		//交易记录汇总
		public boolean addRecords(Records r) {
			String sql = "insert into Records values(?,?,?,?,?);";
			try (Connection conn = dataSource.getConnection(); 
			  	PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setString(1, r.getU_id());
					pstmt.setString(2, r.getA_id());
					pstmt.setTimestamp(3, r.getTime());
					pstmt.setString(4, r.getType());
					pstmt.setBigDecimal(5, new BigDecimal(r.getMoney()) );
									
					pstmt.executeUpdate();
					return true;
				} catch (SQLException se) {
					se.printStackTrace();
					System.out.println("录入总记录出现异常");
					return false;
				}
		}	
		//查找指定客户的指定账户的总记录
		public ArrayList<Records> findRecords(String U_id, String A_id) {
			String sql = "SELECT * FROM records WHERE U_id=? and A_id=? order by Time desc";
			ArrayList<Records> records=new ArrayList<Records>();
			try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, U_id);
				pstmt.setString(2, A_id);
				try (ResultSet rst = pstmt.executeQuery()) {
					while (rst.next()) {
						Timestamp Time = rst.getTimestamp(3) ;
						String Type= new String(rst.getString(4));
						String Money= new String(rst.getBigDecimal(5).toString());
						Records record=new Records(U_id, A_id, Type, Money, Time);
						records.add(record);
					}	
				    System.out.println("找到总记录");
					return records;
				}
			} catch (SQLException se) {
				se.printStackTrace();
			    System.out.println("查找总记录出现异常");
				return null;
			}		
		}
				
}