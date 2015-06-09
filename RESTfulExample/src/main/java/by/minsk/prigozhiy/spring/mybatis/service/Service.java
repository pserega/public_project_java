package by.minsk.prigozhiy.spring.mybatis.service;

import by.minsk.prigozhiy.entity.db.MapTreeDB;
import by.minsk.prigozhiy.entity.db.PaymentDB;
import by.minsk.prigozhiy.entity.db.SumDB;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import by.minsk.prigozhiy.spring.mybatis.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class Service {

    @Autowired
	private Mapper mapper;
        
        public List<PaymentDB> selectAllPayment() {
		return mapper.selectAllPayment();
	}
        
        public int insertPayment(PaymentDB payment) {
		return mapper.insertPayment(payment);
	}
        
        public PaymentDB selectPayment(String pathTree) {
		return mapper.selectPayment(pathTree);
	}
        
        public List<SumDB> selectAllSum() {
		return mapper.selectAllSum();
	}
        
        public int insertSum(SumDB sum) {
		return mapper.insertSum(sum);
	}
        
        
        public List<MapTreeDB> selectAllMapTree() {
		return mapper.selectAllMapTree();
	}
        
        public int insertMapTree(MapTreeDB mapTree) {
		return mapper.insertMapTree(mapTree);
	}
        

}
