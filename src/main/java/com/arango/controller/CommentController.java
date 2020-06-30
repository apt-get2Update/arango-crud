/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arango.controller;

import java.util.List;

import com.arango.model.Comment;
import com.arango.service.CommentService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ApiOperation(value = "Post comment for a topic") 
    @RequestMapping(value = "/{topic}", method = RequestMethod.POST)
    public Comment postComment(@PathVariable String topic) {
        Comment comment = new Comment();
        comment.setTopic(topic);
        return commentService.create(comment);
    }

    @RequestMapping(value = "/{topic}", method = RequestMethod.GET)
    public List<Comment> getCommentsByTopic(@PathVariable String topic) {
        List<Comment> list = commentService.getCommentsByTopic(topic);
        return list;
    }


}
