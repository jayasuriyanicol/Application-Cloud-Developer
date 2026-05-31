import { useState } from "react";
import PostForm from "./PostForm";
import PostList from "./PostList";

const BlogApp = () => {

    const[posts, setPosts] = useState([]); 

    function aggiungiPost(post){
        
        setPosts([...posts,post]);
    }
    
    return (

        <div>
            <h2>BLOG PRINCIPALE</h2>
            <PostForm aggiungiPost={aggiungiPost}></PostForm>
            <PostList posts={posts} ></PostList>
        </div>
    );
};

export default BlogApp;