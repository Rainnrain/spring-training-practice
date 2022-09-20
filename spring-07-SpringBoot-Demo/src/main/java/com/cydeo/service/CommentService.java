package com.cydeo.service;

import com.cydeo.config.AppConfigData;
import com.cydeo.config.DBConfigData;
import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    private final AppConfigData appConfigData;
    private final DBConfigData dbConfigData;

    public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy, AppConfigData appConfigData, DBConfigData dbConfigData) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        this.appConfigData = appConfigData;
        this.dbConfigData = dbConfigData;
    }

    public void publishComment(Comment comment){

      commentNotificationProxy.sendComment(comment);
      commentRepository.storeComment(comment);
    }

    public void printConfigData(){
        System.out.println( appConfigData.getUserName()+"\n"+ appConfigData.getPassword()+"\n"+ appConfigData.getUrl());
    }
    public void printdBConfiguration(){
        System.out.println(dbConfigData.getUserName()+"\n"+dbConfigData.getPassword()+"\n"+dbConfigData.getType());
    }
}
