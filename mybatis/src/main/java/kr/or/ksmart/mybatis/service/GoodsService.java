package kr.or.ksmart.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.mybatis.domain.Goods;
import kr.or.ksmart.mybatis.mapper.GoodsMapper;

@Service
@Transactional
public class GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	
	public int gInsert(Goods g) {
		int result = goodsMapper.gInsert(g);
		return result;
	}
	
	public List<Goods> gList(){
		List<Goods> g = goodsMapper.goodsList();
		return g;
	}
	
	public Goods oneSelect(String gCode) {
		Goods g = goodsMapper.oneSelect(gCode);
		return g;
	}
	
	public int goodsUpdate(Goods g) {
		int result = goodsMapper.goodsUpdate(g);
		return result;
	}
	
	public String goodsPw(String gCode, String mId) {
		String pw = goodsMapper.goodsPw(gCode, mId);
		return pw;
	}
	
	public int gDelete(String gCode) {
		int result = goodsMapper.gDelete(gCode);
		return result;
	}
	
	public List<Goods> selectList(String sk, String sv){
		List<Goods> g = goodsMapper.SelectList(sk, sv);
		return g;
	}
}
