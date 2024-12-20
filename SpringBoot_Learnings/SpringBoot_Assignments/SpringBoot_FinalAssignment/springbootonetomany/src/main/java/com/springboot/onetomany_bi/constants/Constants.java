package com.springboot.onetomany_bi.constants;

public class Constants {

    public static final String POST_NOT_FOUND = "Post not found with id = ";

    public static final String COMMENT_NOT_FOUND = "Comment not found with id = ";
    public static final String COMMENT_CONTENT_NULL_OR_EMPTY = "Content cannot be null or empty and Content must be between 4 and 50 characters";
    public static final String COMMENT_DELETED_SUCCESSFULLY = "Comment deleted successfully";

    public static final String API_VERSION_1="api/v1/posts";
    public static final String API_VERSION_2="api/v2";

    public static final String POST_DELETED_SUCCESSFULLY = "Post deleted successfully.";
    public static final String TITLE_REQUIRED = "Title cannot be null or empty and Title must be between 4 and 20 characters";
    public static final String DESCRIPTION_REQUIRED = "Description cannot be null or empty and Description must be between 10 and 200 characters";

    public static final String POST_NOT_PUBLISHED="Comment cannot be posted for unpublished post";
    public static final String PUBLISHED_NOT_FOUND=" Published status cannot be null";
}
