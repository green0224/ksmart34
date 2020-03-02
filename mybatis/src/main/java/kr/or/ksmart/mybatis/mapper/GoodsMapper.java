package kr.or.ksmart.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.mybatis.domain.Goods;

@Mapper
public interface GoodsMapper {

	public int gInsert(Goods g);
	
	public List<Goods> goodsList();
	
	public int goodsUpdate(Goods g);
	
	public Goods oneSelect(String gCode);
	
	public String goodsPw(String gCode, String mId);
	
	public int gDelete(String gCode);
	
	public List<Goods> SelectList(String sk, String sv);
	
}
