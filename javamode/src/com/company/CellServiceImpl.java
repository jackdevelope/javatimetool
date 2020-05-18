package com.company.phone;

public class CellServiceImpl implements CellService{
    private  static final int messageNumber=30;
    private  static int cellTime;

    @Override
    public void myCellMeal() {
        //通话时长
        cellTime=cpc.getCellMinute();
        System.out.println("通话时长为:"+cellTime);
        System.out.println("短信条数为:"+messageNumber);
    }
    public int cellCost(){
        int cellcost=cellTime*4+messageNumber*4;
        return cellcost;
    }
}
