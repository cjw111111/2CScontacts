package Client;

import Server.ContactDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws SQLException {

        System.out.println("个人通讯录");

        while (true) {
            System.out.println("1、查看联系人信息      2、添加新的联系人      3、修改联系人信息      4、删除联系人      5、退出");

            @SuppressWarnings("resource")
            Scanner input = new Scanner(System.in);
            int op = input.nextInt();

            if (op == 5)
                break;
            else if (op < 5) {
                if (op == 1) {
                    System.out.println("输入要查看联系人或电话");

                    // String q = input.next();
                    String op2 = input.next();

                    ContactDAO jdbc = new ContactDAO();

                    ResultSet rs1 = jdbc.select_name(op2);
                    ResultSet rs2 = jdbc.select_phone(op2);


                    if (rs1 != null) {
                        while (rs1.next()) {
                            System.out.println(
                                    "id:"+rs1.getString(1) + "\n" + "姓名:" + rs1.getString(2) + "\n" + "电话:" + rs1.getString(3) + "\n" + "邮箱:" + rs1.getString(4) + "\n" + "地址:" + rs1.getString(5));
                        }
                    }
                    if (rs2 != null) {
                        while (rs2.next()) {
                            System.out.println(
                                    "id:"+rs1.getString(1) + "\n" + "姓名:" + rs1.getString(2) + "\n" + "电话:" + rs1.getString(3) + "\n" + "邮箱:" + rs1.getString(4) + "\n" + "地址:" + rs1.getString(5));
                        }
                    }
                }
                if (op == 2) {
                    String name, phone, email, address;
                    System.out.println("输入联系人姓名");
                    name = input.next();
                    System.out.println("输入联系人电话");
                    phone = input.next();
                    System.out.println("输入联系人邮箱");
                    email = input.next();
                    System.out.println("输入联系人地址");
                    address = input.next();

                    ContactDAO jdbc = new ContactDAO();

                    if (jdbc.insert(name, phone, email, address)) {
                        System.out.println("添加成功");
                    } else {
                        System.out.println("添加失败");
                    }
                }
                if (op == 3) {
                    System.out.println("输入要修改的系统id");
                    int op2 = input.nextInt();

                    System.out.println("输入要修改的内容(1、name, 2、phone, 3、email, 4、address):");
                    int bool = input.nextInt();

                    System.out.println("输入修改后的值");
                    String op3 = input.next();

                    ContactDAO jdbc = new ContactDAO();
                    if (bool == 1)
                        jdbc.update_name(op2, op3);
                    if (bool == 2)
                        jdbc.update_phone(op2, op3);
                    if (bool == 3)
                        jdbc.update_email(op2, op3);
                    if (bool == 4)
                        jdbc.update_address(op2, op3);
                }
                if (op == 4) {
                    System.out.println("输入要删除的系统id");
                    int op2 = input.nextInt();

                    ContactDAO jdbc = new ContactDAO();

                    if (jdbc.delete(op2)) {
                        System.out.println("删除成功");
                    } else {
                        System.out.println("删除失败");
                    }

                }
            } else
                continue;
        }
    }
}
