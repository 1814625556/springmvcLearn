package cn.dy.controller;
import java.io.File;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import cn.dy.po.ItemsCustom;
import cn.dy.po.ItemsQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
@RequestMapping("/itemsnew")
public class ItemsController {
    // 商品查询
    @RequestMapping("/queryItems")
    public ModelAndView queryItems(HttpServletRequest request,
                                   ItemsQueryVo itemsQueryVo) throws Exception {
        // 测试forward后request是否可以共享

        System.out.println(request.getParameter("id"));

        // 调用service查找 数据库，查询商品列表
        List<ItemsCustom> itemsList = new ArrayList<ItemsCustom>();

        ItemsCustom items_1 = new ItemsCustom();
        items_1.setName("联想笔记本");
        items_1.setPrice(6000f);
        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

        ItemsCustom items_2 = new ItemsCustom();
        items_2.setName("苹果手机");
        items_2.setPrice(5000f);
        items_2.setDetail("iphone6苹果手机！");

        ItemsCustom items_3 = new ItemsCustom();
        items_3.setName("mac book air");
        items_3.setPrice(5000f);
        items_3.setDetail("mac book air！");

        itemsList.add(items_1);
        itemsList.add(items_2);
        itemsList.add(items_3);


        // 返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        // 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList", itemsList);

        // 指定视图
        // 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，修改为
        // modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
        // 上边的路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
        modelAndView.setViewName("items/itemsListNew");

        return modelAndView;

    }
}
