import { useState } from "react";
import PostForm from "./PostForm";
import PostList from "./PostList";



const BlogApp = () => {

    const [posts,setPost] = useState([]);
    
    function aggiungiPost(post){

        setPost([...posts, setPost ]);
    
    }


    return (

        <PostForm aggiungiPost={(aggiungiPost)}></PostForm>
        <PostList aggi
    )

}