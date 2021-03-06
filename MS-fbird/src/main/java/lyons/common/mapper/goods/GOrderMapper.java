package lyons.common.mapper.goods;

import java.util.List;

import lyons.common.model.goods.GOrder;

public interface GOrderMapper {
    /**
     * Batch inserts into goods order
     **/
    int insertsBatchOrder(List<GOrder> listOrder);

   /* *//**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     *//*
    long countByExample(GOrderExample example);

    *//**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     *//*
    int deleteByExample(GOrderExample example);

    *//**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     *//*
    int deleteByPrimaryKey(Integer gOrderId);

    *//**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     *//*
    int insert(GOrder record);

    *//**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     *//*
    int insertSelective(GOrder record);

    *//**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     *//*
    List<GOrder> selectByExample(GOrderExample example);

    *//**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     *//*
    GOrder selectByPrimaryKey(Integer gOrderId);

    *//**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     *//*
    int updateByExampleSelective(@Param("record") GOrder record, @Param("example") GOrderExample example);

    *//**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     *//*
    int updateByExample(@Param("record") GOrder record, @Param("example") GOrderExample example);

    *//**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     *//*
    int updateByPrimaryKeySelective(GOrder record);

    *//**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     *//*
    int updateByPrimaryKey(GOrder record);*/
}