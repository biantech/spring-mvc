package com.bianjq.spring.controller;

import com.bianjq.spring.formdto.CommentParam;
import com.bianjq.spring.model.BlogEntity;
import com.bianjq.spring.model.CommentModel;
import com.bianjq.spring.repository.BlogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/")
public class CommentsController {
    Logger logger = LoggerFactory.getLogger(CommentsController.class);
    @Autowired
    BlogRepository blogRepository;

    /**
     * 分页查找行为日志，其实druid里面已经包含了行为日志
     * @param param  页码
     * @return
     */
    //@RequestMapping(value = "/findComment"  , method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    //@ModelAttribute("comment")
    //@ModelAttribute("comment")
    @RequestMapping(value = "/findComment", method = RequestMethod.POST)
    @ResponseBody
    public List<CommentModel> findComment(@RequestBody CommentParam param) {
        ArrayList<CommentModel> listDemo = new ArrayList<>();
        logger.info(param.toString());
        CommentModel model = new CommentModel();
        model.setBlogId(1);
        model.setCommentId(1);
        model.setContent("test1-pageSize="+param.getPageSize());
        model.setTitle("title-test1,blogId="+param.getBlogId());
        //List<BlogEntity> listBlog=blogRepository.findAll();
        //logger.info(listBlog.toString());
        listDemo.add(model);
        return listDemo;
        //return model;
    }
}
