package com.honyelchak.easypoi.request;

import com.honyelchak.easypoi.EasypoiApplication;
import com.honyelchak.easypoi.controller.DataDetailController;
import com.honyelchak.easypoi.entity.DataDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Honyelchak
 * @ClassName: DataDetailTest
 * @Description:
 * @create 2020-05-11
 */
@SpringBootTest(classes = EasypoiApplication.class)
public class DataDetailTest {

    @Autowired
    DataDetailController dataDetailController;

    @Test
    public void test(){
        DataDetail dataDetail = dataDetailController.selectOne(8);

        System.out.println(dataDetail.toString());
    }


}
