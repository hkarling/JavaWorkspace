package project.controller;

import project.model.service.ShopService;
import project.model.service.ShopServiceImpl;
import project.model.util.DbUtil;
import project.view.MainView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShopController {
    private static MainView mainView = new MainView();
    private static ShopService service = new ShopServiceImpl();

    /** 로그인 */
    public static void login(String id) {
        while(true) {
            try {
                service.checkCustomerID(id);
                System.out.println("로그인에 성공하였습니다.");
                break;
            } catch (SQLException e) {
                //e.printStackTrace();
                id = mainView.login();
            }
        }
    }

    /** */


    public static void main(String[] args) {
        login(mainView.login());
    }
}
