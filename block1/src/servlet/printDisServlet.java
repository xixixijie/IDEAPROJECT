package servlet;

import entity.Administrator;
import entity.Distribution;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
import service.disService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by xixi on 2018/6/15.
 */
public class printDisServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        String test=request.getParameter("test");
//        String name=request.getParameter("name");
//
//        System.out.println("test"+test);
//        System.out.println("name"+name);
//
//        System.out.println("开始打印了");
        String[] checks=request.getParameterValues("chk");
//        if(checks==null){
//            System.out.println("kong");
//        }
        System.out.println(checks.length);
        int[] tid=new int[checks.length];
        for(int i=0;i<checks.length;i++){
            tid[i]=Integer.parseInt(checks[i]);
        }
        Administrator administrator=new Administrator();

        List<Distribution> list= disService.getService().printDis(tid,administrator);
        if(list.size()!=0){
            //创建表格
            response.setHeader("Content-disposition",
                    "attachment;filename=Distributions.xls");
            response.setHeader("pragma","no-cache");

            response.setContentType("application/mxexcel");

            ServletOutputStream os=response.getOutputStream();
            //创建excel
            WritableWorkbook workbook = Workbook.createWorkbook(os);

            //生成标题单元格
            //设定样式
            WritableFont font1=new WritableFont(WritableFont.TIMES,16,WritableFont.BOLD);
            //样式嵌套到单元格
            WritableCellFormat format1=new WritableCellFormat(font1);

            //设定内容样式
            WritableFont font2=new WritableFont(WritableFont.TIMES,12,WritableFont.NO_BOLD);
            WritableCellFormat format2=new WritableCellFormat(font1);

            for(int i=0;i<list.size();i++){
                //创建sheet
                WritableSheet sheet=workbook.createSheet("商品签收单",i);

                Label cell=new Label(0,0,"签收单"+list.get(i).getDid(),format1);
                try{
                    sheet.addCell(cell);
                } catch (RowsExceededException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }


                try{
                    sheet.addCell(new Label(0,1,"商品签收ID",format2));
                    sheet.addCell(new Label(1,1,"收货人",format2));
                    sheet.addCell(new Label(2,1,"收货地址",format2));
                    sheet.addCell(new Label(3,1,"收货电话",format2));

                } catch (RowsExceededException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }

                int index=2;
                try {
                    sheet.addCell(new Label(0,index,""+list.get(i).getDid(),format2));
                    sheet.addCell(new Label(1,index,""+list.get(i).getMissionList().getOrderInfo().getReceiverName(),format2));
                    sheet.addCell(new Label(2,index,""+list.get(i).getMissionList().getOrderInfo().getDeliveryAddress(),format2));
                    sheet.addCell(new Label(3,index,""+list.get(i).getMissionList().getOrderInfo().getReceiverTelephone(),format2));
                } catch (WriteException e) {
                    e.printStackTrace();
                }


            }

            workbook.write();

            try {
                workbook.close();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }

       //System.out.println("打印的文件数量"+list.size());








    }
    void generateFile(int[] tid){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
