package java.com.hcl;

import java.com.hcl.dao.ProductCrud;


import java.com.hcl.pojo.Product;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class dbMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner sc=new Scanner(System.in);
        ProductCrud dao=null;
        while(true) {
            System.out.println("Menu 1. add product 2. delete product  3. update product 4.retrive product 5. exit");
            System.out.println("enter choice");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    Product product = new Product();
                    System.out.println("enter product id");
                    product.setPid(sc.nextInt());
                    System.out.println("enter product name");
                    product.setpName(sc.next());
                    System.out.println("enter product cost");
                    product.setCost(sc.nextInt());
                    dao = new ProductCrud();
                    if (dao.addProduct(product) > 0) {
                        System.out.println("product added successfully...");
                    } else {
                        System.out.println("product not added check once...");
                    }
                    break;
                case 2:
                    System.out.println("enter product id to be deleted");
                    int id = sc.nextInt();
                    dao = new ProductCrud();
                    if (dao.deleteProduct(id) > 0) {
                        System.out.println("product got deleted successfully with id:" + id + " ...");
                    } else {
                        System.out.println("product not deleted check once...");
                    }
                    break;
                case 3:
                    System.out.println("enter product id to be updated with name");
                    int idupdate = sc.nextInt();
                    System.out.println("enter product name to be updated");
                    String name = sc.next();
                    dao = new ProductCrud();
                    if (dao.updateProductName(idupdate, name) > 0) {
                        System.out.println("product name got updated successfully for id:" + idupdate + " ..as ." + name);
                    } else {
                        System.out.println("product not updated check once...");
                    }
                    break;
                case 4:
                    dao = new ProductCrud();
                    List<Product> list = dao.selectProduct();
                    for (Product products : list) {
                        System.out.println(products);
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;

            }
        }
    }
}
