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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @Operation(summary = "Post comment for a topic", description = "posted")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Post created successfully"),
            @ApiResponse(responseCode = "400", description = "Post is invalid") })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{topic}")
    public Comment postComment(@PathVariable String topic) {
        Comment comment = new Comment();
        comment.setTopic(topic);
        return commentService.create(comment);
    }

    @Operation(summary = "lists all the comments", description = " Can be invoked by auth users only")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Listing all the comments"),
            @ApiResponse(responseCode = "204", description = "comments are not available") })
    @GetMapping("/{topic}")
    public List<Comment> getCommentsByTopic(@PathVariable String topic) {
        List<Comment> list = commentService.getCommentsByTopic(topic);
        return list;
    }

}
