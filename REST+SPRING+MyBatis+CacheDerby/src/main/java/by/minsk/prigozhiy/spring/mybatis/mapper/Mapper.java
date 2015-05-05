package by.minsk.prigozhiy.spring.mybatis.mapper;

import java.util.List;
import by.minsk.prigozhiy.entity.db.PaymentDB;
import by.minsk.prigozhiy.entity.db.SumDB;
import by.minsk.prigozhiy.entity.db.MapTreeDB;
import org.apache.ibatis.annotations.Param;

public interface Mapper {

    public List<PaymentDB> selectAllPayment();
    public int insertPayment(PaymentDB payment);
    public PaymentDB selectPayment(@Param("pathTree") String pathTree);
    
    public List<SumDB> selectAllSum();
    public int insertSum(SumDB sum);
    
    public List<MapTreeDB> selectAllMapTree();
    public int insertMapTree(MapTreeDB mapTree);
    
    
}
