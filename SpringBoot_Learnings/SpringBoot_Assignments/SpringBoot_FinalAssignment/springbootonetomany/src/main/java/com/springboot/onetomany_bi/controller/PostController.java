package com.springboot.onetomany_bi.controller;

import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import com.springboot.onetomany_bi.model.Comment;
import com.springboot.onetomany_bi.model.Post;
import com.springboot.onetomany_bi.service.CommentService;
import com.springboot.onetomany_bi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final CommentService commentService;
    private final PostService postService;

    @Autowired
    public PostController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    // Get all posts
    @GetMapping("")
    public String getAllPosts(@RequestParam(required = false) String title, Model model) {
        model.addAttribute("posts", postService.findAll(title));
        return "post-list";
    }

    // Get post details by ID
    @GetMapping("/details/{id}")
    public String getPostById(@PathVariable("id") long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "post-details";
    }

    // Show form to create a new post
    @GetMapping("/new")
    public String showPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "post-form";
    }

    // Create a new post
    @PostMapping("")
    public String createPost(@ModelAttribute("post") Post post) {
        postService.createPost(post);
        return "redirect:/posts";
    }

    // Show form to update an existing post
    @GetMapping("/edit/{id}")
    public String showPostEditForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "post-form";
    }

    // Update an existing post
    @PostMapping("/edit/{id}")
    public String updatePost(@PathVariable("id") long id, @ModelAttribute("post") Post post) {
        postService.updatePost(id, post);
        return "redirect:/posts";
    }

    // Delete a post
    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") long id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }

    // Show the comment form for a post
    @GetMapping("/{id}/comment-form")
    public String showCommentForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        model.addAttribute("comment", new Comment());
        return "comment-form";
    }

    // Add a comment to a post
    @PostMapping("/{postId}/comments")
    public String createComment(@PathVariable("postId") Long postId, @RequestParam("content") String content) {
        commentService.createComment(postId, content);
        return "redirect:/posts/" + postId + "/comment-form";
    }

    // Delete a comment from a post
    @PostMapping("/{postId}/comments/{commentId}/delete")
    public String deleteComment(@PathVariable("postId") Long postId, @PathVariable("commentId") Long commentId) {
        commentService.deleteComment(commentId);
        return "redirect:/posts/" + postId + "/comment-form";
    }
}
